package HW9.fish.factory;

import HW9.fish.Fish;

public abstract class FishFactory
{
    public static FishFactory getFactory(String s)
    {
        if (s.equals("Angel Fish"))
            return new AngelFishFactory();
        else if (s.equals("Octopus"))
            return new OctopusFactory();
        else if (s.equals("Mean Fish"))
            return new MeanieFactory();
        else
            return null;
    }

    public abstract Fish create();
}
