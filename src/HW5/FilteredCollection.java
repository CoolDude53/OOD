package HW5;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilteredCollection<T> extends AbstractCollection<T>
{
    private Collection<T> filteredCollection = new ArrayList<>();

    public FilteredCollection(Predicate<T> predicate, Collection<T> collection)
    {
        filteredCollection.addAll(collection.stream().filter(predicate).collect(Collectors.toList()));
    }

    @Override
    public int size()
    {
        return filteredCollection.size();
    }

    @Override
    public Iterator<T> iterator()
    {
        return filteredCollection.iterator();
    }
}
