package Rua.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Rock extends Actor {
    Animation<TextureRegion> animation;
    TextureRegion textureRegion;
    float time;
    Polygon polygon;
    public Rock(Texture texture, float x, float y, Stage s){
        textureRegion = new TextureRegion(new Texture("rock.png"));
        setPosition(x, y);
        setSize(textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
        setOrigin(getWidth() / 2, getHeight() / 2);
        float[] dagiac = {
            16,58,
            5,40,
            4,20,
            22,11,
            50,12,
            58,29,
            51,56,
            32,58,
            17,60,
            16,58,
        };
        polygon = new Polygon(dagiac);
        polygon.setOrigin(getWidth()/2, getHeight()/2);
        s.addActor(this);

    }
    @Override
    public void act(float delta) {
        super.act(delta);

        polygon.setPosition(getX(),getY());
        polygon.setRotation(getRotation());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(textureRegion,getX(),getY(),getOriginX(), getOriginY(),getWidth(),getHeight(),1 , 1,getRotation());
    }
    public Rectangle getBounds(){
        return new Rectangle(getX(), getY(),getWidth(),getHeight());
    }
    public Polygon getPolygon() {
        return polygon;
    }
}
