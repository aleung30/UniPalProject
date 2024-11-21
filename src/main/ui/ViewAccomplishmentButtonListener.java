package ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Accomplishment;

// Represents the action taken when View Accomplishment Button is clicked
public class ViewAccomplishmentButtonListener implements ActionListener {
    private JFrame accomplishmentFrame;

    /*
     * EFFECTS: creates a new JFrame to display user's accomplishments
     * and shows them in a table
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        accomplishmentFrame = new JFrame();
        accomplishmentFrame.setTitle("Your Accomplishment Collection");
        List<Accomplishment> accomplishmentList = new ArrayList<>();
        accomplishmentList = MainMenu.getUniPal().getAccomplishmentCollection();
        Object[][] data = new Object[accomplishmentList.size()][3];
        for (int i = 0; i < accomplishmentList.size(); i++) {
            Accomplishment accomplishment = accomplishmentList.get(i);
            data[i][0] = accomplishment.getName();
            data[i][1] = accomplishment.getDate();
        }
        String[] columnNames = { "Accomplishment Name", "Accomplishment Date", };
        JTable moodTable = new JTable(data, columnNames);
        accomplishmentFrame.setSize(400, 600);

        JScrollPane scrollPane = new JScrollPane(moodTable);
        accomplishmentFrame.add(scrollPane);
        scrollPane.setPreferredSize(new Dimension(250, 100));

        accomplishmentFrame.setVisible(true);
        MainMenu.getMainFrame().repaint();
        MainMenu.getMainFrame().revalidate();

    }
}
