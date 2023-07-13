package service;

import citycollection.CityCollection;
import ui.EndFrame;

import javax.swing.*;
import java.util.List;

public class MakeMove {
    private JTextField computerAnswerField;
    private JTextField scoreField;
    private CityCollection cityCollection;
    private JFrame gameFrame;
    private MakeMoveHelper moveHelper;
    private int scoreCount;

    public MakeMove(JTextField computerAnswerField, CityCollection cityCollection,
                    JTextField scoreField, JFrame gameFrame,int scoreCount) {
        this.computerAnswerField = computerAnswerField;
        this.cityCollection = cityCollection;
        this.scoreField = scoreField;
        this.gameFrame = gameFrame;
        this.scoreCount=scoreCount;
        moveHelper = new MakeMoveHelper();
    }

    public void madeMove(String userCity) {
        if (userCity.equals("Здаюсь")) {
            String message = "Ти програв";
            gameFrame.dispose();
            new EndFrame().createEndFrame(message, scoreCount);
        } else if (!cityCollection.getCityList().contains(userCity)) {
            computerAnswerField.setText("Я не знаю такого міста");
        } else if (cityCollection.getUsedCityList().contains(userCity)) {
            computerAnswerField.setText("Місто вже було");
        } else {
            char lastChar = moveHelper.getLastChar(userCity);
            List<String> availableCity = moveHelper.getAvailableCity(String.valueOf(lastChar), cityCollection);
            if (availableCity.isEmpty()) {
                String message = "Ти переміг!";
                gameFrame.dispose();
                scoreCount++;
                new EndFrame().createEndFrame(message, scoreCount);
            } else {
                String computerCity = moveHelper.getComputerAnswer(availableCity);
                computerAnswerField.setText(computerCity);
            }
            scoreCount++;
            scoreField.setText(String.valueOf(scoreCount));
            cityCollection.markCityUsed(userCity);
            cityCollection.markCityUsed(computerAnswerField.getText());
        }
    }
}