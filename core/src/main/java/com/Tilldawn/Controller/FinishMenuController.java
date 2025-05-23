package com.Tilldawn.Controller;

import com.Tilldawn.Main;
import com.Tilldawn.View.FinishMenu;
import com.Tilldawn.View.MainMenu;

public class FinishMenuController {
    private FinishMenu finishMenu;

    public void setFinishMenu(FinishMenu finishMenu) {
        this.finishMenu = finishMenu;
    }

    public void Update()
    {
        if(finishMenu.getGoback().isChecked()) {
            Main.getMain().setScreen(new MainMenu(new MainMenuController()));
        }
    }

}
