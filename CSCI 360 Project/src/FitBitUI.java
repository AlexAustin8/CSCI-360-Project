 //Note that this code is primarily a modification of the SwingApplication.java file
//Provided in the Java swing Exercise, and therefore is not wholly original material
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class FitBitUI implements ActionListener{
	private static String stepLabelPrefix = "Number of Steps Taken: ";
	private static String heartLabelPrefix = "Current Heart Rate: ";
    private int numSteps = 0;
    private String activeFrame = "none";
    private static JFrame frame = new JFrame();
    private JButton changeDisplay = new JButton("Change Display");
    private FitBitDevice f = new FitBitDevice();
    final JLabel stepLabel = new JLabel(stepLabelPrefix + "0    ");
    final JLabel heartLabel = new JLabel(heartLabelPrefix + "0    ");
    
    //Specify the look and feel to use.  Valid values:
    //null (use the default), "Metal", "System", "Motif", "GTK+"
    final static String LOOKANDFEEL = "System";
    
    public Component createStepViewComponents() {
    	activeFrame = "step";
        JButton takeStep = new JButton("Take Step");
        takeStep.setMnemonic(KeyEvent.VK_I);
        takeStep.addActionListener(this);
        changeDisplay.addActionListener(this);
        stepLabel.setLabelFor(takeStep);
        
        /*
         * An easy way to put space between a top-level container
         * and its contents is to put the contents in a JPanel
         * that has an "empty" border.
         */
        JPanel pane = new JPanel(new GridLayout(0, 1));
        pane.add(takeStep);
        pane.add(changeDisplay);
        pane.add(stepLabel);
        pane.setBorder(BorderFactory.createEmptyBorder(
                30, //top
                30, //left
                10, //bottom
                30) //right
                );
        
        return pane;
    }
    
    public JPanel createHeartbeatViewComponents() {
    	activeFrame = "heart";
        JButton detectHeartbeat = new JButton("Detect Heartbeat");
        JButton changeDisplay = new JButton("Change Display");
        detectHeartbeat.setMnemonic(KeyEvent.VK_I);
        detectHeartbeat.addActionListener(this);
        heartLabel.setLabelFor(detectHeartbeat);
        
        /*
         * An easy way to put space between a top-level container
         * and its contents is to put the contents in a JPanel
         * that has an "empty" border.
         */
        JPanel pane = new JPanel(new GridLayout(0, 1));
        pane.add(detectHeartbeat);
        pane.add(heartLabel);
        pane.setBorder(BorderFactory.createEmptyBorder(
                30, //top
                30, //left
                10, //bottom
                30) //right
                );
        
        return pane;
    }
    
    public void actionPerformed(ActionEvent e) {
    	if(activeFrame.compareTo("heart") == 0){
    		f.detectHeartbeat();
    		heartLabel.setText("Current Heart Rate: " + f.getCurrentHeartrate());
    	}else if(activeFrame.compareTo("step") == 0){
    		if(e.getSource() == changeDisplay){
    			//Component contents = this.createStepViewComponents();
    			JPanel contents = this.createHeartbeatViewComponents();
    			frame.setContentPane(contents);
    			//frame.getContentPane().add(contents, BorderLayout.CENTER);
    			//Display the window.
    			frame.invalidate();
    			frame.validate();
    			//frame.pack();
    			//frame.setVisible(true);
    		}else{
    		f.addToSteps();
    		stepLabel.setText("Current Step Count: " + f.getCurrentSteps());
    		}
    	}
    }
    
    private static void initLookAndFeel() {
        
        // Swing allows you to specify which look and feel your program uses--Java,
        // GTK+, Windows, and so on as shown below.
        String lookAndFeel = null;
        
        if (LOOKANDFEEL != null) {
            if (LOOKANDFEEL.equals("Metal")) {
                lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
            } else if (LOOKANDFEEL.equals("System")) {
                lookAndFeel = UIManager.getSystemLookAndFeelClassName();
            } else if (LOOKANDFEEL.equals("Motif")) {
                lookAndFeel = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
            } else if (LOOKANDFEEL.equals("GTK+")) { //new in 1.4.2
                lookAndFeel = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
            } else {
                System.err.println("Unexpected value of LOOKANDFEEL specified: "
                        + LOOKANDFEEL);
                lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
            }
            
            try {
                UIManager.setLookAndFeel(lookAndFeel);
            } catch (ClassNotFoundException e) {
                System.err.println("Couldn't find class for specified look and feel:"
                        + lookAndFeel);
                System.err.println("Did you include the L&F library in the class path?");
                System.err.println("Using the default look and feel.");
            } catch (UnsupportedLookAndFeelException e) {
                System.err.println("Can't use the specified look and feel ("
                        + lookAndFeel
                        + ") on this platform.");
                System.err.println("Using the default look and feel.");
            } catch (Exception e) {
                System.err.println("Couldn't get specified look and feel ("
                        + lookAndFeel
                        + "), for some reason.");
                System.err.println("Using the default look and feel.");
                e.printStackTrace();
            }
        }
    }
    
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Set the look and feel.
        initLookAndFeel();
        
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);
        
        //Create and set up the window.
        //JFrame stepframe= new JFrame("FitBitUI");
        //JFrame heartframe= new JFrame("FitBitUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        FitBitUI app = new FitBitUI();
        Component stepContents = app.createStepViewComponents();
        
        frame.getContentPane().add(stepContents, BorderLayout.CENTER);
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}



