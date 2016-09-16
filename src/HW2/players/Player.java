package HW2.players;

import HW2.Game;
import HW2.utils.Utils;

import java.util.ArrayList;

public abstract class Player
{
    private Game game;
    private String name;
    private int chips = 0;
    private int roll = 1;
    private ArrayList<Integer> rolls = new ArrayList<>();

    public abstract void go();

    public Player(Game game)
    {
        this.game = game;
    }

    public String getName()
    {
        return name;
    }

    protected ArrayList<Integer> roll()
    {
        // clear any previous rolls
        rolls.clear();

        // based on the roll count, increase dice
        for (int count = 0; count < roll; count++)
            rolls.add(Utils.randInt(1, 4));

        // increase roll count for next turn
        roll++;

        return rolls;
    }

    protected void endTurn(boolean aced)
    {
        // if the player chooses to stop
        if (!aced)
        {
            chips += game.getPot();
            System.out.println(getName() + " stopped after " + (roll - 1) + " rolls, winning " + game.getPot() + " chips!");
            game.resetPot();
        }

        roll = 1;
        rolls.clear();


        game.didWin(this); // check if this player has won
        game.nextUp();

        System.out.println("\n---------------------------------------------------");
        game.printScoreboard();
        System.out.println("Current pot: " + game.getPot());
        System.out.println("\n---------------------------------------------------");
    }

    public int getChips()
    {
        return chips;
    }

    protected Game getGame()
    {
        return game;
    }

    protected int getRoll()
    {
        return roll;
    }

    protected void setName(String name)
    {
        this.name = name;
    }
}
