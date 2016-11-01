package HW6;

import HW6.fish.Fish;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;

@SuppressWarnings("serial")
public class FishPanel extends JPanel
{
    private Collection<Fish> fishies = new ArrayList<>();
    private boolean suspended = false;

    public FishPanel()
    {
        setBackground(Color.blue);
    }

    public void tick()
    {
        if (!suspended)
        {
            Dimension tanksize = getSize();
            for (Fish f : fishies)
                f.move(tanksize);
            repaint();
        }
    }

    public void toggleSuspend()
    {
        suspended = !suspended;
    }

    public void addFish(Fish f)
    {
        fishies.add(f);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for (Fish f : fishies)
            f.display(this, g);
    }
}