package sk.uniza.fri.objekty;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import sk.uniza.fri.Hra;
import sk.uniza.fri.manazer.ManagerOfSources;
import sk.uniza.fri.enumy.TypPolicka;
import sk.uniza.fri.objekty.postavy.Hrac;

/**
 * objekty v hre
 */
public abstract class Objekty {
    private final ManagerOfSources managerOfSources;
    private Texture texture;
    private int x;
    private int y;

    public Objekty(ManagerOfSources managerOfSources, TypPolicka typPolicka, int x, int y) {
        this.managerOfSources = managerOfSources;
        this.texture = managerOfSources.getTexture(typPolicka);
        this.x = x;
        this.y = y;
    }

    protected ManagerOfSources getManagerOfSources() {
        return this.managerOfSources;
    }

    protected Texture getTexture() {
        return this.texture;
    }

    public int getPositionX() {
        return this.x;
    }

    public int getPositionY() {
        return this.y;
    }

    /**
     * metoda na nakreslenie objektov
     */
    public void nakresli(SpriteBatch batch) {
        batch.draw(this.texture, this.x, this.y, Hra.BLOCK_SIZE, Hra.BLOCK_SIZE);
    }

    /**
     * metoda na kontrolovanie kolizie
     */
    public boolean kolizia(Hrac hrac) {
        if (hrac.getX() == this.x && hrac.getY() == this.y) {
            return true;
        }
        return false;
    }

    /**
     * metoda na kontrolovanie kolizie
     */
    public abstract void interakcia(Hrac hrac);
}
