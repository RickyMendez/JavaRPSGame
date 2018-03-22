package rockpaperscissors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * CLASS RockPaperScissorsApp - A comparison game of rock vs paper vs scissors where the user plays against the computer.
 * Rock should beat Scissors, Scissors should beat Paper, and Paper should beat Rock.
 */
public class RockPaperScissorsApp extends JFrame {

    private JPanel contentPane;
    private JPanel selectMenu;
    private JButton scissorsBtn, rockBtn, paperBtn;
    private JPanel display = new JPanel();
    private RockPaperScissors[] rps = RockPaperScissors.values();
    private RockPaperScissors rpsUser;
    private JLabel userImage = new JLabel(),
            compImage = new JLabel(),
            resultLabel = new JLabel();

    /**
     * METHOD main - starts the application
     * @param args
     */
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RockPaperScissorsApp frame = new RockPaperScissorsApp();
                    frame.setVisible(true);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * CONSTRUCTOR RockPaperScissorsApp - builds the window
     */
    public RockPaperScissorsApp(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        setTitle("Rock Paper Scissors");

        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);

        JPanel selectPanel = createSelectPanel();

        display.setLayout(new GridLayout(3,1));
        userImage.setHorizontalAlignment(SwingConstants.CENTER);
        compImage.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);

        display.add(userImage);
        display.add(compImage);
        display.add(resultLabel);

        contentPane.add(selectPanel, BorderLayout.NORTH);
        contentPane.add(display, BorderLayout.CENTER);
    }

    /*
    create the selection panel
     */
    private JPanel createSelectPanel() {
        selectMenu = new JPanel();

        rockBtn = new JButton("Rock");
        selectMenu.add(rockBtn);

        paperBtn = new JButton("paper");
        selectMenu.add(paperBtn);

        scissorsBtn = new JButton("Scissors");
        selectMenu.add(scissorsBtn);

        rockBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choiceListener(0);
            }
        });

        paperBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choiceListener(1);
            }
        });

        scissorsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choiceListener(2);
            }
        });

        return selectMenu;
    }

    /*
    method to handle the user selection, because the only difference is the enum that is chosen the
    method takes an int to select from an array making the class smaller and reusable
     */
    private void choiceListener(int choice){
        userImage.setIcon(rps[choice].getImage());
        rpsUser = rps[choice];
        resultLabel.setText(rpsUser.evaluate());
        compImage.setIcon(rpsUser.getOpponent().getImage());
    }
}
