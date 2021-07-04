package com.algorithms.interview.queue;

//使用 k+1 个元素的空间，两个变量 front, rear 来控制循环队列的使用
public class MyCircularQueue {

    // 队列的头部元素所在位置
    private int front = 0;

    // 队列的尾巴
    // 注意我们采用的是前开后闭原则
    // [front, rear)
    private int rear = 0;

    //循环队列的存储
    private int[] a = null;

    private int capacity = 0;

    public MyCircularQueue(int k) {
        // 初始化队列，注意此时队列中元素个数为
        // k + 1
        capacity = k + 1;
        a = new int[k + 1];
    }

    public boolean enQueue(int value) {
        // 如果已经满了，无法入队
        if (isFull()) {
            return false;
        }
        // 把元素放到rear位置
        a[rear] = value;
        // rear向后移动
        rear = (rear + 1) % capacity;
        return true;
    }

    public boolean deQueue() {
        // 如果已经满了，无法入队
        if (isEmpty()) {
            return false;
        }
        // 出队之后，front要向前移
        front = (front + 1) % capacity;

        return true;
    }

    public int Front() {
        // 如果能取出第一个元素，取a[front];
        return isEmpty() ? -1 : a[front];
    }

    public int Rear() {
        // // 由于我们使用的是前开后闭原则
        // // [front, rear)
        // // 所以在取最后一个元素时，应该是
        // (rear - 1 + capacity) % capacity;
        int tail = (rear - 1 + capacity) % capacity;
        return isEmpty() ? -1 : a[tail];
    }

    public boolean isEmpty() {
        // 队列是否为空
        return front == rear;
    }

    public boolean isFull() {
        // rear与front之间至少有一个空格
        // 当rear指向这个最后的一个空格时，
        // 队列就已经放满了!
        return (rear + 1) % capacity == front;
    }
}
