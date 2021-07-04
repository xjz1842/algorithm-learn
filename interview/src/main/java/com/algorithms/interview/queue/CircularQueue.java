package com.algorithms.interview.queue;


//利用used变量标识使用
public class CircularQueue {

    // 已经使用的元素个数
    private int used = 0;
    // 第一个元素所在位置
    private int front = 0;

    // rear是enQueue可在存放的位置
    // 注意开闭原则
    // [front, rear)
    private int rear = 0;
    // 循环队列最多可以存放的元素个数
    private int capacity = 0;
    // 循环队列的存储空间
    private int[] a = null;

    public CircularQueue(int k) {
        // 初始化循环队列
        capacity = k;
        a = new int[capacity];
    }

    public boolean enQueue(int value) {
        // 如果已经放满了
        if (isFull()) {
            return false;
        }
        // 如果没有放满，那么a[rear]用来存放新进来的元素
        a[rear] = value;

        // rear注意取模
        rear = (rear + 1) % capacity;

        // 已经使用的空间
        used++;
        // 存放成功!
        return true;
    }

    public boolean deQueue() {
        // 如果是一个空队列，当然不能出队
        if (isEmpty()) {
            return false;
        }
        // 第一个元素取出
        int ret = a[front];
        // 注意取模
        front = (front + 1) % capacity;
        // 已经存放的元素减减
        used--;
        // 取出元素成功
        return true;
    }

    public int Front() {
        // 如果为空，不能取出队首元素
        if (isEmpty()) {
            return -1;
        }
        // 取出队首元素
        return a[front];
    }

    public int Rear() {
        // 如果为空，不能取出队尾元素
        if (isEmpty()) {
            return -1;
        }
        // 注意：这里不能使用rear - 1
        // 需要取模
        int tail = (rear - 1 + capacity) % capacity;
        return a[tail];
    }

    // 队列是否为空
    public boolean isEmpty() {
        return used == 0;
    }

    // 队列是否满了
    public boolean isFull() {
        return used == capacity;
    }
}
