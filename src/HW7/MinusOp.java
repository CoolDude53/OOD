package HW7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class MinusOp implements Polynomial
{
    private Polynomial left, right;
    private final static Polynomial negativeOne = new Number(-1);

    public MinusOp(Polynomial left, Polynomial right)
    {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Polynomial p)
    {
        return p instanceof MinusOp && (left.equals(((MinusOp) p).left) || left.equals(((MinusOp) p).right)) && (right.equals(((MinusOp) p).right) || right.equals(((MinusOp) p).left));
    }

    @Override
    public int evaluate(Map<String, Integer> m)
    {
        return left.evaluate(m) - right.evaluate(m);
    }

    @Override
    public Polynomial reduce()
    {
        if (left.equals(right))
            return new Number(0);
        else if (left.reduce() instanceof Number && right.reduce() instanceof Number)
            return new Number(left.reduce().evaluate(null) - left.reduce().evaluate(null));
        else if (left.reduce() instanceof Number && left.reduce().evaluate(null) == 0)
            return new ProductOp(negativeOne, right).reduce();
        else if (right.reduce() instanceof Number && right.reduce().evaluate(null) == 0)
            return left.reduce();

        return new MinusOp(left.reduce(), right.reduce());
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
        return "(" + left.toString() + " - " + right.toString() + ")";
    }
}
