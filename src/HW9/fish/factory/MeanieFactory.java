package HW9.fish.factory;

import HW9.fish.Fish;
import HW9.fish.MeanFish;
import HW9.fish.movement.MovementStyle;
import HW9.fish.movement.OscillatingMovement;

public class MeanieFactory extends FishFactory
{
    public Fish create()
    {
        MovementStyle ms = new OscillatingMovement(8, 10);
        return new MeanFish(ms);
    }
}