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
    private int activeFrame = 0;
    private static JFrame frame = new JFrame();
    private JButton changeDisplay = new JButton("Change Display");
    private FitBitDevice f = new FitBitDevice();
    final JLabel stepLabel = new JLabel("Number of Steps Taken: " + "0    ");
    final JLabel heartLabel = new JLabel("Current Heart Rate: " + "0    ");
    final JLabel timeLabel = new JLabel("Current Time: " + f.getTime());
    final JLabel dateLabel = new JLabel("Current Date: " + f.getDate());
    final JLabel goalLabel = new JLabel("Steps Until Goal Reached: " + "0    ");
    final JLabel historyLabel = new JLabel("# of Days Recorded: " + "0    ");
    final JLabel syncLabel = new JLabel("Last Sync Date");
    final static String LOOKANDFEEL = "System";
    
    
    public JPanel createStepViewComponents() {
    	activeFrame = 1;
        JButton takeStep = new JButton("Take Step");
        takeStep.setMnemonic(KeyEvent.VK_I);
        takeStep.addActionListener(this);
        stepLabel.setLabelFor(takeStep);
        JPanel pane = new JPanel(new GridLayout(0, 2));
        pane.add(takeStep);
        pane.add(changeDisplay);
        pane.add(stepLabel);
        pane.setBorder(BorderFactory.createEmptyBorder(
                30, //top
                100, //left
                10, //bottom
                100) //right
                );
        
        return pane;
    }
    
    public JPanel createHeartbeatViewComponents() {
    	activeFrame = 2;
        JButton detectHeartbeat = new JButton("Detect Heartbeat");
        detectHeartbeat.setMnemonic(KeyEvent.VK_I);
        detectHeartbeat.addActionListener(this);
        heartLabel.setLabelFor(detectHeartbeat);
        
        JPanel pane = new JPanel(new GridLayout(0, 2));
        pane.add(detectHeartbeat);
        pane.add(changeDisplay);
        pane.add(heartLabel);
        pane.setBorder(BorderFactory.createEmptyBorder(
                30, //top
                100, //left
                10, //bottom
                100) //right
                );
        
        return pane;
    }
    
    public JPanel createTimeViewComponents() {
    	activeFrame = 3;
        JPanel pane = new JPanel(new GridLayout(0, 1));
        pane.add(changeDisplay);
        pane.add(timeLabel);
        int i = 0;
        pane.setBorder(BorderFactory.createEmptyBorder(
                30, //top
                100, //left
                10, //bottom
                100) //right
                );
        
        return pane;
    }
    
    public JPanel createDateViewComponents() {
    	activeFrame = 4;
        JPanel pane = new JPanel(new GridLayout(0, 1));
        pane.add(changeDisplay);
        pane.add(dateLabel);
        pane.setBorder(BorderFactory.createEmptyBorder(
                30, //top
                100, //left
                10, //bottom
                100) //right
                );
        
        return pane;
    }
    
    public JPanel createGoalViewComponents() {
    	activeFrame = 5;
        JPanel pane = new JPanel(new GridLayout(0, 1));
        pane.add(changeDisplay);
        goalLabel.setText("Steps until goal reached: " + f.getStepsUntilGoal());
        pane.add(goalLabel);
        pane.setBorder(BorderFactory.createEmptyBorder(
                30, //top
                100, //left
                10, //bottom
                100) //right
                );
        
        return pane;
    }
    
    public JPanel createHistoryViewComponents() {
    	activeFrame = 6;
        JPanel pane = new JPanel(new GridLayout(0, 1));
        pane.add(changeDisplay);
        historyLabel.setText("# of Days Recorded: " + f.getHistory().size() + " Last Date: " + f.getLastDayDate());
        pane.add(historyLabel);
        pane.setBorder(BorderFactory.createEmptyBorder(
                30, //top
                100, //left
                10, //bottom
                100) //right
                );
        
        return pane;
    }
    public JPanel createSyncViewComponents() {
    	activeFrame = 7;
        JButton sync = new JButton("Sync Device");
        sync.setMnemonic(KeyEvent.VK_I);
        sync.addActionListener(this);
        syncLabel.setText("Last Sync Date: " + f.getLastSyncDate());
        historyLabel.setText("# of Days Recorded: " + f.getHistory().size() + " Last Date: " + f.getLastDayDate());
        syncLabel.setLabelFor(sync);
        
        JPanel pane = new JPanel(new GridLayout(0, 2));
        pane.add(sync);
        pane.add(changeDisplay);
        pane.add(historyLabel);
        pane.add(syncLabel, BorderLayout.SOUTH);
        pane.setBorder(BorderFactory.createEmptyBorder(
                30, //top
                100, //left
                10, //bottom
                100) //right
                );
        
        return pane;
    }
    
    public void actionPerformed(ActionEvent e) {
     	if(activeFrame == 1){
    		if(e.getSource() == changeDisplay){
    			JPanel contents = this.createHeartbeatViewComponents();
    			frame.setContentPane(contents);
    			frame.invalidate();
    			frame.validate();
    	    }else{
    	    	f.addToSteps();
        		stepLabel.setText("Current Step Count: " + f.getCurrentSteps());
    		     
    		}
    	}else if(activeFrame == 2){
    		if(e.getSource() == changeDisplay){
    			JPanel contents = this.createTimeViewComponents();
    			frame.setContentPane(contents);
    			frame.invalidate();
    			frame.validate();
    		}else{
    		    f.detectHeartbeat();
   		        heartLabel.setText("Current Heart Rate: " + f.getCurrentHeartrate());
    		
    		}
    	}else if(activeFrame == 3){
    		if(e.getSource() == changeDisplay){
    			JPanel contents = this.createDateViewComponents();
    			frame.setContentPane(contents);
    			frame.invalidate();
    			frame.validate();
    		}
    	}else if(activeFrame == 4){
        	if(e.getSource() == changeDisplay){
        		JPanel contents = this.createGoalViewComponents();
        		frame.setContentPane(contents);
        		frame.invalidate();
        		frame.validate();
        	}
       }else if(activeFrame == 5){
        	if(e.getSource() == changeDisplay){
    	    	JPanel contents = this.createHistoryViewComponents();
    	    	frame.setContentPane(contents);
    		    frame.invalidate();
    		    frame.validate();
        	}
    	}else if(activeFrame == 6){
        	if(e.getSource() == changeDisplay){
    	    	JPanel contents = this.createSyncViewComponents();
    	    	frame.setContentPane(contents);
    		    frame.invalidate();
    		    frame.validate();
    	}
    	}else if(activeFrame == 7){
        	if(e.getSource() == changeDisplay){
    	    	JPanel contents = this.createStepViewComponents();
    	    	frame.setContentPane(contents);
    		    frame.invalidate();
    		    frame.validate();
           	}else{
           		f.sync();
           		syncLabel.setText("Last Sync Date: " + f.getLastSyncDate());
                historyLabel.setText("# of Days Recorded: " + f.getHistory().size() + " Last Date: " + f.getLastDayDate());
           	}
  
    }
    }
    public void setChangeListener(){
        changeDisplay.addActionListener(this);
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
        app.setChangeListener();
        JPanel stepContents = app.createStepViewComponents();
        
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



