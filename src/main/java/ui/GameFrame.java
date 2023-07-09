package ui;

import citycollection.CityCollection;

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
    private int scoreCounter;
    private CityCollection cityCollection;

    public GameFrame() {
        cityCollection = new CityCollection();
        scoreCounter = 0;
    }

    public void createGameFrame() {
        gameFrame = new JFrame("Cities");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setSize(400, 300);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setResizable(false);

        URL imageUrl = getClass().getResource("/img/game_img.png");
        ImageIcon imageIcon = new ImageIcon(imageUrl);
        JLabel backgroundLabel = new JLabel(imageIcon);
        backgroundLabel.setLayout(new BorderLayout());

        Font labelFont = new Font("Verdana", Font.BOLD | Font.ITALIC, 14);
        Font fieldFont = new Font("Verdana", Font.ITALIC, 14);

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
        scorePanel.setLayout(new BorderLayout());
        scorePanel.setOpaque(false);

        JLabel score = new JLabel("Кількість ходів:");
        score.setFont(labelFont);
        scoreField = new JTextField("    ");
        scoreField.setFont(fieldFont);
        scoreField.setEditable(false);
        scoreField.setBackground(new Color(0, 0, 0, 0));

        JTextArea usedCityArea = new JTextArea();
        usedCityArea.setFont(new Font("Verdana", Font.ITALIC, 12));
        usedCityArea.setLineWrap(true);
        usedCityArea.setWrapStyleWord(true);
        usedCityArea.setOpaque(false);
        usedCityArea.setBackground(new Color(0, 0, 0, 0));

        JScrollPane usedCityScrollPane = new JScrollPane(usedCityArea);
        usedCityScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        usedCityScrollPane.setPreferredSize(new Dimension(200, 150));
        usedCityScrollPane.setOpaque(false);
        usedCityScrollPane.getViewport().setOpaque(false);

        JLabel usedCityLabel = new JLabel("Використані міста:");
        usedCityLabel.setFont(labelFont);

        scorePanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.weighty = 1.0;

        scorePanel.add(score, gbc);

        gbc.gridx = 1;
        scorePanel.add(scoreField, gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridwidth = 2;
        gbc.weighty = 0.0;
        scorePanel.add(usedCityLabel, gbc);

        gbc.gridy = 2;
        scorePanel.add(usedCityScrollPane, gbc);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.setOpaque(false);

        JPanel buttonContainer = new JPanel();
        buttonContainer.setLayout(new GridLayout(2, 1));
        buttonContainer.setOpaque(false);

        JButton loseButton = new JButton("Я Здаюсь");
        loseButton.setFont(labelFont);
        loseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameFrame.dispose();
                new EndFrame().createEndFrame("Ти здався", scoreCounter);
            }
        });

        JButton makeMoveButton = new JButton("Зробити хід");
        makeMoveButton.setFont(labelFont);
        makeMoveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setUsedCityArea(usedCityArea, cityCollection);
            }
        });

        buttonContainer.add(makeMoveButton);
        buttonContainer.add(loseButton);

        buttonPanel.add(buttonContainer, BorderLayout.PAGE_END);

        backgroundLabel.add(inputPanel, BorderLayout.WEST);
        backgroundLabel.add(scorePanel, BorderLayout.EAST);
        backgroundLabel.add(buttonPanel, BorderLayout.SOUTH);

        gameFrame.add(backgroundLabel);
        gameFrame.setVisible(true);
    }

    private void setUsedCityArea(JTextArea usedCityArea, CityCollection cityCollection) {
        usedCityArea.setText(" ");
        for (String city : cityCollection.getUsedCityList()) {
            if (!cityCollection.getUsedCityList().isEmpty()) {
                usedCityArea.append(city + ", ");
            }
        }
    }
}