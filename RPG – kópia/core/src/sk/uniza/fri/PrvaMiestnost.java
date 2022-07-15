package sk.uniza.fri;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class PrvaMiestnost implements IMiestnost{
    private Array<Objekty> objekty;
    private ManagerOfSources managerOfSources;
    private SpriteBatch batch;

    public PrvaMiestnost( ManagerOfSources managerOfSources, SpriteBatch batch) {
        this.objekty = new Array<>();
        this.managerOfSources = managerOfSources;
        this.batch = batch;
    }

    @Override
    public void vytvorMiestnost() {
        for (int x = 5; x < 24; x++) {
            for (int y = 2; y < 14; y++) {
                this.objekty.add(new Strom(this.managerOfSources, x, 2));
                this.objekty.add(new Strom(this.managerOfSources, 5 , y));
                this.objekty.add(new Strom(this.managerOfSources, x, 13));
                this.objekty.add(new Strom(this.managerOfSources, 23 , y));
            }
        }
    }

    @Override
    public void nakresliMiestnost() {
        for (Objekty gameObject : this.objekty) {
            gameObject.nakresli(this.batch);
        }
    }

    @Override
    public String getMiestnost() {
        return null;
    }
}
