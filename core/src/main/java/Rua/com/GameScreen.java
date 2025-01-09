package Rua.com;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen implements Screen {
    Texture background;
    Master game;
    OrthographicCamera camera;
    Stage stage;

    Turtle turtle;
    Texture t = new Texture("spritesheet.png");



    StarFish starFish;
    StarFish starFish1;
    StarFish starFish2;
    StarFish starFish3;
    StarFish starFish4;
    Texture star;

    ShapeRenderer shapeRenderer;
    Polygon polygon;
    Texture gameover;

    int sosao;

    GlyphLayout layout;



    Texture w;
    XoayNuoc xoayNuoc;

    Sound song;
    Music nhac;

    Texture win;

    Texture s;
    Shark shark;

    Texture reset;

    Win win1;
    Texture w1 = new Texture("sparkle.png");


    Reset reset1;
    boolean isReset = false;

    public GameScreen(Master game){
        this.game = game;
    }

    @Override
    public void show() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        game.batch = new SpriteBatch();
        game.stage = new Stage();
        layout = new GlyphLayout();
        sosao = 5;
        layout.setText(game.font, "So sao con lai " + sosao + " ");


        w = new Texture("whirlpool.png");

        win = new Texture("you-win.png");

        reset = new Texture("undo.png");

        song = Gdx.audio.newSound(Gdx.files.internal("Ocean_Waves.ogg"));
        nhac = Gdx.audio.newMusic(Gdx.files.internal("Master_of_the_Feast.ogg"));



        game.r = new Texture("rock.png");
        game.rock = new Rock(game.r, MathUtils.random(100,600) ,MathUtils.random(100,400),game.stage);
        game.rock1 = new Rock(game.r,MathUtils.random(100,600) ,MathUtils.random(100,400),game.stage);
        game.rock2 = new Rock(game.r, MathUtils.random(100,600) ,MathUtils.random(100,400),game.stage);
        game.rock3 = new Rock(game.r, MathUtils.random(100,600) ,MathUtils.random(100,400),game.stage);

        game.go = new Texture("sign.png");
        game.coc = new Coc(game.go,MathUtils.random(10,600) ,MathUtils.random(10,400), game.stage);
        game.coc1 = new Coc(game.go,MathUtils.random(10,600) ,MathUtils.random(10,400), game.stage);

        star = new Texture("starfish.png");
        starFish = new StarFish(star, MathUtils.random(10,600) ,MathUtils.random(10,400),game.stage);
        starFish1 = new StarFish(star, MathUtils.random(10,600) ,MathUtils.random(10,400),game.stage);
        starFish2 = new StarFish(star, MathUtils.random(10,600) ,MathUtils.random(10,400),game.stage);
        starFish3 = new StarFish(star, MathUtils.random(10,600) ,MathUtils.random(10,400),game.stage);
        starFish4 = new StarFish(star, MathUtils.random(10,600) ,MathUtils.random(10,400),game.stage);

        background = new Texture("water-border.jpg");
        gameover = new Texture("game-over.png");
        turtle = new Turtle(t,0,0,game.stage,game);
        shapeRenderer = new ShapeRenderer();
        polygon = new Polygon();
//        nhac.play();

        s = new Texture("sharky.png");
        shark = new Shark(488,336,game.stage);

        reset1 = new Reset(reset,769 ,424,game.stage);
        Gdx.input.setInputProcessor(game.stage);
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(Color.BLUE);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.batch.draw(background, 0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        game.font.draw(game.batch, layout,156,462);
        game.batch.end();

        if(Gdx.input.isTouched()){
            System.out.println("x = " + Gdx.input.getX() + " y = " + (Gdx.graphics.getHeight() - Gdx.input.getY()));
        }
        if(turtle.getBounds().overlaps(starFish.getBounds())){
            if(Intersector.overlapConvexPolygons(turtle.getPolygon(), starFish.getPolygon())){
                if (sosao > 1){
                    xoayNuoc = new XoayNuoc(w, starFish.getX(), starFish.getY(), game.stage);
                    starFish.setPosition(1000, 1000);
                    song.play();
                    sosao -= 1;
                    layout.setText(game.font, "So sao con lai " + sosao + " ");
                }else if(sosao <= 1){
                    System.out.println(5);
                    win1 = new Win(w1,starFish.getX(), starFish.getY(), game.stage);
                    starFish.setPosition(1000, 1000);
                    song.play();
                    sosao -= 1;
                    layout.setText(game.font, "So sao con lai " + sosao + " ");
                }
            }

        }
        if(turtle.getBounds().overlaps(starFish1.getBounds())){
            if(Intersector.overlapConvexPolygons(turtle.getPolygon(), starFish1.getPolygon())){
                if (sosao > 1){
                    xoayNuoc = new XoayNuoc(w, starFish1.getX(), starFish1.getY(), game.stage);
                    starFish1.setPosition(1000, 1000);
                    song.play();
                    sosao -= 1;
                    layout.setText(game.font, "So sao con lai " + sosao + " ");
                } else if(sosao <= 1){
                    System.out.println(4);
                    win1 = new Win(w1,starFish1.getX(), starFish1.getY(), game.stage);
                    starFish1.setPosition(1000, 1000);
                    song.play();
                    sosao -= 1;
                    layout.setText(game.font, "So sao con lai " + sosao + " ");
                }
            }

        }
        if(turtle.getBounds().overlaps(starFish2.getBounds())){
            if(Intersector.overlapConvexPolygons(turtle.getPolygon(), starFish2.getPolygon())){
                if (sosao > 1){
                    xoayNuoc = new XoayNuoc(w, starFish2.getX(), starFish2.getY(), game.stage);
                    starFish2.setPosition(1000, 1000);
                    song.play();
                    sosao -= 1;
                    layout.setText(game.font, "So sao con lai " + sosao + " ");
                } else if(sosao <= 1){
                    System.out.println(3);
                    win1 = new Win(w1,starFish2.getX(), starFish2.getY(), game.stage);
                    starFish2.setPosition(1000, 1000);
                    song.play();
                    sosao -= 1;
                    layout.setText(game.font, "So sao con lai " + sosao + " ");
                }
            }

        }

        if(turtle.getBounds().overlaps(starFish3.getBounds())){
            if(Intersector.overlapConvexPolygons(turtle.getPolygon(), starFish3.getPolygon())){
                if (sosao > 1){
                    xoayNuoc = new XoayNuoc(w, starFish3.getX(), starFish3.getY(), game.stage);
                    starFish3.setPosition(1000, 1000);
                    song.play();
                    sosao -= 1;
                    layout.setText(game.font, "So sao con lai " + sosao + " ");
                } else  if(sosao <= 1){
                    System.out.println(2);
                    win1 = new Win(w1,starFish3.getX(), starFish3.getY(), game.stage);
                    starFish3.setPosition(1000, 1000);
                    song.play();
                    sosao -= 1;
                    layout.setText(game.font, "So sao con lai " + sosao + " ");
                }
            }

        }
        if(turtle.getBounds().overlaps(starFish4.getBounds())){

            if(Intersector.overlapConvexPolygons(turtle.getPolygon(), starFish4.getPolygon())) {
                if (sosao > 1){
                    xoayNuoc = new XoayNuoc(w, starFish4.getX(), starFish4.getY(), game.stage);
                    starFish4.setPosition(1000, 1000);
                    song.play();
                    sosao -= 1;
                    layout.setText(game.font, "So sao con lai " + sosao + " ");
                } else if(sosao <= 1){
                    System.out.println(1);
                    win1 = new Win(w1,starFish4.getX(), starFish4.getY(), game.stage);
                    starFish4.setPosition(1000, 1000);
                    song.play();
                    sosao -= 1;
                    layout.setText(game.font, "So sao con lai " + sosao + " ");
                }

            }

        }
        if(sosao <= 0){
            ScreenUtils.clear(Color.BLUE);
            game.batch.begin();
            game.batch.draw(win,Gdx.graphics.getWidth()/8,Gdx.graphics.getHeight()/2,win.getWidth(), win.getHeight());
            game.batch.end();
        }
        if(turtle.getBounds().overlaps(shark.getBounds())) {
            if (Intersector.overlapConvexPolygons(turtle.getPolygon(), shark.getPolygon())) {
                ScreenUtils.clear(Color.BLUE);
                game.batch.begin();
                game.batch.draw(background,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
                game.batch.draw(gameover,Gdx.graphics.getWidth()/8,Gdx.graphics.getHeight()/2,gameover.getWidth(), gameover.getHeight());
                game.batch.end();
            }
        }
        reset1.addListener(new ClickListener(){

            public void clicked(InputEvent event, float x, float y) {
                System.out.println(10);
                if(!isReset) {
                    game.setScreen(new GameScreen(game));
                    isReset = true;
                }

            }
        });

        if(turtle.getBounds().overlaps(shark.getBounds())) {
            if (Intersector.overlapConvexPolygons(turtle.getPolygon(), shark.getPolygon())) {
                game.setScreen(new ContinueScreen(game));
            }
        }
//        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
//        shapeRenderer.setColor(Color.BLUE);
//        shapeRenderer.polygon(shark.polygon.getTransformedVertices());
//        shapeRenderer.end();
        game.stage.act(Gdx.graphics.getDeltaTime());
        game.stage.draw();
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
