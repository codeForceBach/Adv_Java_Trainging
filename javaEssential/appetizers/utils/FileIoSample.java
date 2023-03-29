package javaEssential.appetizers.utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileIoSample {

    //https://www.linkedin.com/learning/java-essential-training-objects-and-apis/copy-files-with-readers-and-buffers?u=26281682
    private String sourceFile = "files/received_20210621130233519.Json";
    private String targetFile = "files/formatted.Json";
    private String copyFile = "files/copied.Json";
    static FileIoSample echo = new FileIoSample();

    //https://github.com/google/gson -
    public static void readAndWrite() throws IOException {
        FileReader fileReader = new FileReader(echo.sourceFile);
        BufferedReader bufferReader = new BufferedReader(fileReader);
        FileWriter writer = new FileWriter(echo.targetFile);
        while(true){
            String line = bufferReader.readLine();
            if(line == null){
                break;
            }
        writer.write(line + "--line End!");
        }

    }
    public String getSourceFile() {
        return sourceFile;
    }

    public void setSourceFile(String sourceFile) {
        this.sourceFile = sourceFile;
    }

    public String getTargetFile() {
        return targetFile;
    }

    public void setTargetFile(String targetFile) {
        this.targetFile = targetFile;
    }//end readAndWrite

    //new java API
    public static void filePath() {
        Path sourceFile = Paths.get("files", "received_20210621130233519.Json");
        Path targetFile = Paths.get("files", "copied.json");

        try {
            Files.copy(sourceFile, targetFile, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//end filePath

    }
