package HW2;

import HW2.players.ComputerPlayer;
import HW2.players.HumanPlayer;
import HW2.players.Player;
import HW2.utils.Difficulty;
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

        while (humanPlayers < 0)
        {
            System.out.println("Maybe you misunderstood...");
            System.out.println("How many human players will be playing today?");

            humanPlayers = scanner.nextInt();
        }

        while (humanPlayers > 0)
        {
            System.out.println("Hello new player, may I ask your name?");

            HumanPlayer player = new HumanPlayer(this, scanner.next());
            players.add(player);

            System.out.println("Thanks " + player.getName() + "! Please wait while I finish setting up!\n");
            humanPlayers--;
        }

        if (players.size() > 0)
            System.out.println("Thank you for entering the game " + getPlayerNames() + "!");

        if (players.size() == 0)
            System.out.println("How many computer players will be playing today? (Atleast 2 required)");
        else if (players.size() == 1)
            System.out.println("How many computer players will be playing today? (Atleast 1 required)");
        else
            System.out.println("How many computer players will be playing today? (Enter 0 if none)");

        int computerPlayers = scanner.nextInt();

        while (computerPlayers <= 1 && players.size() == 0)
        {
            System.out.println("Maybe you misunderstood...");
            System.out.println("How many computer players will be playing today? (Atleast 2 required)");

            computerPlayers = scanner.nextInt();
        }

        while (computerPlayers <= 0 && players.size() == 1)
        {
            System.out.println("Maybe you misunderstood...");
            System.out.println("How many computer players will be playing today? (Atleast 1 required)");

            computerPlayers = scanner.nextInt();
        }

        if (computerPlayers > 0)
        {
            System.out.println("What computer player difficulty would you like to play against today? (easy, medium, hard, mixed)");

            Difficulty difficulty = Utils.difficultyFromString(scanner.next());
            while (difficulty == null)
            {
                System.out.println("Maybe you misunderstood...");
                System.out.println("What computer player difficulty would you like to play against today? (easy, medium, hard, mixed)");

                difficulty = Utils.difficultyFromString(scanner.next());
            }


            while (computerPlayers > 0)
            {
                ComputerPlayer player = new ComputerPlayer(this, difficulty);
                players.add(player);

                computerPlayers--;
            }
        }

        playerUp = players.get(0);
        System.out.println("This is simply wonderful! " + getPlayerNames() + ", let's begin!");
    }

    private void startPlaying()
    {
        while (winner == null)
            playerUp.go();

        long duration = System.currentTimeMillis() - startTime;
        System.out.println("\nSweet biscuits! We have a winner!");
        System.out.println("Let's all congratulate " + winner.getName() + ", who finished with " + winner.getChips() + " chips!");
        printScoreboard();
        System.out.println("I'm simply astounded! This game took " + String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(duration), TimeUnit.MILLISECONDS.toMinutes(duration) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(duration)), TimeUnit.MILLISECONDS.toSeconds(duration) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration))) + "!");
    }

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
}
