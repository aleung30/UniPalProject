package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.Accomplishment;
import model.Mood;
import model.UniPalBoard;

// Represents the action taken when Remove Accomplishment Button is clicked
public class RemoveAccomplishmentButtonListener implements ActionListener {
    private static UniPalBoard uniPal;

    /*
     * EFFECTS: removes accomplishment name and date from the Accomplishment
     * Collection
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        uniPal = MainMenu.getUniPal();
        String name = JOptionPane.showInputDialog("Enter the name of your accomplishment");

        String date = JOptionPane.showInputDialog("Enter the date of your accomplishment");

       
        Accomplishment removeAccomplishment = null;
        for (Accomplishment accomplishment : uniPal.getAccomplishmentCollection()) {
            if (accomplishment.getName().equals(name) && accomplishment.getDate().equals(date)) {
                removeAccomplishment = accomplishment;
                break;
            }
        }

        if (removeAccomplishment != null) {
            uniPal.removeAccomplishment(removeAccomplishment);
            JOptionPane.showMessageDialog(null, "You have successfully removed the accomplishment: " + removeAccomplishment.getName());
        } else {
            JOptionPane.showMessageDialog(null, "Accomplishment was not found in the collection, please try again.");
        }
    }
}
        

    


