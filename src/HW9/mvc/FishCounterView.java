package HW9.mvc;

import HW9.fish.Fish;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

public class FishCounterView extends JPanel implements ActionListener, View
{
    private Collection<Fish> fishes = new ArrayList<>();
    private FTViewObserver observer;
    private JLabel label1;
    private int fish = 0;

    public FishCounterView()
    {
        JFrame frame = new JFrame();
        frame.setTitle("Fish Counter");
        frame.setSize(600, 200);
        frame.setLocation(20, 20);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.getContentPane().setLayout(new GridLayout(1, 3));
        JLabel label = new JLabel("This aquarium has");
        label1 = new JLabel("" + fish);
        label1.setForeground(Color.RED);
        JLabel label2 = new JLabel("fish");

        frame.add(label);
        frame.add(label1);
        frame.add(label2);

        frame.setVisible(true);

        Timer t = new Timer(100, this);
        t.start();  //do the animation forever

    }

    public void actionPerformed(ActionEvent e)
    {
        label1.setVisible(!label1.isVisible());
    }

    @Override
    public void paintComponent(Graphics g)
    {
        ;
    }

    @Override
    public void addFish(Fish fish)
    {
        ;
    }

    @Override
    public void update(Collection<Fish> fishes)
    {
        fish = fishes.size();
        label1.setText("" + fish);
    }

    @Override
    public void addObserver(FTViewObserver observer)
    {
        ;
    }
}
