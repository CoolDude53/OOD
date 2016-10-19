package HW5;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

public class MergedCollection<T> extends AbstractCollection<T>
{
    private Collection<T> collection1, collection2;

    public MergedCollection(Collection<T> collection1, Collection<T> collection2)
    {
        this.collection1 = collection1;
        this.collection2 = collection2;
    }

    @Override
    public int size()
    {
        return collection1.size() + collection2.size();
    }

    @Override
    public Iterator<T> iterator()
    {
        return new MergedIterator(collection1, collection2);
    }
}

class MergedIterator<T> implements Iterator<T>
{
    private Collection<T> collection1, collection2;
    private Iterator<T> iter1, iter2;
    private int pos = 0;

    public MergedIterator(Collection<T> collection1, Collection<T> collection2)
    {
        this.collection1 = collection1;
        this.collection2 = collection2;
        this.iter1 = collection1.iterator();
        this.iter2 = collection2.iterator();
    }

    public boolean hasNext()
    {
        return pos < collection1.size() + collection2.size();
    }

    public T next()
    {
        T t;

        if (pos < collection1.size())
            t = iter1.next();
        else
            t = iter2.next();

        pos++;
        return t;
    }
}

