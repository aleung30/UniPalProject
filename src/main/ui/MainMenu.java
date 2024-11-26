package ui;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;

import model.UniPalBoard;

// Represents main menu panel
public class MainMenu {

    protected static UniPalBoard uniPal;
    protected static JFrame mainFrame;
    private ViewAccomplishmentButtonListener viewAccomplishmentListener = new ViewAccomplishmentButtonListener();
    private ViewMoodButtonListener viewMoodListener = new ViewMoodButtonListener();
    private AddMoodButtonListener addMoodListener = new AddMoodButtonListener();
    private AddAccomplishmentButtonListener addAccomplishmentListener = new AddAccomplishmentButtonListener();
    private LoadFileButtonListener loadFileListener = new LoadFileButtonListener();
    private SaveFileButtonListener saveFileListener = new SaveFileButtonListener();
    private RemoveAccomplishmentButtonListener removeAccomplishmentListener = new RemoveAccomplishmentButtonListener();
    private RemoveMoodButtonListener removeMoodListener = new RemoveMoodButtonListener();
    private static JTextField searchField = new JTextField(30);
    private static JLabel searchLabel = new JLabel("Search");
    protected static JFrame frame;

    public MainMenu() {
        uniPal = new UniPalBoard("Anita");
        frame = new JFrame("UniPal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);

        JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 5));
        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new BorderLayout());

        containerPanel.add(createFilePanel(), BorderLayout.SOUTH);

        JPanel newPanel = new JPanel();
        newPanel.setPreferredSize(new Dimension(500, 70));
        newPanel.setBackground(new Color(173, 216, 230));
        containerPanel.add(createBottomImagePanel(), BorderLayout.NORTH);

        mainPanel.setPreferredSize(new Dimension(400, 100));
        mainPanel.setBackground(new Color(173, 216, 230));
        mainPanel.add(createImagePanel(), BorderLayout.WEST);
        mainPanel.add(createButtonPanel(), BorderLayout.EAST);
        mainPanel.add(containerPanel, BorderLayout.SOUTH);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    /*
     * EFFECTS: constructs a new panel for top image
     */
    private JPanel createImagePanel() {
        JPanel imagePanel = new JPanel();
        ImageIcon originalIcon = new ImageIcon("./data/IMG_7F906D768CB2-1.jpeg");
        Image scaledImage = originalIcon.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
        imagePanel.add(imageLabel);
        return imagePanel;
    }

    /*
     * EFFECTS: constructs a new panel for bottom image
     */
    private JPanel createBottomImagePanel() {
        JPanel bottomImagePanel = new JPanel();
        ImageIcon originalIcon = new ImageIcon("./data/IMG_B4E87115093C-1.jpeg");
        Image scaledImage = originalIcon.getImage().getScaledInstance(400, 200, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
        bottomImagePanel.add(imageLabel);
        return bottomImagePanel;
    }

    /*
     * EFFECTS: constructs a new panel for buttoons
     */
    private JPanel createButtonPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(300, 300));
        JButton addAccomplishmentButton = createButton("Add an Accomplishment!", addAccomplishmentListener,
                new Dimension(200, 50));
        JButton addMoodButton = createButton("Add a mood!", addMoodListener, new Dimension(200, 50));
        JButton viewMoodButton = createButton("View your Mood Collection!", viewMoodListener, new Dimension(300, 40));
        JButton viewAccomplishmentButton = createButton("View your Accomplishment Collection!",
                viewAccomplishmentListener, new Dimension(300, 40));
        JButton removeMoodButton = createButton("Remove a mood!", removeMoodListener, new Dimension(200, 50));
        JButton removeAccomplishmentButton = createButton("Remove an accomplishment!", removeAccomplishmentListener,
                new Dimension(200, 50));
        panel.add(addAccomplishmentButton);
        panel.add(addMoodButton);
        panel.add(Box.createVerticalStrut(30));
        panel.add(viewMoodButton);
        panel.add(Box.createVerticalStrut(2));
        panel.add(viewAccomplishmentButton);
        panel.add(Box.createVerticalStrut(30));
        panel.add(removeMoodButton);
        panel.add(Box.createVerticalStrut(2));
        panel.add(removeAccomplishmentButton);
        return panel;
    }

    /*
     * EFFECTS: constructs a new panel for saving and loading file
     */
    private JPanel createFilePanel() {
        JPanel panel = new JPanel(new FlowLayout());

        JButton saveFileButton = createButton("Save your UniPal!", saveFileListener, new Dimension(200, 50));
        JButton loadFileButton = createButton("Load your UniPal!", loadFileListener, new Dimension(200, 50));

        panel.add(saveFileButton);
        panel.add(loadFileButton);

        return panel;
    }

    /*
     * EFFECTS: constructs a button with given text, listener, and size
     */
    private JButton createButton(String text, ActionListener listener, Dimension size) {
        JButton button = new JButton(text);
        button.addActionListener(listener);
        button.setPreferredSize(size);
        return button;
    }

    public static void main(String[] args) {
        new SplashScreen();
        new MainMenu();
        new WindowClosingListener().addWindowListener(frame);
    }

    public static JFrame getMainFrame() {
        return mainFrame;
    }

    public static UniPalBoard getUniPal() {
        return uniPal;
    }

    public static JTextField getSearchField() {
        return searchField;
    }

    public static JLabel getTextLabel() {
        return searchLabel;
    }

    public static void setUniPal(UniPalBoard updatedUniPal) {
        uniPal = updatedUniPal;
    }
}
