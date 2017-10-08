package com.dr.rui.sotired.Fragment;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dr.rui.sotired.R;

public class Fragment_Main_Knowledge_Nation_Blow extends Fragment implements Fragment_Main_Knowledge_Nation.CallbackFromFragmentBlow, Fragment_Main_Knowledge_Occident.CallbackFromFragmentBlow {
    private int type;
    private FragmentManager fragmentManager;
    private Fragment_Main_Knowledge_Play_Ways fragment_main_knowledge_play_ways;
    private Fragment_Main_Knowledge_Instrument fragment_main_knowledge_instrument;
    private ImageView button_test;

    /* public Fragment_Main_Knowledge_Nation_Blow(int type) {
         this.type = type;
     }*/

    public static Fragment_Main_Knowledge_Nation_Blow newInstance(int type) {
        Bundle args = new Bundle();
        args.putInt("type", type);
        Fragment_Main_Knowledge_Nation_Blow fragment = new Fragment_Main_Knowledge_Nation_Blow();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_knowledge_nation_blow, container, false);
        //
        Bundle args = getArguments();
        this.type = args.getInt("type");

        button_test = (ImageView) view.findViewById(R.id.button_test);

        fragmentManager = getFragmentManager();

        fragment_main_knowledge_play_ways = Fragment_Main_Knowledge_Play_Ways.newInstance(type);
        fragment_main_knowledge_instrument = Fragment_Main_Knowledge_Instrument.newInstance(type);

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (type) {
            case 0:
                fragmentTransaction.add(R.id.frameLayout_main_knowledge_nation_blow, fragment_main_knowledge_play_ways);
                fragmentTransaction.add(R.id.frameLayout_main_knowledge_nation_blow, fragment_main_knowledge_instrument);
                break;
            case 1:
                fragmentTransaction.add(R.id.frameLayout_main_knowledge_nation_la, fragment_main_knowledge_play_ways);
                fragmentTransaction.add(R.id.frameLayout_main_knowledge_nation_la, fragment_main_knowledge_instrument);
                break;
            case 2:
                fragmentTransaction.add(R.id.frameLayout_main_knowledge_nation_tan, fragment_main_knowledge_play_ways);
                fragmentTransaction.add(R.id.frameLayout_main_knowledge_nation_tan, fragment_main_knowledge_instrument);
                break;
            case 3:
                fragmentTransaction.add(R.id.frameLayout_main_knowledge_nation_da, fragment_main_knowledge_play_ways);
                fragmentTransaction.add(R.id.frameLayout_main_knowledge_nation_da, fragment_main_knowledge_instrument);
                break;
            case 4:
                fragmentTransaction.add(R.id.frameLayout_main_knowledge_occident_blow, fragment_main_knowledge_play_ways);
                fragmentTransaction.add(R.id.frameLayout_main_knowledge_occident_blow, fragment_main_knowledge_instrument);
                break;
            case 5:
                fragmentTransaction.add(R.id.frameLayout_main_knowledge_occident_la, fragment_main_knowledge_play_ways);
                fragmentTransaction.add(R.id.frameLayout_main_knowledge_occident_la, fragment_main_knowledge_instrument);
                break;
            case 6:
                fragmentTransaction.add(R.id.frameLayout_main_knowledge_occident_tan, fragment_main_knowledge_play_ways);
                fragmentTransaction.add(R.id.frameLayout_main_knowledge_occident_tan, fragment_main_knowledge_instrument);
                break;
            case 7:
                fragmentTransaction.add(R.id.frameLayout_main_knowledge_occident_da, fragment_main_knowledge_play_ways);
                fragmentTransaction.add(R.id.frameLayout_main_knowledge_occident_da, fragment_main_knowledge_instrument);
                break;
        }

        fragmentTransaction.show(fragment_main_knowledge_play_ways).hide(fragment_main_knowledge_instrument).commitAllowingStateLoss();
        //
        button_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                if (fragment_main_knowledge_instrument.isHidden())
                    fragmentTransaction.setCustomAnimations(R.animator.animator_fragment_enter, R.animator.animator_fragment_exit).show(fragment_main_knowledge_instrument).hide(fragment_main_knowledge_play_ways).commit();
                else
                    fragmentTransaction.setCustomAnimations(R.animator.animator_fragment_enter, R.animator.animator_fragment_exit).show(fragment_main_knowledge_play_ways).hide(fragment_main_knowledge_instrument).commit();
            }
        });
        return view;
    }

    @Override
    public void sendMessage(int type) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (fragment_main_knowledge_instrument.isHidden())
            fragmentTransaction.setCustomAnimations(R.animator.animator_fragment_enter, R.animator.animator_fragment_exit).show(fragment_main_knowledge_instrument).hide(fragment_main_knowledge_play_ways).commit();
        else
            fragmentTransaction.setCustomAnimations(R.animator.animator_fragment_enter, R.animator.animator_fragment_exit).show(fragment_main_knowledge_play_ways).hide(fragment_main_knowledge_instrument).commit();
    }
}
