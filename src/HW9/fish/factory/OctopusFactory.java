package HW9.fish.factory;

import HW9.fish.Fish;
import HW9.fish.Octopus;
import HW9.fish.movement.HorizontalMovement;
import HW9.fish.movement.MovementStyle;

public class OctopusFactory extends FishFactory
{
    public Fish create()
    {
        MovementStyle ms = new HorizontalMovement(1);
        return new Octopus(ms);
    }
}