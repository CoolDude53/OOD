package HW9.fish.movement;

public class OscillatingMovement implements MovementStyle
{
    private int xspeed, yspeed;

    public OscillatingMovement(int x, int y)
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
        return 60;
    }

    public int yDirectionChangeFreq()
    {
        return 80;
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