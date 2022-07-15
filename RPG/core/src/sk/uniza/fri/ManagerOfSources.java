package sk.uniza.fri;
//prevzata trieda
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class ManagerOfSources {

    private AssetManager sources;

    public ManagerOfSources() {
        this.sources = new AssetManager();

        for (TypPolicka textureType : TypPolicka.values()) {
            this.sources.load(textureType.getFileName(), Texture.class);
        }

        this.sources.finishLoading();
    }

    public Texture getTexture(TypPolicka textureType) {
        return this.sources.get(textureType.getFileName(), Texture.class);
    }

    public void dispose() {
        this.sources.dispose();
    }
}
