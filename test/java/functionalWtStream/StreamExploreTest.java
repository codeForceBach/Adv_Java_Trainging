package functionalWtStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static functionalWtStream.StreamExplore.maxAverage;
import static functionalWtStream.StreamExplore.maxAverageSt;
import static org.junit.jupiter.api.Assertions.*;

class StreamExploreTest {

    List<Employee> employee = new ArrayList<>();

    Employee john = new Employee("John", 35, 60000.0, "Woodenville");
    Employee mary = new Employee("Mary", 23, 80000.0, "Seattle");
    Employee adam = new Employee("Adam", 28, 68000.0, "Kirkland");
    Employee joe = new Employee("Joe", 30, 75000.0, "Shoreline");

    Stream<Employee> stEmpy = Stream.of(john, mary, adam, joe);

    @Test
    void streamFilterSamplesTest() {
       Employee youngster = employee.stream()
               .filter(st -> st.getAge() == 23)
                .findAny()
                .orElse(null);
    }

    @Test
    @DisplayName("Validate two method that implement stream function")
    void ValidteMaxAverageWithMaxAverageSt() {
        String[][] scores = {
                {"Amit", "70"},
                {"Author", "60"},
                {"Peterson", "90"},
                {"Author", "100"}
        };
        assertEquals( maxAverage(scores), maxAverageSt(scores));
    }

}