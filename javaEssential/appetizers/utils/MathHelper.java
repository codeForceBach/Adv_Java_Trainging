package javaEssential.appetizers.utils;

public class MathHelper {

    private double total;
    private String input;
    public static final String ADD = "+";
    public static final String SUBTRACT = "-";
    public static final String DIVISION = "/";
    public static final String MULTIPLY = "*";
    public static final String MODULAR = "%";

    InputHelper entry = new InputHelper();

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }


    //calculate value and total, based on operator and
    public double operation() {

        String opt = entry.getInput("choose one of operators ( +, -, *, / or %):");

            try {
                input = entry.getInput("" + "Enter a value : ");
            } catch (NumberFormatException ne) {
                System.out.println("All done!");
            }
            double value = Double.parseDouble(input);
            switch (opt) {
                case ADD:
                    total += value;
                    break;
                case SUBTRACT:
                    total -= value;
                    break;
                case DIVISION:
                    if (value == 0) {
                        System.out.println("Zero denominator is not allowed.");
                    } else {
                        total /= value;
                    }
                    break;
                case MULTIPLY:
                    if (total == 0.0) {
                        total = 1 * value;
                        System.out.println("current total was zero");
                    } else {
                        total *= value;
                    }
                    break;
                case MODULAR:
                    total %= value;
                    break;
                default:
                    System.out.println("operator outside of ( +, -, *, / or %) is not allows.");
                    System.out.println("Please enter one of the operator.");
            }//end switch
        return value;
    }//end operation
}
