package com.Tilldawn.Controller;

import com.Tilldawn.Main;
import com.Tilldawn.View.MainMenu;
import com.Tilldawn.View.PreGameMenu;
import com.Tilldawn.model.App;
import com.Tilldawn.model.Enums.Heros;

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
        if(preGameMenu.getBack().isChecked())
        {
            Main.getMain().setScreen(new MainMenu(new MainMenuController()));
        }
    }

}
