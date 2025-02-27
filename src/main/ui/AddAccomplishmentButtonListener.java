package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Accomplishment;
import model.UniPalBoard;

// Represents the action taken when Add Accomplishment Button is clicked
public class AddAccomplishmentButtonListener implements ActionListener {
    private static UniPalBoard uniPal;

    /*
     * EFFECTS: adds accomplishment name and date to the Accomplishment Collection
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        uniPal = MainMenu.getUniPal();
        String name = JOptionPane.showInputDialog("Enter the name of your accomplishment");

        String date = JOptionPane.showInputDialog("Enter the date of your accomplishment");

        if (!name.isEmpty() && !date.isEmpty()) {
            Accomplishment accomplishment = new Accomplishment(name, date);
            uniPal.addAccomplishment(accomplishment);

            JOptionPane.showMessageDialog(null, "You have successfully added the accomplishment, "
                    + accomplishment.getName() + ", " + accomplishment.getDate() + " to your collection!");
        } else {
            JOptionPane.showMessageDialog(null,
                    "That is invalid, please fill in the name, type, and date to add your mood");
        }

    }

}
