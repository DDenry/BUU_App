package com.dr.rui.sotired.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.dr.rui.sotired.DataBase.InstrumentsInfo;
import com.dr.rui.sotired.R;

public class Activity_Search extends Activity {

    private ImageView imageView_search_back;
    private ImageView imageView_search_icon;
    private EditText editText_Search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__search);
        //
        init();
        imageView_search_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                Activity_Search.this.finish();
            }
        });
    }

    private void init() {
        imageView_search_back = (ImageView) findViewById(R.id.imageView_search_back);
        editText_Search = (EditText) findViewById(R.id.editText_search);
        imageView_search_icon = (ImageView) findViewById(R.id.imageView_search_icon);
        imageView_search_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText_Search.getText().toString().equals(""))
                    Toast.makeText(Activity_Search.this, "请输入要查询的乐器名称！（不可为空）", Toast.LENGTH_SHORT).show();
                else {
                    if (new InstrumentsInfo().getAllInstruments().contains(editText_Search.getText().toString().trim())) {
                        Intent intent = new Intent(Activity_Search.this, Activity_Instrument_1.class);
                        intent.putExtra("instrument_name", editText_Search.getText().toString().trim());
                        startActivity(intent);
                    } else
                        Toast.makeText(Activity_Search.this, "查询的乐器不存在，请重新输入！", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
