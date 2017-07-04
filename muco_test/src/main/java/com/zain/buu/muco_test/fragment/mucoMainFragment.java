package com.zain.buu.muco_test.fragment;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zain.buu.muco_test.R;
import com.zain.buu.muco_test.entity.HomeGird;
import com.zain.buu.muco_test.util.Image;
import com.zain.buu.muco_test.view.AdScrollLayout;
import com.zain.buu.muco_test.view.MyGridVIew;
import com.zain.buu.muco_test.view.MyScrollView;

import java.util.ArrayList;

/**
 * Created by Zain on 2016/3/20.
 * <p>
 * Fragment
 * 主界面碎片
 */
public class mucoMainFragment extends Fragment {

    ICallbackLister1 callbackLister = null;
    private AdScrollLayout ad_scrollLayout; //广告栏布局
    private ViewPager viewPager;    //广告页布局
    private MyGridVIew myGridVIew; //滑动列表布局
    private MyScrollView myScrollView;  //整体滑动布局
    private ArrayList<View> bitMap = new ArrayList<View>(); //广告页布局集合
    private ArrayList<HomeGird> girdData = new ArrayList<HomeGird>();   //列表页集合
    private int wid;    //获取GirdView宽度

    public void setOnCallbackLister(ICallbackLister1 callbackLister) {
        this.callbackLister = callbackLister;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (!(activity instanceof ICallbackLister1)) {
            throw new IllegalStateException("必须实现接口");
        }
        callbackLister = (ICallbackLister1) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callbackLister = null;
    }

    /**
     * 创建View布局
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.muco_main_fragment, container, false);  //创建新布局
        findView(view); //获取布局文件
        init(); //初始化
        setOnclick();   //设置监听事件

        myGridVIew.post(new Runnable() {
            @Override
            public void run() { //单起线程获取
                wid = myGridVIew.getWidth();
                Log.d("zain", "wid" + wid);
            }
        });
        return view;
    }

    /**
     * 设置按键监听
     */
    public void setOnclick() {
        myGridVIew.setOnItemClickListener(new MyItemListener());
    }

    /**
     * 找对象
     */
    private void findView(View view) {
        ad_scrollLayout = (AdScrollLayout) view.findViewById(R.id.myAdScroll);
        viewPager = ad_scrollLayout.getViewPage();
        myGridVIew = (MyGridVIew) view.findViewById(R.id.myGirdView);
        myScrollView = (MyScrollView) view.findViewById(R.id.myScrollView);
    }

    /**
     * 初始化
     */
    private void init() {
        initAdData();   //初始化广告栏数据
        initGirdData(); //初始化列表数据
        viewPager.setAdapter(new Myadapter());  //为广告页设置适配器
        ad_scrollLayout.setPageFromTime(3000);  //广告切换定时器设置
        myGridVIew.setAdapter(new Adapter(getActivity()));  //为滑动列表设置适配器
        myScrollView.smoothScrollTo(0, 0);  //整体默认滑动到该位置
    }

    /**
     * 初始化GirdView数据
     */
    private void initGirdData() {

        HomeGird gird = new HomeGird();
        gird.setImg(R.mipmap.muco_piano1);
        gird.setIntroduce("钢琴");
        girdData.add(gird);

        HomeGird gird1 = new HomeGird();
        gird1.setImg(R.mipmap.muco_guqin1);
        gird1.setIntroduce("古琴");
        girdData.add(gird1);

        HomeGird gird2 = new HomeGird();
        gird2.setImg(R.mipmap.muco_kouqin1);
        gird2.setIntroduce("口琴");
        girdData.add(gird2);

        HomeGird gird3 = new HomeGird();
        gird3.setImg(R.mipmap.muco_jiazigu1);
        gird3.setIntroduce("架子鼓");
        girdData.add(gird3);

        HomeGird gird4 = new HomeGird();
        gird4.setImg(R.mipmap.muco_organ1);
        gird4.setIntroduce("ORGAN");
        girdData.add(gird4);

        HomeGird gird5 = new HomeGird();
        gird5.setImg(R.mipmap.muco_jita1);
        gird5.setIntroduce("吉它");
        girdData.add(gird5);

        HomeGird gird6 = new HomeGird();
        gird6.setImg(R.mipmap.muco_xiaotiqin1);
        gird6.setIntroduce("小提琴");
        girdData.add(gird6);

        HomeGird gird7 = new HomeGird();
        gird7.setImg(R.mipmap.muco_more1);
        gird7.setIntroduce("即将推出");
        girdData.add(gird7);
    }

    /**
     * 初始化广告的图片
     */
    private void initAdData() {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.ad_scroll_item, null);
        view.findViewById(R.id.adImg).setBackgroundResource(R.mipmap.muco_mainpic1);
        bitMap.add(view);

        LayoutInflater inflater1 = getActivity().getLayoutInflater();
        View view1 = inflater1.inflate(R.layout.ad_scroll_item, null);
        view1.findViewById(R.id.adImg).setBackgroundResource(R.mipmap.muco_piano1);
        bitMap.add(view1);

        LayoutInflater inflater2 = getActivity().getLayoutInflater();
        View view2 = inflater2.inflate(R.layout.ad_scroll_item, null);
        view2.findViewById(R.id.adImg).setBackgroundResource(R.mipmap.muco_kouqin1);
        bitMap.add(view2);

        LayoutInflater inflater3 = getActivity().getLayoutInflater();
        View view3 = inflater3.inflate(R.layout.ad_scroll_item, null);
        view3.findViewById(R.id.adImg).setBackgroundResource(R.mipmap.muco_guqin1);
        bitMap.add(view3);

    }

    //回传监听事件
    public interface ICallbackLister1 {
        void click(int id);
    }

    static class ViewHolder {
        ImageView img;
        TextView textView;
    }

    private class MyItemListener implements AdapterView.OnItemClickListener {
        public void onItemClick(AdapterView<?> parent, View view, int position, long rowid) {
            HomeGird homeGird = girdData.get(position); //获取被点击的实体
            callbackLister.click(homeGird.getImg());    //回调
        }
    }

    /**
     * 广告栏适配器
     */
    private class Myadapter extends PagerAdapter {

        @Override
        public int getCount() {
            return bitMap.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(bitMap.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(bitMap.get(position));
            return bitMap.get(position);
        }
    }

    /**
     * GirdView的适配器
     */
    private class Adapter extends BaseAdapter {
        Context context;
        LayoutInflater inflater;

        public Adapter(Context context) {
            this.context = context;
            inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return girdData.size();
        }

        @Override
        public Object getItem(int position) {
            return girdData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View converView, ViewGroup parent) {
            ViewHolder holder;
            if (converView == null) {    //第一次在加载这个第一屏数据的时候调用
                converView = inflater.inflate(R.layout.home_gird_item, null);
                holder = new ViewHolder();
                holder.img = (ImageView) converView.findViewById(R.id.mySmartImage);
                holder.textView = (TextView) converView.findViewById(R.id.myText);
                converView.setTag(holder);

            } else {
                holder = (ViewHolder) converView.getTag();
            }

            holder.img.setImageBitmap(Image.readBitMap(getActivity(), girdData.get(position).getImg()));
            //holder.img.setBackgroundResource(girdData.get(position).getImg());
            holder.textView.setText(girdData.get(position).getIntroduce());
            converView.setLayoutParams(new AbsListView.LayoutParams(ActionBar.LayoutParams.FILL_PARENT, wid / 2));

            return converView;
        }

    }

}
