package com.dr.rui.sotired.Fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.dr.rui.sotired.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Main_Discovery extends Fragment {
    private FragmentManager fragmentManager;
    private ViewPager viewPager;
    private List<View> views;
    private ImageView imageView_discovery_info1;

    public static Fragment_Main_Discovery newInstance() {
        Fragment_Main_Discovery fragment = new Fragment_Main_Discovery();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment__main__discovery, container, false);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager_discovery);
        views = new ArrayList<>();
        views.add(inflater.inflate(R.layout.info1, null));
        views.add(inflater.inflate(R.layout.info1, null));
        views.add(inflater.inflate(R.layout.info1, null));
        views.add(inflater.inflate(R.layout.info1, null));
        views.add(inflater.inflate(R.layout.info1, null));
        imageView_discovery_info1 = (ImageView) views.get(0).findViewById(R.id.imageView_discovery_info1);
        imageView_discovery_info1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "此时应该跳转至相应网页~", Toast.LENGTH_LONG).show();
            }
        });
        PagerAdapter pagerAdapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return views.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(views.get(position));
                return views.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {

                container.removeView(views.get(position));
            }
        };
        viewPager.setAdapter(pagerAdapter);

        return view;
    }

}
