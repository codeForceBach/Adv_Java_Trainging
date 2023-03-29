package designPatterns.behaviors.ChainResponsibility;

public class DigestAuthenticateHandler extends AuthenticateHandler{

    protected DigestAuthenticateHandler handler;

    public DigestAuthenticateHandler(AuthenticateHandler handler){
        super(handler);
    }

    @Override
    public void handleRequest(String requestType){
        if (requestType.equalsIgnoreCase("digest")){
            System.out.println("Process Digest Authentication request . . . ");
        } else {
            handler.handleRequest(requestType);
        }

    }
}
