package HW8.state;

import HW8.CSVMachine;

public class Quoted extends State
{
    public Quoted(CSVMachine machine)
    {
        super(machine);
    }

    @Override
    public void processChar(char c)
    {
        if (c == '"')
            machine.setState(machine.seenQuote);
        else
            machine.addChar(c);
    }
}
