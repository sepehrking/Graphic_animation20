package com.Tilldawn.Controller;

import com.Tilldawn.Main;
import com.Tilldawn.View.GameMenu;
import com.Tilldawn.View.LoginMenu;
import com.Tilldawn.View.SignupMenu;
import com.Tilldawn.View.StartMenu;
import com.Tilldawn.model.App;
import com.Tilldawn.model.Game;
import com.badlogic.gdx.Gdx;

public class StartMenuController {
    private StartMenu startMenu;

    public void setStartMenu(StartMenu startMenu) {
        this.startMenu = startMenu;
    }

    public void CheckScreen()
    {
        if(startMenu.getGuest().isChecked())
        {
            Game newgame = new Game();
            App.Games.add(newgame);
            App.UserLoginId = App.Users.size();
            Main.getMain().setScreen(new GameMenu(new GameMenuController()));
        }
        if(startMenu.getExit().isChecked())
        {
            Gdx.app.exit();
        }
        if(startMenu.getSignup().isChecked())
        {

            Main.getMain().setScreen(new SignupMenu(new SignUpcontroller()));
        }
        if(startMenu.getLogin().isChecked())
        {
            Main.getMain().setScreen(new LoginMenu(new LoginController()));
        }
    }
}
