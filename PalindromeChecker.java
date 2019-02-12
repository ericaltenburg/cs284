package classses;

/**
 * Author: Eric Altenburg
 * Date: 10/1/18
 **/
public class PalindromeChecker {

    //data fields
    private String inputString;
    private StackSLL<Character> charStack;

    //constructor
    public PalindromeChecker (String str) {
        inputString = str;
        charStack = new StackSLL<Character>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                charStack.push(str.charAt(i));
            }
        }
    }

    //methods
    private String buildReverse() {
        StringBuilder s = new StringBuilder();

        while(!charStack.isEmpty()) {
            s.append(charStack.pop());
        }

        return s.toString();
    }

    public boolean isPalindrome() {
        inputString = inputString.replaceAll(" ", ""); //removes all spaces
        return inputString.equalsIgnoreCase(buildReverse());
    }

    public static void main(String[] args) {
        PalindromeChecker c1 = new PalindromeChecker("kayak");
        PalindromeChecker c2 = new PalindromeChecker("I saw I was I");
        PalindromeChecker c3 = new PalindromeChecker("Level, madam, level");
        PalindromeChecker c4 = new PalindromeChecker("kayakL");

        System.out.println(c1.isPalindrome());
        System.out.println(c2.isPalindrome());
        System.out.println(c3.isPalindrome());
        System.out.println(c4.isPalindrome());
    }
}
