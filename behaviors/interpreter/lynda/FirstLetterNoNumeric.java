package designPatterns.behaviors.interpreter.lynda;

public class FirstLetterNoNumeric implements Expression{

    private FirstLetterNoUnderscore noUnderscore = new FirstLetterNoUnderscore();
    @Override
    public String interpreter(String context) {
        if(context.substring(0, 1).matches("\\d")){
            context = context.substring(1);
            System.out.println("result without number : " + context);
        }

        return noUnderscore.interpreter(context);
    }
}
