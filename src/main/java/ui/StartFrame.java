package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class StartFrame {
    private JFrame startFrame;
    private JLabel startLabel;
    private JPanel panel;
    private JButton rulesButton;
    private JButton startButton;
    private JButton exitButton;

    public void createStartFrame() {

        startFrame = new JFrame("Вітаю в грі");
        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startFrame.setSize(400, 300);
        startFrame.setLocationRelativeTo(null);

        URL imageUrl = getClass().getResource("/img/welcome_img.png");
        ImageIcon imageIcon = new ImageIcon(imageUrl);
        JLabel backgroundLabel = new JLabel(imageIcon);
        backgroundLabel.setLayout(new BorderLayout());

        Font buttonFont=new Font("Verdana", Font.BOLD | Font.ITALIC, 14);
        Font welcomeLabelFont = new Font("Verdana", Font.BOLD | Font.ITALIC, 24);

        startLabel = new JLabel("Cities");
        startLabel.setHorizontalAlignment(JLabel.CENTER);
        startLabel.setFont(welcomeLabelFont);

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(false);

        startButton = new JButton("Start");
        startButton.setFont(buttonFont);
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startFrame.dispose();
                new GameFrame().createGameFrame();
            }
        });
        panel.add(startButton);

        rulesButton = new JButton("Правила гри");
        rulesButton.setFont(buttonFont);
        rulesButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        rulesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startFrame.dispose();
                new RulesFrame().createRulesFrame();
            }
        });
        panel.add(rulesButton);

        exitButton=new JButton("Exit");
        exitButton.setFont(buttonFont);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startFrame.dispose();
                new EndFrame().createEndFrame("Ти Програв",10);
            }
        });
        panel.add(exitButton);

        backgroundLabel.add(panel, BorderLayout.SOUTH);
        startFrame.setContentPane(backgroundLabel);
        startFrame.add(startLabel,BorderLayout.NORTH);
        startFrame.setVisible(true);
    }
}