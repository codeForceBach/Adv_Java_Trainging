package designPatterns.behaviors.ChainResponsibility;


public class PdfDocumentHandler extends DocumentHandler{
    public PdfDocumentHandler(DocumentHandler docHandler) {
        super(docHandler);
    }

    @Override
    public void openDocument(DocType type){
        if(type == DocType.PDF){
            System.out.println("Open PDF file....");
        } else
            docHandler.openDocument(type);

    }
}
