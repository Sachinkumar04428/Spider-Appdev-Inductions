package com.example.gravitydance;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public  final static String UP="up";
    public  final static String DOWN="down";
    public final static float STONE_HEIGHT = 400;
    static float SCREEN_HEIGHT ;

    ArrayList<ImageView> Infinity_Stones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getting the screen height
        SCREEN_HEIGHT = this.getWindowManager().getDefaultDisplay().getHeight();

        ImageView stone1 = findViewById(R.id.stone1);
        ImageView stone2 = findViewById(R.id.stone2);
        ImageView stone3 = findViewById(R.id.stone3);
        ImageView stone4 = findViewById(R.id.stone4);
        ImageView stone5 = findViewById(R.id.stone5);
        ImageView stone6 = findViewById(R.id.stone6);

        //creating a list of infinity Stones
        Infinity_Stones = new ArrayList<>();
        Infinity_Stones.add(stone1);
        Infinity_Stones.add(stone2);
        Infinity_Stones.add(stone3);
        Infinity_Stones.add(stone4);
        Infinity_Stones.add(stone5);
        Infinity_Stones.add(stone6);


        //setting random gravity
        setRandomGravity(Infinity_Stones);

    }

    public  void setRandomGravity(ArrayList<ImageView> stones)
    {
        for(int i=0;i<stones.size();i++)
        {
            double randomDirection = Math.random();
            if(randomDirection>0.5)
                set_Animation(stones.get(i), UP);
            else
                set_Animation(stones.get(i), DOWN);
        }
    }

    public void set_Animation(ImageView target,String direction)
    {
        ObjectAnimator transAnim = ObjectAnimator.ofFloat(target, "y", 5, 50);
        transAnim.setTarget(target);
        transAnim.setRepeatCount(0);
        transAnim.setRepeatMode(ValueAnimator.REVERSE);
        transAnim.setDuration(2000);

        float fromY = target.getY();
        if(direction==UP){
            float toY = 0;
            transAnim.setFloatValues(fromY, toY);
        }else{
            float toY = (float)(SCREEN_HEIGHT - STONE_HEIGHT);
            transAnim.setFloatValues(toY);
        }

        //starting the animation
        transAnim.start();

    }

    public void changeGravity(View view)
    {
        //screen tap detected
        setRandomGravity(Infinity_Stones);
    }


}
