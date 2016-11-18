package HW8;

import HW8.state.*;

import java.util.ArrayList;
import java.util.List;

public class CSVMachine
{
    public State begin, quoted, seenQuote, unQuoted, error;
    private List<String> row = new ArrayList<>();
    private State state;
    private int index = 0;

    public CSVMachine()
    {
        state = begin = new Begin(this);
        quoted = new Quoted(this);
        seenQuote = new SeenQuote(this);
        unQuoted = new UnQuoted(this);
        error = new ErrorState(this);
    }

    public void processChar(char c)
    {
        if (row.size() <= index)
            row.add("");

        state.processChar(c);
    }

    public List<String> getRow()
    {
        return row;
    }

    public void addChar(char c)
    {
        row.set(index, row.get(index) + c);
    }

    public void increment()
    {
        index++;
    }

    public int getIndex()
    {
        return index;
    }

    public void setState(State state)
    {
        this.state = state;
    }
}
