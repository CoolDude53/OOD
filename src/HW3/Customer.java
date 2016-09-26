package HW3;

import HW3.distribution.ItemDistribution;

public class Customer
{
    private int arrivalTime;
    private int serviceTime;

    public Customer(int t, ItemDistribution itemDistribution)
    {
        arrivalTime = t;
        int howmanyItems = itemDistribution.howManyItems();
        serviceTime = 2 * howmanyItems + 10;
    }

    public void elapseOneSecond()
    {
        serviceTime--;
    }

    public boolean isFinished()
    {
        return serviceTime == 0;
    }

    public int arrivalTime()
    {
        return arrivalTime;
    }
}