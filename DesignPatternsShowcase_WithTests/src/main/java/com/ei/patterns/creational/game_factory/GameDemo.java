package com.ei.patterns.creational.game_factory;
public class GameDemo {
    public static void main(String[] args){
        System.out.println(CharacterFactory.create("warrior","Thorin"));
        System.out.println(CharacterFactory.create("mage","Gandalf"));
        System.out.println(CharacterFactory.create("archer","Legolas"));
    }
}
