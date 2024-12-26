package Rua.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;

public class MenuScreen implements Screen {
    Texture backgroundImage;
    Texture start;
    Texture title;
    Master game;
    Texture button;
    OrthographicCamera camera;
    Stage stage;
    GlyphLayout layout;

    Texture exit;
    public MenuScreen(Master game){
        this.game = game;
    }

    @Override
    public void show() {
        stage = new Stage();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        game.batch = new SpriteBatch();
        game.stage = new Stage();

        backgroundImage = new Texture("water.jpg");
        start = new Texture("message-start.png");
        title = new Texture("starfish-collector.png");
        button = new Texture("dialog.png");
        game.stage = new Stage();
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = game.font;
        style.fontColor = Color.WHITE;
        TextButton startButton = new TextButton("START",style);
        startButton.setSize(0.9f,0.9f);
        startButton.setPosition(316,174);
        game.stage.addActor(startButton);
        Gdx.input.setInputProcessor(game.stage);
        startButton.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                System.out.println("start Clicked");
                game.setScreen(new  GameScreen(game));
            }
        });

        exit = new Texture("button.png");
        TextButton.TextButtonStyle style1 = new TextButton.TextButtonStyle();
        style1.font = game.font;
        style1.fontColor = Color.YELLOW;
        TextButton exit1 = new TextButton("E",style);
        exit1.setSize(0.9f,0.9f);
        exit1.setPosition(518 ,215);
        game.stage.addActor(exit1);
        Gdx.input.setInputProcessor(game.stage);
        exit1.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                Gdx.app.exit();
            }
        });





    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(Color.BLUE);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.batch.draw(backgroundImage, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        game.batch.draw(title, Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 2, title.getWidth(), title.getHeight());
        game.batch.draw(button, Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 4, button.getWidth() / 2, button.getHeight() / 2);
        game.batch.draw(exit, 484,172);
        game.batch.end();
        game.stage.act(Gdx.graphics.getDeltaTime());
        game.stage.draw();

        if(Gdx.input.isTouched()){
            System.out.println("x = " + Gdx.input.getX() + " y = " + (Gdx.graphics.getHeight() - Gdx.input.getY()));
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
