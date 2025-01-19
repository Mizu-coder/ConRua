package Rua.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Nen extends Actor {
    TextureRegion textureRegion;
    float time;
    public Nen(float x, float y, Stage stage) {
        textureRegion = new TextureRegion(new Texture("water-border.jpg"));
        setPosition(x, y);
        setSize(1200,800);
        stage.addActor(this);
    }
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(textureRegion,getX(),getY(),getOriginX(), getOriginY(),getWidth(),getHeight(),1 , 1,getRotation());
    }
}
