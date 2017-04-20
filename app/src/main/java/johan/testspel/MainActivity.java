package johan.testspel;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.animation.TranslateAnimation;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    public static Button playbutton,bLeft,bRight;
    public ImageView startpic, ball, stick;
    public RelativeLayout layout;
    public boolean gameOver=false;
    public static TextView lost;
    final Handler h = new Handler();
    float xPos = 0;
    long startTime = 0;
    int lTime=0;
    int rTime=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        onCreateNew();

        playbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameSetup();
/*
               ImageView ball = (ImageView) findViewById(R.id.ball);
               TranslateAnimation animation = new TranslateAnimation(0.0f, 0.0f, 10.0f, -200.0f);
               animation.setDuration(1000);
               animation.setRepeatCount(90000000);
               animation.setRepeatMode(2);
               animation.setFillAfter(true);
               ball.startAnimation(animation);
               */
            }
        });

        bLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameSetup();

                ImageView ball = (ImageView) findViewById(R.id.ball);

                TranslateAnimation animation = new TranslateAnimation(xPos, xPos - rTime - 2, 0.0f, 0.0f);
                xPos = xPos - rTime - 2;

                animation.setDuration(200);
                animation.setFillAfter(true);
                ball.startAnimation(animation);
            }
        });

            while(lTime>=1) {
                bRight.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gameSetup();

                        ImageView ball = (ImageView) findViewById(R.id.ball);


                        TranslateAnimation animation = new TranslateAnimation(xPos, xPos + rTime + 2, 0.0f, 0.0f);
                        xPos = xPos + rTime + 2;
                        animation.setDuration(200);
                        animation.setFillAfter(true);
                        ball.startAnimation(animation);
                    }
                });
                rTime
            }
        findViewById(R.id.bLeft).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    lTime++;
                    ((TextView) findViewById(R.id.lost)).setText(""+lTime);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    lTime = 0;
                    ((TextView) findViewById(R.id.lost)).setText(lTime + "");

                }
                return false;
            }
        });
    }




    protected void onCreateNew(){
        playbutton = (Button)findViewById(R.id.playbutton);
        startpic = (ImageView)findViewById(R.id.startpic);
        ball = (ImageView)findViewById(R.id.ball);
        stick = (ImageView)findViewById(R.id.stick);
        bRight = (Button)findViewById(R.id.bRight);
        bLeft = (Button)findViewById(R.id.bLeft);
        lost = (TextView)findViewById(R.id.lost);

        lost.setVisibility(View.INVISIBLE);



        startpic.setVisibility(View.VISIBLE);
        playbutton.setVisibility(View.VISIBLE);
        ball.setVisibility(View.INVISIBLE);
        stick.setVisibility(View.INVISIBLE);
        bRight.setVisibility(View.INVISIBLE);
        bLeft.setVisibility(View.INVISIBLE);
    }

    protected void gameSetup(){
        startpic.setVisibility(View.INVISIBLE);
        playbutton.setVisibility(View.INVISIBLE);
        ball.setVisibility(View.VISIBLE);
        stick.setVisibility(View.VISIBLE);
        bRight.setVisibility(View.VISIBLE);
        bLeft.setVisibility(View.VISIBLE);
        bLeft.setBackgroundColor(Color.TRANSPARENT);
        bRight.setBackgroundColor(Color.TRANSPARENT);

        lost.setVisibility(View.VISIBLE);

    }




}
