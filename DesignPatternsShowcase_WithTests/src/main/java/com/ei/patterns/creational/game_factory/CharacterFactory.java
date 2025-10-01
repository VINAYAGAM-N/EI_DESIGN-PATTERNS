package com.ei.patterns.creational.game_factory;
public class CharacterFactory {
    public static GameCharacter create(String type, String name){
        switch(type.toLowerCase()){
            case "warrior": return new Warrior(name);
            case "mage": return new Mage(name);
            case "archer": return new Archer(name);
            default: throw new IllegalArgumentException("Unknown type: " + type);
        }
    }
}
