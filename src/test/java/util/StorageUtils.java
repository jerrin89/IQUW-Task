package util;

import java.util.HashMap;
import java.util.Map;

public class StorageUtils {

    private static Map<Object, Object> store;

    public StorageUtils() {
        this.store = new HashMap<>();
    }

    public static void store(Object key, Object value) {
        store.put(key, value);
        System.out.println("Stored key: " + key + ", value: " + value);
    }

    public static <T> T get(Object key) {
        if (store.containsKey(key)) {
            return (T) store.get(key);
        } else {
            throw new IllegalArgumentException("Key not found: " + key);
        }
    }
}