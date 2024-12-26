package Rua.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Coc extends Actor {
    TextureRegion textureRegion;
    float time;
    Polygon polygon;

    public Coc(Texture texture, float x, float y, Stage s){
        textureRegion = new TextureRegion(new Texture("sign.png"));
        setPosition(x, y);
        setSize(textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
        float[] dagiac ={
            61,48,
            1,48,
            2,8,
            26,7,
            26,2,
            34,2,
            35,8,
            59,9,
            62,48,
        };
        polygon = new Polygon(dagiac);
        setOrigin(getWidth() / 2, getHeight() / 2);
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

