package HW4;

import javax.swing.*;
import java.util.ArrayList;

public class ScoreInput
{
    private ArrayList<ScoreService> services = new ArrayList<>();

    public ScoreInput()
    {
        buildPanel();
    }

    private void buildPanel()
    {
        String[] labels = {"Sport", "Home Team", "Away Team", "Home Score", "Away Score"};

        JFrame frame = new JFrame("Score Input");
        JPanel panel = new JPanel();

        ArrayList<JTextField> textFields = new ArrayList<>();

        for (String label : labels)
        {
            panel.add(new JLabel(label));
            textFields.add((JTextField) panel.add(new JTextField("", 10)));
        }

        JButton button = new JButton("NEW SCORE");
        panel.add(button);

        button.addActionListener(evt ->
        {
            String sport = textFields.get(0).getText();
            String homeTeam = textFields.get(1).getText();
            String awayTeam = textFields.get(2).getText();
            int homeScore;
            int awayScore;

            if (sport.isEmpty() || homeTeam.isEmpty() || awayTeam.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please provide proper input!", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                return;
            }

            try
            {
                homeScore = Integer.parseInt(textFields.get(3).getText());
                awayScore = Integer.parseInt(textFields.get(4).getText());
            } catch (NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null, "Please provide proper input!", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                return;
            }

            notifySubscribers(sport, homeTeam, awayTeam, homeScore, awayScore);
        });

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocation(200, 200);
        frame.setContentPane(panel);
        frame.setVisible(true);
        frame.pack();
    }

    public void subscribe(ScoreService service)
    {
        services.add(service);
    }

    private void notifySubscribers(String sport, String homeTeam, String awayTeam, int homeScore, int awayScore)
    {
        for (ScoreService service : services)
            service.notifyObservers(sport, homeTeam, awayTeam, homeScore, awayScore);
    }
}
