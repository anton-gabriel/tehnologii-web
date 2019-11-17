package utils;

/**
 * The type Pair.
 *
 * @param <K> the type parameter
 * @param <V> the type parameter
 */
public class Pair<K, V> extends java.util.AbstractMap.SimpleImmutableEntry<K, V> {

    /**
     * Instantiates a new Pair.
     *
     * @param key   the key
     * @param value the value
     */
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