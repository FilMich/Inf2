package sk.uniza.fri.mapa;

import com.badlogic.gdx.utils.Array;
import sk.uniza.fri.objekty.Objekty;

public interface IMiestnost {
    void vytvorMiestnost();

    void nakresliMiestnost();

    void vytvorInteraktivneObjekty();

    void nakresliInteraktivneObjekty();

    Array<Objekty> getObjekty();

    Array<Objekty> getInteraktivneObjekty();
}
