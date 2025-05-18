package com.Tilldawn.Controller;

import com.Tilldawn.View.ProfileMenu;
import com.Tilldawn.model.App;
import com.Tilldawn.model.Enums.Avatars;

public class ProfileMenuController {
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
        for(int i =  0;i < profileMenu.getAvatarbuttons().size();i++) {
            if (profileMenu.getAvatarbuttons().get(i).isChecked()) {
                nowAvatar =  i;
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
    }

}
