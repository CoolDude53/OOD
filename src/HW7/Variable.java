package HW7;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

public class Variable implements Polynomial
{
    private String name;

    public Variable(String name)
    {
        this.name = name;
    }

    @Override
    public boolean equals(Polynomial p)
    {
        return p instanceof Variable && p.toString().equals(name);
    }

    @Override
    public int evaluate(Map<String, Integer> m)
    {
        if (m == null || !m.containsKey(name))
            throw new NoSuchElementException("Variable value not found int Map!");

        return m.get(name);
    }

    @Override
    public Polynomial reduce()
    {
        return this;
    }

    @Override
    public Iterator<Polynomial> iterator()
    {
        return Collections.emptyIterator();
    }

    @Override
    public String toString()
    {
        return name;
    }
}
