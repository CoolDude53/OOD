package HW8.state;

import HW8.CSVMachine;

public class ErrorState extends State
{
    public ErrorState(CSVMachine machine)
    {
        super(machine);
    }

    @Override
    public void processChar(char c)
    {
        if (!machine.getRow().get(machine.getIndex()).equals("ERROR"))
            machine.getRow().set(machine.getIndex(), "ERROR");
        if (c == ',')
        {
            // next phrase
            machine.setState(machine.begin);
            machine.increment();
        }
    }
}