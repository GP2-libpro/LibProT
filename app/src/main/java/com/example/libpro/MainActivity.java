package com.example.libpro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

        private DrawerLayout dl;
        private ActionBarDrawerToggle t;
        private NavigationView nv;
        private UserInfo userInfo ;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            userInfo = new UserInfo(this);

            // Get user name and show it to UI
//        String username = userInfo.getUserusername();
//        TextView welcometextView = findViewById(R.id.welcomeView);
//        welcometextView.setText("Hello");

            dl = findViewById(R.id.activity_main);
            t = new ActionBarDrawerToggle(MainActivity.this, dl,R.string.open, R.string.close);

            dl.addDrawerListener(t);
            t.syncState();

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            nv = findViewById(R.id.nv);
            nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    int id = item.getItemId();

                    if (id == R.id.homenav){
                        Toast.makeText(MainActivity.this,"homenav",Toast.LENGTH_SHORT).show();
                    }
                    if (id == R.id.category){
                        Intent intent = new Intent(MainActivity.this, category.class);
                        startActivity(intent);
                    }
                    if (id == R.id.setting){
                        Toast.makeText(MainActivity.this,"setting",Toast.LENGTH_SHORT).show();
                    }
                    if (id == R.id.logout){
                        userInfo.saveUserInfo("","","");
                        finish();
                    }

                    return true ;
                }
            });


        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {

            if(t.onOptionsItemSelected(item))
                return true;

            return super.onOptionsItemSelected(item);
        }
    }
