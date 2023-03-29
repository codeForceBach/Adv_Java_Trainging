package javaEssential.appetizers.utils;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;

import static java.text.DateFormat.getDateTimeInstance;

public class DateTimeHelper {

    //https://www.linkedin.com/learning/java-essential-training-objects-and-apis/work-with-dates-and-times?u=26281682
    public static void getDate() {
        //old Date time API
        Date now = new Date();
        System.out.println(now);

        //month count start at index 0
        GregorianCalendar gc = new GregorianCalendar(2009, 1, 28);
        Date d1 = gc.getTime();
        System.out.println("month count start at index 0 : " + d1);
        gc.add(GregorianCalendar.DATE, 1);
        Date d2 = gc.getTime();
        System.out.println(d2);
        DateFormat df = getDateTimeInstance();
        System.out.println(df.format(d2));

        //New Date API
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        //month start at index 1
        LocalDate ld = LocalDate.of(2010, 1, 28);
        System.out.println("month start at index 1 : " + ld);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(dtf.format(ld));
    }
}
