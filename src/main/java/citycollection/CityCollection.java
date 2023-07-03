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
        if (cityList.contains(city)) {
            cityList.remove(city);
            usedCityList.add(city);
        } else {
            System.out.println("Місто відсутнє у списку доступних міст.");
        }
    }

    // Приклад використання класу CityCollection та тестування методiв
    public static void main(String[] args) {
        CityCollection collection = new CityCollection();
        System.out.println(collection.getCityList());  // Виведе: [Київ, Нью-Йорк, Вашингтон]
        System.out.println(collection.getUsedCityList());  // Виведе: []

        collection.markCityUsed("Київ");
        System.out.println(collection.getCityList());  // Виведе: [Нью-Йорк, Вашингтон]
        System.out.println(collection.getUsedCityList());  // Виведе: [Київ]
    }
}