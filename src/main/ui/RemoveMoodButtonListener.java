package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.Mood;
import model.UniPalBoard;

// Represents the action taken when Remove Mood Button is clicked
public class RemoveMoodButtonListener implements ActionListener {
    private static UniPalBoard uniPal;

    /*
     * EFFECTS: removes mood name, type, and date from the Accomplishment Collection
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        uniPal = MainMenu.getUniPal();
        String name = JOptionPane.showInputDialog("Enter the name of your mood");
        String type = JOptionPane.showInputDialog("Enter your mood type");
        String date = JOptionPane.showInputDialog("Enter the date of your mood");

        Mood removeMood = null;
        for (Mood mood : uniPal.getMoodCollection()) {
            if (mood.getName().equals(name) && mood.getType().equals(type) && mood.getDate().equals(date)) {
                removeMood = mood;
                break;
            }
        }

        if (removeMood != null) {
            uniPal.removeMood(removeMood);
            JOptionPane.showMessageDialog(null, "You have successfully removed the mood: " + removeMood.getName());
        } else {
            JOptionPane.showMessageDialog(null, "Mood was not found in the collection, please try again.");
        }
    }
}
