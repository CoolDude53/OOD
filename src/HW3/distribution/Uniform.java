package HW3.distribution;

public class Uniform implements ItemDistribution
{
    private int n;

    public Uniform(int n)
    {
        this.n = n;
    }

    public int howManyItems()
    {
        return 1 + (int) (Math.random() * n);
    }
}
