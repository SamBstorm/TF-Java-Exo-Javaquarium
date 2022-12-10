package Models.Handlers;

import Models.Common.Gender;

import java.util.Random;

public class CustomRNG {

    private static Random RNG = new Random();

    public static int GetRandomIndex(int ArrayLength){
        return RNG.nextInt(ArrayLength);
    }
    public static Gender GetRandomGender(){
        if(RNG.nextInt()%2 == 0) return Gender.Male;
        return Gender.Female;
    }

    public static String GetRandomName(String name1, String name2){
        return name1.substring(0,name1.length()/2) + name2.substring(name2.length()/2);
    }

    public static String GetRandomName(){
        String name = "";
        String[] parts = {"as","sa","di", "id", "lu", "ha", "el", "ma", "son", "am", "ri", "er", "on"};
        int iteration = RNG.nextInt(3)+1;
        for (int i = 0; i < iteration; i++) {
            name += parts[GetRandomIndex(parts.length)];
        }
        return name;
    }
}
