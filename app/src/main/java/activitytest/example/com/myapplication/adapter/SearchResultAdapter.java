package activitytest.example.com.myapplication.adapter;

import android.content.Context;

import java.util.List;

import activitytest.example.com.myapplication.R;
import activitytest.example.com.myapplication.entity.Bean;

/**
 * Created by lawrence on 2017/3/30.
 */

public class SearchResultAdapter extends CommonAdapter<Bean>{

    public SearchResultAdapter(Context context, List<Bean> data, int layoutId) {
        super(context, data, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, int position) {
        holder.setImageResource(R.id.item_search_iv_icon,mData.get(position).getIconId())
                .setText(R.id.item_search_tv_title,mData.get(position).getTitle())
                .setText(R.id.item_search_tv_content,mData.get(position).getContent())
                .setText(R.id.item_search_tv_comments,mData.get(position).getComments());
    }
}
