package com.algorithms.leetcode.secondhundred;


import java.util.HashMap;

public class leetcode_146_LRUCache {

    private MyCache<Integer, Integer> cache;

    private static class Node<K, V> {
        Node pre;
        Node next;
        K k;
        V v;

        public Node(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }

    public leetcode_146_LRUCache(int capacity) {
        cache = new MyCache<>(capacity);
    }

    public int get(int key) {
        Integer ans = cache.get(key);
        return ans == null ? -1 : ans;
    }

    public void put(int key, int value) {
        cache.set(key, value);
    }

    public static class NodeDoubleLinkedList<K, V> {
        private Node<K, V> head;
        private Node<K, V> tail;

        public NodeDoubleLinkedList() {
            head = null;
            tail = null;
        }

        public void addNode(Node<K, V> newNode) {
            if (newNode == null) {
                return;
            }
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.pre = tail;
                tail = newNode;
            }
        }

        public void moveNodeToTail(Node<K, V> node) {
            if (this.tail == node) {
                return;
            }
            if (this.head == node) {
                this.head = node.next;
                this.head.pre = null;
            } else {
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            node.pre = this.tail;
            node.next = null;
            this.tail.next = node;
            this.tail = node;
        }

        public Node<K, V> removeHead() {
            if (this.head == null) {
                return null;
            }
            Node<K, V> res = this.head;

            if (this.head == this.tail) {
                // 链表中只有一个节点的时候
                this.head = null;
                this.tail = null;
            } else {
                this.head = res.next;
                res.next = null;
                this.head.pre = null;
            }
            return res;
        }
    }

    public static class MyCache<K, V> {
        private HashMap<K, Node<K, V>> keyNodeMap;
        private NodeDoubleLinkedList<K, V> nodeList;
        private final int capacity;

        public MyCache(int cap) {
            if (cap < 1) {
                throw new RuntimeException("should be more than 0.");
            }
            keyNodeMap = new HashMap<K, Node<K, V>>();
            nodeList = new NodeDoubleLinkedList<K, V>();
            capacity = cap;
        }

        public V get(K key) {
            if (keyNodeMap.containsKey(key)) {
                Node<K, V> res = keyNodeMap.get(key);
                nodeList.moveNodeToTail(res);
                return res.v;
            }
            return null;
        }

        public void set(K key, V value) {
            if (keyNodeMap.containsKey(key)) {
                Node<K, V> node = keyNodeMap.get(key);
                node.v = value;
                nodeList.moveNodeToTail(node);
            } else {
                Node<K, V> newNode = new Node<K, V>(key, value);
                keyNodeMap.put(key, newNode);
                nodeList.addNode(newNode);

                if (keyNodeMap.size() == capacity + 1) {
                    removeMostUnusedCache();
                }
            }
        }

        private void removeMostUnusedCache() {
            Node<K, V> removeNode = nodeList.removeHead();
            keyNodeMap.remove(removeNode.k);
        }
    }


    public static void main(String[] args) {
        leetcode_146_LRUCache cache = new leetcode_146_LRUCache(2/* 缓存容量 */);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        ;       // 返回  1
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));       // 返回  4
    }

}
