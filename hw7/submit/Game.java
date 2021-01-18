import java.awt.Color;
import java.awt.Dimension;
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

    /**
     * Instance variable for JButton.
     */
    private static JButton[] buttons;
    /**
     * Instance variable for score.
     */
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
        window.setSize(670, 490);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create a container
        JPanel pane = new JPanel();

        // Top line of GUI
        JPanel line = new JPanel();

        //Score
        JLabel lblScore = new JLabel("Score:");
        JTextField tfScore = new JTextField(18);
        tfScore.setEditable(false);

        // Game board
        buttons = new JButton[100];
        for (int i = 0; i < buttons.length; i++) {
            // set every button to default state (neither walk nor stop)
            buttons[i] = new JButton("   ");
            buttons[i].setPreferredSize(new Dimension(60, 30));
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
        tfTime.setEditable(false);

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

        // set window's content pane to be the container.
        window.setContentPane(pane);
        window.setVisible(true);

    }
    /**
     * Private class for Start Button listener.
     */
    private static class StartButtonListener implements ActionListener {
        /**
         * Instance variable for button.
         */
        private JButton myStart;
        /**
         * Instance variable for button list.
         */
        private JButton[] myButtonList;
        /**
         * Instance variable for timeLeft.
         */
        private JTextField timeLeft;
        /**
         * Instance variable for myScore.
         */
        private JTextField myScore;
        private StartButtonListener(JButton stopButton, JButton[] buttonList, JTextField textTime, JTextField scoreBoard) {
            /*
             * Instance variable for myStart.
             */
            myStart = stopButton;
            /*
             * Instance variable for buttonList.
             */
            myButtonList = buttonList;
            /*
             * Instance variable for timeLeft.
             */
            timeLeft = textTime;
            /*
             * Instance variable for score.
             */
            myScore = scoreBoard;
        }
        /**
         * Implement actionPerformed method of Thread class.
         * @param event ActionEvent
         */
        @Override
        public void actionPerformed(ActionEvent event) {
            //myStart.setBackground(Color.GRAY);
            myStart.setEnabled(false);
            Thread startTimer = new TimerThread(timeLeft, 1000, myStart, myButtonList, myScore);
            startTimer.start();
            //Thread[] hole_th = new Thread[];
            for (int i = 0; i < myButtonList.length; i++) {
                myButtonList[i].setEnabled(true);
                Thread holeTh = new HoleThread(myButtonList[i]);
                holeTh.start();
            }
        }
    }
    /**
     * Private class for Hole Action Listener.
     */
    private static class HoleActionListener implements ActionListener {
        /**
         * Instance variable for index.
         */
        private int i;
        /**
         * Instance variable for myButtonList.
         */
        private JButton[] myButtonList;
        /**
         * Instance variable for score.
         */
        private JTextField myScore;
        /**
         * Constructor.
         * @param idx int
         * @param buttonList JButton[]
         * @param scoreBoard JTextField
         */
        private HoleActionListener(int idx, JButton[] buttonList, JTextField scoreBoard) {
            i = idx;
            myButtonList = buttonList;
            myScore = scoreBoard;
        }
        /**
         * Implement run method of Thread class.
         * @param event ActionEvent
         */
        @Override
        public void actionPerformed(ActionEvent event) {
            if (myButtonList[i].getBackground() == Color.GREEN) {
                score = score + 1;
                myScore.setText(String.valueOf(score));
                myButtonList[i].setEnabled(false);
                myButtonList[i].setBackground(Color.RED);
                myButtonList[i].setText("Hit");
            }
        }
    }
    /**
     * Private class for Timer Thread.
     */
    private static class TimerThread extends Thread {
        /**
         * Instance variable for time remain.
         */
        private JTextField timeRemain;
        /**
         * Instance variable for sleep time.
         */
        private long mySleepTime;
        /**
         * Instance variable for timeLeft.
         */
        private int timeSeconds = 20;
        /**
         * Instance variable for startButton.
         */
        private JButton startButton;
        /**
         * Instance variable for buttonList.
         */
        private JButton[] buttonList;
        /**
         * Instance variable for score.
         */
        private JTextField myScore;
        /**
         * Constructor.
         * @param buttonListArg JButton[]
         * @param sleepTime long
         * @param start JButton
         * @param timeLeft JTextField
         * @param scoreBoard JTextField
         */
        TimerThread(JTextField timeLeft, long sleepTime, JButton start, JButton[] buttonListArg, JTextField scoreBoard) {
            timeRemain = timeLeft;
            mySleepTime = sleepTime;
            startButton  = start;
            buttonList = buttonListArg;
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
                        if (timeSeconds < 0) {
                            for (int i = 0; i < buttonList.length; i++) {
                                buttonList[i].setEnabled(false);
                                buttonList[i].setBackground(Color.white);
                                buttonList[i].setText("  ");
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
     * static nested class that extends Thread.
     * @author Jeff Eppinger & Terry Lee
     */
    private static class HoleThread extends Thread {
        /**
         * Instance variable for mybutton.
         */
        private JButton myButtons;
        /**
         * Instance variable for color.
         */
        private Color myColor =  Color.GREEN;
        /**
         * Constructor.
         * @param button array of buttons
         */
        HoleThread(JButton button) {
            myButtons = button;
        }
        /**
         * Implement run method of Thread class.
         */
        @Override
        public void run() {
            try {
                // long-running task
                Thread.sleep((long) (((Math.random() * (4 - 0.5)) + 0.5) * 1000));
                while (true) {
                    //Thread.sleep(mySleepTime);

                    // pick a random button based on random number
                    // what is the chance that two threads pick the same number?
//                    synchronized (myButtons) {
                        // used the unique state of instance to set text and color
                    if (myButtons.isEnabled()) {
                        double randomTime = ((Math.random() * (4 - 0.5)) + 0.5) * 1000;
                        myButtons.setBackground(myColor);
                        myButtons.setText("Up");
                        Thread.sleep((long) randomTime);
                        if (!myButtons.getText().equals("Hit")) {
                            myButtons.setBackground(Color.white);
                            myButtons.setText("");
                        }
                        Thread.sleep(2000);
                        //break;
                    } else {
                        if (myButtons.getText().equals("Hit")) {
                            Thread.sleep(3000);
                            myButtons.setBackground(Color.white);
                            myButtons.setText("");
                        }
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
        int numLights = 99;
        long sleepMillis = 2000;
        new Game(numLights, sleepMillis);
    }
}
