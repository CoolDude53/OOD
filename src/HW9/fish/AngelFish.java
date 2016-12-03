package HW9.fish;

import HW9.fish.movement.MovementStyle;

import javax.swing.*;

public class AngelFish extends Fish
{
    private ImageIcon leftimage, rightimage;

    public AngelFish(MovementStyle ms)
    {
        leftimage = new ImageIcon("./images/Langelfish.gif");
        rightimage = new ImageIcon("./images/Rangelfish.gif");
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
