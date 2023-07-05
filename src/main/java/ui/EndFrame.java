package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class EndFrame {
    private JFrame endFrame;
    private JLabel massageLabel;
    private JLabel scoreLabel;
    private JPanel panel;
    private JButton startButton;
    private JButton menuButton;

    public void createEndFrame(String message, int score) {
        endFrame = new JFrame("Кiнець гри");
        endFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        endFrame.setSize(400, 150);
        endFrame.setLocationRelativeTo(null);
        endFrame.setResizable(false);

        URL imageUrl = getClass().getResource("/img/game_img.png");
        ImageIcon imageIcon = new ImageIcon(imageUrl);
        JLabel backgroundLabel = new JLabel(imageIcon);
        backgroundLabel.setLayout(new BorderLayout());

        Font buttonFont=new Font("Verdana", Font.BOLD | Font.ITALIC, 14);
        Font welcomeLabelFont = new Font("Verdana", Font.BOLD | Font.ITALIC, 24);

        massageLabel = new JLabel(message);
        massageLabel.setHorizontalAlignment(JLabel.CENTER);
        massageLabel.setFont(welcomeLabelFont);
        scoreLabel=new JLabel("Рахунок: "+score);
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        scoreLabel.setFont(buttonFont);
        endFrame.setContentPane(backgroundLabel);
        endFrame.add(massageLabel,BorderLayout.NORTH);
        endFrame.add(scoreLabel,BorderLayout.CENTER);
        endFrame.setVisible(true);

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(false);
        backgroundLabel.add(panel, BorderLayout.SOUTH);

        startButton = new JButton("Нова гра");
        startButton.setFont(buttonFont);
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                endFrame.dispose();
                new GameFrame().createGameFrame();
            }
        });
        panel.add(startButton);

        menuButton = new JButton("Головне меню");
        menuButton.setFont(buttonFont);
        menuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                endFrame.dispose();
                new StartFrame().createStartFrame();
            }
        });
        panel.add(menuButton);
    }
}
