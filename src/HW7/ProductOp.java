package HW7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class ProductOp implements Polynomial
{
    public Polynomial left, right;

    public ProductOp(Polynomial left, Polynomial right)
    {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Polynomial p)
    {
        return p instanceof ProductOp && (left.equals(((ProductOp) p).left) || left.equals(((ProductOp) p).right)) && (right.equals(((ProductOp) p).right) || right.equals(((ProductOp) p).left));
    }

    @Override
    public int evaluate(Map<String, Integer> m)
    {
        return left.evaluate(m) * right.evaluate(m);
    }

    @Override
    public Polynomial reduce()
    {
        if (left.reduce() instanceof Number && right.reduce() instanceof Number)
            return new Number(left.reduce().evaluate(null) + left.reduce().evaluate(null));
        else if (left.reduce() instanceof Number)
        {
            if (left.reduce().evaluate(null) == 0)
                return new Number(0);
            else if (left.reduce().evaluate(null) == 1)
                return right.reduce();
        }

        else if (right.reduce() instanceof Number)
        {
            if (right.reduce().evaluate(null) == 0)
                return new Number(0);
            else if (right.reduce().evaluate(null) == 1)
                return left.reduce();
        }

        return new ProductOp(left.reduce(), right.reduce());
    }

    @Override
    public Iterator<Polynomial> iterator()
    {
        ArrayList<Polynomial> representation = new ArrayList<>();
        representation.add(left);
        representation.add(right);

        for (Polynomial aLeft : left) representation.add(aLeft);
        for (Polynomial aRight : right) representation.add(aRight);

        return representation.iterator();
    }

    @Override
    public String toString()
    {
        return "(" + left.toString() + " * " + right.toString() + ")";
    }
}
