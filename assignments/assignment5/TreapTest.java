package assignments;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Author: Eric Altenburg
 * Date: 11/3/18
 **/
public class TreapTest <E> {
    @Test
    public void test() {
        Treap t = new Treap<Integer>();

        //Adding in nodes to the treap
        assertEquals(t.add(4, 19), true);
        assertEquals(t.add(2, 31), true);
        assertEquals(t.add(6, 70), true);
        assertEquals(t.add(1, 84), true);
        assertEquals(t.add(3, 12), true);
        assertEquals(t.add(5, 83), true);
        assertEquals(t.add(7, 26), true);
        assertEquals(t.add(4, 19), false);

        //Making sure toString() is right
        assertEquals(t.toString(), "(key=1, priority=84)\n" +
                "\tnull\n" +
                "\t(key=5, priority=83)\n" +
                "\t\t(key=2, priority=31)\n" +
                "\t\t\tnull\n" +
                "\t\t\t(key=4, priority=19)\n" +
                "\t\t\t\t(key=3, priority=12)\n" +
                "\t\t\t\t\tnull\n" +
                "\t\t\t\t\tnull\n" +
                "\t\t\t\tnull\n" +
                "\t\t(key=6, priority=70)\n" +
                "\t\t\tnull\n" +
                "\t\t\t(key=7, priority=26)\n" +
                "\t\t\t\tnull\n" +
                "\t\t\t\tnull");

        //Finding
        assertEquals(t.find(5), true);
        assertEquals(t.find(9881), false);

        //Removing Node
        assertEquals(t.delete(9), false);
        assertEquals(t.delete(1), true);

        //toString()
        assertEquals(t.toString(), "(key=5, priority=83)\n" +
                "\t(key=2, priority=31)\n" +
                "\t\tnull\n" +
                "\t\t(key=4, priority=19)\n" +
                "\t\t\t(key=3, priority=12)\n" +
                "\t\t\t\tnull\n" +
                "\t\t\t\tnull\n" +
                "\t\t\tnull\n" +
                "\t(key=6, priority=70)\n" +
                "\t\tnull\n" +
                "\t\t(key=7, priority=26)\n" +
                "\t\t\tnull\n" +
                "\t\t\tnull");

        //Adding node back in
        assertEquals(t.add(1, 84), true);

        //toString()
        assertEquals(t.toString(), "(key=1, priority=84)\n" +
                "\tnull\n" +
                "\t(key=5, priority=83)\n" +
                "\t\t(key=2, priority=31)\n" +
                "\t\t\tnull\n" +
                "\t\t\t(key=4, priority=19)\n" +
                "\t\t\t\t(key=3, priority=12)\n" +
                "\t\t\t\t\tnull\n" +
                "\t\t\t\t\tnull\n" +
                "\t\t\t\tnull\n" +
                "\t\t(key=6, priority=70)\n" +
                "\t\t\tnull\n" +
                "\t\t\t(key=7, priority=26)\n" +
                "\t\t\t\tnull\n" +
                "\t\t\t\tnull");
    }
}
