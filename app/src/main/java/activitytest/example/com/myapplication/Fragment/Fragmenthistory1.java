package activitytest.example.com.myapplication.Fragment;

/**
 * Created by lawrence on 2017/4/16.
 */



import android.nfc.Tag;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import activitytest.example.com.myapplication.MyApplication;
import activitytest.example.com.myapplication.R;
import activitytest.example.com.myapplication.adapter.MessageAdapter;
import activitytest.example.com.myapplication.adapter.OfferAdapter;
import activitytest.example.com.myapplication.entity.Message;
import activitytest.example.com.myapplication.entity.offer;

/**
 * Created by lawrence on 2017/4/16.
 */
public class Fragmenthistory1 extends LazyLoadFragment {
    private List<Message> messageList = new ArrayList<>();
    @Override
    protected void lazyLoad() {
        for (int i=0;i<20;i++) {
            Message xuanshang = new Message("陪跑步", R.drawable.message_bgblue, 0, R.drawable.message_xuanshang);
            messageList.add(xuanshang);
            Message lingshi = new Message("空闲3小时", R.drawable.message_bggreen, 4, R.drawable.message_lingshi);
            messageList.add(lingshi);
            Message daike = new Message("代课", R.drawable.message_bgblue, 2, R.drawable.message_xuanshang);
            messageList.add(daike);
        }
        MessageAdapter adapter = new MessageAdapter(MyApplication.getContext(), R.layout.message_item, messageList);
        ListView listView = (ListView)getContentView().findViewById(R.id.list_blacklist);
        listView.setAdapter(adapter);
        String message = "Fragment1" + (isInit ? "已经初始并已经显示给用户可以加载数据" : "没有初始化不能加载数据")+">>>>>>>>>>>>>>>>>>>";
        showToast(message);
        Log.d(TAG, message);
    }


    @Override
    protected int setContentView() {
        return R.layout.fragment_messages;
    }

    @Override
    protected void stopLoad() {
        super.stopLoad();
        Log.d(TAG, "Fragment1" + "已经对用户不可见，可以停止加载数据");
    }
}

