package Rua.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Close extends Actor {
    TextureRegion textureRegion;
    public Close(float x, float y, Stage s) {
        textureRegion = new TextureRegion(new Texture("undo.png"));
        setPosition(x, y);
        setOrigin(getWidth()/2,getHeight()/2);
        setSize(textureRegion.getRegionWidth(),textureRegion.getRegionHeight());
        s.addActor(this);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(textureRegion,getX(),getY(),getOriginX(), getOriginY(),getWidth(),getHeight(),1 , 1,getRotation());
    }
}
