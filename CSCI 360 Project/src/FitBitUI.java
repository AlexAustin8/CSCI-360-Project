 //Note that this code is primarily a modification of the SwingApplication.java file
//Provided in the Java swing Exercise, and therefore is not wholly original material
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;

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


public class FitBitUI extends Thread implements ActionListener, KeyListener {
    private int activeFrame = 0;
    private static JFrame frame = new JFrame();
    private JButton changeDisplay = new JButton("Change Display");
    private FitBitDevice device = new FitBitDevice();
    final JLabel stepLabel = new JLabel("Number of Steps Taken: " + "0    ");
    final JLabel heartLabel = new JLabel("Current Heart Rate: " + "0    ");
    final JLabel timeLabel = new JLabel("Current Time: " + device.getTime());
    final JLabel dateLabel = new JLabel("Current Date: " + device.getDate());
    final JLabel goalLabel = new JLabel("Steps Until Goal Reached: " + device.getStepsUntilGoal());
    final JLabel historyLabel = new JLabel("# of Days Recorded: " + "0    ");
    final JLabel syncLabel = new JLabel("Last Sync Date");
    final static String LOOKANDFEEL = "System";
    
    public JPanel createComponents() {
    	//JButton takeStep = new JButton("Take Step");
    	//takeStep.addActionListener(this);
    	//JButton detectHeartbeat = new JButton("Detect Heartbeat");
    	//detectHeartbeat.addActionListener(this);
    	//JButton showTime = new JButton ("Show Current Time");
    	//showTime.addActionListener(this);
    	JButton newSync = new JButton("Sync Device");
    	newSync.addActionListener(this);
    	BorderLayout layout = new BorderLayout();
    	JPanel pane = new JPanel(layout);
    	pane.addKeyListener(this);
    	pane.setFocusable(true);
    	newSync.setFocusable(false);
    	//pane.add(takeStep);
    	//pane.add(detectHeartbeat);
    	pane.add(newSync);
    	pane.add(stepLabel, layout.PAGE_END);
    	pane.add(heartLabel, layout.LINE_START);
    	pane.add(timeLabel, layout.PAGE_START);
    	//pane.add(dateLabel, layout.CENTER);
    	pane.add(goalLabel, layout.LINE_END);
    	start();
    	return pane;
    	
    }
    

    
    //
    public void keyPressed(KeyEvent e) {
    	if (e.getKeyChar() == 's') {
    		device.addToSteps();
    		stepLabel.setText("Number of Steps Taken: " + device.getCurrentSteps());
    		goalLabel.setText("Steps Until Goal Reached: " + device.getStepsUntilGoal());
    	}
    }
    
    public void keyReleased(KeyEvent e) {
    }
    
    public void keyTyped(KeyEvent e) {
    }
    
    public void actionPerformed(ActionEvent e) {
    	if (e.getActionCommand() == "Take Step") {
    		device.addToSteps();
    		stepLabel.setText("Number of Steps Taken: " + device.getCurrentSteps());
    		goalLabel.setText("Steps Until Goal Reached: " + device.getStepsUntilGoal());
    	}
    	else if (e.getActionCommand() == "Detect Heartbeat") {
    		device.detectHeartbeat();
    		heartLabel.setText("Current Heart Rate: " + device.getCurrentHeartrate());
    	}
    	else if (e.getActionCommand() == "Show Current Time") {
    		timeLabel.setText("Current Time: " + device.getTime());
    	}
    	else if (e.getActionCommand() == "Sync Device") {
    		
    	}

    }
   
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Set the look and feel.
        try{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(Exception e){
        	e.printStackTrace();
        }
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        FitBitUI app = new FitBitUI();
        JPanel stepContents = app.createComponents();
        
        frame.getContentPane().add(stepContents, BorderLayout.CENTER);
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    public void run() {
    	try {
    	while (true) {
    		timeLabel.setText("Current Time: " + device.getTime());
    		Thread.sleep(1000);
    	}
    	}
    	catch (Exception e) {
    		System.out.println(e);
    	}
    }
    
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
    	createAndShowGUI();
    }
}



