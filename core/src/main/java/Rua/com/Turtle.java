package Rua.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Turtle extends Actor {
    Animation<TextureRegion> animation;
    TextureRegion textureRegion;
    float time;
    Polygon polygon;
    float speed = 0;
    Master game;

    public Turtle(Texture texture,float x, float y, Stage s,Master game) {
        this.game = game;
        textureRegion = new TextureRegion(new Texture("spritesheet.png"));
        setPosition(x, y);
        s.addActor(this);
        int cot = 6;
        int hang = 1;
        setSize(texture.getWidth() / cot, texture.getHeight() / hang);
        float speed = 0.2f;
        TextureRegion[][] tam = TextureRegion.split(texture, texture.getWidth() / cot, texture.getHeight() / hang);// đưa tất cả vào danh một danh sách ảnh, vì 6 cột 1 hàng nên sẽ có 6 phần tử: 6 x 1
        TextureRegion[] frames = new TextureRegion[cot * hang];
        int index = 0;
        for (int i = 0; i < hang; i++) {
            for (int j = 0; j < cot; j++) {
                frames[index++] = tam[i][j];
            }
        }

        setOrigin(getWidth()/2,getHeight()/2);
        animation = new com.badlogic.gdx.graphics.g2d.Animation<TextureRegion>(speed, frames);
        animation.setPlayMode(Animation.PlayMode.LOOP);
        time = 0;
        float[] dagiac = {
            44,11,
            74,31,
            74,41,
            99,43,
            99,55,
            74,52,
            64,89,
            61,70,
            15,67,
            2,69,
            3,61,
            12,58,
            13,39,
            4,37,
            4,28,
            20,30,
            59,28
        };
        polygon = new Polygon(dagiac);
        polygon.setOrigin(getWidth()/2, getHeight()/2);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        speed *= 0.9;
        moveBy(speed * MathUtils.cosDeg(getRotation()), speed * MathUtils.sinDeg(getRotation()));


        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            rotateBy(2);
            time += delta;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            rotateBy(-2);
            time += delta;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            speed += 0.3;
            time += delta;
        }
        if(getBounds().overlaps(game.rock.getBounds())){
            if(Intersector.overlapConvexPolygons(getPolygon(), game.rock.getPolygon())){
                speed *= -1f;
            }
        }
        if(getBounds().overlaps(game.rock1.getBounds())){
            if(Intersector.overlapConvexPolygons(getPolygon(), game.rock1.getPolygon())){
                speed *= -1f;
            }
        }
        if(getBounds().overlaps(game.coc1.getBounds())){
            if(Intersector.overlapConvexPolygons(getPolygon(), game.coc1.getPolygon())){
                speed *= -1f;
            }
        }
        if(getBounds().overlaps(game.coc.getBounds())){
            if(Intersector.overlapConvexPolygons(getPolygon(), game.coc.getPolygon())){
                speed *= -1f;
            }
        }
        if(getBounds().overlaps(game.rock2.getBounds())){
            if(Intersector.overlapConvexPolygons(getPolygon(), game.rock2.getPolygon())){
                speed *= -1f;
            }
        }
        if(getBounds().overlaps(game.rock3.getBounds())){
            if(Intersector.overlapConvexPolygons(getPolygon(), game.rock3.getPolygon())){
                speed *= -1f;
            }
        }

        polygon.setPosition(getX(),getY());
        polygon.setRotation(getRotation());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        TextureRegion currentFrame = animation.getKeyFrame(time);
        batch.draw(currentFrame,getX(),getY(),getOriginX(), getOriginY(),getWidth(),getHeight(),1 , 1,getRotation());
    }
    public Rectangle getBounds(){
        return new Rectangle(getX(), getY(),getWidth(),getHeight());
    }
    public Polygon getPolygon() {
        return polygon;
    }

}
