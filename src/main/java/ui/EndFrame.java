package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class EndFrame {
    private JFrame endFrame;
    private JLabel endLabel;
    private JPanel panel;
    private JButton startButton;
    private JButton menuButton;
    private byte score = 100;

    public void createEndFrame() {
        endFrame = new JFrame("Кiнець гри");
        endFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        endFrame.setSize(400, 200);
        endFrame.setLocationRelativeTo(null);
        endFrame.setResizable(false);

        URL imageUrl = getClass().getResource("/img/welcome_img.png");
        ImageIcon imageIcon = new ImageIcon(imageUrl);
        JLabel backgroundLabel = new JLabel(imageIcon);
        backgroundLabel.setLayout(new BorderLayout());

        Font buttonFont=new Font("Verdana", Font.BOLD | Font.ITALIC, 14);
        Font welcomeLabelFont = new Font("Verdana", Font.BOLD | Font.ITALIC, 24);


        endLabel = new JLabel("Рахунок: " + score);
        endLabel.setHorizontalAlignment(JLabel.CENTER);
        endLabel.setFont(welcomeLabelFont);
        endFrame.setContentPane(backgroundLabel);
        endFrame.add(endLabel,BorderLayout.NORTH);
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