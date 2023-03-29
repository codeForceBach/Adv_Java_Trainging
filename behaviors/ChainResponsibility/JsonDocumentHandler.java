package designPatterns.behaviors.ChainResponsibility;


public class JsonDocumentHandler extends DocumentHandler{

    public JsonDocumentHandler(DocumentHandler docHandler) {

        super(docHandler);
    }

    @Override
    public void openDocument(DocType type){
        if(type == DocType.JSON){
            System.out.println("Open json Document file....");
        } else {
            docHandler.openDocument(type);
        }
    }
}
