package HW2.players;

import HW2.Game;

import java.util.ArrayList;

public class HumanPlayer extends Player
{
    public HumanPlayer(Game game, String name)
    {
        super(game);

        // ensures the name is unique by adding a number to the end of the name if it already exists in the game
        if (game.getNamesInUse().contains(name))
        {
            int num = 1;
            while (game.getNamesInUse().contains(name + num))
                num++;

            name += num;
        }

        setName(name);
    }

    @Override
    public void go()
    {
        System.out.println("\n" + getName() + ", it is your turn!");
        getGame().addToPot(getRoll()); // handles the first roll without requirement for user input

        ArrayList<Integer> rolled = roll(); //roll
        System.out.println("You rolled a " + rolled.toString().substring(1, rolled.toString().length() - 1));

        // if player aced out, end their turn
        if (rolled.contains(1))
        {
            System.out.println("Oh gosh! You aced out after " + (getRoll() - 1) + (getRoll() > 1 ? " rolls" : " roll") + "!");
            endTurn(true);
        }

        // if player didn't ace out, ask them what to do
        else
        {
            System.out.println("Would you like to roll again or stop and take the pot containing " + getGame().getPot() + "? (roll, stop)");

            String whatNext = getGame().getScanner().next();

            // handles inputs other than roll and stop
            while (!whatNext.equalsIgnoreCase("roll") && !whatNext.equalsIgnoreCase("stop"))
            {
                System.out.println("Maybe you misunderstood...");
                System.out.println("Would you like to roll again or stop and take the pot containing " + getGame().getPot() + "? (roll, stop)");

                whatNext =  getGame().getScanner().next();
            }

            if (whatNext.equalsIgnoreCase("roll"))
                go(); // to keep playing, the player calls go() again
            else
                endTurn(false); // to stop, the player ends its turn and claims the pot
        }
    }
}
