package com.example.diceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MarketActivity extends AppCompatActivity {

    private Button buttonRed, buttonBlue, buttonGreen;
    private Fragment currentFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);

        Button buttonToMain = (Button) findViewById(R.id.mainButton);
        buttonToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        BottomNavigationView bottomNavigationMenuView = findViewById(R.id.navi);
        bottomNavigationMenuView.setOnItemSelectedListener(item ->{
            if(item.getItemId() == R.id.red_button){
                if(currentFragment instanceof RedFragment){
                    removeFragment();
                } else {
                    replaceFragment(new RedFragment());
                }
                return true;
            }
            else if(item.getItemId()==R.id.green_button){
                if(currentFragment instanceof GreenFragment){
                    removeFragment();
                } else {
                    replaceFragment(new GreenFragment());
                }
                return true;
            }
            else if(item.getItemId()==R.id.blue_button){
                if(currentFragment instanceof BlueFragment){
                    removeFragment();
                } else {
                    replaceFragment(new BlueFragment());
                }
                return true;
            }
            return false;
        });
    }
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentmanager = getSupportFragmentManager();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
        currentFragment = fragment;
    }

    private void removeFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.remove(currentFragment);
        transaction.commit();
        currentFragment = null;
    }
}