package HW8.state;

import HW8.CSVMachine;

public class Begin extends State
{
    public Begin(CSVMachine machine)
    {
        super(machine);
    }

    @Override
    public void processChar(char c)
    {
        if (c == '"')
            machine.setState(machine.quoted);
        else
        {
            machine.setState(machine.unQuoted);
            machine.addChar(c);
        }
    }
}
