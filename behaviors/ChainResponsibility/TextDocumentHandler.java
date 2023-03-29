package designPatterns.behaviors.ChainResponsibility;


public class TextDocumentHandler extends DocumentHandler{

    public TextDocumentHandler(DocumentHandler docHandler) {

        super(docHandler);
    }

    public void openDocument(DocType type){
        if(type == DocType.TXT){
            System.out.println("Open Text Document file....");
        } else
            docHandler.openDocument(type);
    }
}
