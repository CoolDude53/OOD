package HW3.comparator;

import HW3.CashRegister;

import java.util.Comparator;

public class CompareByCustsServed implements Comparator<CashRegister>
{
    @Override
    public int compare(CashRegister register1, CashRegister register2)
    {
        return register1.avgWaitTime() < register2.avgWaitTime() ? -1 : register1.avgWaitTime() == register2.avgWaitTime() ? 0 : 1;
    }
}
