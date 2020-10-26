package classses;

import java.util.EmptyStackException;

/**
 * Author: Eric Altenburg
 * Date: 10/3/18
 **/
public class WBP {
    private static final String OPEN = "[{(";
    private static final String CLOSE = "]})";
    private String str;
    private StackSLL<Character> s;

    WBP(String str) {
        this.str = str;
        this.s = new StackSLL<Character>();
    }

    public Boolean isBalanced() {
        boolean isBal = true;
        int index = 0;

        try {
            while (isBal && index < str.length()) {
                if (OPEN.indexOf(str.charAt(index)) >= 0) {
                    s.push(str.charAt(index));
                } else {
                    Character top = s.pop();
                    isBal = isBal && OPEN.indexOf(top) == CLOSE.indexOf(str.charAt(index));
                }

                index++;
            }
        }
        catch (EmptyStackException e) {
            return false;
        }

        return isBal && s.isEmpty();
    }

    public static void main(String[] args) {
        WBP s1 = new WBP("(())())");
        WBP s2 = new WBP("([]){}");
        WBP s3 = new WBP("({})[)))");
        WBP s4 = new WBP("a");

        System.out.println(s1.isBalanced());
        System.out.println(s2.isBalanced());
        System.out.println(s3.isBalanced());
        System.out.println(s4.isBalanced());
    }
}
