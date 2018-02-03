package com.android.systemui.secondscreen;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View; // ETM
import android.view.ViewGroup;

import com.android.systemui.R; // ETM

public class SecondScreenToggles extends Fragment {

    @Override
// ETM -- private --> public
// Cannot reduce the visibility of the inherited method from Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.second_screen_toggles, container, false);
        return rootView; // was rootview case?
    }

}
