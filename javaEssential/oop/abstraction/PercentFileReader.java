package javaEssential.oop.abstraction;

public class PercentFileReader extends AbstractFileReader{
    public PercentFileReader(String filepath) {
        super(filepath);
    }

    @Override
    protected String parseLine(String line) {
        return line.replace("%", " percents");
    }
}
