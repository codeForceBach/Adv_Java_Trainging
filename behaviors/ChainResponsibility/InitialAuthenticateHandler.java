package designPatterns.behaviors.ChainResponsibility;

public class InitialAuthenticateHandler extends AuthenticateHandler{

    public InitialAuthenticateHandler(AuthenticateHandler handler) {

        super(handler);
    }

    @Override
    public void handleRequest(String requestType) {
        if (requestType.equalsIgnoreCase("int")){
            System.out.println("Process Initial Authentication request ...");
        } else {
            handler.handleRequest(requestType);
        }
    }
}
