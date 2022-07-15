package sk.uniza.fri;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import sk.uniza.fri.enumy.TypPolicka;
import sk.uniza.fri.manazer.ManagerOfSources;
import sk.uniza.fri.mapa.Mapa;
import sk.uniza.fri.objekty.Objekty;
import sk.uniza.fri.objekty.mapa.Portal;
import sk.uniza.fri.objekty.postavy.Hrac;

import javax.swing.JOptionPane;

public class Hra extends ApplicationAdapter {
    private static final int WIDTH = 28;
    private static final int HEIGHT = 15;
    public static final int BLOCK_SIZE = 1;
    private SpriteBatch batch;
    private Texture pozadie;
    private Hrac hrac;
    private Camera camera;
    private Viewport viewport;
    private ManagerOfSources managerOfSources;
    private Mapa mapa;
    private int level = 1;

    @Override
    public void create() {
        this.camera = new OrthographicCamera();
        this.viewport = new FitViewport(Hra.WIDTH, Hra.HEIGHT, this.camera);
        this.batch = new SpriteBatch();
        this.managerOfSources = new ManagerOfSources();
        this.mapa = new Mapa(this.managerOfSources, this.batch);
        this.hrac = new Hrac(TypPolicka.HERO_2, this.managerOfSources);
        this.mapa.vytvorMapu(1);
        this.mapa.vytvorMapu(2);
        this.mapa.vytvorMapu(3);
    }

    @Override
    public void render() {
        ScreenUtils.clear(Color.BLACK);
        batch.begin();
        this.mapa.nakresliMapu(level);
        this.hrac.nakresliHraca(this.batch);
        Array<Objekty> o = new Array<>();
        switch (level) {
            case 1:
                o = this.mapa.getPrvaMiestnost().getInteraktivneObjekty();
                break;
            case 2:
                o = this.mapa.getDruhaMiestnost().getInteraktivneObjekty();
                break;
            case 3:
                o = this.mapa.getTretiaMiestnost().getInteraktivneObjekty();
                break;
        }
        for (Objekty objekty : o) {
            if (objekty.kolizia(this.hrac)) {
                objekty.interakcia(this.hrac);
                if (objekty instanceof Portal) {
                    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
                    if (level < 3) {
                        level++;
                    } else {
                        JOptionPane.showMessageDialog(null, "koniec hry");
                        Gdx.app.exit();
                    }
                }
            }
        }
        this.hrac.pohyb(this.managerOfSources);

        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        this.viewport.update(width, height, true);
        this.batch.setProjectionMatrix(this.camera.combined);
    }

    @Override
    public void dispose() {
        this.batch.dispose();
    }
}
