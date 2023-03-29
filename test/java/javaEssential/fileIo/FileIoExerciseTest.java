package javaEssential.fileIo;

import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import java.nio.file.attribute.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)

class FileIoExerciseTest {

    static String inputPath;
    //non existing
    static String uriTestFamilyDir;
    static String testfamilyOutDir;

    @BeforeAll
    public static void beforeTests(){
        inputPath = "C:\\Users\\chq-richardp\\Documents\\sampleFiles\\java_IO\\family_ex.txt";
        testfamilyOutDir = "C:\\Users\\chq-richardp\\Documents\\file_Io_Tests\\FileOutputs\\familyUriTest.txt";
        uriTestFamilyDir = "file:///Users/chq-richardp/Documents/file_Io_Tests/FileOutputs/familyUriTest.txt";
    }
    /*
    testing for better understand File & Path API
     */
    @Test
    void fileAPIUriPathTest() {
        //toPath - retrofit old FILE API, toURI
        //String inputPath = "C:\\Users\\chq-richardp\\Documents\\sampleFiles\\java_IO\\family_ex.txt";
        Path familyPath = Paths.get(inputPath);

        UserPrincipal owner = null;
        try {
            owner = Files.getOwner(familyPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("EXPEDITORS\\chq-richardp (User)", owner.toString());

    }

    @Test
    void pathAPITests(){
        //String testDirectory = "C:\\Users\\chq-richardp\\Documents\\file_Io_Tests\\FileOutputs\\familyUriTest.txt";
        //String uriTestDirectory = "file:///Users/chq-richardp/Documents/file_Io_Tests/FileOutputs/familyUriTest.txt";
        Path uriPath = Paths.get(URI.create(uriTestFamilyDir));
        assertFalse(Files.exists(uriPath));
        //assertEquals(true, uriPath.isAbsolute());
        //new URI requires URISyntaxException check
        Path uriNewPath = null;
        try {
            uriNewPath = Paths.get(new URI(uriTestFamilyDir));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        assertFalse(Files.exists(uriNewPath));
    }

    @Test
    @DisplayName("Test permission of directory and paths with resolve method.")
    void FilesPathResolveTests() throws IOException {

        String dir = "C:\\Users\\chq-richardp\\Documents\\";
        Path startPath = Paths.get(dir);
        Path fileDir = null;
        System.out.println("Parent path :" + startPath.getParent().toString());
        //the resolve() doesn't create the file it merely returns a reference to the file you are about to create.
        fileDir = Files.createDirectories(startPath.getParent().resolve("Documents\\io_test\\testFolder\\testOutput"));
        assertTrue(Files.exists(fileDir));
        //assertTrue(fileDir.toFile().setExecutable(true, false));
        fileDir = Files.createDirectories(fileDir);
        assertTrue(fileDir.toFile().setWritable(true, false));
        //assertTrue(fileDir.toFile().setExecutable(true, false));

        //the resolve method create file with file permission as read only as default in window
        Path newFile = Files.createFile(fileDir.resolve("testfile.txt"));

        assertTrue(Files.exists(newFile));
        assertTrue(Files.isReadable(newFile));
        assertTrue(Files.isExecutable(newFile));
        assertTrue(Files.isWritable(newFile));

    }

    @Test
    @Order(1)
    @DisplayName("test if a new file under multiple new sub folders can be writable.")
    void multiSubDirectoryTest() throws IOException {

        Path singlePath = Paths.get("C:\\Users\\chq-richardp\\Documents\\io_test\\testFolder\\testOutput");
        Files.createDirectories(singlePath);
        //the resolve method create file with file permission as read only as default in window
        //Files.createFile(singlePath.resolve("testfile.txt"));
        Files.createFile(Paths.get("C:\\Users\\chq-richardp\\Documents\\io_test\\testFolder\\testOutput\\testfile.txt"));

        //File testFile = new File("C:\\Users\\chq-richardp\\Documents\\io_test\\testFolder\\testOutput\\testfile.txt");
        //Paths.get("C:\\Users\\chq-richardp\\Documents\\io_test\\testFolder\\testOutput\\testfile.txt").toFile().setWritable(true);

        File testFile = Paths.get("C:\\Users\\chq-richardp\\Documents\\io_test\\testFolder\\testOutput\\testfile.txt").toFile();
        testFile.setWritable(true);
        assertTrue(Files.isWritable(singlePath));
        Path writepath = Paths.get("C:\\Users\\chq-richardp\\Documents\\io_test\\testFolder\\testOutput\\testfile.txt");
        //https://mkyong.com/java/java-how-to-create-and-write-to-a-file/
        Files.write(writepath, "Hello Richard! that is not your real name though?".getBytes(StandardCharsets.UTF_8), StandardOpenOption.WRITE);
    }
    @Test
    @Order(2)
    void walkFileDiretoryTest(){
        //https://mkyong.com/java/java-files-walk-examples/
        Path walkPath = Paths.get("C:\\Users\\chq-richardp\\Documents\\io_test");
        List <Path> pathList = null;
        try (Stream<Path> walk = Files.walk(walkPath)){
            pathList = walk.filter(Files::isDirectory)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(3, pathList.size());
        for(Path pathO : pathList){
            System.out.println(pathO.toString());
        }
    }

    @Test
    void testFileAndFolderDeleteTests () throws IOException {

        Path writePath = Paths.get("C:\\Users\\chq-richardp\\Documents\\io_test\\testFolder\\testOutput\\testfile.txt");
        /*
        //1) only delete the file not directories
        assertTrue(writeFile.toFile().delete());

        //2) in order to delete all the directories, iterate over with walk.
        //https://www.marcobehler.com/guides/java-files
        //but it only deletes most sub folder or file, not all directories tree.
        try(Stream<Path> pathWalk = Files.walk(writeFile)){
            pathWalk.sorted(Comparator.reverseOrder()).forEach(path -> {
                System.out.println(writeFile.toString());
                //Files.delete(testFile.toPath());
            });
        }

         */
        //3) utilize getParent() to reverse iterate to delete directory tree below.
        //be careful! not delete unintended parent folder.
        Path currentPath = writePath.getParent();
        System.out.println(currentPath.getFileName().toString());
        assertTrue(currentPath.toFile().delete());
        currentPath = writePath.getParent().getParent();
        System.out.println(currentPath.getFileName().toString());
        assertTrue(currentPath.toFile().delete());
        currentPath = writePath.getParent().getParent().getParent();
        System.out.println(currentPath.getFileName().toString());
        assertTrue(currentPath.toFile().delete());
    }

    @Test
    @DisplayName("Foler creation with Path.get() varag argument compare with resolve method")
    void multipleSubfolerVaragTest() throws IOException {
        Path testPath = Paths.get("C:\\Users\\chq-richardp\\Documents\\file_io", "testFoler", "testInput");
         Files.createDirectories(testPath);
         assertTrue(Files.isWritable(testPath));
         assertTrue(Files.isExecutable(testPath));
         Path filePath = Paths.get(testPath.toString(),"test.txt");
         Files.createFile(filePath);
         assertTrue(Files.isWritable(filePath));
    }

}


