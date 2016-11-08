package HW7;

import java.util.Map;
import java.util.function.Consumer;

public interface Polynomial extends Iterable<Polynomial>
{
    String toString();

    boolean equals(Polynomial p);

    int evaluate(Map<String, Integer> m);

    Polynomial reduce();

    default void traverse(Consumer<Polynomial> c)
    {
        c.accept(this);
        forEach(mc -> mc.traverse(c));
    }
}
