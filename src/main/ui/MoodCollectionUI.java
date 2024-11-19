package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Mood;

public class MoodCollectionUI extends JFrame {

    private JList<Mood> moodJList;
    
    

    public MoodCollectionUI() {
        JButton viewMoodButton = new JButton("View your Mood Collection!");

        this.add(viewMoodButton);

        viewMoodButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                StringBuilder moodCollection = new StringBuilder("Your Mood Collection");

                moodJList = new JList<>();
                JScrollPane scrollPane = new JScrollPane(moodJList);
                scrollPane.setPreferredSize(new Dimension(250,

                        100));

                
                add(scrollPane);

                JOptionPane.showMessageDialog(moodJList, scrollPane);

                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                pack();
                setLocationRelativeTo(null);
                setVisible(true);
            }

        });
    }
}
