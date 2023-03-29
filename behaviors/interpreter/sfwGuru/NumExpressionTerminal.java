package designPatterns.behaviors.interpreter.sfwGuru;

public class NumExpressionTerminal implements NumExpression {
    private int number;

    public NumExpressionTerminal (int number){
        this.number = number;
    }

    public NumExpressionTerminal(String number){
        this.number = Integer.parseInt(number);

    }

    @Override
    public int interpret() {
        return this.number;
    }
}
