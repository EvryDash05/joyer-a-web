package com.example.joyeria.commons.utilities;

import java.util.Random;

public class Utils {

    public static String generateRandomId(String prefix){
        Random rand = new Random();
        int randomNumber = rand.nextInt(100, 999);
        return prefix + randomNumber;
    }

    private Utils() {}
}
