package HW3.comparator;

import HW3.CashRegister;

import java.util.Comparator;

public class CompareByWaitTime implements Comparator<CashRegister>
{
    @Override
    public int compare(CashRegister register1, CashRegister register2)
    {
        return register2.customersServed() < register1.customersServed() ? -1 : register2.customersServed() == register1.customersServed() ? 0 : 1;
    }
}
