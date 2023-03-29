package javaEssential.oop.lambdas;

public class LambdaTests {

    public static void main(String[] args) {

        //lambda  - method reference sample
        Square s = new Square(4);

        /*
        Shapes shapes = (Square square) ->{
            return square.calculateArea();
        };
        */
     //replace above commented block of code as method reference
        Shapes shapes = Square::calculateArea;

        System.out.println("Area" + shapes.getArea(s));
    }
}
