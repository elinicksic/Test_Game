package dev.Dolphinbob.ppm.entity.creature;

import java.awt.Graphics;

import dev.Dolphinbob.ppm.Game;
import dev.Dolphinbob.ppm.gfx.Assets;

public class Player extends Creature{
	public Player(Game game, float x, float y) {
		super(game, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
	}

	public void tick() {
		getInput();
		move();
		game.getGameCamera().centerOnEntity(this);
	}
	
	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		if(game.getKeyManager().up){
			yMove = -speed;
		}
		if(game.getKeyManager().down){
			yMove = speed;
		}
		if(game.getKeyManager().left){
			xMove = -speed;
		}
		if(game.getKeyManager().right){
			xMove = speed;
		}
		
	}

	public void render(Graphics g) {
		g.drawImage(Assets.player, (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), width, height, null);
	}

}
