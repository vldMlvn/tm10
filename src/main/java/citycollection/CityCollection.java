package citycollection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
        loadCitiesFromFile("/citylist/cities.txt");
    }

    private void loadCitiesFromFile(String filename) {
        try (InputStream inputStream = getClass().getResourceAsStream(filename);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] cities = line.split("\\s+");
                for (String city : cities) {
                    cityList.add(city);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
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
