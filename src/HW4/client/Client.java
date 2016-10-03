package HW4.client;

import HW4.ScoreService;

import javax.swing.*;

public abstract class Client
{
    private ScoreService service;
    private String sport;
    private String homeTeam;
    private String awayTeam;

    public Client(ScoreService service)
    {
        this.service = service;
        service.subscribe(this);
    }

    public void update()
    {
        if (sport != null && sport.equalsIgnoreCase(service.getSport()))
            generateNotification(0);
        if (homeTeam != null && homeTeam.equalsIgnoreCase(service.getHomeTeam()))
            generateNotification(1);
        if (awayTeam != null && awayTeam.equalsIgnoreCase(service.getAwayTeam()))
            generateNotification(2);
    }

    private void generateNotification(int type)
    {
        if (type == 0)
            JOptionPane.showMessageDialog(null, service.getHomeTeam() + (service.getHomeScore() > service.getAwayScore() ? " defeats " : service.getHomeScore() == service.getAwayScore() ? " ties " : " loses to ") + service.getAwayTeam() + ", " + service.getHomeScore() + " to " + service.getAwayScore() + "!", sport + " News", JOptionPane.WARNING_MESSAGE);
        else if (type == 1)
            JOptionPane.showMessageDialog(null, "The " + service.getSport() + " team" + (service.getHomeScore() > service.getAwayScore() ? " defeated " : service.getHomeScore() == service.getAwayScore() ? " tied " : " lost to ") + service.getAwayTeam() + ", " + service.getHomeScore() + " to " + service.getAwayScore() + "!", homeTeam + " News", JOptionPane.WARNING_MESSAGE);
        else if (type == 2)
            JOptionPane.showMessageDialog(null, "The " + service.getSport() + " team" + (service.getAwayScore() > service.getHomeScore() ? " defeated " : service.getAwayScore() == service.getHomeScore() ? " tied " : " lost to ") + service.getHomeTeam() + ", " + service.getAwayScore() + " to " + service.getHomeScore() + "!", awayTeam + " News", JOptionPane.WARNING_MESSAGE);
    }

    public void setSport(String sport)
    {
        this.sport = sport;
    }

    public void setHomeTeam(String homeTeam)
    {
        this.homeTeam = homeTeam;
    }

    public void setAwayTeam(String awayTeam)
    {
        this.awayTeam = awayTeam;
    }
}
