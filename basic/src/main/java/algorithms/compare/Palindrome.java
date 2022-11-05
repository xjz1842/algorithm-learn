package algorithms.compare;

import java.util.ArrayList;
import java.util.List;

public class Palindrome {

    public static boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
 
        List<Integer> str = new ArrayList<>();

        int low = x % 10;

        str.add(low);
        while (x >= 10) {
            int high = x / 10;
            low = high % 10;
            str.add(low);
            x = high;
        }

        for (int i = 0, j = str.size() - 1; i < j; i++, j--) {
            if (str.get(i) != str.get(j)) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(1000021));
    }

}
