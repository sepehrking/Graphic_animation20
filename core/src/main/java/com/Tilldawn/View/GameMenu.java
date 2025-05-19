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
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameMenu implements Screen {
    private OrthographicCamera camera;
    private GameMenuController controller;
    private Stage stage;
    private Label HpLabel;
    private Label Time;
    private Table table = new Table();
    private Table PauseMenu = new Table();
    private Table ChooseAbilityTable = new Table();
    private TextButton FirstAbility;
    private TextButton SecondAbility;
    private TextButton ThirdAbility;

    public OrthographicCamera getCamera() {
        return camera;
    }

    public Table getPauseMenu() {
        return PauseMenu;
    }

    public Table getChooseAbilityTable() {
        return ChooseAbilityTable;
    }

    public TextButton getFirstAbility() {
        return FirstAbility;
    }

    public Table getTable() {
        return table;
    }

    public TextButton getSecondAbility() {
        return SecondAbility;
    }

    public TextButton getThirdAbility() {
        return ThirdAbility;
    }

    public GameMenu(GameMenuController controller) {
        this.controller = controller;
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        HpLabel = new Label("Hp :  " + 10 , GameAssets.getInstance().getSkin());
        Time = new Label("Time :  " + 10 , GameAssets.getInstance().getSkin());
        FirstAbility = new TextButton("First Ability", GameAssets.getInstance().getSkin());
        SecondAbility = new TextButton("Second Ability", GameAssets.getInstance().getSkin());
        ThirdAbility = new TextButton("Third Ability", GameAssets.getInstance().getSkin());
        controller.setGameMenu(this);
    }

    @Override

    public void show() {
        stage = new Stage();
        table.setFillParent(true);
        ChooseAbilityTable.setFillParent(true);
        PauseMenu.setFillParent(true);
        table.setVisible(true);
        ChooseAbilityTable.setVisible(false);
        PauseMenu.setVisible(false);
        ChooseAbilityTable.add(FirstAbility);
        ChooseAbilityTable.padLeft(30);
        ChooseAbilityTable.add(SecondAbility);
        ChooseAbilityTable.padLeft(30);
        ChooseAbilityTable.add(ThirdAbility);
        stage.addActor(ChooseAbilityTable);
        for(int i = 0;i < App.ReturnCurrentGame().NUmberOfTreeMonsters ; i++) {
            controller.getEnemyController().getTreecontroller().CreateTree();
        }
        camera.position.set(Gdx.graphics.getWidth()/2f, Gdx.graphics.getHeight()/2f, 0);
        camera.update();
        Gdx.input.setInputProcessor(stage);
        table.setFillParent(true);
        table.top().left().padTop(20).padLeft(20);
        table.add(HpLabel);
        table.row();
        table.add(Time);
        stage.addActor(table);
    }

    @Override
    public void render(float v) {
        HpLabel.setText("Hp :  " + App.ReturnCurrentGame().getPlayer().getHp());
        Time.setText("Time :  " + App.ReturnCurrentGame().getTimer().getTime());
        /*if(App.ReturnCurrentGame().getPlayer().getHp() < 0)
        {
            Gdx.app.exit();
        }*/
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
