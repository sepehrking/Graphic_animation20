package com.Tilldawn.Controller;

import com.Tilldawn.Main;
import com.Tilldawn.View.*;

public class MainMenuController {
    private MainMenu mainMenu;

    public void setMainMenu(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

    public void ApplyScreen() {
        if(mainMenu.getSetting().isChecked())
        {
            Main.getMain().setScreen(new SettingMenu(new SettingController()));
        }
        if(mainMenu.getPregameMenu().isChecked())
        {
            Main.getMain().setScreen(new PreGameMenu(new PreGameMenucontroller()));
        }
        if(mainMenu.getScoreBoard().isChecked())
        {

        }
        if(mainMenu.getProfile().isChecked())
        {
            Main.getMain().setScreen(new ProfileMenu(new ProfileMenuController()));
        }
        if(mainMenu.getTalents().isChecked())
        {

        }
        if(mainMenu.getStartGame().isChecked())
        {
            Main.getMain().setScreen(new GameMenu(new GameMenuController()));
        }
    }
}
