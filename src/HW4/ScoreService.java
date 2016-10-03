package HW4;

import HW4.client.Client;

import java.util.ArrayList;

// register as an observer of ScoreInput (push)
// likewise use this as an obvservable with clients as observers (pull)
public class ScoreService
{
    private ArrayList<Client> clients = new ArrayList<>();
    private String sport;
    private String homeTeam;
    private String awayTeam;
    private int homeScore;
    private int awayScore;

    public ScoreService(ScoreInput input)
    {
        input.subscribe(this);
    }

    public void notifyObservers(String sport, String homeTeam, String awayTeam, int homeScore, int awayScore)
    {
        this.sport = sport;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = homeScore;
        this.awayScore = awayScore;

        clients.forEach(Client::update);
    }

    public void subscribe(Client client)
    {
        clients.add(client);
    }

    public String getSport()
    {
        return sport;
    }

    public String getHomeTeam()
    {
        return homeTeam;
    }

    public String getAwayTeam()
    {
        return awayTeam;
    }

    public int getHomeScore()
    {
        return homeScore;
    }

    public int getAwayScore()
    {
        return awayScore;
    }
}
