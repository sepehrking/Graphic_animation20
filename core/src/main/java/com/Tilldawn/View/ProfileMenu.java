package com.Tilldawn.View;

import com.Tilldawn.Controller.ProfileMenuController;
import com.Tilldawn.Main;
import com.Tilldawn.model.GameAssets;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;


public class ProfileMenu implements Screen {
    private ProfileMenuController controller;
    private Stage stage;
    private TextField ChangUsername;
    private TextField ChangePassword;
    private ArrayList<ImageButton> Avatarbuttons;
    private TextButton ApplyChangeUsername;
    private TextButton ApplyChangePassword;
    private TextButton BackButton;
    private TextButton DeleteAccount;
    private Label UsernameLogMassage;
    private Label PasswordLogMassage;

    public ProfileMenu(ProfileMenuController controller) {
        this.controller = controller;
        ChangUsername = new TextField("New Username" , GameAssets.getInstance().getSkin());
        ChangePassword = new TextField("New Password" , GameAssets.getInstance().getSkin());
        ApplyChangeUsername = new TextButton("Apply", GameAssets.getInstance().getSkin());
        ApplyChangePassword = new TextButton("Apply", GameAssets.getInstance().getSkin());
        BackButton = new TextButton("Back", GameAssets.getInstance().getSkin());
        DeleteAccount = new TextButton("Delete Account", GameAssets.getInstance().getSkin());
        Avatarbuttons = GameAssets.getInstance().getbuttons();
        controller.setProfileMenu(this);
        UsernameLogMassage = new Label("", GameAssets.getInstance().getSkin());
        PasswordLogMassage = new Label("", GameAssets.getInstance().getSkin());
    }

    public Label getUsernameLogMassage() {
        return UsernameLogMassage;
    }

    public Label getPasswordLogMassage() {
        return PasswordLogMassage;
    }

    public ProfileMenuController getController() {
        return controller;
    }

    public TextButton getDeleteAccount() {
        return DeleteAccount;
    }

    public TextButton getBackButton() {
        return BackButton;
    }

    public TextButton getApplyChangePassword() {
        return ApplyChangePassword;
    }

    public TextButton getApplyChangeUsername() {
        return ApplyChangeUsername;
    }

    public ArrayList<ImageButton> getAvatarbuttons() {
        return Avatarbuttons;
    }

    public TextField getChangePassword() {
        return ChangePassword;
    }

    public TextField getChangUsername() {
        return ChangUsername;
    }

    @Override
    public void show() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        Table LeftTable = new Table();
        LeftTable.setFillParent(true);
        LeftTable.left().top().padLeft(50).padLeft(70);
        LeftTable.add(ChangUsername).width(300);
        LeftTable.padLeft(10);
        LeftTable.add(ApplyChangeUsername);
        LeftTable.padLeft(10);
        LeftTable.add(UsernameLogMassage);
        LeftTable.row().padTop(20);
        LeftTable.add(ChangePassword).width(300);
        LeftTable.padLeft(10);
        LeftTable.add(ApplyChangePassword);
        LeftTable.padLeft(10);
        LeftTable.add(PasswordLogMassage);
        LeftTable.row().padTop(20);
        for(int i = 0;i < Avatarbuttons.size();i++) {

            LeftTable.add(Avatarbuttons.get(i)).width(70).height(70);
            LeftTable.row().padTop(10);
        }
        stage.addActor(LeftTable);
        Table RightTable = new Table();
        RightTable.setFillParent(true);
        RightTable.right().top().padRight(50).padLeft(70);
        RightTable.add(DeleteAccount);
        RightTable.padTop(700);
        RightTable.add(BackButton);
        stage.addActor(RightTable);
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0 , 0 , 0 , 1);
        Main.getBatch().begin();
        Main.getBatch().end();
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
        controller.ApplyScreen();
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
