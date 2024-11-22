package ui;

import java.awt.*;
import javax.swing.*;

// Represents a splash screen with an image
public class SplashScreen {

    public SplashScreen() {

        JWindow splashScreen = createSplashScreen();

        JLabel text = new JLabel("Loading your UniPal, please wait...", JLabel.CENTER);
        text.setFont(new Font("Monospace", Font.BOLD, 20));
        splashScreen.add(text, BorderLayout.SOUTH);

        splashScreen.setVisible(true);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        splashScreen.setVisible(false);
        splashScreen.dispose();

    }

    /*
     * EFFECTS: constructs a JWindow and JPanel to add loading image and text
     */
    private JWindow createSplashScreen() {
        JWindow splashScreen = new JWindow();
        JPanel splashPanel = new JPanel(new BorderLayout());
        splashPanel.setBackground(Color.WHITE);

        ImageIcon icon = new ImageIcon(new ImageIcon("./data/IMG_F70EF8FA8FF1-1.jpeg").getImage().getScaledInstance(400,
                300, Image.SCALE_SMOOTH));

        splashPanel.add(new JLabel(icon), BorderLayout.CENTER);

        splashScreen.getContentPane().add(splashPanel);
        splashScreen.setSize(400, 300);
        splashScreen.setLocationRelativeTo(null);

        return splashScreen;
    }

}
