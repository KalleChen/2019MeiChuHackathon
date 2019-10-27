package com.example.kkbox;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        Button testButton = (Button) findViewById(R.id.test_button);

        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                opentest();
            }
        });
        /*
        Button test = findViewById(R.id.test_button);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DrawerActivity();
            }
        });
         */
        handleIntent(getIntent());
        // ATTENTION: This was auto-generated to handle app links.


        // ATTENTION: This was auto-generated to handle app links.
    }
    /*
    public void DrawerActivity(){
        Intent intent = new Intent (this, DrawerActivity.class);
        startActivity(intent);
    }
     */
    public void opentest(){
        Intent intent = new Intent (this, googlemap.class);
        startActivity(intent);
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(intent);
    }

    private void handleIntent(Intent intent){
        /*
        //Intent appLinkIntent = getIntent();
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        Button testButton = (Button) findViewById(R.id.test_button);

        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                opentest();
            }
        });*/
        String appLinkAction = intent.getAction();
        Uri appLinkData = intent.getData();
        if(appLinkData != null)
        {
            String code = appLinkData.getLastPathSegment();
            //do something with code
        }
    }
}
