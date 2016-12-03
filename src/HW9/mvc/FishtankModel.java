package HW9.mvc;

import HW9.fish.Fish;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FishtankModel implements ActionListener
{
    private ArrayList<Fish> fishes = new ArrayList<>();
    private Dimension dimension;
    private ArrayList<FTModelObserver> observers = new ArrayList<>();
    private boolean suspended = false;

    private void tick()
    {
        if (!suspended)
        {
            for (Fish f : fishes)
                f.move(dimension);

            for (FTModelObserver observer : observers)
                observer.update(fishes);
        }
    }

    public void addFish(Fish fish)
    {
        fishes.add(fish);

    }

    public void setSize(Dimension d)
    {
        dimension = d;
    }

    public void actionPerformed(ActionEvent e)
    { // called by the timer
        tick();
    }

    public ArrayList<Fish> getFishes()
    {
        return fishes;
    }

    public void addObserver(FTModelObserver observer)
    {
        observers.add(observer);
    }

    public boolean isSuspended()
    {
        return suspended;
    }

    public void setSuspended(boolean suspended)
    {
        this.suspended = suspended;
    }
}
