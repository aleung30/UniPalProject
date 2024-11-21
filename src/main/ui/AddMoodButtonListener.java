package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.Mood;
import model.UniPalBoard;

// Represents the action taken when Add Mood Button is clicked
public class AddMoodButtonListener implements ActionListener {
    private static JFrame mainFrame;
    private static UniPalBoard uniPal;

    /*
     * EFFECTS: adds mood name, type, and date to the Mood Collection
     */
    public void actionPerformed(ActionEvent e) {
        mainFrame = MainMenu.getMainFrame();
        uniPal = MainMenu.getUniPal();
        String name = JOptionPane.showInputDialog("Enter the name of your mood");
        String type = JOptionPane.showInputDialog("Enter your mood type");
        String date = JOptionPane.showInputDialog("Enter the date of your mood");

        Mood mood = new Mood(name, type, date);
        uniPal.addMood(mood);
        JOptionPane.showMessageDialog(mainFrame, "You have successfully added the mood, "
                + mood.getName() + ", " + mood.getType() + ", " + mood.getDate() + " to your collection!");

    }

}
