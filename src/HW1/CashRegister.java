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
        totalWaitTime += customer.getWaitTime();
    }

    public void customerServed(Customer customer)
    {
        customersInLine.remove(customer);
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

    public void elapseOneSecond()
    {
        // If the list is empty, there are no customers to process.
        if (getLine() == 0)
            return;

        // Otherwise, the first customer in line gets processed.
        if (customersInLine.get(0).waited() <= 0)
        {
            // First update the register's statistics.
            customersServed++;

            // Then remove the customer.
            customersInLine.remove(0);
        }
    }
}
