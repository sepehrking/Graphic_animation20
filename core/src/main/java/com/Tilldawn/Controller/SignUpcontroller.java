package com.Tilldawn.Controller;

import com.Tilldawn.Main;
import com.Tilldawn.View.MainMenu;
import com.Tilldawn.View.SignupMenu;
import com.Tilldawn.View.StartMenu;
import com.Tilldawn.model.App;
import com.Tilldawn.model.Enums.Avatars;
import com.Tilldawn.model.Game;
import com.Tilldawn.model.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpcontroller {
    private SignupMenu menu;
    public void SetMenu(SignupMenu menu) {
        this.menu = menu;
    }
    public boolean CheckPass(String Pass)
    {
        String Passrejex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@%$#&*_]).+$";
        Pattern pattern = Pattern.compile(Passrejex);
        Matcher matcher = pattern.matcher(Pass);
        if(Pass.length() < 8)
        {
            return false;
        }
        return matcher.matches();
    }
    public boolean CheckUserAlreadyBeTaken(String Username)
    {
        return App.returnUserindex(Username) != -1;
    }
    public void CheckScreen()
    {
        if(menu.getExit().isChecked())
        {
            Main.getMain().setScreen(new StartMenu(new StartMenuController()));
        }
        if(menu.getConfirmButton().isChecked())
        {
            if(menu.getUsernameField().getText().equals(""))
            {
                menu.getErrorMassage().setText("User name field is empty");
            }
            else
            {
                if(menu.getPasswordField().getText().equals(""))
                {
                    menu.getErrorMassage().setText("Password field is empty");
                }
                else
                {
                    if(menu.getSequrityFeild().getText().equals(""))
                    {
                        menu.getErrorMassage().setText("Sequrity field is empty");
                    }
                    else
                    {
                        if(CheckUserAlreadyBeTaken(menu.getUsernameField().getText()))
                        {
                            menu.getErrorMassage().setText("Username already exists");
                        }
                        else {
                            if (!CheckPass(menu.getPasswordField().getText())) {
                                menu.getErrorMassage().setText("Password field is weak");
                            } else {
                                ApplySignup();
                            }
                        }
                    }
                }
            }
        }
        menu.getConfirmButton().setChecked(false);
    }
    public void ApplySignup()
    {
        App.Users.add(new User(menu.getUsernameField().getText(), menu.getPasswordField().getText(), menu.getSequrityFeild().getText()));
        App.Games.add(new Game());
        App.UserLoginId = App.Users.size() - 1;
        int RandomAvatar = App.rand.nextInt(Avatars.values().length);
        App.ReturnCurrentUser().setAvatar(Avatars.values()[RandomAvatar]);
        Main.getMain().setScreen(new MainMenu(new MainMenuController()));
    }
}
