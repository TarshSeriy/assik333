package org.example.utils.classes;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class MyBST<K extends Comparable<K>, V> implements Iterable<K> {
    private Node root;
    private int size;

    public MyBST() {
        root = null;
        size = 0;
    }

    public void put(K key, V value) {
        if (root == null) {
            root = new Node(key, value);
            size++;
            return;
        }
        put(root, key, value);
    }

    private void put(Node node, K key, V value) {
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            if (node.left == null) {
                node.left = new Node(key, value);
                size++;
            } else {
                put(node.left, key, value);
            }
        } else if (cmp > 0) {
            if (node.right == null) {
                node.right = new Node(key, value);
                size++;
            } else {
                put(node.right, key, value);
            }
        } else {
            node.value = value;
        }
    }

    public V get(K key) {
        return get(root, key);
    }

    private V get(Node node, K key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(node.left, key);
        } else if (cmp > 0) {
            return get(node.right, key);
        } else {
            return node.value;
        }
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    private Node delete(Node node, K key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null) {
                size--;
                return node.right;
            } else if (node.right == null) {
                size--;
                return node.left;
            }
            Node temp = findMin(node.right);
            node.key = temp.key;
            node.value = temp.value;
            node.right = delete(node.right, temp.key);
        }
        return node;
    }

    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.key + ": " + node.value);
            inOrder(node.right);
        }
    }

    public int getSize() {
        return size;
    }

    @Override
    public Iterator<K> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<K> {
        private Node current;
        private Node lastReturned;
        private Stack<Node> stack;

        public MyIterator() {
            current = root;
            lastReturned = null;
            stack = new Stack<>();
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty() || current != null;
        }

        @Override
        public K next() {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            if (stack.isEmpty()) {
                throw new NoSuchElementException();
            }
            Node node = stack.pop();
            lastReturned = node;
            current = node.right;
            return node.key;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class Node {
        private K key;
        private V value;
        private Node left;
        private Node right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }
}
