package designPatterns.behaviors.interpreter.sfwGuru;

import designPatterns.behaviors.interpreter.lynda.Expression;

public class ParseUtil {

    public static boolean isOperator(String symbol){
        return (symbol.equals("+") || symbol.equals("-") || symbol.equals("*") || symbol.equals("/"));

    }

    public static NumExpression getExpressionObject(NumExpression firstExpression, NumExpression secondExpression, String symbol){
        NumExpression resultExpression;
        switch (symbol){
            case "+" : resultExpression =  new AdditionalExpression(firstExpression, secondExpression);
                break;
            case "-" : resultExpression =  new SubtractionExpression(firstExpression, secondExpression);
                break;
            case "*" : resultExpression =  new MultipicationExpression(firstExpression, secondExpression);
                break;
            case "/" : resultExpression =  new DivisionExpression(firstExpression, secondExpression);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + symbol);
        }//end switch

        return resultExpression;
    }
}
