package activitytest.example.com.myapplication.Fragment;

import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import activitytest.example.com.myapplication.MyApplication;
import activitytest.example.com.myapplication.R;
import activitytest.example.com.myapplication.adapter.MessageAdapter;
import activitytest.example.com.myapplication.entity.Message;

/**
 * Created by lawrence on 2017/4/18.
 */

public class fragment_friends extends LazyLoadFragment {

    @Override
    protected void lazyLoad() {

        String message = "Fragment2" + (isInit ? "已经初始并已经显示给用户可以加载数据" : "没有初始化不能加载数据")+">>>>>>>>>>>>>>>>>>>";
        showToast(message);
        Log.d(TAG, message);
    }


    @Override
    protected int setContentView() {
        return R.layout.fragment_friends;
    }

    @Override
    protected void stopLoad() {
        super.stopLoad();
        Log.d(TAG, "Fragment1" + "已经对用户不可见，可以停止加载数据");
    }
}
