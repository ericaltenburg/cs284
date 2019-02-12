package practice;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Author: Eric Altenburg
 * Date: 9/28/18
 **/
public class ExampleTest {

    @Test
    public void test() {
        Example h1 = new Example(4,2);
        assertEquals(h1.add(), 6);
    }
}
