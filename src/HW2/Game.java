package HW2;

import HW2.players.ComputerPlayer;
import HW2.players.HumanPlayer;
import HW2.players.Player;
import HW2.players.logic.Difficulty;
import HW2.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game
{
    private Scanner scanner = new Scanner(System.in);
    private long startTime = System.currentTimeMillis();
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<String> namesInUse = new ArrayList<>();
    private int playerUpNum = 0;
    private Player playerUp;
    private Player winner = null;
    private int pot = 0;

    public Game()
    {
        setupGame();
        startPlaying();
    }

    private void setupGame()
    {
        System.out.println("Hello and welcome!");
        System.out.println("How many human players will be playing today?");

        int humanPlayers = scanner.nextInt();

        // handles negative numbers
        while (humanPlayers < 0)
        {
            System.out.println("Maybe you misunderstood...");
            System.out.println("How many human players will be playing today?");

            humanPlayers = scanner.nextInt();
        }

        // handles human player creation
        while (humanPlayers > 0)
        {
            System.out.println("Hello new player, may I ask your name?");

            HumanPlayer player = new HumanPlayer(this, scanner.next());
            addToGame(player);

            System.out.println("Thanks " + player.getName() + "! Please wait while I finish setting up!\n");
            humanPlayers--;
        }

        // prints the list of human players, if any, before moving on to the computer players
        if (players.size() > 0)
            System.out.println("Thank you for entering the game " + getPlayerNames() + "!");

        // handles requirements based on number of human players
        if (players.size() == 0)
            System.out.println("How many computer players will be playing today? (Atleast 2 required)");
        else if (players.size() == 1)
            System.out.println("How many computer players will be playing today? (Atleast 1 required)");
        else
            System.out.println("How many computer players will be playing today? (Enter 0 if none)");

        int computerPlayers = scanner.nextInt();

        // handles invalid number of computer players (0 human players requires 2 computer players)
        while (computerPlayers <= 1 && players.size() == 0)
        {
            System.out.println("Maybe you misunderstood...");
            System.out.println("How many computer players will be playing today? (Atleast 2 required)");

            computerPlayers = scanner.nextInt();
        }

        // handles invalid number of computer players (1 human player requires 1 computer player)
        while (computerPlayers <= 0 && players.size() == 1)
        {
            System.out.println("Maybe you misunderstood...");
            System.out.println("How many computer players will be playing today? (Atleast 1 required)");

            computerPlayers = scanner.nextInt();
        }

        // handles computer player generation
        while (computerPlayers > 0)
        {
            ComputerPlayer player = new ComputerPlayer(this);

            System.out.println("What difficulty would you like " + player.getName() + " to have today? (easy, medium, hard)");

            Difficulty difficulty = Utils.difficultyFromString(scanner.next());

            // handles invalid difficulty entries
            while (difficulty == null)
            {
                System.out.println("Maybe you misunderstood...");
                System.out.println("What difficulty would you like " + player.getName() + " to have today? (easy, medium, hard)");

                difficulty = Utils.difficultyFromString(scanner.next());
            }

            player.setDifficulty(difficulty);
            addToGame(player);
            computerPlayers--;
        }

        // set the first player
        playerUp = players.get(0);
        System.out.println("\nxThis is simply wonderful! " + getPlayerNames() + ", let's begin!");
    }

    private void addToGame(Player player)
    {
        players.add(player);
        namesInUse.add(player.getName());
    }

    private void startPlaying()
    {
        // while there isn't a winner, the next player up can go
        while (winner == null)
            playerUp.go();

        // dialogue when someone wins
        long duration = System.currentTimeMillis() - startTime;
        System.out.println("\nSweet biscuits! We have a winner!");
        System.out.println("Let's all congratulate " + winner.getName() + ", who finished with " + winner.getChips() + " chips!");
        printScoreboard();
        System.out.println("I'm simply astounded! This game took " + String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(duration), TimeUnit.MILLISECONDS.toMinutes(duration) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(duration)), TimeUnit.MILLISECONDS.toSeconds(duration) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration))) + "!");
    }

    // used to ensure no two players share the same name
    private String getPlayerNames()
    {
        if (players.size() > 1)
        {
            ArrayList<String> names = new ArrayList<>();

            for (int count = 0; count < players.size(); count++)
            {
                if (count == players.size() - 1)
                    names.add("and " + players.get(count).getName());
                else
                    names.add(players.get(count).getName());
            }

            return names.toString().substring(1, names.toString().length() - 1);
        }

        return players.get(0).getName();
    }

    public void didWin(Player player)
    {
        if (player.getChips() >= 30)
            winner = player;
    }

    public void nextUp()
    {
        playerUpNum = playerUpNum + 1 < players.size() ? playerUpNum + 1 : 0;
        playerUp = players.get(playerUpNum);
    }

    public void printScoreboard()
    {
        System.out.println("\n--Scoreboard--");

        Map<String, Integer> scoreboard = new HashMap<>();

        for (Player player : players)
            scoreboard.put(player.getName(), player.getChips());

        scoreboard = Utils.sortByValue(scoreboard);

        for (Map.Entry<String, Integer> entry : scoreboard.entrySet())
            System.out.println(entry.getKey() + " - " + entry.getValue());

        System.out.println("\n");
    }

    public int getPot()
    {
        return pot;
    }

    public Scanner getScanner()
    {
        return scanner;
    }

    public void addToPot(int amount)
    {
        pot += amount;
    }

    public void resetPot()
    {
        pot = 0;
    }

    public ArrayList<String> getNamesInUse()
    {
        return namesInUse;
    }
}
