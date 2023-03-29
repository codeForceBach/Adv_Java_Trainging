package javaEssential.fileIo;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilesReadWriteUtil {


    private BufferedWriter buffNewWriter, buffFilesWriter;
    private BufferedReader buffReader;
    private InputListHelper storeInput;
    private String directory;
    private Path path,outFilePath ;
    private URL urlPath;

    public Path getOutUriFilePath() {
        return outUriFilePath;
    }

    public void setOutUriFilePath(Path outUriFilePath) {
        this.outUriFilePath = outUriFilePath;
    }

    private Path outUriFilePath;

    public BufferedWriter getBuffNewWriter() {
        return buffNewWriter;
    }

    public void setBuffNewWriter(BufferedWriter buffNewWriter) {
        this.buffNewWriter = buffNewWriter;
    }

    public BufferedWriter getBuffFilesWriter() {
        return buffFilesWriter;
    }

    public void setBuffFilesWriter(BufferedWriter buffFilesWriter) {
        this.buffFilesWriter = buffFilesWriter;
    }

    public BufferedReader getBuffReader() {
        return buffReader;
    }

    public void setBuffReader(BufferedReader buffReader) {
        this.buffReader = buffReader;
    }

    public InputListHelper getStoreInput() {
        return storeInput;
    }

    public void setStoreInput(InputListHelper storeInput) {
        this.storeInput = storeInput;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public URL getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(URL urlPath) {
        this.urlPath = urlPath;
    }

    public FilesReadWriteUtil() {
        storeInput = new InputListHelper();
        //scan = new Scanner(System.in);

    }

    public void bufferedRead(String directory) throws IOException {
        System.out.println("------------- Read file with new BufferedReader--------------");
        /*
        scan = new Scanner(System.in);
        System.out.println("Please enter a file path to this Scanner2 : ");
         */

        try {
            buffReader = new BufferedReader(new FileReader(directory));
            String line;
            while((line = buffReader.readLine()) != null){
                storeInput.convertStringToMember(line);
                //System.out.println("Read Lines : " + line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(buffReader != null){
                buffReader.close();
            }
        }//try, catch & finally


    }//end Scanner Read

    public void filesBufferRead(String directory) throws IOException {
        System.out.println("------------Read file with Files.newBufferedReader----------------------");
        /*
        Console console = System.console();
        if(console == null){

            System.out.print("please enter a file path to the scanner :");
            directory = scan.nextLine();
            System.err.println("Console is not available...");
            //the nonzero argument in exit() indicate abnomal termination.
            //System.exit(1);
        } else {
            directory = console.readLine("please enter a file path to this console:");
        }

        */

        try {
            //https://www.baeldung.com/reading-file-in-java
            buffReader = Files.newBufferedReader(Paths.get(directory));
            //buffReader = new BufferedReader(new FileReader(path));
            String scanLine;
            while((scanLine = buffReader.readLine()) != null){
                storeInput.convertStringToMember(scanLine);
                System.out.println(scanLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(buffReader != null){
                buffReader.close();
            }
        }

    }//end consoleRead

    public void filesLinesRead(String directory) throws URISyntaxException, IOException {
        System.out.println("------------- testing Files.lines ------------------");
        /*
        //https://mkyong.com/java8/java-8-stream-read-a-file-line-by-line/
        System.out.print("please enter a file path to this scanner :");
        String directory = scan.nextLine();
         */
        Path fielPath = Paths.get(directory);

        Stream<String> lines = Files.lines(fielPath);
        List<String> memberStream = lines.collect(Collectors.toList());
            for(String s : memberStream){
                storeInput.convertStringToMember(s);
                System.out.println(s.toString());
            }
        lines.close();

        }

    public void classLoaderPathFile (String directory) throws URISyntaxException, IOException {
        System.out.println("------------- testing classLoader  ------------------");

        //buffReader = new BufferedReader(new FileReader(directory));
        urlPath = getClass().getClassLoader().getResource(directory);
        path = Paths.get(urlPath.toURI());
        //short version
        //path = Paths.get(getClass().getClassLoader().getResource(directory).toURI());
        buffReader = Files.newBufferedReader(path);
        String eachline;
        while ((eachline = buffReader.readLine()) != null){
            System.out.println(eachline.toString());
            storeInput.convertStringToMember(eachline);
        }
    }

    public void randomAccessFileRead(String directory) throws FileNotFoundException {
        System.out.println("-------------- Testing RandomAccessFile --------------");

        RandomAccessFile raFile= new RandomAccessFile(directory, "rwd");
    }

    public void printmember(){
        System.out.println("------------- print out members ----------------");
        List<Member> memberList = storeInput.getMemberAsList();
        for(Member fm : memberList){
            System.out.println(fm.toString());
        }//end for
    }//end printMember

    public void bufferedFileWrite (Path path) throws IOException {
        System.out.println("------------ Write a File with bufferedWriter ---------------- ");
        //File outputFile = path.toFile();
        buffFilesWriter = Files.newBufferedWriter(path);
        List<Member> outputlist = storeInput.getMemberAsList();

        for(Member family : outputlist){
            buffFilesWriter.write(family.toString());
            buffFilesWriter.newLine();
        }

        buffFilesWriter.close();
    }

    public void newBufferedWriter(String directory) {
        setDirectory(directory);
        //outUriFilePath = Paths.get(URI.create(directory));
        outFilePath = Paths.get(directory);
        try {

            if (Files.notExists(outFilePath)){
                Files.createDirectories(outFilePath);
                Files.createFile(outFilePath);
            }

            buffNewWriter = new BufferedWriter(new FileWriter(outFilePath.toFile()));
            List<Member> outputlist = storeInput.getMemberAsList();
            for(Member fa: outputlist){
                buffNewWriter.write(fa.toString());
                buffNewWriter.newLine();
            }
            buffNewWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }


}//end class
