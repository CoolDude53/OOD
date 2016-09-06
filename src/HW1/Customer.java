package HW1;

import java.util.List;

public class Customer
{
    // is the wait time the customer is going to have
    private int waitTime;

    public Customer()
    {
        this.waitTime = 2 * howManyItems() + 10;
    }

    // determines how many items this customer is going to get
    private int howManyItems()
    {
        int n = (int) (Math.random() * 10);
        return n + 1;
    }

    // determines the shortest line for the customer to go to
    public CashRegister smallestRegister(List<CashRegister> registers)
    {
        CashRegister smallestLine = null;

        for (CashRegister register : registers)
        {
            if (smallestLine == null || register.getLine() < smallestLine.getLine())
                smallestLine = register;
        }

        return smallestLine;
    }

    public int getWaitTime()
    {
        return waitTime;
    }

    public int waited()
    {
        waitTime--;
        return waitTime;
    }
}
