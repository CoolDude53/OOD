package HW9.fish.movement;

public class UpDownMovement implements MovementStyle
{
    private int xspeed, yspeed;

    public UpDownMovement(int x, int y)
    {
        xspeed = x;
        yspeed = y;
    }

    public int xspeed()
    {
        return xspeed;
    }

    public int yspeed()
    {
        return yspeed;
    }

    public int xDirectionChangeFreq()
    {
        return 1;
    }

    public int yDirectionChangeFreq()
    {
        return 0;
    }

    public void changeXdirection()
    {
        xspeed = -xspeed;
    }

    public void changeYdirection()
    {
        yspeed = -yspeed;
    }
}