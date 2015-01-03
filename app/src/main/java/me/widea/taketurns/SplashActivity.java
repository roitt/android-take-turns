package me.widea.taketurns;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

/**
 * Created by Rohit and Viveka on 11/23/14.
 */

public class SplashActivity extends Activity {
    ImageView ivTurns;
    RotateAnimation rotateAnimation;
    ScaleAnimation scaleAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ivTurns = (ImageView) findViewById(R.id.as_iv_turns);

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                /**
                 * Check for the oAuth token. If it is still valid, fetch user details and take him to the main activity
                 */
//                Intent i = new Intent(SplashActivity.this, MainActivity.class);
//                startActivity(i);
//                finish();

                /** Else show login screen **/
                Intent loginIntent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(loginIntent);
                finish();
            }
        }, 3000);
    }

    @Override
    protected void onResume() {
        super.onResume();
        rotateAnimation = new RotateAnimation(0f, 120f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setFillEnabled(true);
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        rotateAnimation.setStartOffset(700);
        rotateAnimation.setDuration(300);
        ivTurns.startAnimation(rotateAnimation);
    }

    @Override
    protected void onStop() {
        super.onStop();
        ivTurns.clearAnimation();
    }
}
