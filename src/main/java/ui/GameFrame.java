package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class GameFrame {
    private JFrame gameFrame;
    private JTextField userInputField;
    private JTextField computerAnswerField;
    private JTextField scoreField;

    public void createGameFrame(){

        gameFrame=new JFrame("Cities");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setSize(400,300);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setResizable(false);

        URL imageUrl = getClass().getResource("/img/game_img.png");
        ImageIcon imageIcon = new ImageIcon(imageUrl);
        JLabel backgroundLabel = new JLabel(imageIcon);
        backgroundLabel.setLayout(new BorderLayout());

        Font labelFont = new Font("Verdana", Font.BOLD | Font.ITALIC, 14);
        Font fieldFont = new Font("Verdana",  Font.ITALIC, 14);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2));
        inputPanel.setOpaque(false);

        JLabel cityInputLabel = new JLabel("Введіть місто:");
        cityInputLabel.setFont(labelFont);
        userInputField = new JTextField();
        userInputField.setFont(fieldFont);

        JLabel computerAnswerLabel = new JLabel("Відповідь комп'ютера:");
        computerAnswerLabel.setFont(labelFont);
        computerAnswerField = new JTextField();
        computerAnswerField.setFont(fieldFont);
        computerAnswerField.setEditable(false);

        inputPanel.add(cityInputLabel);
        inputPanel.add(userInputField);
        inputPanel.add(computerAnswerLabel);
        inputPanel.add(computerAnswerField);

        JPanel scorePanel = new JPanel();
        scorePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        scorePanel.setOpaque(false);

        JLabel score = new JLabel("Кількість ходів:");
        score.setFont(labelFont);
        scoreField = new JTextField("      ");
        scoreField.setFont(fieldFont);
        scoreField.setEditable(false);
        scoreField.setBackground(new Color(0,0,0,0));

        scorePanel.add(score);
        scorePanel.add(scoreField);

        JPanel buttonPanel=new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.setOpaque(false);

        JButton makeMove=new JButton("Зробити хід");
        makeMove.setFont(labelFont);
        makeMove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameFrame.dispose();
            }
        });
        buttonPanel.add(makeMove);

        backgroundLabel.add(inputPanel, BorderLayout.WEST);
        backgroundLabel.add(scorePanel,BorderLayout.EAST);
        backgroundLabel.add(buttonPanel,BorderLayout.PAGE_END);


        gameFrame.add(backgroundLabel);
        gameFrame.setVisible(true);
    }
}
