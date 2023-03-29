package designPatterns.behaviors.ChainResponsibility;


public class XmlDocumentHandler extends DocumentHandler{
    public XmlDocumentHandler(DocumentHandler docHandler) {

        super(docHandler);
    }

    @Override
    public void openDocument(DocType type){
        if(type == DocType.XML){
            System.out.println("Open Xml Document file....");
        } else
            docHandler.openDocument(type);

    }
}
