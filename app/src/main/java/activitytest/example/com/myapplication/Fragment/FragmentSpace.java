package activitytest.example.com.myapplication.Fragment;

/**
 * Created by lawrence on 2017/3/7.
 */


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import activitytest.example.com.myapplication.BriefActivity;
import activitytest.example.com.myapplication.MoreinformationActivity;
import activitytest.example.com.myapplication.R;
import activitytest.example.com.myapplication.searchActivity;

public class FragmentSpace extends Fragment implements View.OnClickListener{
  LinearLayout jianjie;
    LinearLayout gengduoziliao;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_space, container, false);
    }
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        jianjie=(LinearLayout)getActivity().findViewById(R.id.jianjie);
        gengduoziliao=(LinearLayout)getActivity().findViewById(R.id.gengduoziliao);
        gengduoziliao.setOnClickListener(this);
        jianjie.setOnClickListener(this);

    }
    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.jianjie:
                Intent intent1=new Intent(getActivity(),BriefActivity.class);
                getActivity().startActivity(intent1);
                break;
            case R.id.gengduoziliao:
                Intent intent2=new Intent(getActivity(),MoreinformationActivity.class);
                getActivity().startActivity(intent2);
                break;
        }
    }
}
