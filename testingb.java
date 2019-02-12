//package assignments;
//
///**
// * Author: Eric Altenburg
// * Date: 9/8/18
// * Project:
// * Project Description:
// **/
//public class testingb {
//    public void add (BinaryNumber aBinaryNumber) {
//        //Prepends 0's in front of the smalled BinaryNumber object
//        int[] smaller;
//        int howMuch;
//        if (aBinaryNumber.data.length > this.data.length) {
//            smaller = this.data;
//            howMuch = aBinaryNumber.data.length - smaller.length;
//        }
//        else {
//            smaller = aBinaryNumber.data;
//            howMuch = this.data.length - smaller.length;
//        }
//
//        int[] tempArray = new int[smaller.length];
//        int ii = 0;
//
//        for (int i = howMuch; i < tempArray.length; i ++) {
//            tempArray[i] = smaller.getDigit(ii);
//            ii++;
//        }
//
//        smaller.data = tempArray;
//        smaller.length = tempArray.length;
//
//
//        if (aBinaryNumber.data.length < this.data.length) {
//            tempArray = new int[this.data.length];
//            int howMuch = this.data.length - aBinaryNumber.data.length;
//            int ii = 0;
//
//            for (int i = howMuch; i < tempArray.length; i++) {
//                tempArray[i] = aBinaryNumber.getDigit(ii);
//                ii ++;
//            }
//
//            aBinaryNumber.data = tempArray;
//            aBinaryNumber.length = tempArray.length;
//        }
//        if (aBinaryNumber.data.length > this.data.length) {
//            tempArray = new int[aBinaryNumber.data.length];
//            int howMuch = aBinaryNumber.data.length - this.data.length;
//            int ii = 0;
//
//            for (int i = howMuch; i < tempArray.length; i ++) {
//                tempArray[i] = this.data[ii];
//                ii ++;
//            }
//
//            this.data = tempArray;
//            this.length = tempArray.length;
//        }
//
//
//
//    }
