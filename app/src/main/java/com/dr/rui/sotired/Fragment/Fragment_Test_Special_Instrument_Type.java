package com.dr.rui.sotired.Fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.dr.rui.sotired.Activity.Activity_Test_Content;
import com.dr.rui.sotired.Activity.Activity_Test_Recognition;
import com.dr.rui.sotired.Activity.Activity_Test_Single;
import com.dr.rui.sotired.R;

import java.util.ArrayList;
import java.util.HashMap;

public class Fragment_Test_Special_Instrument_Type extends Fragment {

    private ListView listView_instrument;
    private SimpleAdapter simpleAdapter_question;
    private ArrayList<HashMap<String, Object>> listItem_instrument;

    private int[] icon = new int[]{R.drawable.icon_blowing_n, R.drawable.icon_pullstring_n, R.drawable.icon_plucked_n, R.drawable.icon_percussion_n};
    private String[] text = new String[]{"吹管乐器", "拉弦乐器", "弹拨乐器", "打击乐器"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragment_test_music = inflater.inflate(R.layout.fragment_test_music_1, container, false);
        listView_instrument = (ListView) fragment_test_music.findViewById(R.id.listView_test_instrument);
        listItem_instrument = new ArrayList<>();
        simpleAdapter_question = new SimpleAdapter(getActivity(), listItem_instrument, R.layout.item_question, new String[]{"icon", "text"}, new int[]{R.id.imageView_question_icon, R.id.textView_question_text});
        listView_instrument.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;
                switch (position) {
                    case 0:
                        intent = new Intent(getActivity(), Activity_Test_Single.class);
                        break;
                    case 1:
                        intent = new Intent(getActivity(), Activity_Test_Content.class);
                        break;
                    case 2:
                        intent = new Intent(getActivity(), Activity_Test_Recognition.class);
                        break;
                    case 3:
                        intent = new Intent(getActivity(), Activity_Test_Recognition.class);
                        break;
                }
                startActivity(intent);
            }
        });

        for (int i = 0; i < 4; i++) {
            HashMap<String, Object> map_nation = new HashMap<>();
            map_nation.put("icon", icon[i]);
            map_nation.put("text", text[i]);
            //Log.i("INFORMATION:", "" + i);
            listItem_instrument.add(map_nation);
        }
        listView_instrument.setAdapter(simpleAdapter_question);
        return fragment_test_music;
    }

}
