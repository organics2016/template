package ink.organics.openjdk11;


import org.junit.Test;

import java.time.LocalDateTime;

public class DateTest {


    @Test
    public void test() {


        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);
    }

}
