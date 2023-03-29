package designPatterns.behaviors.command;

public class SaveCommand implements Command{

    private Response response;

    public SaveCommand(Response response) {
        this.response = response;
    }

    @Override
    public void execute() {
        response.save();
    }
}
