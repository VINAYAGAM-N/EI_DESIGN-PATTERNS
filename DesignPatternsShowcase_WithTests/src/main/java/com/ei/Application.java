package com.ei;

import com.ei.patterns.creational.travel_builder.TravelDemo;
import com.ei.patterns.creational.game_factory.GameDemo;
import com.ei.patterns.behavioral.chat_observer.ChatDemo;
import com.ei.patterns.behavioral.smarthome_command.SmartHomeDemo;
import com.ei.patterns.structural.filesystem_composite.FileSystemDemo;
import com.ei.patterns.structural.graphics_flyweight.GraphicsDemo;

public class Application {
    public static void main(String[] args) throws Exception {
        System.out.println("Running TravelBuilder Demo:");
        TravelDemo.main(args);
        System.out.println();

        System.out.println("Running GameFactory Demo:");
        GameDemo.main(args);
        System.out.println();

        System.out.println("Running ChatObserver Demo:");
        ChatDemo.main(args);
        System.out.println();

        System.out.println("Running SmartHomeCommand Demo:");
        SmartHomeDemo.main(args);
        System.out.println();

        System.out.println("Running FileSystemComposite Demo:");
        FileSystemDemo.main(args);
        System.out.println();

        System.out.println("Running GraphicsFlyweight Demo:");
        GraphicsDemo.main(args);
        System.out.println();
    }
}
