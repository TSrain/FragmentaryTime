package activitytest.example.com.myapplication.Fragment;

/**
 * Created by lawrence on 2017/3/7.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import activitytest.example.com.myapplication.MyApplication;
import activitytest.example.com.myapplication.adapter.OfferAdapter;
import activitytest.example.com.myapplication.entity.offer;
import activitytest.example.com.myapplication.R;

public class FragmentAt extends Fragment {
    private offer[] offers={new offer("帮打扫","20元","1小时",R.drawable.bang_dasao),
            new offer("帮取快递","8元","少于20分钟",R.drawable.bang_qukuaidi),
            new offer("代课","面议","1.5小时",R.drawable.dai_ke),
            new offer("接孩子","25元","40分钟",R.drawable.jie_haizi),
            new offer("陪跑步","20元","1小时",R.drawable.pei_paobu),
            new offer("陪备考","面议（女士优先）","不定时",R.drawable.pei_beikao),
            new offer("帮修电脑","40元","1次",R.drawable.xiu_diannao)};
    private List<offer> offerList=new ArrayList<>();
//    private SwipeRefreshLayout swipeRefresh;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

     return    inflater.inflate(R.layout.fragment_at, container, false);

    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        initOffers();
        RecyclerView recyclerView=(RecyclerView)getActivity().findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager=new GridLayoutManager(MyApplication.getContext(),2);
        recyclerView.setLayoutManager(layoutManager);
        OfferAdapter adapter;
        adapter =new OfferAdapter(offerList);
        recyclerView.setAdapter(adapter);
//        swipeRefresh=(SwipeRefreshLayout)getView().findViewById(R.id.swipe_refresh);
//        swipeRefresh.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));
//        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                refreshOffers();
//            }
//        });

    }

//    private void refreshOffers(){
//        new Thread(new Runnable(){
//            @Override
//            public void run(){
//                try{
//                    Thread.sleep(2000);
//                }catch (InterruptedException e){
//                    e.printStackTrace();
//                }
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        initOffers();
//                        adapter.notifyDataSetChanged();
//                        swipeRefresh.setRefreshing(false);
//                    }
//                });
//            }
//        }).start();
//    }
    private void initOffers(){
        offerList.clear();
        for (int j=0;j<6;j++){
            for (int i = 0; i < 6; i++) {
                offerList.add(offers[i]);
            }
        }

    }

}