package functionalWtStream;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MethodReferenceEx {

    public static void main(String[] args) {
        //objectMethodRefAnonymousSort set up for testing
        Employee john = new Employee("John", 35, 60000.0, "Woodenville");
        Employee mary = new Employee("Mary", 23, 80000.0, "Seattle");
        Employee adam = new Employee("Adam", 28, 68000.0, "Kirkland");
        Employee joe = new Employee("Joe", 30, 75000.0, "Shoreline");

        List<Employee> epyList = Arrays.asList(john, mary, adam, joe);
        EmployeeComparator epyComparator = new EmployeeComparator();

        epyList.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return epyComparator.compareByAge(o1, o2);
            }
        });

    }///~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ end main method ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    /*
    https://mkyong.com/java8/java-8-method-references-double-colon-operator/
    1-2. static method
     */
    public List<Integer> StaticAnanymouseConvert(List<String> stList) {
        //ananymous class
        List<Integer> convert = stList.stream()
                .map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) {
                        return Integer.parseInt(s);
                    }
                })
                .collect(Collectors.toList());
        return convert;
    }

    public List<Integer> staticLambdaConvert(List<String> stList){
        //lambda Expression
         List<Integer> convert2 = stList.stream()
                .map(str->Integer.parseInt(str))
                .collect(Collectors.toList());
         return convert2;
    }

    public List<Integer> staticMethodRefConvert(List<String> stList){
        //method reference
        List<Integer> convert = stList.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return convert;
    }//end staticMethodRefConvert

    /*
    https://mkyong.com/java8/java-8-method-references-double-colon-operator/
    1-3. Lambda Expressions & Method References with BiFunction
    addTwoArgument implements Bifunction that requires two arguments and initialize the biFunction
    which requires same type of argument and return type and Function which is a method that implement abstact method "Apply"
    the apply method bined to return same type of the return type of BiFunction.
     */
    //ananymouse class
    public String StaticAnanymouseBiFunct(Integer i1, Integer i2){
        //ananymouse class
        String combindInt = addTwoArgument(i1, i2, new BiFunction<Integer, Integer, String>() {
            @Override
            public String apply(Integer a, Integer b) {
                return IntUti.sum(a, b);//reference to inncer class
            }
        });
        return combindInt;
    }

    public String lambdaBiFunct(Integer i1, Integer i2){
        String combineInt = addTwoArgument(i1, i2, (a, b) -> IntUti.sum(a, b));
        return combineInt;
    }

    public String methodRefSum (Integer i1, Integer i2){
        String combineInt2 = addTwoArgument(i1, i2, IntUti::sum);
        return combineInt2;
    }

    private static <R> R addTwoArgument(Integer i1, Integer i2, BiFunction<Integer, Integer, R> func){
        return func.apply(i1, i2);
    }

    /*
    https://mkyong.com/java8/java-8-method-references-double-colon-operator/
    2-1. Instance Method of particular object
     */

    public List<Employee> istMethodRefAnanymouseSortByAge(List <Employee> epyList){
        //Comparator with instance method
        Comparator<Employee> byAgeCompare = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                Integer o1Age = o1.getAge();
                Integer o2Age = o2.getAge();
                return o1Age.compareTo(o2Age);
            }
        };

        epyList.sort(byAgeCompare);

        /*
        //comparator with instance class
        EmployeeComparator epyComparator = new EmployeeComparator();
       epyList.sort(new Comparator<Employee>() {
            public int compare(Employee o1, Employee o2) {
                return epyComparator.compareByAge(o1, o2);
            }
        });
         */
       epyList.forEach(System.out::println);
        return epyList;
    }

    public List<Employee> istMethodRefLambda(List <Employee> epyList){
        //instance method with lambda
        Comparator<Employee> byAgeCompare = (o1, o2) -> {
            Integer o1Age = o1.getAge();
            Integer o2Age = o2.getAge();
            return o1Age.compareTo(o2Age);
        };
        epyList.sort(byAgeCompare);
        /*
        EmployeeComparator epyComparator = new EmployeeComparator();
        epyList.sort((e1, e2) -> epyComparator.compareByAge(e1, e2));
         */
        epyList.forEach(System.out::println);
        return epyList;
    }

    public List<Employee> istMethodRefMethodRef(List<Employee> epyList){
        /*
        Lambda expression limit the use if the paremeter need any conversion
        Comparator<Employee> byAgeCompare = (e1, e2) -> e1.getAge().compareTo(e2.getAge());
            Integer e1Age = e1.getAge();
            Integer e2Age = e2.getAge();
            e1Age.compareTo(e2Age);
         */
        
        EmployeeComparator epyComparator = new EmployeeComparator();
        epyList.sort(epyComparator::compareByAge);
        
        epyList.forEach(System.out::println);
        return epyList;
    }//End method

    public List<Employee> anonymousClassCompareByname(List<Employee> epyList){
        Comparator<Employee> byNameCompare = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        epyList.sort(byNameCompare);
        epyList.forEach(System.out::println);
        return epyList;
    }

    public List<Employee> lambdaComparebyName(List<Employee> epyList){
        Comparator<Employee> byNameLambdaCompare = (Employee e1, Employee e2) -> {
            return e1.getName().compareTo(e2.getName());
        };
        epyList.sort(byNameLambdaCompare);
        epyList.forEach(System.out::println);
        return epyList;
    }

    public List<Employee> lambdaShortCompareByName(List <Employee> epyList){
        Comparator<Employee> byNameShortLambda = (e1, e2) -> e1.getName().compareTo(e2.getName());
        epyList.sort(byNameShortLambda);
        epyList.forEach(System.out::println);
        return epyList;
    }

    /*
    3-3. Reference to an instance method of an arbitrary object of a particular type
     */
    //utiliize biFunction
    public BigDecimal calculate (InvoiceCaculator invCalculate, Invoice inv, BiFunction<InvoiceCaculator, Invoice, BigDecimal> funct){
        return funct.apply(invCalculate, inv);
    }

    /*
    4 - Reference to a constructor
    // constructor with method Reference is limited to no argument constructor, single argument or empty argument constructor
     */
    public List<Invoice> invoiceList(List<BigDecimal> priceList, Function<BigDecimal, Invoice> func){
        List<Invoice> invoiceList = new ArrayList<>();
        for(BigDecimal bd : priceList){
            invoiceList.add(func.apply(bd));
        }
        return invoiceList;
    }


}// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ end class ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

