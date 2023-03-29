package javaEssential.oop.abstraction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractFileReader {
    private final Path filePath;

    protected AbstractFileReader(String filepath) {
//http://tutorials.jenkov.com/java-nio/path.html
        this.filePath = Paths.get(filepath);
    }

    public String getPath(){
        return filePath.toString();
    }

    public List<String> readFile() throws IOException {
        return Files.lines(filePath)
                .map(this::parseLine)
                .collect(Collectors.toList());
    }

    protected abstract String parseLine(String line);
}
