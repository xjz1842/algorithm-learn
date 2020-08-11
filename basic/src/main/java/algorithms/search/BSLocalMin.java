package algorithms.search;

public class BSLocalMin {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 6, 5, 8};

        System.out.println(getLessIndex(arr));
    }

    public static int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1; // no exist
        }

        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }

        int length = arr.length;
        if (arr[length - 1] < arr[length - 2]) {
            return arr.length - 1;
        }

        int left = 1;
        int right = length - 2;


        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }

}
