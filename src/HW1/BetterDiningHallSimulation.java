package HW1;

import java.util.ArrayList;

public class BetterDiningHallSimulation
{
    private static final int SIMULATION_TIME = 50000;  // A simulation is for 50,000 imaginary seconds.
    private static final int CUST_ARRIVAL_PCT = 18;    // There is a 18% chance a customer arrives each second.
    private static final int NUM_REGISTERS = 4;        // There are 4 cash registers.

    private static ArrayList<CashRegister> registers = new ArrayList<>();

    public static void main(String[] args)
    {
        // First, initialize the cash register arrays.
        for (int r = 0; r < NUM_REGISTERS; r++)
            registers.add(new CashRegister());

        // Then perform the simulation for the specified number of seconds.
        for (int t = 0; t < SIMULATION_TIME; t++)
        {
            if (aCustomerArrives())
            {
                Customer newCustomer = new Customer(t);
                newCustomer.smallestRegister(registers).addCustomerInLine(newCustomer);
            }

            for (CashRegister register : registers)
                register.elapseOneSecond(t);
        }

        // Print out the statistics.
        for (int r = 0; r < NUM_REGISTERS; r++)
        {
            CashRegister register = registers.get(r);

            System.out.println("Register " + r);
            System.out.println("\tNumber of arrivals = " + register.getCustomersServed());
            System.out.println("\tAverage wait time = " + register.getAverageWaitTime());
        }
    }

    // keep this here because it is driving the simulation
    private static boolean aCustomerArrives()
    {
        int n = (int) (Math.random() * 100);  // an integer between 0 and 99
        return n < CUST_ARRIVAL_PCT;
    }
}
