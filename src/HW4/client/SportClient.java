package HW4.client;

import HW4.ScoreService;

public class SportClient extends Client
{
    public SportClient(String sport, ScoreService service)
    {
        super(service);

        this.setSport(sport);
    }
}
