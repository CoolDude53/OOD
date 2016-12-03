package HW9.fish.factory;

import HW9.fish.AngelFish;
import HW9.fish.Fish;
import HW9.fish.movement.MovementStyle;
import HW9.fish.movement.UpDownMovement;

public class AngelFishFactory extends FishFactory
{
    public Fish create()
    {
        // each new fish has random speeds from 1 to 8
        int xspeed = 1 + (int) (8 * Math.random());
        int yspeed = 1 + (int) (8 * Math.random());
        MovementStyle ms = new UpDownMovement(xspeed, yspeed);
        return new AngelFish(ms);
    }
}
