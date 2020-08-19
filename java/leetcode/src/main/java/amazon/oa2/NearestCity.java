package amazon.oa2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NearestCity {
    public String[] nearestCities(int numOfCities, String[] cities, int[] xCoordinates,
                             int[] yCoordinates, int numOfQueries, String[] queries){
        Map<Integer, List<City>> citiesInX = new HashMap<>();
        Map<Integer, List<City>> citiesInY = new HashMap<>();
        Map<String, City> cityMap = new HashMap<>();
        for(int i =0; i < numOfCities; i++){
            City city = new City(cities[i], xCoordinates[i], yCoordinates[i]);
            List<City> xCities = citiesInX.getOrDefault(xCoordinates[i], new ArrayList<>());
            List<City> yCities = citiesInY.getOrDefault(yCoordinates[i], new ArrayList<>());
            xCities.add(city);
            yCities.add(city);
            citiesInX.put(city.x, xCities);
            citiesInY.put(city.y, yCities);
            cityMap.put(city.name, city);
        }
        String[] ans = new String[numOfQueries];
        for(int i =0 ; i <numOfQueries; i++ ){
            City city = cityMap.get(queries[i]);
            List<City> sameX = citiesInX.get(city.x);
            List<City> sameY = citiesInY.get(city.y);
            ans[i] = getNearest(city, sameX, sameY);
        }
        return ans;
    }

    String getNearest(City city, List<City> sameX, List<City> sameY){
        CityDistance cityDistance = new CityDistance("NONE", Integer.MAX_VALUE);
        nearest(sameX, city, cityDistance);
        nearest(sameY, city, cityDistance);
        return cityDistance.cityName;
    }

    private void nearest(List<City> sameCoordiate, City city,  CityDistance cityDistancey) {
        for(City city1 : sameCoordiate){
            if(city1.name.equals(city.name)){
                continue;
            }
            int difference = Math.abs(city.x-city1.x) + Math.abs(city.y-city1.y);
            if(difference < cityDistancey.distance){
                cityDistancey.cityName = city1.name;
                cityDistancey.distance = difference;
            }else if(difference == cityDistancey.distance){
                cityDistancey.cityName = cityDistancey.cityName.compareTo(city1.name) > 0? city1.name : cityDistancey.cityName;
            }
        }
    }

    @Test
    public void test(){
        String[] cities = {"c1", "c2", "c67", "c4"};
        int[] xCoordinate = {3,2,1, 1};
        int[] yCoordinate = {3,2,3, 3};
        String[] queries = {"c1"};
        String[] ans1 = nearestCities(4, cities, xCoordinate, yCoordinate, 1, queries);
    }
}

class City{
    String name;
    int x;
    int y;
    City(String name, int x, int y){
        this.name = name;
        this.x = x;
        this.y = y;
    }
}
class CityDistance{
    String cityName;
    Integer distance;
    CityDistance(){}
    CityDistance(String cityName, Integer distance){
        this.cityName = cityName;
        this.distance = distance;
    }
}
