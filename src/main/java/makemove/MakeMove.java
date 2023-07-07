package makemove;

import citycollection.CityCollection;

import javax.swing.*;
import java.util.ArrayList;

public class MakeMove {
    private JTextField computerAnswerField;
    private CityCollection cityCollection;
    private JTextField scoreField;
    private int scoreCounter = 0;

    public MakeMove(JTextField computerAnswerField, CityCollection cityCollection, JTextField scoreField) {
        this.computerAnswerField = computerAnswerField;
        this.cityCollection = cityCollection;
        this.scoreField = scoreField;
    }

    public void move(String inputtedText) {
        String userCity = inputtedText.trim().toLowerCase();
        if (isInputValid(userCity)) {
            for (String city : cityCollection.getCityList()) {
                if (userCity.equals(city.toLowerCase())) {
                    madeMove(userCity);
                }
            }
        } else {
            String message = "Введіть назву міста. В назві міста мають бути тількі літери";
            // вивести окно с помилкою та повернути гравця до вводу міста знов
        }
    }

    private boolean isInputValid(String userCity){
        if (userCity.isEmpty()) return false;
        if (userCity.contains(" ")) return false;
        if (!userCity.matches("^[\\\\p{IsCyrillic}]+$")) return false;

        return true;
    }

    private void madeMove(String userCity){
        if (userCity.equals("здаюсь")) {
            String message = "You Lose";
            //закрываем игру
        }
        String computerAnswer = computerAnswerField.toString();
        char firstLetter;
        char lastLetter;
        firstLetter = userCity.charAt(0);
        lastLetter = userCity.charAt(userCity.length()-1);

        if (computerAnswer != null) {
            if (firstLetter != computerAnswer.charAt(computerAnswer.length()-1)) {
                String message = "Перша буква назви міста повинна дорівнювати останній букві міста соперника";
                // вивести окно с помилкою та повернути гравця до вводу міста знов
            }
            else {
                checkCityFromCollection(userCity);
                scoreCounter++;
                computerMove(lastLetter);
            }
        }
    }

    private void checkCityFromCollection(String userCity) {
        for (String city : cityCollection.getUsedCityList()) {
            if (userCity.equals(city.toLowerCase())) {
                String message = "Таке місто вже було використано в цей грі";
                // вивести окно с помилкою та повернути гравця до вводу міста знов
            }
        }
        cityCollection.markCityUsed(userCity);
    }

    private void computerMove(char lastLetter) {
        ArrayList<String> fitCity = new ArrayList();
        boolean isFitCityNotUsed = true;
        for (String city : cityCollection.getCityList()) {
            if (lastLetter == city.toLowerCase().charAt(0)) {
                for (String usedcity : cityCollection.getUsedCityList()) {
                    if (city.equals(usedcity.toLowerCase())) {
                        isFitCityNotUsed = false;
                    }
                }
                if (isFitCityNotUsed) fitCity.add(city);
            }
        }
        if (!fitCity.isEmpty()) {
            String message = "Компьютер зробив хід. Тепер твоя черга";
//          записати у поле computerAnswerField значення fitCity.get(0)
            scoreCounter++;
            cityCollection.markCityUsed(fitCity.get(0));
            // перейти до форми вводу міста гравцем
        } else {
            String message = "У компьютера більше не має ходу. Комп'ютер програв.";
        }
    }
}

