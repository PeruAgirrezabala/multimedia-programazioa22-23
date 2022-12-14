package com.example.android_game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements Runnable {
    private Thread thread;
    private  boolean isPlaying;
    private int screenX,screenY;
    private Paint paint;
    public static float screenRatioX,screenRatioY;
    private Flight flight;
    private Background background1,background2;

    public GameView(Context context,int screenX,int screenY){
        super(context);

        this.screenX = screenX;
        this.screenY = screenY;
        screenRatioX = 1920f/ screenX;
        screenRatioY = 1080f / screenY;

        background1 = new Background(screenX,screenY,getResources());
        background2 = new Background(screenX,screenY,getResources());

        flight = new Flight(screenY,getResources());


        background2.x = screenX;
    }

    @Override
    public void run() {
        while(isPlaying){
            update();
            draw();
            sleep();
        }

    }
    private void update(){
        background1.x-=10*screenRatioX;
        background2.x-=10*screenRatioX;
        if(background1.x + background1.bg.getWidth()< 0 ){
            background1.x=screenX;
        }
        if(background2.x + background1.bg.getWidth()< 0 ){
            background2.x=screenX;
        }
        if(flight.isGoingUp){
            flight.y -= 30 * screenRatioY;
        }else{
            flight.y -= 30 * screenRatioY;
        }
        if(flight.y <0){
            flight.y= 0;
        }
        if(flight.y>screenY -flight.height){
            flight.y = screenY - flight.height;
        }

    }
    private void draw (){
        if(getHolder().getSurface().isValid()){
            Canvas canvas = getHolder().lockCanvas();
            canvas.drawBitmap(background1.bg,background1.x,background1.y,paint);
            canvas.drawBitmap(background2.bg,background2.x,background2.y,paint);

            canvas.drawBitmap(flight.getFlight(),flight.x,flight.y,paint);

            getHolder().unlockCanvasAndPost(canvas);
        }
    }
    private void sleep(){
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void resume(){
        isPlaying=true;
        thread = new Thread(this);
        thread.start();

    }
    public void pause() {
        try {
            isPlaying=false;
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                if(event.getX() <screenX/2){
                    flight.isGoingUp=true;
                }
                break;
            case MotionEvent.ACTION_UP:
                flight.isGoingUp=false;
                break;
        }
        return true;
    }
}
