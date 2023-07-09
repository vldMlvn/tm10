package citycollection;

import ui.EndFrame;
import ui.StartFrame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class CityCollection {
    private Set<String> cityList;
    private List<String> usedCityList;

    public CityCollection() {
        cityList = new HashSet<>();
        usedCityList = new ArrayList<>();

        loadCitiesFromFile("src/main/java/citycollection/cities.txt");
//        cityList.add("Київ");
//        cityList.add("Нью-Йорк");
//        cityList.add("Вашингтон");

        System.out.println(cityList.toString());
    }

    private void loadCitiesFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] cities = line.split("\\s+");
                for (String city : cities) {
                    cityList.add(city);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            // можливо добавимо виклик ErrFrame з можливiстю вибору файлу
        }
    }
    public Set<String> getCityList() {
        return cityList;
    }

    public List<String> getUsedCityList() {
        return usedCityList;
    }

    public void markCityUsed(String city) {
        usedCityList.add(city);
    }
}