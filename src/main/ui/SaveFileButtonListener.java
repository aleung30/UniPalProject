package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

import model.UniPalBoard;
import persistence.JsonWriter;

// Represents the action taken when Save File Button is clicked
public class SaveFileButtonListener implements ActionListener {
    private JsonWriter jsonWriter;
    private static UniPalBoard uniPal;
    private static final String JSON_STORE = "./data/unipalboard.json";

    /*
     * EFFECTS: saves current application to JSON file
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        uniPal = MainMenu.getUniPal();
        jsonWriter = new JsonWriter(JSON_STORE);
        saveUniPalBoard();
    }

    /*
     * Referenced from the JsonSerialization Demo
     * https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
     * EFFECTS: saves UniPalBoard to file
     */
    public void saveUniPalBoard() {
        try {
            jsonWriter.open();
            jsonWriter.write(uniPal);
            jsonWriter.close();
            JOptionPane.showMessageDialog(null, "Saved " + uniPal.getName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Unable to write to file: " + JSON_STORE);
        }
    }

}
