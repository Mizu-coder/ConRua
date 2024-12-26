package Rua.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class XoayNuoc extends Actor {
    Animation<TextureRegion> animation;
    TextureRegion textureRegion;
    float time;
    public XoayNuoc(Texture texture, float x, float y, Stage s){
        textureRegion = new TextureRegion(new Texture("whirlpool.png"));
        setPosition(x, y);
        s.addActor(this);
        int cot = 5;
        int hang = 2;
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
    }
    @Override
    public void act(float delta) {
        super.act(delta);
        time += delta;
        if(animation.isAnimationFinished(time)){
            remove();
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        TextureRegion currentFrame = animation.getKeyFrame(time);
        batch.draw(currentFrame,getX(),getY(),getOriginX(), getOriginY(),getWidth(),getHeight(),1 , 1,getRotation());
    }
}
