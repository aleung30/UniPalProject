package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import model.Accomplishment;
import model.Mood;
import model.UniPalBoard;

public class MainMenu implements ActionListener {

    protected UniPalBoard uniPal;
    private JList<Mood> moodJList;
    private ArrayList<Mood> moods;

    public MainMenu() {
        JTable moodTable;
        uniPal = new UniPalBoard("Anita");

        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new GridLayout(2, 2, 3, 3));

        JButton addAccomplishmentButton = new JButton("Add an Accomplishment!");
        JButton addMoodButton = new JButton("Add a Mood!");
        JButton viewMoodButton = new JButton("View your Mood Collection!");
        JButton viewAccomplishmentButton = new JButton("View your Accomplishment Collection!");

        frame.add(addAccomplishmentButton);
        frame.add(addMoodButton);
        frame.add(viewAccomplishmentButton);
        frame.add(viewMoodButton);

        viewMoodButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JFrame frame1 = new JFrame();
                frame1.setTitle("Your Mood Collection");

    
                List<Mood> moodList = uniPal.getMoodCollection();
                moodList = new ArrayList<>();
                // convert list (1d) to java array (1d) -> 2d array (curly brace)
                Object[][] data = new Object[moodList.size()][3];
                for (int i = 0; i < moodList.size(); i++) {
                    Mood mood = moodList.get(i);
                    data[i][0] = mood.getName();
                    data[i][1] = mood.getType();
                    data[i][2] = mood.getDate();

                }

                String[] columnNames = { "Mood Name", "Mood Type", "Mood Date" };
                JTable moodTable = new JTable(data, columnNames);
                frame1.setSize(400, 600);

                JScrollPane scrollPane = new JScrollPane(moodTable);
                frame1.add(scrollPane);
                scrollPane.setPreferredSize(new Dimension(250,

                        100));

                frame1.setVisible(true);
                frame.repaint();
                frame.revalidate();

            }

        });

        addMoodButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog("Enter the name of your mood");
                String type = JOptionPane.showInputDialog("Enter your mood type");
                String date = JOptionPane.showInputDialog("Enter the date of your mood");

                Mood mood = new Mood(name, type, date);
                uniPal.addMood(mood);
                JOptionPane.showMessageDialog(frame, "You have successfully added the mood, "
                        + mood + " to your collection!");
            }

        });

        addAccomplishmentButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog("Enter the name of your accomplishment");

                String date = JOptionPane.showInputDialog("Enter the date of your accomplishment");

                if (name != null && date != null) {
                    Accomplishment accomplishment = new Accomplishment(name, date);
                    UniPalBoard.addAccomplishment(accomplishment);

                    JOptionPane.showMessageDialog(null, "You have successfully added the accomplishment, "
                            + accomplishment + " to your collection!");
                }
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new MainMenu();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}