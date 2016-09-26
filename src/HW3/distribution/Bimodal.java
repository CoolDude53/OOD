package HW3.distribution;

public class Bimodal implements ItemDistribution
{
    private int n;

    public Bimodal(int n)
    {
        this.n = n;
    }

    public int howManyItems()
    {
        return 1 + (Math.random() < .5 ? (int) (Math.random() * n / 4) : (int) (n - Math.random() * n / 4));
    }
}
