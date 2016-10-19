package HW5;

import java.util.AbstractCollection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashTableCollection<T> extends AbstractCollection<T>
{
    private Map<T, T> map = new HashMap<>();

    public int size()
    {
        return map.size();
    }

    public boolean add(T e)
    {
        T v = map.put(e, e);
        return v == null;
    }

    public Iterator<T> iterator()
    {
        return map.keySet().iterator();
    }

    // overrides the method in AbstractCollection
    public boolean contains(Object obj)
    {
        return map.get(obj) != null;
    }
}
