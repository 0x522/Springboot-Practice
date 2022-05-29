package com.lwc.admin.util;

import java.util.*;

/**
 * @author lwc
 * @date 2022/5/10 14:35
 */
public class BTree<Key extends Comparable<Key>, Value> {
    private static final int M = 4;  // B树的阶数

    private Node root;       //  B-tree 的根节点
    private int height;      //  B-tree 的高度
    private int N;           //  B-tree 树中键值对的数目

    // B-tree 节点类型
    private static final class Node {
        private int m;                             // number of children
        private Entry[] children = new Entry[M];   // the array of children

        // create a node with k children
        private Node(int k1, int i, int k) {
            m = k;
        }
    }

    //  B-tree 节点中的元素类型
    private static class Entry {
        private Comparable key;
        private Object val;
        private Node next;     // 指向节点中下一元素

        public Entry(Comparable key, Object val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }


    /**
     * 初始化空 B-tree树
     */
    public BTree() {
        root = new Node(0, 1, 0);
    }

    /**
     * 判断 B-tree 是否是空树
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return N;
    }

    public int height() {
        return height;
    }

    /**
     * get操作
     */
    public Value get(Key key) {
        if (key == null) throw new NullPointerException("key must not be null");
        return search(root, key, height);
    }

    /**
     * put 操作
     */
    public void put(Key key, Value val) {
        if (key == null) throw new NullPointerException("key must not be null");
        Node u = insert(root, key, val, height);
        N++;
        if (u == null) return;

        // need to split root
        Node t = new Node(0, 1, 2);
        t.children[0] = new Entry(root.children[0].key, null, root);
        t.children[1] = new Entry(u.children[0].key, null, u);
        root = t;
        height++;
    }


    //  搜索操作
    private Value search(Node x, Key key, int ht) {
        Entry[] children = x.children;

        // 节点内数组操作  内部遍历
        if (ht == 0) {
            for (int j = 0; j < x.m; j++) {
                if (equals(key, children[j].key)) return (Value) children[j].val;
            }
        }

        //  外部定位
        else {
            for (int j = 0; j < x.m; j++) {
                if (j + 1 == x.m || less(key, children[j + 1].key))
                    return search(children[j].next, key, ht - 1);
            }
        }
        return null;
    }

    //  插入操作
    private Node insert(Node h, Key key, Value val, int ht) {
        int j;
        Entry t = new Entry(key, val, null);

        // 节点内部数组操作
        if (ht == 0) {
            for (j = 0; j < h.m; j++) {
                if (less(key, h.children[j].key)) break;
            }
        }
        // 外部遍历
        else {
            for (j = 0; j < h.m; j++) {
                if ((j + 1 == h.m) || less(key, h.children[j + 1].key)) {
                    Node u = insert(h.children[j++].next, key, val, ht - 1);
                    if (u == null) return null;
                    t.key = u.children[0].key;
                    t.next = u;
                    break;
                }
            }
        }

        for (int i = h.m; i > j; i--)
            h.children[i] = h.children[i - 1];
        h.children[j] = t;
        h.m++;
        if (h.m < M) return null;
        else return split(h);
    }

    //  分裂节点成两半
    private Node split(Node h) {
        Node t = new Node(0, 1, M / 2);
        h.m = M / 2;
        for (int j = 0; j < M / 2; j++)
            t.children[j] = h.children[M / 2 + j];
        return t;
    }

    // 判断两个元素是否相等
    private boolean equals(Comparable k1, Comparable k2) {
        return k1.compareTo(k2) == 0;
    }

    // 判断两个元素的大小
    private boolean less(Comparable k1, Comparable k2) {
        return k1.compareTo(k2) < 0;
    }


    public static void main(String[] args) {
        BTree<String, String> bTree = new BTree<>();
        for (int i=0;i<1000000;i++){
            bTree.put("li"+i,"an"+i);
        }
        HashMap<String,String> map=new HashMap<>();
        for (int i=0;i<1000000;i++){
            map.put("li"+i,"an"+i);
        }
        long start=System.currentTimeMillis();
        for (int i=0;i<1000;i++) {   //一开始1200  后来一直17
            int num=(int)(Math.random()*1000000);
            System.out.println(bTree.get("li" + num));
        }
//        for (int i=0;i<1000;i++){   //14-28 18次数居多
//            int num=(int)(Math.random()*1000000);
//            System.out.println(map.get("li"+num));
//        }
        long end=System.currentTimeMillis();
        System.out.println(end-start);

    }

}