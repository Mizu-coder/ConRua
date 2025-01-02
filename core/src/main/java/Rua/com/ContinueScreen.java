package Rua.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;

public class ContinueScreen implements Screen {
    Texture background;
    Texture title;
    Master game;
    OrthographicCamera camera;
    Stage stage;
    public ContinueScreen(Master game){
        this.game = game;
    }
    @Override
    public void show() {
        stage = new Stage();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        game.batch = new SpriteBatch();
        game.stage = new Stage();

        background = new Texture("water.jpg");
        title = new Texture("message-continue.png");

    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(Color.BLUE);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        game.batch.draw(title,Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 2, title.getWidth(), title.getHeight());
        game.batch.end();
        game.stage.act(Gdx.graphics.getDeltaTime());
        game.stage.draw();
    if(Gdx.input.isKeyPressed(Input.Keys.C)){
        game.setScreen(new GameScreen(game));
    }

    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
