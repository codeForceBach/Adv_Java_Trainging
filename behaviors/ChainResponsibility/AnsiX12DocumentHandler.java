package designPatterns.behaviors.ChainResponsibility;


public class AnsiX12DocumentHandler extends DocumentHandler{
    public AnsiX12DocumentHandler(DocumentHandler docHandler) {

        super(docHandler);
    }

    @Override
    public void openDocument(DocType type){
        if(type == DocType.EDI){
            System.out.println("Open Ansi X12 Document file....");
        } else
            docHandler.openDocument(type);

    }
}
