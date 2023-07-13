package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RulesFrame {
    private JFrame rulesFrame;
    private JLabel title;
    private JTextArea rules;
    private JButton backToMenuButton;

    public void createRulesFrame() {

        rulesFrame = new JFrame("Правила гри");
        rulesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rulesFrame.setSize(400, 420);
        rulesFrame.setLocationRelativeTo(null);
        rulesFrame.setResizable(false);
        rulesFrame.setLayout(new BorderLayout());

        title = new JLabel("Правила гри \"Cities\":");
        Font titleFont = new Font("Verdana", Font.BOLD | Font.ITALIC, 24);
        title.setFont(titleFont);
        title.setVerticalAlignment(JLabel.NORTH);

        rules = new JTextArea();
        rules.append("\n☞ Щоб розпочати гру натисніть \"Start\";\n");
        rules.append("\n☞ Гравець і комп`ютер по черзі називають\n назви міст;\n");
        rules.append("\n☞ Назва міста повинна починатись на ту літеру,\n на яку закінчується попереднє місто;\n");
        rules.append("\n☞ Назви міст не повинні повторюватись;\n");
        rules.append("\n☞ Назви міст повинні починатися з великої літери;\n");
        rules.append("\n☞ Гра триває до тих пір, поки гравець не здасться \nабо коп`ютер не зможе назвати місто.\n");
        rules.append("\n\nВеселої гри :)");
        Font rulesFont = new Font("Verdana", Font.ITALIC, 14);
        rules.setEditable(false);
        rules.setFont(rulesFont);

        backToMenuButton = new JButton("Повернутися до головного меню");
        Font backToMenuFont = new Font("Verdana", Font.BOLD | Font.ITALIC, 14);
        backToMenuButton.setFont(backToMenuFont);
        backToMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rulesFrame.dispose();
                new StartFrame().createStartFrame();
            }
        });

        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.add(title,BorderLayout.NORTH);
        contentPanel.add(rules, BorderLayout.CENTER);
        contentPanel.add(backToMenuButton, BorderLayout.SOUTH);

        rulesFrame.add(contentPanel, BorderLayout.CENTER);
        rulesFrame.setVisible(true);
    }
}