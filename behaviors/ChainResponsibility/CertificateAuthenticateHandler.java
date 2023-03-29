package designPatterns.behaviors.ChainResponsibility;

public class CertificateAuthenticateHandler extends AuthenticateHandler{

    public CertificateAuthenticateHandler(AuthenticateHandler handler) {

        super(handler);
    }

    @Override
    public void handleRequest(String requestType) {
        if (requestType.equalsIgnoreCase("cert")){
            System.out.println("Process Client Certificate Authentication request ...");
        } else handler.handleRequest(requestType);
    }
}
