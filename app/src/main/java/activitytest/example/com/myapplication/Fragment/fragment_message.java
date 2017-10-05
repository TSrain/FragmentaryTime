package activitytest.example.com.myapplication.Fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import activitytest.example.com.myapplication.MyApplication;
import activitytest.example.com.myapplication.R;
import activitytest.example.com.myapplication.adapter.MessageAdapter;
import activitytest.example.com.myapplication.entity.Message;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by lawrence on 2017/4/18.
 */

public class fragment_message extends LazyLoadFragment{
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
