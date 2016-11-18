package HW8.state;

import HW8.CSVMachine;

public abstract class State
{
    protected CSVMachine machine;

    public State(CSVMachine machine)
    {
        this.machine = machine;
    }

    public abstract void processChar(char c);
}
