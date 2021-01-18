import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * Whack-a-Mole Game class.
 * @author Prerna Singh
 * Andrew id - prernasi
 */
public class Game {

    //private JButton startButton;
    private static JButton[] buttons;
    private static int score = 0;
    /**
     * Constructor.
     * @param numLights number of lights using buttons
     * @param sleepTime sleep milliseconds
     */
    public Game(int numLights, long sleepTime) {
        Font font = new Font(Font.MONOSPACED, Font.BOLD, 14);

        // create a window
        JFrame window = new JFrame("Whack-a-Mole Sample GUI");
        window.setSize(650, 630);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create a container
        JPanel pane = new JPanel();
        
        
        // Top line of GUI
        JPanel line = new JPanel();
        
      //Score
        JLabel lblScore = new JLabel("Score:");
        JTextField tfScore = new JTextField(18);
        
        // Game board
        buttons = new JButton[100];
        for (int i = 0; i < buttons.length; i++) {
            // set every button to default state (neither walk nor stop)
            buttons[i] = new JButton("   ");
            buttons[i].setBackground(Color.WHITE);
            buttons[i].setFont(font);
            buttons[i].setOpaque(true);
            buttons[i].setEnabled(false);
            buttons[i].addActionListener(new HoleActionListener(i, buttons, tfScore));
            //pane.add(buttons[i]);
        }
        
        // Time left
        JLabel lblTime = new JLabel("Time Left:");
        JTextField tfTime = new JTextField(18);

        //Start Button
        JButton startButton = new JButton("Start");
        startButton.addActionListener(new StartButtonListener(startButton, buttons, tfTime, tfScore));

        line.add(startButton);
        line.add(lblTime);
        line.add(tfTime);
        line.add(lblScore);
        line.add(tfScore);
        pane.add(line);
        
        //Adding buttons to the pane
        for (int i = 0; i < buttons.length; i++) {
            pane.add(buttons[i]);
        }

        // set window's content pane to be the container
        window.setContentPane(pane);
        window.setVisible(true);
        
    }
    private static class StartButtonListener implements ActionListener {
        private JButton myStart;
        private JButton[] myButtonList;
        private JTextField timeLeft;
        private JTextField myScore;
        private StartButtonListener(JButton stop_button, JButton[] buttonList, JTextField textTime, JTextField scoreBoard) {
            myStart = stop_button;
            myButtonList = buttonList;
            timeLeft = textTime;
            myScore = scoreBoard;
        }
        @Override
        public void actionPerformed(ActionEvent event) {
            //myStart.setBackground(Color.GRAY);
            myStart.setEnabled(false);
            Thread startTimer = new TimerThread(timeLeft, 1000, myStart, myButtonList, myScore);
            startTimer.start();
            //Thread[] hole_th = new Thread[];
            for (int i = 0; i < myButtonList.length; i++) {
                myButtonList[i].setEnabled(true);
                Thread hole_th = new HoleThread(myButtonList[i]);
                hole_th.start();
            }
        }
    }
    
    private static class HoleActionListener implements ActionListener {
        private int i;
        private JButton[] myButtonList;
        private JTextField myScore;
        private HoleActionListener(int idx, JButton[] buttonList, JTextField scoreBoard) {
            i = idx;
            myButtonList = buttonList;
            myScore = scoreBoard;
        }
        @Override
        public void actionPerformed(ActionEvent event) {
            if(myButtonList[i].getBackground()==Color.GREEN) {
                score = score + 1;
                myScore.setText(String.valueOf(score));
                myButtonList[i].setEnabled(false);
                myButtonList[i].setBackground(Color.RED);
                myButtonList[i].setText("Hit");
            }
        }
    }
    
    private static class TimerThread extends Thread {
        // unique state (instance variables) per instance
        private JTextField timeRemain;
        private long mySleepTime;
        private int timeSeconds = 20;
        private JButton startButton;
        private JButton[] button_list;
        private JTextField myScore;

        /**
         * Constructor.
         * @param buttons array of buttons
         * @param sleepTime sleep time milliseconds
         * @param color color
         * @param text text
         */
        public TimerThread(JTextField timeLeft, long sleepTime, JButton start, JButton[] buttonList, JTextField scoreBoard) {
            timeRemain = timeLeft;
            mySleepTime = sleepTime;
            startButton  = start;
            button_list = buttonList;
            myScore = scoreBoard;
        }

        /**
         * Implement run method of Thread class.
         */
        @Override
        public void run() {
            try {
                // long-running task
                while (true) {
                    Thread.sleep(mySleepTime);

                    // pick a random button based on random number
                    // what is the chance that two threads pic
                    //synchronized (timeSeconds) {
                        // used the unique state of instance to set text and color
                        timeRemain.setText(String.valueOf(timeSeconds));
                        timeSeconds = timeSeconds - 1;
                        if(timeSeconds < 0) {
                            for (int i = 0; i < button_list.length; i++) {
                                button_list[i].setEnabled(false);
                                button_list[i].setBackground(Color.white);
                                button_list[i].setText("  ");
                            }
                            Thread.sleep(5000);
                            score = 0;
                            myScore.setText(String.valueOf(0));
                            startButton.setEnabled(true);
                            break;
                        }
                        //light.setBackground(myColor);
                    //}
                }
            } catch (InterruptedException e) {
                throw new AssertionError(e);
            }
            
        }
    }

    /**
     * static nested class that extends Thread
     * @author Jeff Eppinger & Terry Lee
     */
    private static class HoleThread extends Thread {
        // unique state (instance variables) per instance
        private JButton myButtons;
        private Color myColor =  Color.GREEN;
//        private String myText;
//        private Random random = new Random();

        /**
         * Constructor.
         * @param buttons array of buttons
         * @param sleepTime sleep time milliseconds
         * @param color color
         * @param text text
         */
        public HoleThread(JButton button) {
            myButtons = button;
        }

        /**
         * Implement run method of Thread class.
         */
        @Override
        public void run() {
            try {
                // long-running task
                Thread.sleep((long) (((Math.random() * (4 - 0.5)) + 0.5)*1000));
                while (true) {
                    //Thread.sleep(mySleepTime);

                    // pick a random button based on random number
                    // what is the chance that two threads pick the same number?
//                    synchronized (myButtons) {
                        // used the unique state of instance to set text and color
                    if(myButtons.isEnabled()) {
                        double randomTime = ((Math.random() * (4 - 0.5)) + 0.5)*1000;
                        myButtons.setBackground(myColor);//pop up
                        myButtons.setText("Up");
                        Thread.sleep((long) randomTime);
                        if(!myButtons.getText().equals("Hit")) {
                            myButtons.setBackground(Color.white);
                        }
                        Thread.sleep(2000);// stay down for 2 seconds
                        //break;
                    }
                    else {
                        break;
                    }
                    //}
                }
            } catch (InterruptedException e) {
                throw new AssertionError(e);
            }
        }
    }
    
    /**
     * Program to check lights on and off example.
     * @param args number of lights and sleep milliseconds
     */
    public static void main(String[] args) {
//        if (args.length != 2) {
//            System.out.println("Usage: java Lights2 <numLights> <sleepMillis>");
//            return;
//        }

        int numLights = 99;//Integer.parseInt(args[0]);
        long sleepMillis = 2000;//Long.parseLong(args[1]);
        new Game(numLights, sleepMillis);
    }

}