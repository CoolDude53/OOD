package HW6.fish;

public class AngelFishFactory extends FishFactory
{
    @Override
    public Fish create()
    {
        return new AngelFish();
    }
}
