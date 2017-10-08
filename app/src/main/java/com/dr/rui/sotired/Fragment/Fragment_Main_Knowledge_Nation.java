package com.dr.rui.sotired.Fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dr.rui.sotired.R;

public class Fragment_Main_Knowledge_Nation extends Fragment implements Fragment_Main_Knowledge.CallbackFromFragment {
    //private ExpandableListView expandableListView;
    private FragmentManager fragmentManager;
    private Fragment_Main_Knowledge_Nation_Blow fragment_main_knowledge_nation_blow;
    private Fragment_Main_Knowledge_Nation_Blow fragment_main_knowledge_nation_la;
    private Fragment_Main_Knowledge_Nation_Blow fragment_main_knowledge_nation_tan;
    private Fragment_Main_Knowledge_Nation_Blow fragment_main_knowledge_nation_da;
    private CallbackFromFragmentBlow callbackFromFragmentBlow;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_knowledge_nation, container, false);
        //expandableListView = (ExpandableListView) view.findViewById(R.id.expandableListView_instrument);

        fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragment_main_knowledge_nation_blow = Fragment_Main_Knowledge_Nation_Blow.newInstance(0);
        fragment_main_knowledge_nation_la = Fragment_Main_Knowledge_Nation_Blow.newInstance(1);
        fragment_main_knowledge_nation_tan = Fragment_Main_Knowledge_Nation_Blow.newInstance(2);
        fragment_main_knowledge_nation_da = Fragment_Main_Knowledge_Nation_Blow.newInstance(3);

        fragmentTransaction.add(R.id.frameLayout_main_knowledge_nation_blow, fragment_main_knowledge_nation_blow);
        fragmentTransaction.add(R.id.frameLayout_main_knowledge_nation_la, fragment_main_knowledge_nation_la);
        fragmentTransaction.add(R.id.frameLayout_main_knowledge_nation_tan, fragment_main_knowledge_nation_tan);
        fragmentTransaction.add(R.id.frameLayout_main_knowledge_nation_da, fragment_main_knowledge_nation_da);

        fragmentTransaction.show(fragment_main_knowledge_nation_blow).show(fragment_main_knowledge_nation_la).show(fragment_main_knowledge_nation_tan).show(fragment_main_knowledge_nation_da).commitAllowingStateLoss();
        return view;
    }

    @Override
    public void sendMessage(int type) {
        switch (type) {
            case 0:
                callbackFromFragmentBlow = fragment_main_knowledge_nation_blow;
                break;
            case 1:
                callbackFromFragmentBlow = fragment_main_knowledge_nation_la;
                break;
            case 2:
                callbackFromFragmentBlow = fragment_main_knowledge_nation_tan;
                break;
            case 3:
                callbackFromFragmentBlow = fragment_main_knowledge_nation_da;
                break;
        }
        //
        callbackFromFragmentBlow.sendMessage(type);
    }

    public interface CallbackFromFragmentBlow {
        void sendMessage(int type);
    }
}
