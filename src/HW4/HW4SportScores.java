package HW4;

import HW4.client.Client;
import HW4.client.CollegeClient;
import HW4.client.SportClient;

public class HW4SportScores
{
    public static void main(String[] args)
    {
        ScoreInput input = new ScoreInput();

        ScoreService svc = new ScoreService(input);

        Client d1 = new CollegeClient("BC", svc);
        Client d2 = new SportClient("Chess", svc);
    }
}