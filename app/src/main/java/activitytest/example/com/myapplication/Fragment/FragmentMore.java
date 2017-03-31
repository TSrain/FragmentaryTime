package activitytest.example.com.myapplication.Fragment;

/**
 * Created by lawrence on 2017/3/7.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import activitytest.example.com.myapplication.MyApplication;
import activitytest.example.com.myapplication.R;
import activitytest.example.com.myapplication.adapter.MessageAdapter;
import activitytest.example.com.myapplication.entity.Message;

public class FragmentMore extends Fragment {
    private List<Message> messageList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_more, container, false);
    }
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        initMessage();
        MessageAdapter adapter = new MessageAdapter(MyApplication.getContext(), R.layout.message_item, messageList);
        ListView listView = (ListView) getActivity().findViewById(R.id.list_blacklist);
        listView.setAdapter(adapter);
    }

    private void initMessage() {
        for (int i=0;i<20;i++) {
            Message xuanshang = new Message("陪跑步", R.drawable.message_bgblue, 0, R.drawable.message_xuanshang);
            messageList.add(xuanshang);
            Message lingshi = new Message("空闲3小时", R.drawable.message_bggreen, 4, R.drawable.message_lingshi);
            messageList.add(lingshi);
            Message daike = new Message("代课", R.drawable.message_bgblue, 2, R.drawable.message_xuanshang);
            messageList.add(daike);
        }
    }
}
