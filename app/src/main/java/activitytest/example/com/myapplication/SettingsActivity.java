package activitytest.example.com.myapplication;



import android.content.Intent;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.List;

public class SettingsActivity extends BaseActivity implements View.OnClickListener{
LinearLayout gerenshezhi;
    LinearLayout xiaoxitongzhi;
    LinearLayout neicunqingli;
    LinearLayout banbengengxin;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      setContentView(R.layout.setting_activity);
gerenshezhi=(LinearLayout)findViewById(R.id.gerenshezhi);
        xiaoxitongzhi=(LinearLayout)findViewById(R.id.xiaoxitongzhi);
        neicunqingli=(LinearLayout)findViewById(R.id.neicunqingli);
        banbengengxin=(LinearLayout)findViewById(R.id.banbengengxin);
        back=(Button)findViewById(R.id.back_button);
        back.setOnClickListener(this);
        gerenshezhi.setOnClickListener(this);
        xiaoxitongzhi.setOnClickListener(this);
        neicunqingli.setOnClickListener(this);
        banbengengxin.setOnClickListener(this);
        }
    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.gerenshezhi:
                break;
            case R.id.xiaoxitongzhi:
                Intent intent1=new Intent(SettingsActivity.this,NotificationActivity.class);
                startActivity(intent1);
                break;
            case R.id.neicunqingli:
                break;
            case R.id.banbengengxin:
                Intent intent2=new Intent(SettingsActivity.this,VersionActivity.class);
                startActivity(intent2);
                break;
            case R.id.back_button:
                finish();
                break;
        }
    }

    }
