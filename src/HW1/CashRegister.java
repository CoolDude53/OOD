package HW1;

import java.util.ArrayList;

public class CashRegister
{
    private ArrayList<Customer> customersInLine = new ArrayList<>();
    private int customersServed = 0;
    private int totalWaitTime = 0;

    public void addCustomerInLine(Customer customer)
    {
        customersInLine.add(customer);
    }

    private void customerServed(Customer customer, int exitLineTime)
    {
        customersInLine.remove(customer);
        totalWaitTime += customer.getWaitTime(exitLineTime);
        customersServed++;
    }

    public int getCustomersServed()
    {
        return customersServed;
    }

    public int getLine()
    {
        return customersInLine.size();
    }

    public int getAverageWaitTime()
    {
        return totalWaitTime / customersServed;
    }

    public void elapseOneSecond(int time)
    {
        // If the list is empty, there are no customers to process.
        if (getLine() == 0)
            return;

        Customer firstCustomer = customersInLine.get(0);

        // Otherwise, the first customer in line gets processed.
        if (firstCustomer.waited() <= 0)
            customerServed(firstCustomer, time);
    }
}
