package HW3;

import HW3.cashier.Cashier;
import HW3.cashier.Fast;
import HW3.cashier.NormalSpeed;
import HW3.comparator.CompareByCustsServed;
import HW3.comparator.CompareByWaitTime;
import HW3.distribution.Bimodal;
import HW3.distribution.ItemDistribution;
import HW3.distribution.Uniform;

import java.util.Arrays;

public class DiningHall
{
    private static final int CUST_ARRIVAL_PCT = 18;    // There is a 18% chance a customer arrives each second.
    private CashRegister[] registers;
    private static final Cashier normalCashier = new NormalSpeed();
    private static final Cashier fastCashier = new Fast();

    public DiningHall(int normal, int fast, String distType, int distSize)
    {
        ItemDistribution dist;

        if (distType.equals("u"))
            dist = new Uniform(distSize);
        else
            dist = new Bimodal(distSize);

        registers = new CashRegister[normal + fast];

        for (int r = 0; r < normal; r++)
            registers[r] = new CashRegister(r, normalCashier, dist);

        for (int r = normal; r < normal + fast; r++)
            registers[r] = new CashRegister(r, fastCashier, dist);
    }

    public void elapseOneSecond(int t)
    {
        if (aCustomerArrives())
        {
            // The new customer goes into the smaller line.
            CashRegister chosenRegister = smallestLine();
            chosenRegister.addCustomer(t);
        }

        for (CashRegister register : registers) register.elapseOneSecond(t);  // Simulate each register for one second.
    }

    public void printStatistics(String sortType)
    {
        if (sortType.equals("w"))
            Arrays.sort(registers, new CompareByWaitTime());
        else if (sortType.equals("s"))
            Arrays.sort(registers, new CompareByCustsServed());

        for (CashRegister reg : registers)
        {
            System.out.println("Register " + reg.whoAmI());
            System.out.println("\tNumber served = " + reg.customersServed());
            System.out.println("\tAverage wait time = " + reg.avgWaitTime());
        }
    }

    private boolean aCustomerArrives()
    {
        int n = (int) (Math.random() * 100);  // an integer between 0 and 99
        return n < CUST_ARRIVAL_PCT;
    }

    private CashRegister smallestLine()
    {
        CashRegister currentSmallest = registers[0];
        for (int r = 1; r < registers.length; r++)
        {
            CashRegister cr = registers[r];
            if (cr.size() < currentSmallest.size())
                currentSmallest = cr;
        }
        return currentSmallest;
    }
}
