package sk.uniza.fri;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import jdk.internal.net.http.common.HttpHeadersBuilder;

public class Mapa {
    private ManagerOfSources managerOfSources;
    private SpriteBatch spriteBatch;
    private PrvaMiestnost prvaMiestnost;

    public Mapa(ManagerOfSources managerOfSources, SpriteBatch spriteBatch) {
        this.managerOfSources = managerOfSources;
        this.spriteBatch = spriteBatch;
        this.prvaMiestnost = new PrvaMiestnost(this.managerOfSources, this.spriteBatch);
    }

    public void vytvorMapu() {
        this.prvaMiestnost.vytvorMiestnost();
        this.prvaMiestnost.nakresliMiestnost();
    }
}
