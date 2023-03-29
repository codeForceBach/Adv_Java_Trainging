package designPatterns.behaviors.ChainResponsibility;

public class DocumentHandler {
    public DocumentHandler docHandler;

    public DocumentHandler(DocumentHandler docHandler) {

        this.docHandler = docHandler;
    }

    public void openDocument(DocType type){
        if(docHandler != null){
            docHandler.openDocument(type);
        }
    }
}
