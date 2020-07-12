package comalgorithms.sort;


public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 10, 8, 10};

        quickSort(arr, 0, arr.length - 1);

        for (int a : arr) {
            System.out.println(a);
        }
    }

    public static void quickSort(int[] arr, int l, int r) {

        if (l < r) {
            int index = partition(arr, l, r);
            quickSort(arr, l, index - 1);
            quickSort(arr, index + 1, r);
        }
    }

    public static int partition(int[] arr, int l, int r) {

        int pivot = arr[l];

        while (l < r) {
            while (l < r && arr[r] >= pivot) {
                r--;
            }

            if (l < r) {
                arr[l++] = arr[r];
            }

            while (l < r && arr[l] < pivot) {
                l++;
            }
            if (l < r) {
                arr[r--] = arr[l];
            }
        }
        arr[l] = pivot;

        return l;
    }
}
