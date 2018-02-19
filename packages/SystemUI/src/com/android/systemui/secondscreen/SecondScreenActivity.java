package com.android.systemui.secondscreen;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
//import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentPagerAdapter;
//import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.LinearLayout;

import java.util.ArrayList;

import com.android.systemui.R;

public class SecondScreenActivity extends FragmentActivity implements OnTouchListener {

    private LinearLayout rootView;
    private ViewsPagerAdapter viewsPagerAdapter;
    private ViewPager viewPager;
    private WindowManager wm;
    LayoutInflater inflater;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);

        rootView = (LinearLayout) inflater.inflate(R.layout.second_screen_root, null);
        rootView.setBackgroundColor(Color.BLACK);
        rootView.setOnTouchListener(this);

        viewPager = (ViewPager) rootView.findViewById(R.id.second_screen_viewpager);
//        viewsPagerAdapter = new ViewsPagerAdapter(getFragmentManager());
        viewsPagerAdapter = new ViewsPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewsPagerAdapter);

        WindowManager.LayoutParams params = new WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.TYPE_SYSTEM_ERROR, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN, PixelFormat.TRANSLUCENT);
        params.gravity = Gravity.LEFT | Gravity.TOP;
        params.x = 400;
        params.y = 0;
        params.width = 1040;
        params.height = 160;
        wm.addView(rootView, params);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (rootView != null) {
            wm.removeView(rootView);
            rootView = null;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        System.out.println("SecondScreenTouch");
        return false;
    }

    class ViewsPagerAdapter extends FragmentPagerAdapter {
        private ArrayList<Fragment> frags = new ArrayList<>();
        
        public ViewsPagerAdapter(FragmentManager fm) {
            super(fm);
            frags.add((Fragment) new SecondScreenText());
            frags.add((Fragment) new SecondScreenToggles());
        }

        @Override
        public Fragment getItem(int position) {
            return (Fragment) frags.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "";//*
        }

        @Override
        public int getCount() {
            return frags.size();
        }
    }   

}
