package designPatterns.behaviors.interpreter.sfwGuru;

public class DivisionExpression implements NumExpression {

    private NumExpression firstExpression, secondExpression;
    public DivisionExpression(NumExpression firstExpression, NumExpression secondExpression) {
        this.firstExpression = firstExpression;
        this.secondExpression = secondExpression;
    }

    @Override
    public int interpret() {
        return this.firstExpression.interpret() / this.secondExpression.interpret();
    }
}
