package StepDefinitions;

import java.util.HashMap;
import java.util.Map;

public class Context {

    // Much Neater Approach from using Static, and specific objects.  More scalable.
    private final Map<String, Object> data = new HashMap<>();

    public void set(String key, Object value) {
        data.put(key, value);
    }

    public <T> T get(String key, Class<T> clazz) {
        return clazz.cast(data.get(key));
    }

    public boolean contains(String key) {
        return data.containsKey(key);
    }

}