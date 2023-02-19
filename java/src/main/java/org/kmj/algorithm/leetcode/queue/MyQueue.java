package org.kmj.algorithm.leetcode.queue;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/5/6 16:13
 */
public // "static void main" must be defined in a public class.

class MyQueue {
    private Integer[] data;
    private int front;
    private int rear;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyQueue(int k) {
        data = new Integer[k + 1];
        front = 0;
        rear = 0;
    }

    public MyQueue() {
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        } else {
            data[rear] = value;
            if (rear == data.length - 1) {
                rear = 0;
            } else {
                rear++;
            }
            return true;
        }

    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        } else {
            if (front == data.length - 1) {
                front = 0;
            } else {
                front++;
            }
            return true;
        }

    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (isEmpty()) {
            return -1;
        } else {
            return data[front];
        }
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        } else {
            if (rear == 0) {
                return data[data.length - 1];
            } else {
                return data[rear - 1];
            }
        }
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return (rear + 1) % data.length == front;
    }

    public static void main(String[] args) {
        MyQueue obj = new MyQueue(3);
        final boolean b = obj.enQueue(1);
        final boolean b1 = obj.enQueue(2);
        final boolean b2 = obj.enQueue(3);
        final boolean b3 = obj.enQueue(4);
        final int rear = obj.Rear();
        final boolean full = obj.isFull();
        final boolean b4 = obj.deQueue();
        final boolean b5 = obj.enQueue(4);
        final int rear1 = obj.Rear();
    }
}
