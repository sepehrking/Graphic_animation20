package com.Tilldawn.View;

import com.Tilldawn.Controller.GameMenuController;
import com.Tilldawn.Main;
import com.Tilldawn.model.App;
import com.Tilldawn.model.GameAssets;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameMenu implements Screen {
    private OrthographicCamera camera;
    private GameMenuController controller;
    private Stage stage;

    public GameMenu(GameMenuController controller) {
        this.controller = controller;
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    @Override

    public void show() {
        for(int i = 0;i < App.ReturnCurrentGame().NUmberOfTreeMonsters ; i++) {
            controller.getEnemyController().getTreecontroller().CreateTree();
        }
        for(int i = 0;i <10 ; i++)
        {
            controller.getEnemyController().getTenteacontroller().CreateTentacleMonster();
        }
        camera.position.set(Gdx.graphics.getWidth()/2f, Gdx.graphics.getHeight()/2f, 0);
        camera.update();
        Table table = new Table();
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        table.setFillParent(true);
        table.center();
        table.add(new Label("STart Game" , GameAssets.getInstance().getSkin()));
        stage.addActor(table);
    }

    @Override
    public void render(float v) {
        App.ReturnCurrentGame().getTotalTime()
        float heroX = controller.getPlayer().getPosX();
        float heroY = controller.getPlayer().getPosY();
        camera.position.set(heroX, heroY, 0);
        camera.update();
        ScreenUtils.clear(0 , 0 , 0 , 1);
        Main.getBatch().setProjectionMatrix(camera.combined);
        Main.getBatch().begin();
        controller.Update(v);
        Main.getBatch().end();
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
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
