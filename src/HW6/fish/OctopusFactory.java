package HW6.fish;

public class OctopusFactory extends FishFactory
{
    @Override
    public Fish create()
    {
        return new Octopus();
    }
}
