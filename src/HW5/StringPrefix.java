package HW5;

import java.util.function.Predicate;

public class StringPrefix implements Predicate<String>
{
    String base;

    public StringPrefix(String s)
    {
        base = s;
    }

    @Override
    public boolean test(String s)
    {
        return s.startsWith(base);
    }
}
