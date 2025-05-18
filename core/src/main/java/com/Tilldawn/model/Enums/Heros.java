package com.Tilldawn.model.Enums;

import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;
import java.util.Arrays;

public enum Heros {
    Shana(new ArrayList<>(Arrays.asList("Shana/Idle_0 #8330.png" , "Shana/Idle_1 #8360.png" , "Shana/Idle_2 #8819.png" , "Shana/Idle_3 #8457.png" , "Shana/Idle_4 #8318.png" , "Shana/Idle_5 #8307.png")) ,4 , 4 ),
    Diamond(new ArrayList<>(Arrays.asList("Dimond/Idle_0 #8332.png" , "Dimond/Idle_2 #8815.png" , "Dimond/Idle_2 #8821.png" , "Dimond/Idle_3 #8453.png" , "Dimond/Idle_4 #8314.png" , "Dimond/Idle_5 #8309.png")) , 7 , 1),
    Dasher(new ArrayList<>(Arrays.asList("Dasher/Idle_0 #8325.png" , "Dasher/Idle_1 #8355.png" , "Dasher/Idle_2 #8814.png" , "Dasher/Idle_3 #8452.png" , "Dasher/Idle_4 #8313.png" , "Dasher/Idle_5 #8302.png" )) , 3 , 5) ,
    Lilith(new ArrayList<>(Arrays.asList("Lilith/Idle_0 #8333.png" , "Lilith/Idle_1 #8363.png" , "Lilith/Idle_2 #8822.png" , "Lilith/Idle_3 #8460.png" , "Lilith/Idle_4 #8321.png" , "Lilith/Idle_5 #8310.png")) , 5 ,  3),
    Scarlet(new ArrayList<>(Arrays.asList("Scarlet/Idle_0.png" , "Scarlet/Idle_1 #8354.png" , "Scarlet/Idle_2 #8813.png" , "Scarlet/Idle_3.png" , "Scarlet/Idle_4.png" , "Scarlet/Idle_5.png")) , 2 , 10);
    public final ArrayList<String> AnimationAdreeses;
    public final int Hp;
    public final int Speed;

    Heros(ArrayList<String> animationAdreeses, int hp, int speed) {
        AnimationAdreeses = animationAdreeses;
        Hp = hp;
        Speed = speed;
    }
}
