package HW9.mvc;

import HW9.fish.Fish;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;

public class FishtankView extends JPanel implements View
{
    private Collection<Fish> fishes = new ArrayList<>();
    private ArrayList<FTViewObserver> observers = new ArrayList<>();

    public FishtankView()
    {
        setBackground(Color.blue);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for (Fish f : fishes)
            f.display(this, g);
    }

    public void addFish(Fish fish)
    {
        ;
    }

    public void update(Collection<Fish> fishes)
    {
        this.fishes = fishes;
        repaint();
    }

    public void addObserver(FTViewObserver observer)
    {
        observers.add(observer);
    }
}
