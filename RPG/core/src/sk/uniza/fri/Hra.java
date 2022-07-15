package sk.uniza.fri;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Hra extends ApplicationAdapter {
	private static final int WIDTH = 28;
	private static final int HEIGHT = 15;
	public static final int BLOCK_SIZE = 1;
	private SpriteBatch batch;
	private Texture pozadie;
	private Hrac hrac;
	private int X = 320;
	private int Y = 240;
	private Camera camera;
	private Viewport viewport;
	private ManagerOfSources managerOfSources;
	private Mapa mapa;
	
	@Override
	public void create () {
		this.camera = new OrthographicCamera();
		this.viewport = new FitViewport(Hra.WIDTH, Hra.HEIGHT, this.camera);
		this.mapa = new Mapa(this.managerOfSources, this.batch);
		this.batch = new SpriteBatch();
		this.managerOfSources = new ManagerOfSources();
		this.hrac = new Hrac(TypPolicka.HERO_2, this.managerOfSources);
	}

	@Override
	public void render () {
		ScreenUtils.clear(Color.BLACK);
		batch.begin();
		//this.mapa.vytvorMapu(); zatial nefunguje
		this.hrac.nakresliHraca(this.batch);
		this.hrac.pohyb(this.managerOfSources);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		this.viewport.update(width, height, true);
		this.batch.setProjectionMatrix(this.camera.combined);
	}

	@Override
	public void dispose () {
		this.batch.dispose();
	}
}
