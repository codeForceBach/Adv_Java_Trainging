package designPatterns.behaviors.interpreter.sfwGuru;

public class AdditionalExpression implements NumExpression {

    private NumExpression firstExpression, secondExpression;
    public AdditionalExpression(NumExpression firstExpression, NumExpression secondExpression) {
        this.firstExpression = firstExpression;
        this.secondExpression = secondExpression;
    }

    @Override
    public int interpret() {
        return this.firstExpression.interpret() + this.secondExpression.interpret();
    }
}
