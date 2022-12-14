package com.example.android_game;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Background {

    int x=0,y=0;
    Bitmap bg;

    Background(int screeX, int screenY, Resources res){
        bg = BitmapFactory.decodeResource(res,R.drawable.bg);
        bg = Bitmap.createScaledBitmap(bg,screeX,screenY,false);

    }
}
