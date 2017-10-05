package activitytest.example.com.myapplication.Fragment;

/**
 * Created by lawrence on 2017/3/7.
 */
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import activitytest.example.com.myapplication.MyApplication;
import activitytest.example.com.myapplication.R;
import activitytest.example.com.myapplication.adapter.MessageAdapter;
import activitytest.example.com.myapplication.adapter.PDFragmentAdapter;
import activitytest.example.com.myapplication.entity.Message;
import de.hdodenhof.circleimageview.CircleImageView;

public class FragmentMore extends Fragment {
    private TextView tvtittlecontent;
    private TextView tvtittlecontent2;
    TabLayout tittles;
    ViewPager vpdetails;
    private fragment_message fragment1;
    private fragment_friends fragment2;
    protected List<Fragment> mFragmentList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_more, container, false);

    }
    private void initViewpager(){
//
//    tittles.setupWithViewPager(vpdetails);
        vpdetails.setAdapter(new PDFragmentAdapter(getActivity().getSupportFragmentManager(),mFragmentList));
//    vpdetails.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                tittles.getTabAt(position).select();
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
        vpdetails.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tittles));
    }
    private void initToolbars(){


        tittles.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vpdetails.setCurrentItem(tab.getPosition());
                switch (tab.getPosition()){
                    case 0:  tvtittlecontent.setTextColor(getResources().getColor(R.color.blue));
                        tvtittlecontent.setTextSize(16);
                        break;
                    case 1:tvtittlecontent2.setTextColor(getResources().getColor(R.color.blue));
                        tvtittlecontent2.setTextSize(16);
                    default:break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tvtittlecontent.setTextColor(getResources().getColor(R.color.base_color_text_black));
                tvtittlecontent.setTextSize(14);
                tvtittlecontent2.setTextColor(getResources().getColor(R.color.base_color_text_black));
                tvtittlecontent2.setTextSize(14);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        tittles=(TabLayout)getActivity().findViewById(R.id.tabtittle);
        vpdetails=(ViewPager)getActivity().findViewById(R.id.vpdetail);
        fragment1=new fragment_message();
        fragment2=new fragment_friends();
        mFragmentList.add(fragment1);
        mFragmentList.add(fragment2);
        tittles.addTab(tittles.newTab().setCustomView(R.layout.history_tab1));
        tvtittlecontent=(TextView)getActivity().findViewById(R.id.tabcontent1);
        tvtittlecontent.setText("消息");
        tvtittlecontent.setTextColor(getResources().getColor(R.color.blue));
        tvtittlecontent.setTextSize(15);
        tittles.addTab(tittles.newTab().setCustomView(R.layout.history_tab2));
        tvtittlecontent2=(TextView)getActivity().findViewById(R.id.tabcontent2);
        tvtittlecontent2.setText("好友");
        tvtittlecontent2.setTextColor(getResources().getColor(R.color.base_color_text_black));
        tvtittlecontent2.setTextSize(15);
        tittles.setTabGravity(TabLayout.GRAVITY_CENTER);
        tittles.setTabMode(TabLayout.MODE_FIXED);
        initViewpager();
        initToolbars();

    }


}
