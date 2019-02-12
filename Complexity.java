package assignments;

/**
 * Author: Eric Altenburg
 * Date: 9/20/18
 * Class: CS284 Section A
 * Project: Homework Assignment 2
 * Honor Pledge: I pledge my honor that I have abided by the Stevens Honor System.
 **/
public class Complexity {
    /**
     * This method uses for loops to demonstrate the time complexity O(n^2). Prints out the operation time
     * for each time it is run.
     * @param n - number of times being run
     */
    public static void method1(int n) {
        int counter = 1;

        for (int i = 0; i < n; i ++)
            for (int j = 0; j < n; j++) {
                System.out.println("Time complexity: O(n^2). Operation #: " +counter);
                counter++;
            }
    }

    /**
     * This method uses for loops to demonstrate the time complexity O(n^3). Prints out the operation time
     * for each time it is run.
     * @param n - number of times being run
     */
    public static void method4(int n) {
        int counter = 1;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < n; k++) {
                    System.out.println("Time complexity: O(n^3). Operation #: " +counter);
                    counter++;
                }
    }

    /**
     * This method uses for loops to demonstrate the time complexity O(log(n)). Prints out the operation time
     * for each time it is run.
     * @param n - number of times being run
     */
    public static void method2(int n) {
        int counter = 1;

        for (int i = 1; i < n; i*= 2) {
            System.out.println("Time complexity: O(log(n)). Operation #: " +counter);
            counter++;
        }
    }

    /**
     * This method uses for loops to demonstrate the time complexity O(n*log(n)). Prints out the operation time
     * for each time it is run.
     * @param n - number of times being run
     */
    public static void method3(int n) {
        int counter = 1;

        for (int i = 0; i < n; i ++)
            for (int j = 1; j < n; j *= 2) {
                System.out.println("Time complexity: O(n*log(n)). Operation #: " +counter);
                counter++;
            }
    }

    /**
     * This method uses for loops to demonstrate the time complexity O(log(log(n))). Prints out the operation time
     * for each time it is run. Would also like to state that the time complexity is not two logs being multiplied
     * together, instead, it is a log within a log.
     * @param n - number of times being run
     */
    public static void method5(int n) {
        int counter = 1;

        for (int i = n; i > 2 ; i= (int)(Math.pow(i, .5))) {
            System.out.println("Time complexity: O(log(log(n))). Operation #: " +counter);
            counter++;
        }
    }

    //Data field for method6. Used to keep track of total operations being performed.
    private static int counter = 1;
    /**
     * This method contains the fibonacci sequence as it has a time complexity of O(φ^n). It uses recursion to attain
     * the said time complexity.
     * @param n - number in which you want the fibonacci sequence
     * @return - number in the fibonacci sequence coinciding with the number entered as the parameter
     */
    public static int method6(int n) {
        int fib = 0;

        if (n <= 1) {
            System.out.println("Time complexity: O(φ^n). Operation #: " +counter);
            counter++;
            int tempFib = n;
            return tempFib;
        } else {
            System.out.println("Time complexity: O(φ^n). Operation #: " +counter);
            counter++;
            fib += method6(n-1) + method6(n-2);
            return fib;
        }
    }
}
