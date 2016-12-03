package HW9.fish;

import HW9.fish.movement.MovementStyle;

import javax.swing.*;

public class Octopus extends Fish
{
    private ImageIcon leftimage, rightimage;

    public Octopus(MovementStyle ms)
    {
        leftimage = new ImageIcon("./images/Loctopus.gif");
        rightimage = new ImageIcon("./images/Roctopus.gif");
        setMovementStyle(ms);
    }

    public ImageIcon leftImage()
    {
        return leftimage;
    }

    public ImageIcon rightImage()
    {
        return rightimage;
    }
}
