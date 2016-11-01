package HW6;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class FishFrame extends JFrame implements ActionListener
{
    private FishPanel panel;

    public FishFrame()
    {
        setTitle("Fish Tank");
        setSize(650, 400);
        setLocation(20, 20);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new FishPanel();
        setJMenuBar(new FishMenuBar(panel));
        getContentPane().add(panel);
    }

    public void actionPerformed(ActionEvent e)
    { // called by the timer
        panel.tick();
    }
}