package citycollection;

import java.util.List;
import java.util.ArrayList;

public class CityCollection {
    private List<String> cityList;
    private List<String> usedCityList;
    
    public CityCollection() {
        cityList = new ArrayList<>();
        usedCityList = new ArrayList<>();
        cityList.add("Київ");
        cityList.add("Нью-Йорк");
        cityList.add("Вашингтон");
    }
    public List<String> getCityList() {
        return cityList;
    }
    public List<String> getUsedCityList() {
        return usedCityList;
    }

    public void markCityUsed(String city) {
        usedCityList.add(city);
    }
}
