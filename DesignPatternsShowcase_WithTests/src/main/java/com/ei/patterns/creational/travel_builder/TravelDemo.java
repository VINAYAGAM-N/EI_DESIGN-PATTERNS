package com.ei.patterns.creational.travel_builder;
import java.util.Arrays;
public class TravelDemo {
    public static void main(String[] args){
        TravelPackage tp = new TravelPackage.Builder("Alice").withFlight().withHotel().extras(Arrays.asList("CityTour","Meals")).build();
        System.out.println(tp);
    }
}
