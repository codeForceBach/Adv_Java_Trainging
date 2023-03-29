package javaEssential.oop.abstraction;

import java.nio.file.Path;

public class DigitOnlyFileReader extends AbstractFileReader{

    public DigitOnlyFileReader(String filepath) {
        super(filepath);
    }

    @Override
    protected String parseLine(String line) {
        return line.replaceAll("[^0-9]", "");

    }
}
