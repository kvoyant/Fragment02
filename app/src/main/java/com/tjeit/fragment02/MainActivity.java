package com.tjeit.fragment02;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.tjeit.fragment02.databinding.ActivityMainBinding;
import com.tjeit.fragment02.fragments.FragmentTwo;

public class MainActivity extends BaseActivity {
    ActivityMainBinding act;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        act.changeFragTwoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fr = new FragmentTwo();

                FragmentManager frManager = getSupportFragmentManager();
                FragmentTransaction frTransaction = frManager.beginTransaction();
                frTransaction.replace(R.id.fragOne, fr);
                frTransaction.commit();
            }
        });
    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {
        act = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }
}
