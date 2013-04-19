package screens;
import level.Level;
import gesturelistener.ExplorerGestureListener;
import image.Image;
import inputprocessor.ExplorerInputProcessor;
import nl.am1a.kingsvalley1.KingsValley;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;

import explorer.Explorer;

public class PlayScreen implements Screen{

	//Fields
	private KingsValley game;
	private Explorer explorer;
	private OrthographicCamera camera;
	private Vector2 mousePointer;
	private Level level;
	private float ratio,zoom = 480f;
	
	//Properties
	public Explorer getExplorer()
	{
		return this.explorer;
	}
	public void setExplorer(Explorer explorer)
	{
		this.explorer = explorer;
	}
	public void setMousePointer(Vector2 mousePointer)
	{		
		this.mousePointer = mousePointer;
	}
	
	//Constructor
	public PlayScreen(KingsValley game)
	{
		this.game = game;
		this.explorer = new Explorer(this.game, new Vector2(100f,0f), 1f);
		this.level = new Level(this.game,0);
		this.ratio = Gdx.graphics.getWidth() / Gdx.graphics.getHeight();
		camera = new OrthographicCamera();
		camera.setToOrtho(true,this.ratio*this.zoom,this.zoom);
		camera.position.set(544/2f,480/2f,0f);
		
		
	}
	
	@Override
	public void render(float delta) {
		this.explorer.Update(delta);
		this.game.getBatch().setProjectionMatrix(camera.combined);
		this.game.getBatch().begin();
		this.level.Draw(delta);
		this.explorer.Draw(delta);
		this.game.getBatch().end();
	}

	@Override
	public void resize(int width, int height)
	{		
	}

	@Override
	public void show() {		
				
		camera.update();
		//Gdx.app.log("show", "Ik wordt een keer aangeroepen");
	}

	@Override
	public void hide() {		
	}

	@Override
	public void pause() {		
	}

	@Override
	public void resume() {		
	}

	@Override
	public void dispose() {		
	}

}
