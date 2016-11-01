package HW6.fish;

public class MeanFishFactory extends FishFactory
{
    @Override
    public Fish create()
    {
        return new MeanFish();
    }
}