//inner class for StaticMethodReferenceWithBiFunct
class IntUti{
    public static String sum(Integer z, Integer y){
        return String.valueOf(z+ y);
    }
}//end class

class EmployeeComparator {

    //not sure why it throwing error -> "int cannot be dereferenced"
    public int compareByAge(Employee e1, Employee e2){
        /*
        Integer ageE1 = e1.getAge();
        Integer ageE2 = e2.getAge();
        return ageE1.compareTo(ageE2);
         */
        return e1.getAge().compareTo(e2.getAge());
    }

    public int compareByName(Employee e1, Employee e2){
        return e1.getName().compareTo(e2.getName());
    }

    public int compareBysarely(Employee e1, Employee e2){
        return e1.getSalary().compareTo(e2.getSalary());

      /* Integer salaryE1 = e1.getSalary();
       Integer salaryE2 = e2.getSalary();
       return salaryE1.compareTo(salaryE2);

       */
    }

}//end EmployeeComparator class

class InvoiceCaculator{

    public BigDecimal normalCal (Invoice inv){
        return inv.getUnitPrice().multiply(BigDecimal.valueOf(inv.getQty()));
    }//edn method

    public BigDecimal promoteCal (Invoice inv){
        return inv.getUnitPrice()
                .multiply(BigDecimal.valueOf(inv.getQty()))
                .multiply(BigDecimal.valueOf(0.9))
                .setScale(2, RoundingMode.HALF_UP);
    }//end method

}//end InvoiceCalculator class
