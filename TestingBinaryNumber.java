package assignments;

/**
 * Author: Eric Altenburg
 * Date: 9/5/18
 * Project:
 * Project Description:
 **/
public class TestingBinaryNumber {
    public static void main(String[] args) {
        BinaryNumber len = new BinaryNumber(4);
        BinaryNumber bn1 = new BinaryNumber("00001");
        BinaryNumber bn2 = new BinaryNumber("10001");

        System.out.println(len);
        System.out.println(bn1);
        System.out.println(bn2);
        System.out.println();

        System.out.println(len.getLength());
        System.out.println(bn1.getLength());
        System.out.println(bn2.getLength());
        System.out.println();

        System.out.println(len.getDigit(2)); //try another index out of bounds
        System.out.println(bn1.getDigit(4));
        System.out.println(bn2.getDigit(0));
        System.out.println();

        int[] x;
        x = len.getInnerArray();
        for (int i = 0; i < x.length; i ++)
            System.out.print(x[i]);
        System.out.println();
        int[] y;
        y = bn1.getInnerArray();
        for (int i = 0; i < y.length; i ++)
            System.out.print(y[i]);
        System.out.println();
        int[] z;
        z = bn2.getInnerArray();
        for (int i = 0; i < z.length; i ++)
            System.out.print(z[i]);
        System.out.println();
        System.out.println();

        System.out.println(len.toDecimal());
        System.out.println(bn1.toDecimal());
        System.out.println(bn2.toDecimal());
        System.out.println();

        int[] a;
        a = BinaryNumber.bwor(bn1, bn2);
        for (int i = 0; i < a.length; i ++)
            System.out.print(a[i]);
        System.out.println();
        int[] b;
        b = BinaryNumber.bwand(bn1, bn2);
        for (int i = 0; i < b.length; i ++)
            System.out.print(b[i]);
        System.out.println();
        System.out.println();

        bn1.bitShift(-1, 0);
        System.out.println(bn1);
        bn2.bitShift(1, 0);
        System.out.println(bn2);
        System.out.println();

        bn1.add(bn2);
        System.out.println(bn1);
    }
}
