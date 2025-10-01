package com.ei.tests;

import com.ei.patterns.creational.travel_builder.TravelPackage;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TravelBuilderTest {
    @Test
    public void testTravelPackageBuilder() {
        TravelPackage tp = new TravelPackage.Builder("Alice")
                .withFlight()
                .withHotel()
                .extras(Arrays.asList("CityTour", "Meals"))
                .build();
        assertEquals("Alice", tp.toString().split(",")[0].split("=")[1]);
        assertTrue(tp.toString().contains("flight=true"));
        assertTrue(tp.toString().contains("hotel=true"));
        assertTrue(tp.toString().contains("extras=[CityTour, Meals]"));
    }
}
