package com.algorithms.interview.sort;

public class MergeSort {

    //归并排序 O(N*lgn)
    private static void msort(int[] a, int b, int e, int t[]) {
        // 空区间 或 只有一个元素
        // 为了防止b + 1溢出，这里用b >= e先判断一下
        if (b == e || b + 1 >= e) {
            return;
        }
        // 分成两半
        // 这里我们需要通过计算来得到左右子数组
        final int m = b + ((e - b) >> 1);

        // 类比二叉树分别遍历左子树和右子树。
        msort(a, b, m, t);
        msort(a, m, e, t);

        // i指向左子数组的开头，j指向右子数组的开头
        // to指向要临时数组t与区间[b, e)对应的位置
        int i = b;
        int j = m;
        int to = b;

        // 将两个子数组进行合并,[b,m) [m,e)
        // 这里的判断条是，只要两个子数组中还有元素
        while (i < m || j < e) {
            // 如果右子数组没有元素 或 左子数组开头的元素小于右子数组开头的元素
            // 那么取走左子数组开头的元素
            // 考点：a[i] <= a[j]这样可以保证合并排序是稳定的，不要写错!
            if (j >= e || i < m && a[i] <= a[j]) {
                t[to++] = a[i++];
            } else {
                // 否则就是取右子数组开头的元素
                t[to++] = a[j++];
            }
        }
        // 把合并的结果拷回原来的数组a[]
        for (i = b; i < e; i++) {
            a[i] = t[i];
        }
    }

    public static void mergeSort(int[] nums) {
        //数组为空
        if (nums == null || nums.length == 0) {
            return;
        }
        // t是一个临时中转的数组
        int[] t = new int[nums.length];
        msort(nums, 0, nums.length, t);
    }


    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 6, 7, 8, 3};

        mergeSort(arr);

        for(int a : arr){
            System.out.println(a);
        }
    }

}

