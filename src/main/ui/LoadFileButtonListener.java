package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import model.UniPalBoard;
import persistence.JsonReader;

public class LoadFileButtonListener implements ActionListener {
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/unipalboard.json";
    private UniPalBoard uniPal;

    /*
     * EFFECTS: loads previous application from JSON file
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        uniPal = MainMenu.getUniPal();
        jsonReader = new JsonReader(JSON_STORE);
        loadUniPalBoard();

    }
   
    // Referenced from the JsonSerialization Demo
    // https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    // MODIFIES: this
    // EFFECTS: loads UniPalBoard from file
    private void loadUniPalBoard() {
        try {
            uniPal = jsonReader.read();
            MainMenu.setUniPal(uniPal);
            JOptionPane.showMessageDialog(null, "Loaded " + uniPal.getName() + " from " + JSON_STORE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Unable to read from file: " + JSON_STORE);
        }
    }

}
