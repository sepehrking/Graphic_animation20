package com.Tilldawn.Controller;

import com.Tilldawn.Main;
import com.Tilldawn.View.GameMenu;
import com.Tilldawn.View.LoginMenu;
import com.Tilldawn.View.StartMenu;
import com.Tilldawn.model.App;
import com.badlogic.gdx.Gdx;

public class LoginController {

    LoginMenu loginMenu;

    public void setLoginMenu(LoginMenu loginMenu) {
        this.loginMenu = loginMenu;
    }

    public void CheckScreen()
    {
        if(loginMenu.getExitButton().isChecked())
        {
            Main.getMain().setScreen(new StartMenu(new StartMenuController()));
        }
        if(loginMenu.getLoginButton().isChecked())
        {
            if(App.returnUserindex(loginMenu.getUsernameField().getText()) == -1)
            {
                loginMenu.getErrorLabel().setText("Username Doesnt Exist");
            }
            else
            {
                int index = App.returnUserindex(loginMenu.getUsernameField().getText());
                if(!App.Users.get(index).getPassword().equals(loginMenu.getPasswordField().getText()))
                {
                    loginMenu.getErrorLabel().setText("Wrong Password");
                }
                else
                {
                    App.UserLoginId = index;
                    Main.getMain().setScreen(new GameMenu(new GameMenuController()));
                }
            }
        }
        loginMenu.getLoginButton().setChecked(false);
    }

}
