package com.dr.rui.sotired.Fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dr.rui.sotired.Activity.Activity_Main;
import com.dr.rui.sotired.R;

public class Fragment_Main_Knowledge extends Fragment implements Activity_Main.CallbackFromActivity {

    private LinearLayout linearLayout;
    private Fragment_Main_Knowledge_Nation fragment_main_knowledge_nation;
    private Fragment_Main_Knowledge_Occident fragment_main_knowledge_occident;
    private FragmentManager fragmentManager;
    private TextView textView_Main_Knowledge_Nation;
    private TextView textView_Main_Knowledge_Occident;
    private CallbackFromFragment callbackFromFragment;

    public static Fragment_Main_Knowledge newInstance() {
        Fragment_Main_Knowledge fragment = new Fragment_Main_Knowledge();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_knowledge, container, false);

        linearLayout = (LinearLayout) view.findViewById(R.id.linearLayout_main_knowledge);

        textView_Main_Knowledge_Nation = (TextView) view.findViewById(R.id.textView_main_knowledge_nation);
        textView_Main_Knowledge_Occident = (TextView) view.findViewById(R.id.textView_main_knowledge_occident);

        textView_Main_Knowledge_Nation.setOnClickListener(new onClickListener());
        textView_Main_Knowledge_Occident.setOnClickListener(new onClickListener());

        fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragment_main_knowledge_nation = new Fragment_Main_Knowledge_Nation();
        fragment_main_knowledge_occident = new Fragment_Main_Knowledge_Occident();

        fragmentTransaction.add(R.id.frameLayout_main_knowledge, fragment_main_knowledge_nation);
        fragmentTransaction.add(R.id.frameLayout_main_knowledge, fragment_main_knowledge_occident);

        fragmentTransaction.show(fragment_main_knowledge_nation).hide(fragment_main_knowledge_occident).commitAllowingStateLoss();
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void receiveMessage(int type) {
        //
        if (type < 4) callbackFromFragment = fragment_main_knowledge_nation;
        else callbackFromFragment = fragment_main_knowledge_occident;
        callbackFromFragment.sendMessage(type);
    }

    //
    public interface CallbackFromFragment {
        void sendMessage(int type);
    }

    private class onClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            switch (v.getId()) {
                case R.id.textView_main_knowledge_nation:
                    linearLayout.setBackgroundResource(R.drawable.select_musical);
                    fragmentTransaction.show(fragment_main_knowledge_nation).hide(fragment_main_knowledge_occident).commit();
                    break;
                case R.id.textView_main_knowledge_occident:
                    linearLayout.setBackgroundResource(R.drawable.select_questions);
                    fragmentTransaction.show(fragment_main_knowledge_occident).hide(fragment_main_knowledge_nation).commit();
                    break;
            }
        }
    }
}
