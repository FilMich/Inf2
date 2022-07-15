package sk.uniza.fri;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

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

    public void nakresli(SpriteBatch batch) {
        batch.draw(this.texture, this.x, this.y, Hra.BLOCK_SIZE, Hra.BLOCK_SIZE);
    }
}
