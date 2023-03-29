package functionalWtStream;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;
import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.groupingBy;

public class StreamExplore {

        public static void main(String[] args) {
         /*
        Create a Functional interface as Anonymous class with new keyword would create new instance
        */
        System.out.println("Anonymous Class instantiation");
        for(int i = 0; i < 5; i++){
            Consumer<String> msg = new Consumer<String>() {
                @Override
                public void accept(String s) {System.out.println("Consuming : " + s);
                }
            };
            msg.accept(msg.toString());
        }

        /*
        the lambda expression store copy of instance in memory thus, doesn't require to create a new instance
        rather reuse same instance for the lambda expression
         */
        System.out.println("\nNon-capturing Lambda:");
        for(int i = 0; i < 5; i++){
            Consumer<String> print = msg -> System.out.println("Consuming ~ " + msg);
            print.accept(print.toString());

        }

        (new StreamExplore()).lambdaInstantCopy();
        (new StreamExplore()).lambdaMethodReference();
    }//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ End main method ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public void lambdaMethodReference() {

        List<String> privateclList = Arrays.asList("java", "python", "c#", "swift");
        System.out.println("default implementation of List.forEach()\n");
        privateclList.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });//end forEach

        System.out.println("\n\t\t* Alternative Lambda Expression \n");
        privateclList.forEach(stList -> System.out.println(stList));

        System.out.println("\n\t\t** Alternative method reference \n");
    }


     //current java compilier is smart enough to know that it is same instance
    public void lambdaInstantCopy() {
        System.out.println("\n Instance-Capturing lambda");
        for(int i = 0; i < 5; i++ ){
            Consumer<String> print4 = msg -> System.out.println("Consuming - " + msg);
            print4.accept(print4.toString());
        }
    }// end  method


    //functional program as recursive version that requires linear space

    public static int arraySumRecur(final int[] array, final int start) {
        if (start >= array.length)
            return 0;
        else
            return array[start] + arraySumRecur(array, start + 1);
    }

    //Static sequences of objects
    Stream<Integer> fib = Stream.of(1, 1, 2, 3);
    Stream <String> italianNumber = Stream.of("uno", "due", "Tre");

    Employee [] emps;
    Stream<Employee> empStream = Stream.of(emps);

    //Stream from arrays are ordered and sequential
    Stream<Employee> empArryStream = Arrays.stream(emps);

    //Streams from lists are ordered, sets are unordered.
    Collection<Employee> empC;
    Stream<Employee> empCStream = empC.stream();

    //stream from computation with supplier or unaryOperator
    //computed streams are infinite and no bound on their length and only a finite number of them will be ever be created.

    //select 10 random positive distinct integers with stream operation
    public static void StreamFilterSamples (){
        final Random random= new Random();
        Stream<Integer> randomNum = Stream.generate(random::nextInt);

        /*
          *distinct() - One of the few stateful intermediate Operations
              - it doesn't operate independently on each elements
              - harder to parallelize
         */
        randomNum.filter(n -> n>0)
                .distinct()//limit duplicate
                .limit(10)
                .forEach(System.out::println);
        /*
        Switch the operation between disticnt and filter is not so efficient.
         since the distinct is more complicate duplicate negative number
        randomNum.distinct()
                .filter(n -> n>0)
                .limit(10)
                .forEach(System.out::println);
         */

        /*
        Switch the operation between disticnt and limit would return fewer thatn 10 positive number
        since the limit would only return 10 number prior to distinct which would remove duplicate number within 10 number
        randomNum.filter(n -> n>0)
                .limit(10)
                .distinct()
                .forEach(System.out::println);
         */
    }//end  streamfilter method

    public static void streamMap(){
        Employee john = new Employee("John", 35, 60000.0, "Woodenville");
        Employee mary = new Employee("Mary", 23, 80000.0, "Seattle");
        Employee adam = new Employee("Adam", 28, 68000.0, "Kirkland");
        Employee joe = new Employee("Joe", 30, 75000.0, "Shoreline");

        Stream<Employee> stEmpy = Stream.of(john, mary, adam, joe);
        stEmpy.map(Employee::getAddress)
                .map(Address::getCity)
                //.map(City::getName)
                .distinct()
                .forEach(System.out::println);

        Stream<Employee> stEmpySalery = Stream.of(john, mary, adam, joe);

        stEmpySalery.sorted(Comparator.comparingDouble(Employee::getSalary)
                .reversed())
                .limit(10)
                .map(Employee::getName)
                .forEach(System.out::println);

        List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,14);
        long n = intList.parallelStream()
                .unordered()
                .distinct()
                .count();

        /*
        Basic terminal Operations
  extract a single elements
  put all elements in an array
  count the elements
  check condition
  execute arbitrary code on each element
         */


    }//end streamMap method

    //https://codereview.stackexchange.com/questions/205898/stream-operation-with-two-dimensional-array#
    /*
    given String array to bet the highest average score in double
    /String[][] scores = {
                    {"Amit", "70"},
                    {"Author", "60"},
                    {"Peterson", "90"},
                    {"Author", "100"}
            };
      Expected result: 80
     */
    public static double maxAverage(String[][] scores){

       int maxAve = Integer.MIN_VALUE;
        Function<String[], Integer> function = new Function<String[], Integer>() {
            @Override
            public Integer apply(String[] t) {
                int sum = 0, count = 0;
                for(int i = 0; i < scores.length; i++){
                    if(t[0].equals(scores[i][0])){
                        count++;
                        sum+= parseInt(scores[i][1]);
                    }
                }
                int average = sum / count;
                return maxAve < average? average : maxAve;
            }
        };
        System.out.println("the result is : " + Arrays.stream(scores)
                .map(function)
                .max((o1, o2)-> o1.compareTo(o2)).get());
        return Arrays.stream(scores)
                .map(function)
                .max((o1, o2)-> o1.compareTo(o2)).get();

    }


    public static double maxAverageSt(String[][] scores){
        double higestAvg = Arrays.stream(scores)
            .collect(groupingBy(s -> s[0], averagingInt(s -> parseInt(s[1]))))
            .values()
            .stream()
            .max(Comparator.naturalOrder())
            .get();
        System.out.println("the stream result is : " + higestAvg);
        return higestAvg;

    }//end maxAverageSt

}//end class
