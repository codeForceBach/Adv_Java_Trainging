package designPatterns.behaviors.command;

public class PrintCommand implements Command{
    private Response response;

    public PrintCommand(Response response) {

        this.response = response;
    }

    @Override
    public void execute() {
    response.print();
    }
}
