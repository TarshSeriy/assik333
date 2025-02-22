package org.example.utils.interfaces;

public interface MyBSTInterface<K extends Comparable<K>, V> {
    void put(K key, V value);

    V get(K key);

    void delete(K key);

    Iterable<K> iterator();
}

