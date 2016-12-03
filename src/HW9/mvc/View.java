package HW9.mvc;

import HW9.fish.Fish;

import java.awt.*;
import java.util.Collection;

public interface View
{
    public void paintComponent(Graphics g);

    public void addFish(Fish fish);

    public void update(Collection<Fish> fishes);

    public void addObserver(FTViewObserver observer);
}
