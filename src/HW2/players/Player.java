package HW2.players;

import HW2.Game;
import HW2.utils.Utils;

import java.util.ArrayList;

public abstract class Player
{
    private Game game;
    private String name;
    private ArrayList<String> namesInUse = new ArrayList<>();
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

    public ArrayList<Integer> roll()
    {
        rolls.clear();

        for (int count = 0; count < roll; count++)
            rolls.add(Utils.randInt(1, 4));

        roll++;

        return rolls;
    }

    public void endTurn(boolean aced)
    {
        if (!aced)
        {
            chips += game.getPot();
            System.out.println(getName() + " stopped after " + (roll - 1) + " rolls, winning " + game.getPot() + " chips!");
            game.resetPot();
        }

        roll = 1;
        rolls.clear();


        game.didWin(this);
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

    public Game getGame()
    {
        return game;
    }

    public ArrayList<String> getNamesInUse()
    {
        return namesInUse;
    }

    public int getRoll()
    {
        return roll;
    }

    public ArrayList<Integer> getRolls()
    {
        return rolls;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
