package ru.job4j;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* Test.
*
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 16.08.2017
* @version 2.0
*/

public class CalculateTest {
/**
* Test add.
*/
    @Test
	public void whenAddOneToOneThenTwo() {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));
    Calculate.main(null);
    assertThat(
         out.toString(),
         is(
            String.format(
                   "Hello, world%s",
                    System.getProperty("line.separator")
            )
        )
    );
	}
}
	