package designPatterns.behaviors.interpreter.lynda;


public class FirstLetterLowerCase implements Expression{

    private PrimitiveTerminal nameNoPrimitiveType = new PrimitiveTerminal();

    @Override
    public String interpreter(String context) {
        context = context.substring(0, 1).toLowerCase() + context.substring(1);
        System.out.println("result with lowercase : " + context);
        return nameNoPrimitiveType.interpreter(context);
    }
}
