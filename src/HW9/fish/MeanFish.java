package HW9.fish;

import HW9.fish.movement.MovementStyle;

import javax.swing.*;

public class MeanFish extends Fish
{
    private ImageIcon leftimage, rightimage;

    public MeanFish(MovementStyle ms)
    {
        leftimage = new ImageIcon("./images/Lmeaniefish.gif");
        rightimage = new ImageIcon("./images/Rmeaniefish.gif");
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

