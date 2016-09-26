package HW3;

import javax.swing.*;
import java.util.Scanner;

public class HW3Simulation
{
    private static final int SIMULATION_TIME = 50000;  // A simulation is for 50,000 seconds.

    public static void main(String[] args)
    {
        String cinput = JOptionPane.showInputDialog("Enter number of normal and fast cashiers, separated by a space.");
        Scanner cscan = new Scanner(cinput);
        int normal = cscan.nextInt();
        int fast = cscan.nextInt();
        cscan.close();

        String dinput = JOptionPane.showInputDialog("Enter item distribution type (either u or b) and size, separated by a space.");
        Scanner dscan = new Scanner(dinput);
        String distType = dscan.next();
        int distSize = dscan.nextInt();
        dscan.close();

        DiningHall hall = new DiningHall(normal, fast, distType, distSize);

        String sortType = JOptionPane.showInputDialog("Enter output sort field (either x, s, or w).");

        for (int t = 0; t < SIMULATION_TIME; t++)
            hall.elapseOneSecond(t);

        hall.printStatistics(sortType);
    }
}
