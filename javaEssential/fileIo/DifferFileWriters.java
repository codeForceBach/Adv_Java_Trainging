package javaEssential.fileIo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class DifferFileWriters {

    BufferedWriter buffNewWriter, buffFilesWriter;
    InputListHelper familyList;
    List<Member> outputlist;

    public void bufferedFileWrite (Path path) throws IOException {
        System.out.println("------------ Write a File with bufferedWriter ---------------- ");
        //File outputFile = path.toFile();
        buffFilesWriter = Files.newBufferedWriter(path);
        outputlist = familyList.getMemberAsList();
        buffFilesWriter.write(outputlist.toString());
    }

    public void bufferedNewWriter(Path path) throws IOException {
        buffNewWriter = new BufferedWriter(new FileWriter(path.toFile()));
        outputlist = familyList.getMemberAsList();
        buffNewWriter.write(outputlist.toString());

    }

}
