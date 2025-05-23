package com.Tilldawn.model;

import java.util.ArrayList;
import java.util.Random;

public class App {
    public static Random rand = new Random();
    public static ArrayList<User> Users = new ArrayList<>();
    public static ArrayList<Game> Games = new ArrayList<>();
    public static int UserLoginId = -1;

    public static Game ReturnCurrentGame()
    {
        return Games.get(UserLoginId);
    }

    public static int returnUserindex(String Username)
    {
        int count = 0;
        for(User user : Users)
        {
            if(user.getUseranme().equals(Username))
            {
                return count;
            }
            count++;
        }
        return -1;
    }

    public static  User ReturnCurrentUser()
    {
        return Users.get(UserLoginId);
    }

    public static void UpdateGame()
    {
        User ouruser = Users.get(UserLoginId);
        ouruser.setPoint(ouruser.getPoint() +  (int) (App.ReturnCurrentGame().getPlayer().getKills() * App.ReturnCurrentGame().getTimer().getTime()));
        ouruser.setKill(ouruser.getKill() + App.ReturnCurrentGame().getPlayer().getKills());
        ouruser.setMostTimeAlive(Math.max(ouruser.getMostTimeAlive() , (int)App.ReturnCurrentGame().getTimer().getTime()));
    }

    public static float Difreence(float X1 , float Y1 , float X2 , float Y2)
    {
        float ans = 0;
        if(X1 > X2)
        {
            ans += X1 - X2;
        }
        else
        {
            ans += X2 - X1;
        }
        if(Y1 > Y2)
        {
            ans += Y1 - Y2;
        }
        else
        {
            ans += Y2 - Y1;
        }
        return ans;
    }


}
