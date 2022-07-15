package sk.uniza.fri.mapa;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import sk.uniza.fri.manazer.ManagerOfSources;

/**
 * sluzi na poskladanie miestnosti
 */
public class Mapa {
    private ManagerOfSources managerOfSources;
    private SpriteBatch spriteBatch;
    private PrvaMiestnost prvaMiestnost;
    private DruhaMiestnost druhaMiestnost;
    private TretiaMiestnost tretiaMiestnost;

    public Mapa(ManagerOfSources managerOfSources, SpriteBatch spriteBatch) {
        this.managerOfSources = managerOfSources;
        this.spriteBatch = spriteBatch;
        this.prvaMiestnost = new PrvaMiestnost(this.managerOfSources, this.spriteBatch);
        this.druhaMiestnost = new DruhaMiestnost(this.managerOfSources, this.spriteBatch);
        this.tretiaMiestnost = new TretiaMiestnost(this.managerOfSources, this.spriteBatch);
    }

    /**
     * metoda na vytvorenie mapy z miestnosti
     */
    public void vytvorMapu(int cisloMapy) {
        switch (cisloMapy) {
            case 1:
                this.prvaMiestnost.vytvorMiestnost();
                this.prvaMiestnost.vytvorInteraktivneObjekty();
                break;
            case 2:
                this.druhaMiestnost.vytvorMiestnost();
                this.druhaMiestnost.vytvorInteraktivneObjekty();
                break;
            case 3:
                this.tretiaMiestnost.vytvorMiestnost();
                this.tretiaMiestnost.vytvorInteraktivneObjekty();
                break;
            default:
                this.prvaMiestnost.vytvorMiestnost();
                this.prvaMiestnost.vytvorInteraktivneObjekty();
                break;
        }

    }

    /**
     * metoda na nakreslenie mapy z miestnosti
     */
    public void nakresliMapu(int cisloMapy) {
        switch (cisloMapy) {
            case 1:
                this.prvaMiestnost.nakresliMiestnost();
                this.prvaMiestnost.nakresliInteraktivneObjekty();
                break;
            case 2:
                this.druhaMiestnost.nakresliMiestnost();
                this.druhaMiestnost.nakresliInteraktivneObjekty();
                break;
            case 3:
                this.tretiaMiestnost.nakresliMiestnost();
                this.tretiaMiestnost.nakresliInteraktivneObjekty();
                break;
            default:
                this.prvaMiestnost.nakresliMiestnost();
                this.prvaMiestnost.nakresliInteraktivneObjekty();
                break;
        }
    }

    public PrvaMiestnost getPrvaMiestnost() {
        return prvaMiestnost;
    }

    public DruhaMiestnost getDruhaMiestnost() {
        return druhaMiestnost;
    }

    public TretiaMiestnost getTretiaMiestnost() {
        return tretiaMiestnost;
    }
}
