package assignments;

/**
 * Author: Eric Altenburg
 * Date: 9/8/18
 * Class: CS284 Section A
 * Project: Homework Assignment 1
 * Honor Pledge: I pledge my honor that I have abided by the Stevens Honor System.
 **/
public class BinaryNumber {
    //Data fields

    private int data[];
    private int length;

    //Constructors

    /**
     * Creates a BinaryNumber object with the length parameter which fills the data array with 0's to the desired length.
     * @param length - the length of the binary number being created
     */
    public BinaryNumber (int length) {
        this.length = length;
        this.data = new int [length];
    }

    /**
     * Creates a BinaryNumber object with the use of a string parameter with the desired numbers.
     * @param str - the string containing the desired binary number
     */
    public BinaryNumber (String str) {
        this.length = str.length();
        this.data = new int [length];


        //for loop travels through the string picking out each char and converting it into an int then implementing it into
        //the array.
        for (int i = 0; i < str.length(); i++) {
           char x = str.charAt(i);
           this.data[i] = java.lang.Character.getNumericValue(x);
        }
    }

    //Methods

    /**
     * Returns the length of a binary number.
     * @return the length of a binary number
     */
    public int getLength () {
        return this.length;
    }

    /**
     * Gives the digit requested at the index given in the parameter, but if the index does not fall in the right range,
     * then the method spits out an error message.
     * @param index - place in which the user wants to know the number
     * @return the number in the array in which the index falls on or a -1 if the index is wrong
     */
    public int getDigit (int index) {
        //These if else statements are used to determine which exception to throw
        if (index < 0 || index > this.length-1)
            throw new IndexOutOfBoundsException("The index provided for getDigit is too small.");
        else if (index > this.length-1)
            throw new IndexOutOfBoundsException("The index provided for getDigit is too large.");

        return this.data[index];
    }

    /**
     * Returns the integer array that represents the binary number.
     * @return - the data field "data" which holds the binary number
     */
    public int[] getInnerArray () {
        return this.data;
    }

    /**
     * This method computes the bitwise or of two BinaryNumber objects, however, both objects must be the same length or
     * else the method will spit out an error message.
     * @param bn1- first BinaryNumber object
     * @param bn2 - second BinaryNumber object
     * @return - the bitwise or of the two BinaryNumber objects which is held in an array
     */
    public static int[] bwor (BinaryNumber bn1, BinaryNumber bn2) {
        if (bn1.data.length != bn2.data.length)
            throw new IllegalArgumentException("The two BinaryNumbers entered for the method bwor are two different " +
                    "lengths, they must be the same.");

        int[] bworBinaryNumber = new int[bn1.data.length];

        for (int i = 0; i < bn1.data.length; i++) {
            if (bn1.getDigit(i) == 1 || bn2.getDigit(i) == 1)
                bworBinaryNumber[i] = 1;
            else
                bworBinaryNumber[i] = 0;
        }

        return bworBinaryNumber;
    }

    /**
     * This method computes the bitwise and of two BinaryNumber objects, however, both objects must be the same length
     * or else the method will spit out an error message.
     * @param bn1 - first BinaryNumber object
     * @param bn2 - second BinaryNumber object
     * @return - the bitwise and of the two BinaryNumber objects which is held in an array
     */
    public static int[] bwand (BinaryNumber bn1, BinaryNumber bn2) {
        if (bn1.data.length != bn2.data.length)
            throw new IllegalArgumentException("The two BinaryNumbers entered for the method bwand are two different " +
                    "lengths, they must be the same.");

        int[] bwandBinaryNumber = new int[bn1.data.length];

        for (int i = 0; i < bn1.data.length; i ++) {
            if (bn1.getDigit(i) == 1 && bn2.getDigit(i) == 1)
                bwandBinaryNumber[i] = 1;
            else
                bwandBinaryNumber[i] = 0;
        }

        return bwandBinaryNumber;
    }

    /**
     * This method shifts each binary over to the left or right a certain amount by creating a temporary array and
     * filling it with the correct ints with the shift. Then the data field data[] gets set equal to the temporary array
     * this way the BinaryNumber object gets updated with the new number. It also throws an exception based on if the
     * direction is incorrect or the amount is negative/too big for the array.
     * @param direction - tells whether to shift to the left or right
     * @param amount - tells how much to shift to the left or right
     */
    public void bitShift (int direction, int amount) {
        //These if statements are for determining what type of exception to throw
        if (direction < -1 || direction == 0 || direction > 1)
            throw new IllegalArgumentException("The direction entered for bitShift must be -1 or 1, no other number " +
                    "will be accepted.");
        if (amount < 0)
            throw new IllegalArgumentException("The amount entered for bitShift must be a non-negative number.");

         if (direction == 1) {
             //This if statment is for determining whether the amount entered is within the range of the BinaryNumber
             if (amount > this.length)
                 throw new IndexOutOfBoundsException("The amount entered for bitShift must be within the length of the " +
                         "binary number when shifting to the right.");

             int[] tempArray = new int[this.data.length-amount];
             for (int i = 0; i < tempArray.length; i++)
                 tempArray[i] = this.data[i];

             this.data = tempArray;
             this.length = this.data.length;
         }
         else {
             int[] tempArray = new int[this.data.length+amount];
             for (int i = 0; i < this.data.length; i++)
                 tempArray[i] = this.data[i];
             for (int ii = this.data.length; ii < tempArray.length; ii++)
                 tempArray[ii] = 0;

             this.data = tempArray;
             this.length = this.data.length;
         }
    }

