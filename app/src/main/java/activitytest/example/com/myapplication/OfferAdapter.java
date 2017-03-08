package activitytest.example.com.myapplication;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import activitytest.example.com.myapplication.entity.offer;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.ViewHolder> {
  private Context mContext;
    private List<offer> mOfferList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView offerImage;
        TextView offertitle;
        TextView offertime;
        TextView offerpay;
        public ViewHolder(View view){
            super(view);
            cardView=(CardView) view;
            offerImage=(ImageView)view.findViewById(R.id.offer_image);
            offertitle=(TextView)view.findViewById(R.id.offer_title);
            offertime=(TextView)view.findViewById(R.id.offer_time);
            offertitle=(TextView)view.findViewById(R.id.offer_title);
            offerpay=(TextView)view.findViewById(R.id.offer_pay);
        }
    }
    public OfferAdapter (List<offer> offerList){
        mOfferList=offerList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        if(mContext==null){
            mContext=parent.getContext();
        }
        View view= LayoutInflater.from(mContext).inflate(R.layout.offer_item,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position= holder.getAdapterPosition();
                offer offer=mOfferList.get(position);
                Intent intent=new Intent(mContext,OfferActivity.class);
                intent.putExtra(OfferActivity.OFFER_NAME,offer.getTitle());
                intent.putExtra(OfferActivity.OFFER_IMAGE_ID,offer.getImageId());
                mContext.startActivity(intent);
            }
        });
        return holder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder ,int position){
        offer offer=mOfferList.get(position);
        holder.offertitle.setText(offer.getTitle());
        holder.offertime.setText(offer.getTime());
        holder.offerpay.setText(offer.getPay());
        Glide.with(mContext).load(offer.getImageId()).into(holder.offerImage);
    }
    @Override public int getItemCount(){
        return mOfferList.size();
    }
}
