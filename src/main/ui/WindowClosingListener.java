package ui;

import javax.swing.JFrame;

import model.Event;
import model.EventLog;

// Represents the action taken when window is closed
public class WindowClosingListener {

    public void addWindowListener(JFrame frame) {

        // EFFECTS: prints all events from the EventLog to the console
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                EventLog eventLog = EventLog.getInstance();

                System.out.println("Logged Events");
                for (Event event : eventLog) {
                    System.out.println(event.getDescription());
                }
                eventLog.clear(); // Clear the log after printing if desired
            }
        });
    }
}
