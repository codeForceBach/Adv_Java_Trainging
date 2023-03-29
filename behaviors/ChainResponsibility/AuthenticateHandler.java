package designPatterns.behaviors.ChainResponsibility;

public class AuthenticateHandler {

    protected AuthenticateHandler handler;

    public AuthenticateHandler(AuthenticateHandler handler){

        this.handler = handler;
    }


    public void handleRequest(String requestType){
        if (handler != null){
            handler.handleRequest(requestType);
        }

    }
}
