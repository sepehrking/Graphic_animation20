package com.Tilldawn.Controller;

import com.Tilldawn.Main;
import com.Tilldawn.View.MainMenu;
import com.Tilldawn.View.SettingMenu;
import com.Tilldawn.model.App;
import com.Tilldawn.model.AudioManager;

public class SettingController {
    SettingMenu settingMenu;

    public void setSettingMenu(SettingMenu settingMenu) {
        this.settingMenu = settingMenu;
    }

    public void ApplyScrren()
    {
        if(settingMenu.getEXIT().isChecked())
        {
            Main.getMain().setScreen(new MainMenu(new MainMenuController()));
        }
        App.ReturnCurrentGame().getPregame().setSFX(settingMenu.getSfxChecker().isChecked());
        App.ReturnCurrentGame().getPregame().setAutoReload(settingMenu.getAutoReload().isChecked());
        //App.ReturnCurrentGame().getPregame().setVoulume(settingMenu.getVoloumSlider().getValue());
        AudioManager.Volume = settingMenu.getVoloumSlider().getValue();
        AudioManager.PlayedMusic.setVolume(settingMenu.getVoloumSlider().getValue());
    }

}
