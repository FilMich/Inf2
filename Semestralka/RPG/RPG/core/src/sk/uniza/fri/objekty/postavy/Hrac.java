package sk.uniza.fri.objekty.postavy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import sk.uniza.fri.Hra;
import sk.uniza.fri.enumy.Smer;
import sk.uniza.fri.enumy.TypPolicka;
import sk.uniza.fri.manazer.ManagerOfSources;

public class Hrac {
    private int x = 6;
    private int y = 3;
    private TypPolicka typPolicka;
    private Texture texture;
    private int utok = 100;
    private int zivot = 200;

    /**
     * vytvorenie hraca
     */
    public Hrac(TypPolicka typPolicka, ManagerOfSources managerOfSources) {
        this.texture = managerOfSources.getTexture(typPolicka);
        this.typPolicka = typPolicka;
    }

    /**
     * metoda na nakreslenie hraca
     */
    public void nakresliHraca(SpriteBatch batch) {
        batch.draw(this.texture, this.x, this.y, Hra.BLOCK_SIZE, Hra.BLOCK_SIZE);
    }

    /**
     * metoda na otacanie hraca
     */
    private void otocenieHraca(ManagerOfSources managerOfSources, Smer direction) {
        if (direction == Smer.UP) {
            this.texture = managerOfSources.getTexture(TypPolicka.HERO_1);
        } else if (direction == Smer.DOWN) {
            this.texture = managerOfSources.getTexture(TypPolicka.HERO_2);
        } else if (direction == Smer.RIGHT) {
            this.texture = managerOfSources.getTexture(TypPolicka.HERO_3);
        } else if (direction == Smer.LEFT) {
            this.texture = managerOfSources.getTexture(TypPolicka.HERO_4);
        }
    }

    /**
     * metoda na pohyb hraca
     */
    public void pohyb(ManagerOfSources managerOfSources) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP) && y < 13) {
            otocenieHraca(managerOfSources, Smer.UP);
            this.y++;
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN) && y > 3) {
            otocenieHraca(managerOfSources, Smer.DOWN);
            this.y--;
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT) && x < 22) {
            otocenieHraca(managerOfSources, Smer.RIGHT);
            this.x++;
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT) && x > 6) {
            otocenieHraca(managerOfSources, Smer.LEFT);
            this.x--;
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }
    }


    public void dobiZivot() {
        this.zivot += 100;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getUtok() {
        return utok;
    }

    public int getZivot() {
        return zivot;
    }

    public void setZivot(int zivot) {
        this.zivot -= zivot;
    }
}
