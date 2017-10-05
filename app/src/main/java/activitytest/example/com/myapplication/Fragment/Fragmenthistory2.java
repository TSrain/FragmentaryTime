package activitytest.example.com.myapplication.Fragment;

/**
 * Created by lawrence on 2017/4/16.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import activitytest.example.com.myapplication.MyApplication;
import activitytest.example.com.myapplication.R;
import activitytest.example.com.myapplication.adapter.OfferAdapter;
import activitytest.example.com.myapplication.entity.offer;

/**
 * Created by lawrence on 2017/4/16.
 */

public class Fragmenthistory2 extends LazyLoadFragment {
    private offer[] offers={new offer("帮打扫","20元","1小时",R.drawable.bang_dasao),
            new offer("帮取快递","8元","少于20分钟",R.drawable.bang_qukuaidi),
            new offer("代课","面议","1.5小时",R.drawable.dai_ke),
            new offer("接孩子","25元","40分钟",R.drawable.jie_haizi),
            new offer("陪跑步","20元","1小时",R.drawable.pei_paobu),
            new offer("陪备考","面议（女士优先）","不定时",R.drawable.pei_beikao),
            new offer("帮修电脑","40元","1次",R.drawable.xiu_diannao)};
    private List<offer> offerList=new ArrayList<>();
    @Override
    protected void lazyLoad() {
        initOffers();
        RecyclerView recyclerView=(RecyclerView)getContentView().findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager=new GridLayoutManager(MyApplication.getContext(),1);
        recyclerView.setLayoutManager(layoutManager);
        OfferAdapter adapter;
        adapter =new OfferAdapter(offerList);
        recyclerView.setAdapter(adapter);
        String message = "Fragment2" + (isInit ? "已经初始并已经显示给用户可以加载数据" : "没有初始化不能加载数据")+">>>>>>>>>>>>>>>>>>>";
        showToast(message);
        Log.d(TAG, message);
    }
    private void initOffers(){
        offerList.clear();
        for (int j=0;j<6;j++){
            for (int i = 3; i > 0; i--) {
                offerList.add(offers[i]);
            }
        }
    }

    @Override
    protected int setContentView() {
        return R.layout.fragment_at;
    }

    @Override
    protected void stopLoad() {
        super.stopLoad();
        Log.d(TAG, "Fragment2" + "已经对用户不可见，可以停止加载数据");
    }
}
