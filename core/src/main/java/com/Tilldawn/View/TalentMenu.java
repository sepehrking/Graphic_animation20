package com.Tilldawn.View;

import com.Tilldawn.Controller.TalentContoller;
import com.Tilldawn.Main;
import com.Tilldawn.model.GameAssets;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

public class TalentMenu implements Screen{
    private Stage stage;
    private TalentContoller contoller;
    private TextButton ExitButton;

    public TalentMenu(TalentContoller contoller) {
        this.contoller = contoller;
        contoller.setTalentMenu(this);
        ExitButton = new TextButton("Exit" , GameAssets.getInstance().getSkin());

    }

    @Override
    public void show() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        Table HEROTable = new Table();
        HEROTable.setFillParent(true);
        //HEROTable.setPosition(Gdx.graphics.getWidth()/5, Gdx.graphics.getHeight()/5);
        HEROTable.left().top();
        HEROTable.add(new Label("Character" , GameAssets.getInstance().getSkin())).pad(30).left();
        HEROTable.add(new Label("Hp" , GameAssets.getInstance().getSkin())).pad(30).left();
        HEROTable.add(new Label("Speed" , GameAssets.getInstance().getSkin())).pad(30).left();
        HEROTable.row();
        Array<Integer> speeds = GameAssets.getInstance().getspeeds();
        Array<Integer> hp = GameAssets.getInstance().getspeeds();
        Array<String> Heroes = GameAssets.getInstance().getHeros();
        for(int i = 0 ; i < speeds.size; i++){
            HEROTable.add(new Label(Heroes.get(i), GameAssets.getInstance().getSkin())).left();
            HEROTable.add(new Label(hp.get(i).toString() , GameAssets.getInstance().getSkin())).pad(5).left();
            HEROTable.add(new Label(speeds.get(i).toString() , GameAssets.getInstance().getSkin())).pad(5).left();
            HEROTable.row();
        }

        Table AbilityTable = new Table();
        AbilityTable.setFillParent(true);

        Array<String> Abilites = new Array<>();
        Abilites.add("Vitality");Abilites.add("Speedy");Abilites.add("AmmoCrease");Abilites.add("Damager");Abilites.add("TileIncrease");
        Array<String> Description = new Array<>();
        Description.add("Increase Hp");Description.add("Make Speed 2x");Description.add("Max Ammo Increase 5");Description.add("Make weopen_damage 125%");Description.add("BulletTileCover Increase 1");
        AbilityTable.setPosition(Gdx.graphics.getWidth()/5, Gdx.graphics.getHeight()/5);
        AbilityTable.add(new Label("Ability" , GameAssets.getInstance().getSkin())).pad(10).left();
        AbilityTable.add(new Label("Description" , GameAssets.getInstance().getSkin()));
        AbilityTable.row();
        for(int i = 0;i < Description.size; i++){
            AbilityTable.add(new Label(Abilites.get(i), GameAssets.getInstance().getSkin())).pad(10).left();
            AbilityTable.add(new Label(Description.get(i), GameAssets.getInstance().getSkin()));
            AbilityTable.row();
        }
        stage.addActor(AbilityTable);
        stage.addActor(HEROTable);
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0 , 0 , 0 , 1);
        Main.getBatch().begin();
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
