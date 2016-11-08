package HW6.fish;

import HW6.fish.movement.HorizontalMovement;
import HW6.fish.movement.MovementStyle;
import HW6.fish.movement.OscillatingMovement;
import HW6.fish.movement.UpDownMovement;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public abstract class Fish
{
    private static Random rand = new Random();
    protected static MovementStyle oscillatingMovement = new OscillatingMovement(3, 1);
    protected static MovementStyle upDownMovement = new UpDownMovement(3, 1);
    protected static MovementStyle horizontalMovement = new HorizontalMovement(3);

    private Point currentpos = new Point(rand.nextInt(200) + 1, rand.nextInt(200) + 1);
    private MovementStyle movementStyle;

    public Fish(MovementStyle movementStyle)
    {
        this.movementStyle = movementStyle;
    }

    public void move(Dimension tanksize)
    {
        ImageIcon image = getImage();
        int x = movementStyle.moveX(currentpos.x, image.getIconWidth(), tanksize.width);
        int y = movementStyle.moveY(currentpos.y, image.getIconHeight(), tanksize.height);
        currentpos = new Point(x, y);
    }

    public void display(JComponent c, Graphics g)
    {
        ImageIcon img = getImage();
        img.paintIcon(c, g, currentpos.x, currentpos.y);
    }

    private ImageIcon getImage()
    {
        if (movementStyle.movesRight())
            return rightImage();
        else
            return leftImage();
    }

    protected abstract ImageIcon rightImage();

    protected abstract ImageIcon leftImage();
}
