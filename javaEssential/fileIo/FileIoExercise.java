package javaEssential.fileIo;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserPrincipal;
import java.util.Scanner;

/**
 * https://docs.oracle.com/javase/tutorial/essential/io/pathOps.html
 */
public class FileIoExercise {

    public static void main(String[] args) throws IOException, URISyntaxException {

        //Console console = System.console();
        String inputPath;
        Scanner scan = new Scanner(System.in);
        InputListHelper memberHelp = new InputListHelper();

        System.out.println("Current home directory : " + System.getProperty("user.home"));
        //System.out.println(System.getProperty("C:\\Users\\chq-richardp\\Documents\\java_workSpace"));
        //Microsoft windows UNC pathname sameple
        Path testPath = Paths.get("C:\\Users\\chq-richardp\\Documents\\java_workSpace", "Java_Documents", "testPath", "test.txt");
        System.out.format("testing testPath: %s%n", testPath.toString());
        System.out.format("testPathFileName : %s%n", testPath.getFileName());
        System.out.format("testpath GetParent : %s%n", testPath.getParent());
        System.out.format("testPath getClass : %s%n", testPath.getClass());
        System.out.format("toUri of testPath: %s%n", testPath.toUri());
        //A system dependent prefix String such as disk-drive specifier"/" for unix root directory
        Path urlPath = Paths.get(URI.create("file:///Users/chq-richardp/Documents/Job_Application/family.txt"));
        //Path subPath = Paths.get(testPath, "directSubPath", "secondaryPath");

        //Files.createDirectories(testPath);
        //Files.delete(testPath);
        Path outFileTestPath = Paths.get("C:\\Users\\chq-richardp\\Documents\\file_io","FileOutputTest", "familyPathTest.txt" );
        Path outUriFilePath = Paths.get(URI.create("file:///Users/chq-richardp/Documents/file_io/FileOutputs/familyUriTest.txt"));
        FileIoExercise.validateURIPathwithFiles(urlPath);
        //FileIoExercise.createFileDirectory(outUriFilePath);

        /*
        System.out.print("please enter a  path to read file:");

        inputPath = scan.nextLine();
        String outputDirectory ="C:\\Users\\chq-richardp\\Documents\\java_workSpace\\Java_Documents\\FileOutputs\\familyUriTest.txt";
        FilesReadWriteUtil bufferReadWrite = new FilesReadWriteUtil();

        bufferReadWrite.bufferedRead(inputPath);

         */
        //bufferReadWrite.bufferedFileWrite(outUriFilePath);
        //bufferReadWrite.newBufferedWriter(outputDirectory);

        //bufferReader.filesBufferRead(inputPath);
        //bufferReader.filesLinesRead(inputPath);
        //bufferReader.classLoaderPathFile(inputPath);
        //bufferReader.printmember();

    }//end main

    private static void validateURIPathwithFiles(Path familyPath) throws IOException {
        System.out.format("String urlPath: %s%n", familyPath.toString());
        System.out.format("toFile of urlPath : %s%n", familyPath.toFile());
        UserPrincipal owner = Files.getOwner(familyPath);
        System.out.println("Owner of the family.txt : " + owner);
    }

    private static void createFileDirectory(Path ghostPath){

    }


    public static String askForFilePath(){
        /*
        System.out.print("please enter a file path :");
        return scan.nextLine();
         */
        String directory;
        Scanner scan = null;

        Console console = System.console();
        if(console == null){
            System.out.print("please enter a  path to read file:");
            directory = scan.nextLine();
            //System.err.println("Console is not available...");
            //the nonzero argument in exit() indicate abnomal termination.
            //System.exit(1);
        } else {
            directory = console.readLine("please enter a file path to this console:");
        }
        return directory;
    }


    //https://mkyong.com/java/java-read-a-file-from-resources-folder/
    private File getFileFromUrlClassLoader(String filePath) throws URISyntaxException {
        ClassLoader loader = getClass().getClassLoader();
        URL resource = loader.getResource(filePath);
        return new File(resource.toURI());
    }

    private InputStream getStreamFromClassLoader(String path) {
        ClassLoader loader = getClass().getClassLoader();
        InputStream inStream = loader.getResourceAsStream(path);
        return null;
    }//end

    private File getFileFromClassLoader(String path) throws URISyntaxException {
        ClassLoader loader = getClass().getClassLoader();
        File afile = new File(loader.getResource(path).getFile());

        return afile;
    }

}
