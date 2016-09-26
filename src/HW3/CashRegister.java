package HW3;

import HW3.cashier.Cashier;
import HW3.distribution.ItemDistribution;

import java.util.LinkedList;
import java.util.List;

public class CashRegister
{
    private int whoami;  // identifies the cash register
    private Cashier cashier;
    private ItemDistribution dist;
    private List<Customer> custs = new LinkedList<>();
    private int numServed = 0;
    private int totalWaitTime = 0;
    private Customer currentCust = null;

    public CashRegister(int n, Cashier cashier, ItemDistribution dist)
    {
        whoami = n;
        this.cashier = cashier;
        this.dist = dist;
    }

    public void addCustomer(int t)
    {
        Customer c = new Customer(t, dist);
        custs.add(c);
        if (currentCust == null)
            currentCust = c;
    }

    public void elapseOneSecond(int currentTime)
    {
        // Return if there is no current customer.
        if (currentCust == null)
            return;

        // Otherwise, process the current customer.
        cashier.elapseASecond(currentCust);
        if (currentCust.isFinished())
        {
            numServed++;
            totalWaitTime += currentTime - currentCust.arrivalTime();

            // Remove the finished customer and make the next customer current.
            custs.remove(0);
            currentCust = custs.size() > 0 ? custs.get(0) : null;
        }
    }

    public int size()
    {
        return custs.size();
    }

    public int customersServed()
    {
        return numServed;
    }

    public int avgWaitTime()
    {
        return numServed > 0 ? totalWaitTime / numServed : 0;
    }

    public String whoAmI()
    {
        return whoami + " " + cashier.getSpeed();
    }
}
