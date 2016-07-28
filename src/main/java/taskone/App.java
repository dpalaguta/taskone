package taskone;

/**
 * Find the largest palindrome (a palindrome is a number that reads the same in either direction, e.g. 1221)
 * formed by the product of two three-digit numbers.
 {Correct answer: 906609}
 */
public class App {

/*   According to the terms of the task, the number cannot exceed the limits of the range obtained as a result
 of multiplication of the minimum and maximum three-digit numbers. This range covers the values with five
  and six digits. There are no instructions in the terms of the task regarding the universality of the program
  operation that’s why I have determined on my own the limits of even and odd number of the digits in the numeral
  of the specified range.
    */

    final int MIN_VALUE = 100 * 100;
    final int MAX_VALUE = 999 * 999;
    final int MAX_FIVE_DIGIT_NUMBER = 99999;

    boolean isRequiredPalindrome(int palindrome) {
        int k = 999;

        while (k > 99) {
            //If the initial palindrome can be divided by a three-digit number without a remainder
            // and the result obtained will also be a three-digit number,
            // it means that we have found the required palindrome.

            if (palindrome % k == 0 && palindrome / k > 99 && palindrome / k < 1000) {
                return true;
            }
            k--;
        }
        return false;
    }

    boolean isPalindrome(int number) {
        int left_number_part, right_number_part;

        if (number > MAX_FIVE_DIGIT_NUMBER) { // The unit for calculation of a six-digit palindrome
            left_number_part = number / 1000;
            right_number_part = number % 1000;
            int multiplier = 100;
            int mirror_number = 0;

            for (int i = 0; i < 3; i++) {
                mirror_number = mirror_number + (right_number_part % 10) * multiplier;
                multiplier /= 10;
                right_number_part /= 10;
            }


            if (left_number_part - mirror_number == 0) return true;

        } else { // The unit for calculation of a five-digit palindrome
            left_number_part = number / 1000;
            right_number_part = number % 100;
            int multiplier = 10;
            int mirror_number = 0;
            for (int i = 0; i < 2; i++) {
                mirror_number = mirror_number + (right_number_part % 10) * multiplier;
                multiplier /= 10;
                right_number_part /= 10;
            }
            if (left_number_part - mirror_number == 0) return true;
        }

        return false;
    }

    public static void main(String[] args) {

        App app = new App();
        int k = app.MAX_VALUE;
        do {
            if (app.isPalindrome(k)) {
                if (app.isRequiredPalindrome(k)) {
                    System.out.println("MAX needful palindrome = " + k);
                    k = app.MIN_VALUE - 1;
                } else k--;

            } else k--;

        }
        while (k >= app.MIN_VALUE);

    }
}
