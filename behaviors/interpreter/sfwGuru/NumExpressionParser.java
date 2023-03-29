package designPatterns.behaviors.interpreter.sfwGuru;

import java.util.Stack;

public class NumExpressionParser {
    Stack numStack = new Stack<NumExpression> ();

    public int parse(String str){
        String[] tokenList = str.split(" ");
        for(String symbol: tokenList){
            if(!ParseUtil.isOperator(symbol)){
                //if the symbol is numeric value, add to stack
               NumExpression numberExpression = new NumExpressionTerminal(symbol);
                numStack.push(numberExpression);
                System.out.println(String.format("Pushed to Stack:  %d", numberExpression.interpret()));

            } else if (ParseUtil.isOperator(symbol)){
                //fi the symbol is operator, take two value from the stack and calculate according to the symbol.
                NumExpression firstExpression = (NumExpression) numStack.pop();
                NumExpression secondExpression = (NumExpression) numStack.pop();
                System.out.println(String.format("Popped operands %d and %d",
                        firstExpression.interpret(),
                        secondExpression.interpret()));
                NumExpression operator = ParseUtil.getExpressionObject(firstExpression, secondExpression, symbol);
                System.out.println(String.format("Applying Operator : %d", operator));

                int result = operator.interpret();
                NumExpressionTerminal resultExpression = new NumExpressionTerminal(result);
                numStack.push(resultExpression);
                System.out.println(String.format("paused result to stack : %d", resultExpression.interpret()));
            }//end if else

        }//End for
        //return numStack.pop().interpret();
        return 0;
    }//end parse method
}//end class
