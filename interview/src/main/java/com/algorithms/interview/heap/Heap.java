package com.algorithms.interview.heap;

//大根堆
public class Heap {

    private int[] a = null;
    private int n = 0;

    public Heap(int n) {
        this.a = new int[n+1];
    }

    // 下沉
    public void sink(int i) {
        int j = 0;
        int t = a[i];
        // 找到i结点的左子结点
        while ((j = (i << 1) + 1) < n) {
            // j < n - 1判断是否有右子结点
            // 如果有，并且右子结点更大，那么
            // j指向右子结点
            if ((j + 1) < n && a[j] < a[j + 1]) {
                j++;
            }
            // 如果子结点比t大
            // 那么t的位置还需要往后排
            if (a[j] > t) {
                a[i] = a[j];
                i = j;
            } else {
                // 找到了t的位置
                // 此时t是大于所有的子结点的
                break;
            }
        }
        // 将t放在找到的位置那里
        a[i] = t;
    }

    // 上浮
    public void swim(int i) {
        int t = a[i];
        // 如果还存在父结点
        int parent = (i - 1) / 2;

        while (i > 0 && (parent=(i-1)/2) != i){
            // 如果父结点比t值小
            if(a[parent] < t){
                a[i] = a[parent];
                i = parent;
            }else{
                break;
            }
        }
        a[i] = t;
    }

    public void push(int v) {
        // push是先把元素追加到数组尾巴上，然后再执行上浮操作
        a[n++] = v;
        swim(n - 1);
    }

    public int pop() {
        int ret = a[0];
        a[0] = a[--n];
        sink(0);
        return ret;
    }

    public int size() {
        return n;
    }

}
