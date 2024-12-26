package Rua.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class BaseActor extends Actor {
    TextureRegion textureRegion;
    float scaleX = 1.0f;
    float scaleY = 1.0f;
    public BaseActor(Texture texture, float x, float y){
        this.textureRegion = new TextureRegion(texture);
        setPosition(x, y);
        setSize(texture.getWidth(), texture.getHeight());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        //batch.draw(texture, getX(), getY());
        batch.draw(textureRegion, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), scaleX, scaleY, getRotation());
    }

    public Rectangle getBounds(){ // lấy ra khung hình chữ nhật theo kích thước nhân vật
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }
}
