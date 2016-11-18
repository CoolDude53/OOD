package HW8.state;

import HW8.CSVMachine;

public class SeenQuote extends State
{
    public SeenQuote(CSVMachine machine)
    {
        super(machine);
    }

    @Override
    public void processChar(char c)
    {
        if (c == '"')
        {
            machine.setState(machine.quoted);
            machine.addChar(c);
        }
        else if (c == ',')
        {
            // next phrase
            machine.setState(machine.begin);
            machine.increment();
        }
        else
            machine.setState(machine.error);
    }
}
