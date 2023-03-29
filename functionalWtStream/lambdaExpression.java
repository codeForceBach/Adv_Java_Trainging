package functionalWtStream;

//https://www.linkedin.com/learning/functional-programming-with-streams-in-java-9/writing-your-first-lambda-expression?u=26281682

import com.google.gson.internal.bind.util.ISO8601Utils;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
1) how to write lamdaExpression with typing issues related to lamdaExpression.
2) how lambda expression can access values from the surrounding context.
3) method reference
 */

public class lambdaExpression {

    //moving from anonymous classes to lambda expressions
    //remove parameter types, parentheses and curly braces.

    //simple Comparator ex
    Comparator<String> byLength = (String a, String b) ->{
        return Integer.compare(a.length(), b.length());};


    Comparator<Employee> byName = new Comparator<Employee>() {
        @Override
        public int compare(Employee a, Employee b) {
            return a.getName().compareTo(b.getName());
        }
    };

    //remove initialization of Comparator, no override
    Comparator<Employee> byNameLambda1 = (Employee a, Employee b)-> {
        return a.getName().compareTo(b.getName());
    };

    //remove parameter types
    Comparator<Employee> byNameLambda2 = (a, b) ->{
      return a.getName().compareTo(b.getName());
    };

    //remove braces and return :
    //the return statement goes together with braces if one of these missing it won't compile
    Comparator<Employee> byNameLambda3 = (a, b) ->
        a.getName().compareTo(b.getName());


    //Expression without parameter
    Runnable run = () -> {
        System.out.println("A compact Runnable");
    };
    Thread t1 = new Thread(run);

    //no Runnable initialization in a single line
    Thread t2 = new Thread(() -> {
        System.out.println("An Implicit Runnable.");
    });

    //no curly brace
    Thread t3 = new Thread(() -> System.out.println("An Implicit Runnable."));

    Consumer <String> lengthPrinter = a -> System.out.println(a.length());

    //next -> https://www.baeldung.com/java-8-sort-lambda
    //next -> https://www.baeldung.com/java-8-streams

    Consumer<String> c1 = msg -> System.out.println(msg.length());
    //by casting to specific type of functional interface as casting,
    //context contain enough info to identify the functional Interface
    Object o3 = (Consumer<String>)((String msg)-> System.out.println(msg.length()));

    /*
    Method references in lambda
    Static Method, an instance with specified or unspecified instance method, Constructor, new array
     */

    Supplier<Thread> s1 = Thread::currentThread;
    ThreadSupplier ts1 = Thread::currentThread;


    Employee frank = new Employee("Frank", 39, 78000.0, "Shoreline");
    Double salary = frank.getSalary();
    Supplier<Double> fs = frank::getSalary;
   // System.out.println(fs.get());


}//end class

/**
 *
 */
interface ThreadSupplier{
    Thread giveMeThread();
}
