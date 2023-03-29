package designPatterns.behaviors.interpreter.lynda;

public class PrimitiveTerminal implements Expression{

    @Override
    public String interpreter(String context) {
        if ( context.equals("int") || (context.equals("double")) || (context.equals("long"))){
            context = "\"" + context + " \" is complete check syntax!";
            System.out.println(context);
        }
        return context;
    }
}
