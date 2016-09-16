package HW2.players.logic;

import HW2.utils.Utils;

public class Hard implements Difficulty
{
    @Override
    public boolean keepGoing()
    {
        return Utils.randInt(1, 4) == 1;
    }
}
