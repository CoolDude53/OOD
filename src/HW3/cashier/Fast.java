package HW3.cashier;

import HW3.Customer;

public class Fast implements Cashier
{
    @Override
    public void elapseASecond(Customer customer)
    {
        customer.elapseOneSecond();
        if (!customer.isFinished())
            customer.elapseOneSecond();
    }

    @Override
    public String getSpeed()
    {
        return "fast";
    }
}
