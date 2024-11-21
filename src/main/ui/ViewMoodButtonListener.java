package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import model.Mood;
import model.UniPalBoard;

// Represents the action taken when View Mood Button is clicked
public class ViewMoodButtonListener implements ActionListener {
    private static JTable moodTable;
    private static UniPalBoard uniPal;
    private static JFrame frame1;
    private static JPanel searchPanel;
    private static JFrame mainFrame;
    private static JLabel searchLabel;
    private static JTextField searchField;

    /*
     * EFFECTS: creates a new JFrame to display user's moods
     * and shows them in a table
     */
    public void actionPerformed(ActionEvent e) {

        frame1 = new JFrame();
        searchPanel = new JPanel();
        mainFrame = MainMenu.getMainFrame();
        uniPal = MainMenu.getUniPal();
        searchLabel = MainMenu.getTextLabel();
        searchField = MainMenu.getSearchField();
        searchLabel.setBounds(300, 11, 46, 14);
        searchField.setBounds(600, 11, 46, 14);
        searchPanel.add(searchLabel);
        searchPanel.add(searchField);
        frame1.setTitle("Your Mood Collection");

        searchList();

        frame1.setVisible(true);
        mainFrame.repaint();
        mainFrame.revalidate();

    }

    /*
     * EFFECTS: creates a new JTable to display user's moods with 3 columns
     */
    public void searchList() {
        List<Mood> moodList = new ArrayList<>();
        moodList = uniPal.getMoodCollection();
        Object[][] data = new Object[moodList.size()][3];
        for (int i = 0; i < moodList.size(); i++) {
            Mood mood = moodList.get(i);
            data[i][0] = mood.getName();
            data[i][1] = mood.getType();
            data[i][2] = mood.getDate();
        }

        String[] columnNames = { "Mood Name", "Mood Type", "Mood Date" };
        moodTable = new JTable(data, columnNames);
        frame1.setSize(750, 500);

        JScrollPane scrollPane = new JScrollPane(moodTable);
        frame1.add(scrollPane, BorderLayout.CENTER);
        frame1.add(searchPanel, BorderLayout.NORTH);
        scrollPane.setPreferredSize(new Dimension(250, 100));
    }
}
