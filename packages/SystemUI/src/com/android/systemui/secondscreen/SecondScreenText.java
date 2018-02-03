package com.android.systemui.secondscreen;

import android.graphics.Color;
//import android.app.Fragment; // ETM
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View; // ETM
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.systemui.R; // ETM

public class SecondScreenText extends Fragment {

    @Override
// ETM -- private --> public
// Cannot reduce the visibility of the inherited method from Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.second_screen_text, container, false);
        TextView text = (TextView) rootView.findViewById(R.id.second_screen_text);
        text.setText("V20");
        text.setTextColor(Color.WHITE);
        return rootView; // was rootview case?
    }

}
