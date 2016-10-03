package HW4.client;

import HW4.ScoreService;

public class CollegeClient extends Client
{
    public CollegeClient(String college, ScoreService service)
    {
        super(service);

        this.setHomeTeam(college);
        this.setAwayTeam(college);
    }
}
