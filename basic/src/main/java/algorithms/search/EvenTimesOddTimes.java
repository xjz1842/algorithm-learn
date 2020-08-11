package algorithms.search;

public class EvenTimesOddTimes {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 3, 2, 3, 2};

        printOddTimesNum1(arr);

        printOddTimesNum2(arr);
    }

    // arr中，只有一种数，出现奇数次
    public static void printOddTimesNum1(int[] arr) {
        int eor = 0;
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            eor ^= arr[i];
        }
        System.out.println(eor);
    }

    // arr中，有两种数，出现奇数次
    public static void printOddTimesNum2(int[] arr) {
        int eor = 0;
        int length = arr.length;

        for (int i = 0; i < length; i++) {
            eor ^= arr[i];
        }

        // eor = a ^ b
        // eor != 0
        // eor必然有一个位置上是1
        // 0110010000
        // 0000010000
        int rightOne = eor & (~eor + 1);

        int onlyOne = 0; // eor'

        for (int i = 0; i < length; i++) {
            if ((arr[i] & rightOne) != 0) {
                onlyOne ^= arr[i];
            }
        }
        System.out.println(onlyOne + " " + (onlyOne ^ eor));
    }

}
