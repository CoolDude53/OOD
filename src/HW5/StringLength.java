package HW5;

import java.util.function.Predicate;

public class StringLength implements Predicate<String>
{
    private int length;

    public StringLength(int length)
    {
        this.length = length;
    }

    @Override
    public boolean test(String s)
    {
        return s.length() <= length;
    }
}
