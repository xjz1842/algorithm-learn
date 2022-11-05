package algorithms.sort;

import java.util.PriorityQueue;

public class HeapSort {

    public static void main(String[] args) {
        // 默认小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(6);
        heap.add(8);
        heap.add(0);
        heap.add(2);
        heap.add(9);
        heap.add(1);
//      while (!heap.isEmpty()) {
//          System.out.println(heap.poll());
//      }
        int[] arr = new int[]{6, 8, 0, 2, 9, 1};

        heapSort(arr);

        for (int i : arr) {
            System.out.println(i);
        }
    }

    // O(N*logN)
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2){
            return;
        }
        int heapSize = arr.length;
//      for (int i = 0; i < len; i++) {
//           heapInsert(arr, i);
//      }ProxyFactory
        for (int i = heapSize - 1; i >= 0; i--) {
            heapify(arr, i, heapSize);
        }
        //O(N*logN)
        swap(arr, 0, --heapSize);

        while (heapSize > 0) {
            heapify(arr, 0, heapSize);// O(logN)
            swap(arr, 0, --heapSize);
        }
    }

    private static void heapify(int[] arr, int index, int length) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;

        while (leftChildIndex < length) {
            int largestIndex;
            if (rightChildIndex < length) {
                largestIndex = arr[leftChildIndex] > arr[rightChildIndex] ? leftChildIndex : rightChildIndex;
            } else {
                largestIndex = leftChildIndex;
            }
            largestIndex = arr[largestIndex] > arr[index] ? largestIndex : index;

            if (largestIndex == index) {
                break;
            }
            swap(arr, index, largestIndex);
            index = largestIndex;
            leftChildIndex = index * 2 + 1;
            rightChildIndex = index * 2 + 2;
        }
    }

//    // O(N*logN)
//    public static void heapInsert(int[] arr, int index) {
//
//        while (arr[index] > arr[(index - 1) / 2]) {
//            swap(arr, index, (index - 1) / 2);
//            index = (index - 1) / 2;
//        }
//    }


    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


