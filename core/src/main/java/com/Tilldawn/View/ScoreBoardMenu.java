package com.Tilldawn.View;

import com.Tilldawn.Main;
import com.Tilldawn.model.App;
import com.Tilldawn.model.GameAssets;
import com.Tilldawn.model.User;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.*;
import java.util.List;


public class ScoreBoardMenu implements Screen {
    private Stage stage;
    private SelectBox<String> sortBox;
    private Table userTable;

    public ScoreBoardMenu() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        Table root = new Table();
        root.setFillParent(true);
        stage.addActor(root);

        sortBox = new SelectBox<>(GameAssets.getInstance().getSkin());
        sortBox.setItems("By Kills", "By Points", "By Username", "By Time Alive");
        root.add(sortBox).pad(10).row();
        userTable = new Table();
        userTable.defaults().pad(5);
        root.add(userTable).expand().top().left().padTop(20);

        sortBox.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                updateTable();
            }
        });

        updateTable();
    }

    private void updateTable() {
        userTable.clearChildren();
        userTable.add(new Label("Username" , GameAssets.getInstance().getSkin()));
        userTable.add(new Label("Kills" , GameAssets.getInstance().getSkin()));
        userTable.add(new Label("Points" , GameAssets.getInstance().getSkin()));
        userTable.add(new Label("Time Alive" , GameAssets.getInstance().getSkin()));
        userTable.row();
        List<User> sortedUsers = GameAssets.getInstance().GETUSERS();

        switch (sortBox.getSelected()) {
            case "By Kills":
                sortedUsers.sort(Comparator.comparingInt(User::getKill).reversed());
                break;
            case "By Points":
                sortedUsers.sort(Comparator.comparingInt(User::getPoint).reversed());
                break;
            case "By Username":
                sortedUsers.sort(Comparator.comparing(User::getUseranme));
                break;
            case "By Time Alive":
                sortedUsers.sort(Comparator.comparingInt(User::getMostTimeAlive).reversed());
                break;
        }
        int limit = Math.min(10, sortedUsers.size());
        for (int i = 0; i < limit; i++) {
            Color GOLD   = new Color(1f, 0.84f, 0f, 1f);     // RGB for Gold
            Color SILVER = new Color(0.75f, 0.75f, 0.75f, 1f); // RGB for Silver
            Color BRONZE = new Color(0.8f, 0.5f, 0.2f, 1f);
            Color color = new Color(1f , 1f  , 1f , 1f);
            if(i == 0)
            {
                color = GOLD;
            }
            if(i == 1)
            {
                color = SILVER;
            }
            if(i == 2)
            {
                color = BRONZE;
            }
            User user = sortedUsers.get(i);
            userTable.add(new Label(user.getUseranme() , new Label.LabelStyle(new BitmapFont(), color))).left();
            userTable.add(new Label(String.valueOf(user.getKill()) , new Label.LabelStyle(new BitmapFont() , color))).left();
            userTable.add(new Label(String.valueOf(user.getPoint()) ,new Label.LabelStyle(new BitmapFont(), color)));
            userTable.add(new Label(String.valueOf(user.getMostTimeAlive()) , new Label.LabelStyle(new BitmapFont(), color))).left();
            if(user == App.ReturnCurrentUser())
            {
                userTable.add(new Label("<------------" , new Label.LabelStyle(new BitmapFont(), color))).left();
            }
            userTable.row();
        }
    }

    @Override
    public void show() {}

    @Override
    public void render(float v) {
        ScreenUtils.clear(0 , 0 , 0 , 1);
        Main.getBatch().begin();
        Main.getBatch().end();
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {
    }
}
