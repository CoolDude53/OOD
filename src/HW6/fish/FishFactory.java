package HW6.fish;

public abstract class FishFactory
{
    public abstract Fish create();

    public static FishFactory getFactory(String fishtype)
    {
        switch (fishtype)
        {
            case "Angel Fish":
                return new AngelFishFactory();
            case "Octopus":
                return new OctopusFactory();
            case "Mean Fish":
                return new MeanFishFactory();

            default:
                return new AngelFishFactory();
        }
    }
}
