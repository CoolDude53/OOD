package HW5;

import java.util.*;

public class SortedCollection<T> extends AbstractCollection<T>
{
    private Collection<T> sortedCollection;

    public SortedCollection(Collection<T> collection, Comparator<T> comparator)
    {
        List<T> sortedList = new ArrayList<>(collection);
        Collections.sort(sortedList, comparator);
        sortedCollection = sortedList;
    }

    @Override
    public int size()
    {
        return sortedCollection.size();
    }

    @Override
    public Iterator<T> iterator()
    {
        return sortedCollection.iterator();
    }
}
