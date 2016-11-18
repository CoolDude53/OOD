package HW8.state;

import HW8.CSVMachine;

public class UnQuoted extends State
{
    public UnQuoted(CSVMachine machine)
    {
        super(machine);
    }

    @Override
    public void processChar(char c)
    {
        if (c == '"')
            machine.setState(machine.error);
        else if (c == ',')
        {
            // next phrase
            machine.setState(machine.begin);
            machine.increment();
        }
        else
            machine.addChar(c);
    }
}