    /**
     * This method adds two binary numbers, and if one binary number is greater than the other, or they simply are not the
     * same size, then the method will also pretend 0's in front of the smaller binary number.
     * @param aBinaryNumber - the BinaryNumber object being added to the first BinaryNumber object
     */
    public void add (BinaryNumber aBinaryNumber) {
        //Prepends 0's in front of the smaller BinaryNumber object
        int[] tempArray;
        if (aBinaryNumber.data.length < this.data.length) {
            tempArray = new int[this.data.length];
            int howMuch = this.data.length - aBinaryNumber.data.length;
            int ii = 0;

            for (int i = howMuch; i < tempArray.length; i++) {
                tempArray[i] = aBinaryNumber.getDigit(ii);
                ii ++;
            }

            aBinaryNumber.data = tempArray;
            aBinaryNumber.length = tempArray.length;
        }
        if (aBinaryNumber.data.length > this.data.length) {
            tempArray = new int[aBinaryNumber.data.length];
            int howMuch = aBinaryNumber.data.length - this.data.length;
            int ii = 0;

            for (int i = howMuch; i < tempArray.length; i ++) {
                tempArray[i] = this.data[ii];
                ii ++;
            }

            this.data = tempArray;
            this.length = tempArray.length;
        }

        //Adds the two BinaryNumber objects if they are already the same length, or if they went through the prepend process
        int carry = 0;
        int[] addedArray = new int[this.data.length];

        for (int i = this.data.length - 1; i >= 0; i --) {
            //Conditions for each possibility when adding two binary numbers
            if (aBinaryNumber.getDigit(i) == 0 && this.data[i] == 0 && carry == 0) {
                addedArray[i] = 0;
                carry = 0;
            }
            else if (aBinaryNumber.getDigit(i) == 0 && this.data[i] == 0 && carry == 1) {
                addedArray[i] = 1;
                carry = 0;
            }
            else if (aBinaryNumber.getDigit(i) == 1 && this.data[i] == 1 && carry == 0) {
                addedArray[i] = 0;
                carry = 1;
            }
            else if (aBinaryNumber.getDigit(i) == 1 && this.data[i] == 1 && carry ==1) {
                addedArray[i] = 1;
                carry = 1;
            }
            else if (aBinaryNumber.getDigit(i) == 0 && this.data[i] == 1 && carry == 0) {
                addedArray[i] = 1;
                carry = 0;
            }
            else if (aBinaryNumber.getDigit(i) == 1 && this.data[i] == 0 && carry == 0) {
                addedArray[i] = 1;
                carry = 0;
            }
            else if (aBinaryNumber.getDigit(i) == 0 && this.data[i] == 1 && carry == 1) {
                addedArray[i] = 0;
                carry = 1;
            }
            else if (aBinaryNumber.getDigit(i) == 1 && this.data[i] == 0 && carry == 1) {
                addedArray[i] = 0;
                carry = 1;
            }
        }

        //Changes this.data array to that of the new "addedArray" this happens regardless of whether or not it needs another value
        this.data = addedArray;
        this.length = addedArray.length;

        //in case it needs another value
        if (carry == 1) {
            int[] extraArray = new int[this.data.length + 1];
            int ii = 0;

            int thisMuch = extraArray.length - this.data.length;
            extraArray[0] = 1;
            for (int i = thisMuch; i < extraArray.length; i++) {
                extraArray[i] = this.data[ii];
                ii++;
            }

            //with the new value added in another array called extraArray, it changes this.data to extraArray one last time
            this.data = extraArray;
            this.length = extraArray.length;
        }
    }

    /**
     * This method returns a String containing information about the BinaryNumber object that is attempting to be printed
     * by the user.
     * @return - a String containing information about BinaryNumber
     */
    @Override
    public String toString() {
        String x = "";
        for (int i = 0; i < this.length; i ++)
            x += this.data[i];

        return "The binary number is " +x+ ", and the length is " +this.length+ ".";
    }

    /**
     * converts the binary number to its decimal number
     * @return - an int that represents the binary decimal number
     */
    public int toDecimal () {
        int decimalNum = 0;
        int exp = this.length -1;

        for (int i = 0; i < this.length; i++) {
            decimalNum += this.data[i] * Math.pow(2, exp);
            exp--;
        }

        return decimalNum;
    }
}