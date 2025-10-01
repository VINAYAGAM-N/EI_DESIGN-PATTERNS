package com.ei.tests;

import com.ei.patterns.creational.game_factory.CharacterFactory;
import com.ei.patterns.creational.game_factory.GameCharacter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameFactoryTest {
    @Test
    public void testCreateWarrior() {
        GameCharacter warrior = CharacterFactory.create("warrior", "Thorin");
        assertNotNull(warrior);
        assertEquals("Thorin", warrior.getName());
        assertEquals("Warrior", warrior.getType());
    }

    @Test
    public void testCreateMage() {
        GameCharacter mage = CharacterFactory.create("mage", "Gandalf");
        assertNotNull(mage);
        assertEquals("Gandalf", mage.getName());
        assertEquals("Mage", mage.getType());
    }

    @Test
    public void testCreateArcher() {
        GameCharacter archer = CharacterFactory.create("archer", "Legolas");
        assertNotNull(archer);
        assertEquals("Legolas", archer.getName());
        assertEquals("Archer", archer.getType());
    }

    @Test
    public void testCreateUnknownType() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            CharacterFactory.create("unknown", "Name");
        });
        assertTrue(exception.getMessage().contains("Unknown type"));
    }
}
