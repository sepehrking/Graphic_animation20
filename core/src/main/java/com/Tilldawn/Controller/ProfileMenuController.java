package com.Tilldawn.Controller;

import com.Tilldawn.Main;
import com.Tilldawn.View.MainMenu;
import com.Tilldawn.View.ProfileMenu;
import com.Tilldawn.View.StartMenu;
import com.Tilldawn.model.App;
import com.Tilldawn.model.Enums.Avatars;

public class ProfileMenuController {
    private SignUpcontroller signUpcontroller = new SignUpcontroller();
    private ProfileMenu profileMenu;
    int nowAvatar;
    public void setProfileMenu(ProfileMenu profileMenu) {
        this.profileMenu = profileMenu;
        int count = 0;
        for(Avatars avatar : Avatars.values()) {
            if(avatar == App.Users.get(App.UserLoginId).getAvatar()) {
                nowAvatar = count;
            }
            count++;
        }
    }

    public int getNowAvatar() {
        return nowAvatar;
    }

    public void ApplyScreen()
    {
        if(profileMenu.getBackButton().isChecked())
        {
            Main.getMain().setScreen(new MainMenu(new MainMenuController()));
        }
        for(int i =  0;i < profileMenu.getAvatarbuttons().size();i++) {
            if (profileMenu.getAvatarbuttons().get(i).isChecked()) {
                nowAvatar =  i;
                App.ReturnCurrentUser().setAvatar(Avatars.values()[i]);
            }
            profileMenu.getAvatarbuttons().get(i).setChecked(false);
        }
        for(int i =  0;i < profileMenu.getAvatarbuttons().size();i++) {
            if(i == nowAvatar) {
                profileMenu.getAvatarbuttons().get(i).getImage().setColor(1f ,1f ,1f, 1f);
            }
            else
            {
                profileMenu.getAvatarbuttons().get(i).getImage().setColor(0.3f, 0.3f, 0.3f, 1f);
            }
        }
        if(profileMenu.getApplyChangeUsername().isChecked()) {
            if(App.returnUserindex(profileMenu.getChangUsername().getText()) == -1) {
                App.ReturnCurrentUser().setUseranme(profileMenu.getChangUsername().getText());
                profileMenu.getUsernameLogMassage().setText("Username changed succesfully");
            }
            else
            {
                profileMenu.getUsernameLogMassage().setText("Username already Exist");
            }
            profileMenu.getApplyChangeUsername().setChecked(false);
        }
        if(profileMenu.getApplyChangePassword().isChecked()) {
            if(signUpcontroller.CheckPass(profileMenu.getChangePassword().getText())) {
                App.ReturnCurrentUser().setPassword(profileMenu.getChangePassword().getText());
                profileMenu.getPasswordLogMassage().setText("Password changed succesfully");
            }
            else
            {
                profileMenu.getPasswordLogMassage().setText("Password is weak");
            }
            profileMenu.getApplyChangePassword().setChecked(false);
        }
        if(profileMenu.getDeleteAccount().isChecked()) {
            App.Users.remove(App.UserLoginId);
            App.Games.remove(App.UserLoginId);
            App.UserLoginId = -1;
            Main.getMain().setScreen(new StartMenu(new StartMenuController()));
        }
    }

}
