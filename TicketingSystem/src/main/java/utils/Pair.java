package utils;

public class Pair<K, V> extends java.util.AbstractMap.SimpleImmutableEntry<K, V> {

    public Pair(K key, V value) {
        super(key, value);
    }

    public K getKey() {
        return super.getKey();
    }

    public V getValue() {
        return super.getValue();
    }

    public String toString() {
        return "[" + getKey() + "," + getValue() + "]";
    }
}