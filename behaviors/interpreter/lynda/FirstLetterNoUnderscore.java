package designPatterns.behaviors.interpreter.lynda;

public class FirstLetterNoUnderscore implements Expression{
    private FirstLetterLowerCase firstLetterLowerCase = new FirstLetterLowerCase();
    @Override
    public String interpreter(String context) {
        if (context.startsWith("_")){
            context = context.substring(1);
            System.out.println("result without underscore : " + context);

        }
        return firstLetterLowerCase.interpreter(context);
    }
}
