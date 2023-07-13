package makemove;

import citycollection.CityCollection;
import ui.EndFrame;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MakeMove {
    private JTextField computerAnswerField;
    private JTextField scoreField;
    private CityCollection cityCollection;
    private JFrame gameFrame;
    private int scoreCount;

    public MakeMove(JTextField computerAnswerField, CityCollection cityCollection,
                    JTextField scoreField, int scoreCount, JFrame gameFrame) {
        this.computerAnswerField = computerAnswerField;
        this.cityCollection = cityCollection;
        this.scoreField = scoreField;
        this.scoreCount = scoreCount;
        this.gameFrame=gameFrame;
    }

    public void move(String userCity) {
        if (!isInputValid(userCity)) {
            String message = "Введіть назву міста";
            JOptionPane.showMessageDialog(null, message);
            return;
        }

        for (String city : cityCollection.getCityList()) {
            if (userCity.equals(city)) {
                if (checkCityFromCollection(userCity)) {
                    madeMove(userCity);
                } else {
                    String message = "Таке місто вже було використано";
                    JOptionPane.showMessageDialog(null, message);
                }
                return;
            }
        }

        String message = "Місто не знайдено";
        JOptionPane.showMessageDialog(null, message);
    }

    private boolean isInputValid(String userCity) {
        return !userCity.isEmpty() && !userCity.contains(" ");
    }

    private boolean checkCityFromCollection(String userCity) {
        for (String city : cityCollection.getUsedCityList()) {
            if (userCity.equals(city)) {
                return false;
            }
        }
        return true;
    }

    private void madeMove(String userCity) {
        String computerAnswer = computerAnswerField.getText();
        char firstLetter = Character.toLowerCase(userCity.charAt(0));
        char lastLetter;
        if(userCity.toUpperCase().charAt(userCity.length()-1)=='Ь'){
            lastLetter=userCity.toUpperCase().charAt(userCity.length()-2);
        }else {
            lastLetter = Character.toUpperCase(userCity.charAt(userCity.length() - 1));
        }
        if (computerAnswer != null && !computerAnswer.isEmpty()) {
            if (firstLetter != Character.toLowerCase(computerAnswer.charAt(computerAnswer.length() - 1))) {
                String message = "Місто має починатись на літеру, на яку закінчується відповідь комп`ютера";
                JOptionPane.showMessageDialog(null, message);
            } else {
                scoreCount++;
                scoreField.setText(String.valueOf(scoreCount));
                cityCollection.markCityUsed(userCity);
                computerMove(lastLetter);
            }
        } else {
            scoreCount++;
            scoreField.setText(String.valueOf(scoreCount));
            cityCollection.markCityUsed(userCity);
            computerMove(lastLetter);
        }
    }

    private void computerMove(char lastLetter) {
        List<String> availableCities = new ArrayList<>();
        for (String city : cityCollection.getCityList()) {
            if (!cityCollection.getUsedCityList().contains(city) &&
                    city.startsWith(String.valueOf(lastLetter))) {
                availableCities.add(city);
            }
        }
        if (availableCities.isEmpty()) {
            gameFrame.dispose();
            new EndFrame().createEndFrame("Ти переміг", scoreCount);
        } else {
            String computerCity = availableCities.get(new Random().nextInt(availableCities.size()));
            computerAnswerField.setText(computerCity);
            cityCollection.markCityUsed(computerCity);
        }
    }
}

