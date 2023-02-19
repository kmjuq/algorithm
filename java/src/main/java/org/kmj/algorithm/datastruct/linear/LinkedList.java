package org.kmj.algorithm.datastruct.linear;

import org.junit.jupiter.api.Assertions;
import zzz.KNode;

public class LinkedList implements IList {

    private int count = 0;
    private final KNode head = new KNode();

    @Override
    public int indexOf(KNode node) {
        Assertions.assertNotNull(node);
        int index = -1;
        KNode cur = this.head;
        while (cur.next() != null) {
            index++;
            cur = cur.next();
            if (cur.equals(node)) {
                return index;
            }
        }
        return -1;
    }

    @Override
    public KNode get(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException();
        }
        KNode cur = this.head;
        for (int i = 0; i <= index; i++) {
            cur = cur.next();
        }
        return cur;
    }

    @Override
    public void set(KNode node, int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException();
        }
        KNode cur = get(index);
        KNode next = cur.next();
        if (index == 0) {
            KNode head = this.head;
            head.next(node);
            node.next(next);
        } else {
            KNode prev = get(index - 1);
            prev.next(node);
            node.next(next);
        }
    }

    @Override
    public void add(KNode node, int index) {
        if (index < 0 || index > count) {
            throw new IllegalArgumentException();
        }
        KNode prev = this.head;
        for (int i = 0; i < index; i++) {
            prev = prev.next();
        }
        KNode next = prev.next();
        prev.next(node);
        node.next(next);
        count = count + 1;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException();
        }
        if (index == count - 1) {
            KNode prev = get(index - 1);
            prev.next(null);
        } else if (index == 0) {
            KNode head = this.head;
            KNode cur = head.next();
            KNode next = cur.next();
            head.next(next);
        } else {
            KNode prev = get(index - 1);
            KNode next = get(index + 1);
            prev.next(next);
        }
        count--;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public void clear() {
        head.next(null);
        count = 0;
    }

}
