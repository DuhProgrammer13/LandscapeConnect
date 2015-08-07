package com.desitum.landscape_connect.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.desitum.landscape_connect.R;


public class LoginActivity extends Activity {

    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setupView();

        if (getActionBar() != null) getActionBar().hide();
    }

    private void setupView() {
        Typeface pressuraRegular = Typeface.createFromAsset(getAssets(), "fonts/GT-Pressura-Regular.otf");
        Typeface pressuraBold = Typeface.createFromAsset(getAssets(), "fonts/GT-Pressura-Bold.otf");

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        username.setTypeface(pressuraRegular);
        password.setTypeface(pressuraRegular);
        ((TextView) findViewById(R.id.forgot_password)).setTypeface(pressuraRegular);
        ((TextView) findViewById(R.id.title)).setTypeface(pressuraRegular);
        ((Button) findViewById(R.id.login_button)).setTypeface(pressuraBold);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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

    @Override
    public void onBackPressed() {
        // We don't want it to go back to the splash screen, it would get stuck there
    }

    public void onClickLogin(View view) {
        //TODO need to verify credentials
        Intent myIntent = new Intent(this, HomeActivity.class);
        startActivity(myIntent);
    }
}
