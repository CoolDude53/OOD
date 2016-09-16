package HW2.players.logic;

import HW2.utils.Utils;

public class Easy implements Difficulty
{
    @Override
    public boolean keepGoing()
    {
        return Utils.randInt(1, 2) == 1;
    }
}
