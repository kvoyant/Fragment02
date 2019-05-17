package com.tjeit.fragment02;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.tjeit.fragment02.adapters.PagerAdapter;
import com.tjeit.fragment02.databinding.ActivityMainBinding;
import com.tjeit.fragment02.fragments.FragmentOne;

public class MainActivity extends BaseActivity {
    ActivityMainBinding act;
    PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

        act.okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                버튼이 눌렀을때 하고 싶은 일?

//                1. 지금 보여지고 있는 Fragment에 접근
//                => 현재 작성중인 MainActivity 에서?

                Fragment currentFrag = pagerAdapter.getItem(act.viewPager.getCurrentItem());

//                2. 접근한 Fragment에게 어떻게 작업을 시킬건지 ?

                if(act.viewPager.getCurrentItem() == 0) {
//                    currentFrag가 FragmentOne 이다!
                    ((FragmentOne) currentFrag).changeTextMsg(act.testEdt.getText().toString());
                }
                else if(act.viewPager.getCurrentItem() == 1) {
//                    currentFrag가 FragmentTwo 이다!
                }
                else if(act.viewPager.getCurrentItem() == 2) {
//                    currentFrag가 FragmentThree 이다!
                }

            }
        });

//        뷰페이저 페이지 변경 이벤트 처리
        act.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if (i == 0) {
                    act.changeFragOneBtn.setText("현재 선택됨");
                    act.changeFragTwoBtn.setText("2번 프래그먼트");
                    act.changeFragThreeBtn.setText("3번 프래그먼트");
                } else if (i == 1) {
                    act.changeFragOneBtn.setText("1번 프래그먼트");
                    act.changeFragTwoBtn.setText("현재 선택됨");
                    act.changeFragThreeBtn.setText("3번 프래그먼트");
                } else if (i == 2) {
                    act.changeFragOneBtn.setText("1번 프래그먼트");
                    act.changeFragTwoBtn.setText("2번 프래그먼트");
                    act.changeFragThreeBtn.setText("현재 선택됨");
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        act.changeFragOneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                act.viewPager.setCurrentItem(0);

                act.changeFragOneBtn.setText("현재 선택됨");
                act.changeFragTwoBtn.setText("2번 프래그먼트");
                act.changeFragThreeBtn.setText("3번 프래그먼트");
            }
        });

        act.changeFragTwoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Fragment fr = new FragmentTwo();
//
//                FragmentManager frManager = getSupportFragmentManager();
//                FragmentTransaction frTransaction = frManager.beginTransaction();
//                frTransaction.replace(R.id.fragOne, fr);
//                frTransaction.commit();

                act.viewPager.setCurrentItem(1);

                act.changeFragOneBtn.setText("1번 프래그먼트");
                act.changeFragTwoBtn.setText("현재 선택됨");
                act.changeFragThreeBtn.setText("3번 프래그먼트");
            }
        });

        act.changeFragThreeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                act.viewPager.setCurrentItem(2);

                act.changeFragOneBtn.setText("1번 프래그먼트");
                act.changeFragTwoBtn.setText("2번 프래그먼트");
                act.changeFragThreeBtn.setText("현재 선택됨");
            }
        });
    }

    @Override
    public void setValues() {

        act.viewPager.setOffscreenPageLimit(4); // 프래그먼의 갯수와 맞춰주자 !

        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), 3);
        act.viewPager.setAdapter(pagerAdapter);
    }

    @Override
    public void bindViews() {
        act = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }
}
