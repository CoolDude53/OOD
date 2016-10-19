package HW5;

import java.util.AbstractCollection;
import java.util.Iterator;

// This class stores a collection of strings as a single string.
// The elements of the collection are separated by tab characters.

public class MyStringCollection extends AbstractCollection<String>
{
    private String myStrings = "";
    private int howmany = 0;

    public int size()
    {
        return howmany;
    }

    public boolean add(String s)
    {
        s += '\t' + s;
        howmany++;
        return true;
    }

    public Iterator<String> iterator()
    {
        return new StringIterator(myStrings);
    }
}

// This class extracts the elements of the collection
// from the string and places them into an array.
// The next() method returns the next string in that array.

class StringIterator implements Iterator<String>
{
    private String[] strings;
    private int pos = 0;

    public StringIterator(String s)
    {
        strings = s.split("\t");
    }

    public boolean hasNext()
    {
        return pos < strings.length;
    }

    public String next()
    {
        pos++;
        return strings[pos - 1];
    }
}

