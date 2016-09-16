package HW2.players.logic;

import HW2.utils.Utils;

public class Medium implements Difficulty
{
    @Override
    public boolean keepGoing()
    {
        return Utils.randInt(1, 3) == 1;
    }
}
