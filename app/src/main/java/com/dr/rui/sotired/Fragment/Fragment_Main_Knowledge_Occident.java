package com.dr.rui.sotired.Fragment;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.dr.rui.sotired.R;

public class Fragment_Main_Knowledge_Occident extends Fragment implements Fragment_Main_Knowledge.CallbackFromFragment {
    private ExpandableListView expandableListView;

    private FragmentManager fragmentManager;
    private Fragment_Main_Knowledge_Nation_Blow fragment_main_knowledge_occident_blow;
    private Fragment_Main_Knowledge_Nation_Blow fragment_main_knowledge_occident_la;
    private Fragment_Main_Knowledge_Nation_Blow fragment_main_knowledge_occident_tan;
    private Fragment_Main_Knowledge_Nation_Blow fragment_main_knowledge_occident_da;
    private CallbackFromFragmentBlow callbackFromFragmentBlow;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_knowledge_occident, container, false);
        //expandableListView = (ExpandableListView) view.findViewById(R.id.expandableListView_instrument);

        fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragment_main_knowledge_occident_blow = Fragment_Main_Knowledge_Nation_Blow.newInstance(4);
        fragment_main_knowledge_occident_la = Fragment_Main_Knowledge_Nation_Blow.newInstance(5);
        fragment_main_knowledge_occident_tan = Fragment_Main_Knowledge_Nation_Blow.newInstance(6);
        fragment_main_knowledge_occident_da = Fragment_Main_Knowledge_Nation_Blow.newInstance(7);

        fragmentTransaction.add(R.id.frameLayout_main_knowledge_occident_blow, fragment_main_knowledge_occident_blow);
        fragmentTransaction.add(R.id.frameLayout_main_knowledge_occident_la, fragment_main_knowledge_occident_la);
        fragmentTransaction.add(R.id.frameLayout_main_knowledge_occident_tan, fragment_main_knowledge_occident_tan);
        fragmentTransaction.add(R.id.frameLayout_main_knowledge_occident_da, fragment_main_knowledge_occident_da);

        fragmentTransaction.show(fragment_main_knowledge_occident_blow).show(fragment_main_knowledge_occident_la).show(fragment_main_knowledge_occident_tan).show(fragment_main_knowledge_occident_da).commit();
        return view;
    }

    @Override
    public void sendMessage(int type) {
        switch (type) {
            case 4:
                callbackFromFragmentBlow = fragment_main_knowledge_occident_blow;
                break;
            case 5:
                callbackFromFragmentBlow = fragment_main_knowledge_occident_la;
                break;
            case 6:
                callbackFromFragmentBlow = fragment_main_knowledge_occident_tan;
                break;
            case 7:
                callbackFromFragmentBlow = fragment_main_knowledge_occident_da;
                break;
        }
        //
        callbackFromFragmentBlow.sendMessage(type);
    }

    public interface CallbackFromFragmentBlow {
        void sendMessage(int type);
    }
}
