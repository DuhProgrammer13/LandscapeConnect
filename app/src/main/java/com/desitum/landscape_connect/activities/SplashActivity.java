package com.desitum.landscape_connect.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.desitum.landscape_connect.R;


public class SplashActivity extends Activity {

    private boolean dataHasLoaded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (getActionBar() != null) getActionBar().hide();

        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                while (!dataHasLoaded) {
                    // TODO need to load data from Spring Boot api call
                    try {
                        Thread.sleep(1000);
                        dataHasLoaded = true;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                Intent myIntent = new Intent(getBaseContext(), LoginActivity.class);
                startActivity(myIntent);

            }
        };

        Thread myThread = new Thread(myRunnable);
        myThread.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
