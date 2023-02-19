package org.kmj.algorithm.datastruct.linear;

import zzz.KNode;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class ArrayList implements IList {

    private KNode[] els;
    private int count = 0;

    public ArrayList(int length) {
        els = new KNode[length];
    }

    public ArrayList() {
        els = new KNode[8];
    }

    @Override
    public String toString() {
        return Arrays.stream(els).map(e -> Objects.nonNull(e) ? e.value() : Optional.empty()).collect(Collectors.toList()).toString();
    }

    @Override
    public int indexOf(KNode node) {
        for (int i = 0; i < count; i++) {
            KNode n = els[i];
            if (n.equals(node)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public KNode get(int index) {
        return els[index];
    }

    @Override
    public void set(KNode node, int index) {
        els[index] = node;
    }

    @Override
    public void add(KNode node, int index) {
        if (index < 0 || index > count) {
            throw new IllegalArgumentException("下标越界");
        }
        count++;
        set(node, index);
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index > count) {
            throw new IllegalArgumentException("下标越界");
        }
        for (int i = index; i < els.length - 1; i++) {
            els[index] = els[index + 1];
        }
        els[count - 1] = null;
        count--;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public void clear() {
        els = new KNode[els.length];
        count = 0;
    }

}
