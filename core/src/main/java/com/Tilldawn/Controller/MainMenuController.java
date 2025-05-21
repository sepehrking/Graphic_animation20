package com.Tilldawn.Controller;

import com.Tilldawn.Main;
import com.Tilldawn.View.*;
import com.Tilldawn.model.App;

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
            Main.getMain().setScreen(new ScoreBoardMenu());
        }
        if(mainMenu.getProfile().isChecked())
        {
            Main.getMain().setScreen(new ProfileMenu(new ProfileMenuController()));
        }
        if(mainMenu.getTalents().isChecked())
        {
            Main.getMain().setScreen(new TalentMenu(new TalentContoller()));
        }
        if(mainMenu.getStartGame().isChecked())
        {
            Main.getMain().setScreen(new GameMenu(new GameMenuController()));
        }
        if(mainMenu.getLogout().isChecked())
        {
            App.UserLoginId = -1;
            Main.getMain().setScreen(new StartMenu(new StartMenuController()));
        }
    }
}
