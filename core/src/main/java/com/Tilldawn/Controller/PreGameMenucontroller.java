package com.Tilldawn.Controller;

import com.Tilldawn.Main;
import com.Tilldawn.View.MainMenu;
import com.Tilldawn.View.PreGameMenu;
import com.Tilldawn.model.App;
import com.Tilldawn.model.Enums.Heros;
import com.Tilldawn.model.Enums.Weopens;

public class PreGameMenucontroller {
    private PreGameMenu preGameMenu;

    public void setPreGameMenu(PreGameMenu preGameMenu) {
        this.preGameMenu = preGameMenu;
    }

    public void ApplyScrren()
    {
        String SelectedHero = preGameMenu.getSelectHero().getSelected();
        for(Heros hero : Heros.values())
        {
            if(SelectedHero.equals(hero.toString()))
            {
                App.Games.get(App.UserLoginId).setHero(hero);
            }

        }
        String Selectweopen = preGameMenu.getSelectWeaopen().getSelected();
        for(Weopens weopen : Weopens.values())
        {
            if(Selectweopen.equals(weopen.toString()))
            {
                App.Games.get(App.UserLoginId).setWeopen(weopen);
            }
        }

        String SelectedTime = preGameMenu.getSelectTime().getSelected();
        if(SelectedTime.equals("2 MIn"))
        {
            App.ReturnCurrentGame().setTotalTime(120);
        }
        if(SelectedTime.equals("5 Min"))
        {
            App.ReturnCurrentGame().setTotalTime(300);
        }
        if(SelectedTime.equals("10 Min"))
        {
            App.ReturnCurrentGame().setTotalTime(600);
        }
        if(SelectedTime.equals("20 Min"))
        {
            App.ReturnCurrentGame().setTotalTime(1200);
        }
        if(preGameMenu.getBack().isChecked())
        {
            Main.getMain().setScreen(new MainMenu(new MainMenuController()));
        }
    }

}
