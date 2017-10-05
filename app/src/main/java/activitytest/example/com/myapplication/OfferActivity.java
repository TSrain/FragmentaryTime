package activitytest.example.com.myapplication;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.CollapsibleActionView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class OfferActivity extends AppCompatActivity {
   public static final String OFFER_NAME="offer_name";
    public static final String OFFER_IMAGE_ID="offer_image_id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer);
        Intent intent=getIntent();
        String offerName= intent.getStringExtra(OFFER_NAME);
        int offerImageId=intent.getIntExtra(OFFER_IMAGE_ID,0);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbarLayout=(CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
        ImageView offerImageView=(ImageView)findViewById(R.id.offer_image_view);
        TextView offerContentText=(TextView)findViewById(R.id.offer_content_text);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbarLayout.setTitle(offerName);
        Glide.with(this).load(offerImageId).into(offerImageView);
        String offerContent=generateOfferContent(offerName);
        offerContentText.setText(offerContent);
    }
    private String generateOfferContent(String offerName){
        StringBuilder offerContent =new StringBuilder();
        for (int i=0;i<500;i++){
            offerContent.append(offerName);
        }
        return  offerContent.toString();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return  super.onOptionsItemSelected(item);
    }
}

