package assignments;

/**
 * Author: Eric Altenburg
 * Date: 11/21/18
 **/
public class Sort {
    private static class Interval {
        //Data fields
        private int lower;
        private int upper;

        //Constructors
        public Interval(int lower, int upper) {
            this.lower = lower;
            this.upper = upper;
        }

        //Methods
        public int getLower() {
            return lower;
        }

        public int getUpper() {
            return upper;
        }

//        public boolean equals(Object o) {
//
//        }

        public int hashCode() {
            return lower * lower + upper;
        }
    }
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
