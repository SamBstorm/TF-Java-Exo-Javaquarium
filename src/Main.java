import Models.Aquarium;
import Models.Common.Gender;
import Models.Fishes.*;
import Models.Seaweed;

import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Aquarium aq = new Aquarium();
        aq.addLiving(new Clownfish("Sam", Gender.Male));
        aq.addLiving(new Carp("Didier",Gender.Male));
        aq.addLiving(new Sole("Estelle",Gender.Female));
        aq.addLiving(new Bar("Ginette",Gender.Female));
        aq.addLiving(new Grouper("Hadi",Gender.Male));
        aq.addLiving(new Clownfish("Ludivine",Gender.Female));
        aq.addLiving(new Tuna("Mariam",Gender.Female));
        aq.addLiving(new Seaweed());
        aq.addLiving(new Seaweed());
        aq.addLiving(new Seaweed());

        String input = "";
        while (input != "Fin") {
            aq.newTurn();
            input = in.nextLine();
        }
    }
}
