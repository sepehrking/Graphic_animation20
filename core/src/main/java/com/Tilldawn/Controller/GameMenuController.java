package com.Tilldawn.Controller;

import com.Tilldawn.Controller.ModelsController.BulletController;
import com.Tilldawn.Controller.ModelsController.EnemyController;
import com.Tilldawn.Controller.ModelsController.PlayerController;
import com.Tilldawn.View.GameMenu;
import com.Tilldawn.model.App;
import com.Tilldawn.model.Enemy;
import com.Tilldawn.model.Player;

public class GameMenuController {
    private Player player;
    private PlayerController playerController;
    private GirdController girdController;
    private EnemyController enemyController;
    private GameMenu gameMenu;
    private BulletController bulletController;


    public EnemyController getEnemyController() {
        return enemyController;
    }

    public GameMenuController() {
        playerController = new PlayerController();
        enemyController = new EnemyController();
        //playerController.setPlayer();
        player = new Player();
        App.ReturnCurrentGame().setPlayer(player);
        girdController = new GirdController(player);
        playerController.setPlayer(player , girdController);
    }

    public Player getPlayer() {
        return player;
    }

    public void Update(float Delta)
    {
        girdController.update();
        playerController.Update();
        for(Enemy enemy : App.ReturnCurrentGame().getEnemies())
        {
            enemyController.Update(enemy , Delta);
        }
    }
}
