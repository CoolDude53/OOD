package HW7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;


public class PlusOp implements Polynomial
{
    private Polynomial left, right;

    public PlusOp(Polynomial left, Polynomial right)
    {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Polynomial p)
    {
        return p instanceof PlusOp && (left.equals(((PlusOp) p).left) || left.equals(((PlusOp) p).right)) && (right.equals(((PlusOp) p).right) || right.equals(((PlusOp) p).left));
    }

    @Override
    public int evaluate(Map<String, Integer> m)
    {
        return left.evaluate(m) + right.evaluate(m);
    }

    @Override
    public Polynomial reduce()
    {
        if (left.reduce() instanceof Number && right.reduce() instanceof Number)
            return new Number(left.reduce().evaluate(null) + right.reduce().evaluate(null));
        else if (left.reduce() instanceof Number && left.reduce().evaluate(null) == 0)
            return right.reduce();
        else if (right.reduce() instanceof Number && right.reduce().evaluate(null) == 0)
            return left.reduce();

        return new PlusOp(left.reduce(), right.reduce());
    }

    @Override
    public Iterator<Polynomial> iterator()
    {
        ArrayList<Polynomial> representation = new ArrayList<>();
        representation.add(right);
        representation.add(left);

        for (Polynomial aLeft : left) representation.add(aLeft);
        for (Polynomial aRight : right) representation.add(aRight);

        return representation.iterator();
    }

    @Override
    public String toString()
    {
        return "(" + left.toString() + " + " + right.toString() + ")";
    }
}
