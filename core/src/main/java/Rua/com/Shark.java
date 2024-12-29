package Rua.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Shark extends Actor {
    TextureRegion textureRegion;
    Polygon polygon;
    float x = 1;
    public Shark( float x, float y, Stage s) {
        textureRegion = new TextureRegion(new Texture("sharky.png"));
        setPosition(x, y);
        setOrigin(getWidth()/2,getHeight()/2);
        setSize(textureRegion.getRegionWidth(),textureRegion.getRegionHeight());
        s.addActor(this);
        setRotation(0);
        float[] dagiac = {
            34,60,
            37,42,
            22,32,
            14,33,
            2,29,
            12,17,
            13,3,
            29,16,
            45,10,
            47,3,
            62,9,
            97,28,
            63,50,
            34,60,
        };
        polygon = new Polygon(dagiac);
        polygon.setOrigin(getWidth()/2, getHeight()/2);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        float speed = 2*3.14f* 60/360;
        float y = speed* MathUtils.sinDeg(getRotation());
        if(getX() > 800){
            x = -1;
            setScaleX(-1);
        }
        if(getX() < 0){
            x= 1;
            setScaleX(1);

        }
        moveBy(x,y);
        polygon.setPosition(getX(),getY());
        polygon.setRotation(getRotation());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(textureRegion,getX(),getY(),getOriginX(), getOriginY(),getWidth(),getHeight(),getScaleX() , getScaleY(),getRotation());
    }
    public Rectangle getBounds(){
        return new Rectangle(getX(), getY(),getWidth(),getHeight());
    }
    public Polygon getPolygon() {
        return polygon;
    }
}
