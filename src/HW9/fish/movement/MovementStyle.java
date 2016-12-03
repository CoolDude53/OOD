package HW9.fish.movement;

public interface MovementStyle
{
    public int xspeed();

    public int yspeed();

    public void changeXdirection();

    public void changeYdirection();

    public int xDirectionChangeFreq(); // in tenths of a percent

    public int yDirectionChangeFreq(); // in tenths of a percent
}
