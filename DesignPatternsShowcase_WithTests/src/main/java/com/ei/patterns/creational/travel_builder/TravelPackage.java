package com.ei.patterns.creational.travel_builder;
import java.util.List;
public class TravelPackage {
    private final String owner;
    private final boolean flight;
    private final boolean hotel;
    private final List<String> extras;
    private TravelPackage(Builder b){ owner=b.owner; flight=b.flight; hotel=b.hotel; extras=b.extras; }
    public static class Builder {
        private final String owner;
        private boolean flight=false; private boolean hotel=false; private List<String> extras=null;
        public Builder(String owner){ this.owner = owner; }
        public Builder withFlight(){ this.flight = true; return this; }
        public Builder withHotel(){ this.hotel = true; return this; }
        public Builder extras(List<String> extras){ this.extras = extras; return this; }
        public TravelPackage build(){ return new TravelPackage(this); }
    }
    @Override public String toString(){ return "TravelPackage[owner="+owner+", flight="+flight+", hotel="+hotel+", extras="+extras+"]"; }
}
