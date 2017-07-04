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

public class Fragment_Test_Special_Question_Type extends Fragment {

    private ListView listView_question;
    private SimpleAdapter simpleAdapter_question;
    private ArrayList<HashMap<String, Object>> listItem_question;

    private int[] icon = new int[]{R.drawable.viewcompress, R.drawable.viewcompress1, R.drawable.viewcompress2};
    private String[] text = new String[]{"耳聪目慧", "博闻强识", "观察入微"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragment_test_question = inflater.inflate(R.layout.fragment_fragment__test__question, container, false);
        listView_question = (ListView) fragment_test_question.findViewById(R.id.listView_question);
        listItem_question = new ArrayList<>();
        simpleAdapter_question = new SimpleAdapter(getActivity(), listItem_question, R.layout.item_question, new String[]{"icon", "text"}, new int[]{R.id.imageView_question_icon, R.id.textView_question_text});
        listView_question.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
                }
                startActivity(intent);
            }
        });

        for (int i = 0; i < 3; i++) {
            HashMap<String, Object> map_nation = new HashMap<>();
            map_nation.put("icon", icon[i]);
            map_nation.put("text", text[i]);
            //Log.i("INFORMATION:", "" + i);
            listItem_question.add(map_nation);
        }
        listView_question.setAdapter(simpleAdapter_question);
        return fragment_test_question;
    }

}
