package com.example.carshareapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MenuActvity extends AppCompatActivity {
    LinearLayout profileLayout = findViewById(R.id.profile_layout_id);
    LinearLayout settingsLayout = findViewById(R.id.settings_id);
    LinearLayout carLayout = findViewById(R.id.car_layout_id);
    LinearLayout mycCarLayout = findViewById(R.id.mycar_id);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_actvity);
        carLayout.setVisibility(View.VISIBLE);
        settingsLayout.setVisibility(View.GONE);
        profileLayout.setVisibility(View.GONE);
        mycCarLayout.setVisibility(View.GONE);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_menu);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener(){
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                       if (item.getItemId() == R.id.action_orders){
                           showLayout(2);
                           return true;
                       }else if(item.getItemId() == R.id.action_profile){
                           showLayout(1);
                           return true;
                       }

                       else if(item.getItemId() == R.id.action_rent){
                           showLayout(3);
                           return true;

                       }else if(item.getItemId() == R.id.action_settings){
                           showLayout(4);
                           return true;
                       }
                       return false;
                    }
                });
    }
    private void showLayout(int id){
        if (id==1){
            profileLayout.setVisibility(View.VISIBLE);
            mycCarLayout.setVisibility(View.GONE);
            carLayout.setVisibility(View.GONE);
            settingsLayout.setVisibility(View.GONE);
        }else if(id==2){
            profileLayout.setVisibility(View.GONE);
            mycCarLayout.setVisibility(View.VISIBLE);
            carLayout.setVisibility(View.GONE);
            settingsLayout.setVisibility(View.GONE);
        }
        else if(id==3){
            profileLayout.setVisibility(View.GONE);
            mycCarLayout.setVisibility(View.GONE);
            carLayout.setVisibility(View.VISIBLE);
            settingsLayout.setVisibility(View.GONE);
        }else {
            profileLayout.setVisibility(View.GONE);
            mycCarLayout.setVisibility(View.GONE);
            carLayout.setVisibility(View.GONE);
            settingsLayout.setVisibility(View.VISIBLE);
        }
    }

}