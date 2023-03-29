package functionalWtStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class MethodReferenceExTests {

    MethodReferenceEx MtRf = new MethodReferenceEx();

    Employee john = new Employee("John", 35,  60000.0, "Woodenville");
    Employee mary = new Employee("Mary", 23, 80000.0, "Seattle");
    Employee adam = new Employee("Adam", 28,  68000.0, "Kirkland");
    Employee joe = new Employee("Joe", 30, 75000.0, "Shoreline");
    List<Employee> epyList = Arrays.asList(john, mary, adam, joe);

    @Test
    @DisplayName("Testing Static class Ananymouse class reference")
    void StaticAnanymouseConvertTest(){
        //List<Integer> num = Arrays.asList(1,2,3,4);
        List<String> clList = Arrays.asList("1", "2", "3", "4");
        List<Integer> convertList = MtRf.StaticAnanymouseConvert(clList);
        assertEquals(convertList.get(3), 4);
        assertEquals(convertList.size(), 4);
    }//edn test

    @Test
    @DisplayName("Testing Static class lambda expression reference!")
    void staticLambdaConvertTest(){
        List<String> numSt = Arrays.asList("1", "2", "4", "8", "16", "32", "48");
        List<Integer> convertList = MtRf.staticLambdaConvert(numSt);
        assertEquals(convertList.get(5), 32);
        assertEquals(convertList.size(), 7);
    }//end test

    @Test
    @DisplayName("Test Static class method reference method")
    void staticMethodRefConvertTest(){
        List<String> numSt = Arrays.asList("1", "2", "4", "8", "16", "32", "48");
        List<Integer> convertList = MtRf.staticMethodRefConvert(numSt);
        assertEquals(convertList.get(5), 32);
        assertEquals(convertList.size(), 7);
    }//End test

    @Test
    @DisplayName("Tests different method call compare in static class")
    void StaticMethodCompareTest(){
        List<String> numSt = Arrays.asList("1", "2", "4", "8", "16", "32", "48");
        List<Integer> MethodRefList = MtRf.staticMethodRefConvert(numSt);
        List<Integer> LambdaList = MtRf.staticLambdaConvert(numSt);
        List<Integer> ananymousList = MtRf.StaticAnanymouseConvert(numSt);
        assertEquals(MethodRefList.get(4), LambdaList.get(4));
        assertEquals(ananymousList.size(), MethodRefList.size());
    }

    @Test
    @DisplayName("Testing istMethodRefAnanymouseSort with EmployCompartor with Age")
    void istMethodRefAnanymouseSortTest(){
        List<Employee> anonySortList = MtRf.istMethodRefAnanymouseSortByAge(epyList);
        List<Employee> anonylambdalist = MtRf.istMethodRefAnanymouseSortByAge(epyList);
        List<Employee> anonyMethReflist = MtRf.istMethodRefMethodRef(epyList);
        assertEquals(anonylambdalist.get(3), anonySortList.get(3));
        assertEquals(anonyMethReflist.get(1), anonySortList.get(1));
        assertEquals(anonyMethReflist.get(2).getName(), anonylambdalist.get(2).getName());
    }

    @Test
    @DisplayName("Testing instance comparator with lambda expression by Name of Employee")
    void instanceCompartorSortTest(){
        List<Employee>instanceSortList = MtRf.anonymousClassCompareByname(epyList);
        List<Employee> instanceLambdaSortList = MtRf.lambdaComparebyName(epyList);
        List<Employee> instancelambdaShortList = MtRf.lambdaShortCompareByName(epyList);

    }

    @Test
    @DisplayName("Tests Reference to an instance method of an arbitrary object of a particular type")
    void biFunctionInvoiceCalculatorTest(){
        Invoice inv = new Invoice("A0001", BigDecimal.valueOf(1.99), 3);
        InvoiceCaculator invCalculate = new InvoiceCaculator();

        BigDecimal normalCalLambda = MtRf.calculate(invCalculate, inv, (f, o) -> f.normalCal(o));
        BigDecimal normalCalMethodRef = MtRf.calculate(invCalculate, inv, InvoiceCaculator::normalCal);
        BigDecimal promoCalLambda = MtRf.calculate(invCalculate, inv, (f, o) -> f.promoteCal(o));
        BigDecimal promoCalMethodRef = MtRf.calculate(invCalculate, inv, InvoiceCaculator::promoteCal);

        assertEquals(normalCalLambda, normalCalMethodRef);
        assertEquals(promoCalLambda, promoCalMethodRef);

    }

    @Test
    @DisplayName("Teasting default constructor with lambda and Method Reference")
    void defaultConstructCallTests(){
        Supplier<Map> hashmapObj1 = () -> new HashMap();
        Supplier<Map> hashmapObj2 = HashMap::new;
        assertNotEquals(hashmapObj1, hashmapObj2);

        //constructor with method Reference is limited to no argument constructor, single argument or empty argument constructor
        Supplier<Invoice> invObj1 = () -> new Invoice();
        Supplier<Invoice> invObj2 = Invoice::new;
        assertNotNull(invObj1);

    }

    @Test
    @DisplayName("Testing constructor reference call with function")
        /*
    4 - Reference to a constructor
    // constructor with method Reference is limited to no argument constructor, single argument or empty argument constructor
     */
    void invoiceListTest(){
        List<BigDecimal> priceList = Arrays.asList(
                BigDecimal.valueOf(9.99),
                BigDecimal.valueOf(16.78),
                BigDecimal.valueOf(19.45)
        );

        List<Invoice> invoices = MtRf.invoiceList(priceList, Invoice::new);
        invoices.forEach(System.out::println);
        assertFalse(invoices.isEmpty());
        assertEquals(BigDecimal.valueOf(16.78), invoices.get(1).getUnitPrice());
    }

}//end test class