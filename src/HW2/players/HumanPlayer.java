package HW2.players;

import HW2.Game;

import java.util.ArrayList;

public class HumanPlayer extends Player
{
    public HumanPlayer(Game game, String name)
    {
        super(game);

        if (getNamesInUse().contains(name))
        {
            int num = 1;
            while (getNamesInUse().contains(name + num))
                num++;

            name += num;
        }

        setName(name);
    }

    @Override
    public void go()
    {
        System.out.println("\n" + getName() + ", it is your turn!");
        getGame().addToPot(getRoll());

        ArrayList<Integer> rolled = roll();
        System.out.println("You rolled a " + rolled.toString().substring(1, rolled.toString().length() - 1));

        if (rolled.contains(1))
        {
            System.out.println("Oh gosh! You aced out after " + (getRoll() - 1) + (getRoll() > 1 ? " rolls" : " roll") + "!");
            endTurn(true);
        }

        else
        {
            System.out.println("Would you like to roll again or stop and take the pot containing " + getGame().getPot() + "? (roll, stop)");

            String whatNext = getGame().getScanner().next();
            while (!whatNext.equalsIgnoreCase("roll") && !whatNext.equalsIgnoreCase("stop"))
            {
                System.out.println("Maybe you misunderstood...");
                System.out.println("Would you like to roll again or stop and take the pot containing " + getGame().getPot() + "? (roll, stop)");

                whatNext =  getGame().getScanner().next();
            }

            if (whatNext.equalsIgnoreCase("roll"))
                go();
            else
                endTurn(false);
        }
    }
}
