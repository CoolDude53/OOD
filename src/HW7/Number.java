package HW7;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

public class Number implements Polynomial
{
    private int val;

    public Number(int val)
    {
        this.val = val;
    }

    @Override
    public boolean equals(Polynomial p)
    {
        return p instanceof Number && p.toString().equals("" + val);
    }

    @Override
    public int evaluate(Map<String, Integer> m)
    {
        return val;
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
        return "" + val;
    }
}
