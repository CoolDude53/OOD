package HW5;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class BorderTest
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Borders");
        frame.getContentPane().setLayout(new GridLayout(2, 5));
        frame.setPreferredSize(new Dimension(1400, 150));
        frame.setMaximumSize(new Dimension(1400, 150));
        frame.setMinimumSize(new Dimension(1400, 150));

        for (int count = 0; count < 7; count++)
        {
            JPanel panel = new JPanel(new GridLayout(count < 5 ? 1 : 4, 1)); // add elements to this
            JScrollPane scrollPane = new JScrollPane(panel);

            panel.setSize(200, 300);
            scrollPane.setSize(200, 300);

            if (count < 5)
                addText(panel, "Hello!");
            else
                addText(panel, "Hello!", "a", "ab", "abc");

            switch (count)
            {
                case 0:
                    panel.setBorder(new CompoundBorder(new LineBorder(Color.RED, 5), new LineBorder(Color.GREEN, 5)));
                    frame.add(panel);
                    break;
                case 1:
                    panel.setBorder(new CompoundBorder(new CompoundBorder(new LineBorder(Color.RED, 5), new LineBorder(Color.GREEN, 5)), new LineBorder(Color.BLUE, 5)));
                    frame.add(panel);
                    break;
                case 2:
                    panel.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(Color.GREEN, 5), "A Green Border"), new LineBorder(Color.RED, 5)));
                    frame.add(panel);
                    break;
                case 3:
                    panel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(Color.RED, 5), new LineBorder(Color.GREEN, 5)), "A Red-Green Border"));
                    frame.add(panel);
                    break;
                case 4:
                    panel.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(Color.GREEN, 5), "A Green Border"), new TitledBorder(new LineBorder(Color.RED, 5), "A Red Border")));
                    frame.add(panel);
                    break;
                case 5:
                    scrollPane.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(Color.RED, 5), new LineBorder(Color.GREEN, 5)), "A bordered scrollpane"));
                    frame.add(scrollPane);
                    break;
                case 6:
                    scrollPane.setBorder(new TitledBorder(new LineBorder(Color.RED, 5), "A Red Border"));
                    panel.setBorder(new LineBorder(Color.BLUE, 5));
                    frame.add(scrollPane);
                    break;
            }
        }

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private static void addText(JComponent panel, String... labels)
    {
        for (String label : labels)
            panel.add(new JLabel(label));
    }
}
