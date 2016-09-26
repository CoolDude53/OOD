package HW3.cashier;

import HW3.Customer;

public class NormalSpeed implements Cashier
{
    @Override
    public void elapseASecond(Customer customer)
    {
        customer.elapseOneSecond();
    }

    @Override
    public String getSpeed()
    {
        return "normal";
    }
}
