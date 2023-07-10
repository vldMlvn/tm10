package service;

import citycollection.CityCollection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MakeMoveHelper {
    public char getLastChar(String userCity) {
        char c = Character.toUpperCase(userCity.charAt(userCity.length() - 1));
        if (c == 'Ь' && userCity.length() > 1) {
            return Character.toUpperCase(userCity.charAt(userCity.length() - 2));
        }
        return c;
    }

    public List<String> getAvailableCity(String userCity, CityCollection cityCollection) {
        List<String> available = new ArrayList<>();
        char c = getLastChar(userCity);
        for (String city : cityCollection.getCityList()) {
            if (!cityCollection.getUsedCityList().contains(city) && city.startsWith(String.valueOf(c))) {
                available.add(city);
            }
        }
        return available;
    }

    public String getComputerAnswer(List<String> available) {
        Random random = new Random();
        int index = random.nextInt(available.size());
        return available.get(index);
    }
}