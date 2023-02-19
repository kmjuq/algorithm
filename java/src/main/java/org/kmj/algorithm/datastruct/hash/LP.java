package org.kmj.algorithm.datastruct.hash;

import lombok.extern.slf4j.Slf4j;
import zzz.KNode;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 线性探测
 */
@Slf4j
public class LP implements IHash {

    private final KNode[] nodes;
    private int count;

    private static final KNode DEL = new KNode();

    public LP(int capacity) {
        nodes = new KNode[capacity];
    }

    @Override
    public KNode search(KNode node) {
        int index = hash(node, nodes.length);
        // 遍历所有节点，
        for (int i = 0; i < nodes.length; i++) {
            final KNode e = nodes[index];
            if (e == null) {
                return null;
            } else if (e.equals(node)) {
                return e;
            }
            // 如果 hash 索引到了最大，则从0开始从新遍历，直到遍历完所有元素
            if (index == nodes.length - 1) {
                index = 0;
            } else {
                index++;
            }
        }
        return null;
    }

    @Override
    public void insert(KNode node) {
        assert Objects.nonNull(node);
        if (count == nodes.length) {
            throw new RuntimeException("容量已满");
        }
        int index = hash(node, nodes.length);

        // 遍历所有节点，
        for (int i = 0; i < nodes.length; i++) {
            final KNode indexN = nodes[index];
            if (Objects.isNull(indexN) || indexN.equals(DEL)) {
                nodes[index] = node;
                count++;
                return;
            } else {
                if (indexN.equals(node)) {
                    // 说明有重复元素
                    return;
                }
            }

            // 如果 hash 索引到了最大，则从0开始从新遍历，直到遍历完所有元素
            if (index == nodes.length - 1) {
                index = 0;
            } else {
                index++;
            }
        }
    }

    @Override
    public void remove(KNode node) {
        int index = hash(node, nodes.length);

        // 遍历所有节点，
        for (int i = 0; i < nodes.length; i++) {
            final KNode indexN = nodes[index];
            if (Objects.isNull(indexN)) {
                return;
            } else {
                if(node.equals(indexN)){
                    count--;
                    nodes[index] = DEL;
                }
            }

            // 如果 hash 索引到了最大，则从0开始从新遍历，直到遍历完所有元素
            if (index == nodes.length - 1) {
                index = 0;
            } else {
                index++;
            }
        }
        // 没找到节点，忽略
        log.info("全部节点均没有找到相同节点，忽略删除操作");
    }

    @Override
    public void resize() {

    }

    @Override
    public void log() {
        String content = Arrays.stream(nodes)
                .map(kNode -> String.valueOf(kNode.value()))
                .collect(Collectors.joining(","));
        log.info("hash elements: [{}]", content);
    }

    @Override
    public int size() {
        return count;
    }
}
