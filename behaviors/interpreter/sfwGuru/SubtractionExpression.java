package designPatterns.behaviors.interpreter.sfwGuru;

public class SubtractionExpression implements NumExpression {
    private NumExpression firstExpression, secondExpression;

    public SubtractionExpression(NumExpression firstExpression, NumExpression secondExpression) {
        this.firstExpression = firstExpression;
        this.secondExpression = secondExpression;
    }

    @Override
    public int interpret() {
        return this.firstExpression.interpret() - this.secondExpression.interpret();
    }
}
