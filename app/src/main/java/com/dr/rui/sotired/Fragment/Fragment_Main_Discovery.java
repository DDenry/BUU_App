package com.dr.rui.sotired.Fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dr.rui.sotired.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Main_Discovery extends Fragment {
    private FragmentManager fragmentManager;

    public static Fragment_Main_Discovery newInstance() {
        Fragment_Main_Discovery fragment = new Fragment_Main_Discovery();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment__main__discovery, container, false);

        return view;
    }

}
