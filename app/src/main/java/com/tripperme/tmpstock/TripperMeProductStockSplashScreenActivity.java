package com.tripperme.tmpstock;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class TripperMeProductStockSplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Thread splashTread;

        //Start MainActivity
        splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    // Splash screen pause time
                    while (waited < 3500) {
                        sleep(100);
                        waited += 100;
                    }
                    Intent intent = new Intent(TripperMeProductStockSplashScreenActivity.this,
                            TripperMeProductStockActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    TripperMeProductStockSplashScreenActivity.this.finish();
                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    TripperMeProductStockSplashScreenActivity.this.finish();
                }

            }
        };
        splashTread.start();
    }
}
