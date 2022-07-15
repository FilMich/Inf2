package sk.uniza.fri;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Hrac {
    private int X = 0;
    private int Y = 0;
    private TypPolicka typPolicka;
    private Texture texture;

    public Hrac(TypPolicka typPolicka, ManagerOfSources managerOfSources) {
        this.texture = managerOfSources.getTexture(typPolicka);
        this.typPolicka = typPolicka;
    }

    public void nakresliHraca(SpriteBatch batch) {
        batch.draw(this.texture, this.X, this.Y, Hra.BLOCK_SIZE, Hra.BLOCK_SIZE);
    }

    private void OtocenieHraca(ManagerOfSources managerOfSources, Smer direction) {
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

    public void pohyb(ManagerOfSources managerOfSources) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            OtocenieHraca(managerOfSources, Smer.UP);
            this.Y++;
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
            OtocenieHraca(managerOfSources, Smer.DOWN);
            this.Y--;
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
            OtocenieHraca(managerOfSources, Smer.RIGHT);
            this.X++;
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
            OtocenieHraca(managerOfSources, Smer.LEFT);
            this.X--;
        }
    }
}
