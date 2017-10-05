package activitytest.example.com.myapplication;

import android.os.Bundle;
import android.print.PageRange;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import activitytest.example.com.myapplication.MainActivity;

/**
 * Created by lawrence on 2017/4/11.
 */

public class FabuActivity extends BaseActivity implements View.OnClickListener {
   private Button home;
   private Button fabu;
   private EditText e1;
    private EditText e2;
    private EditText e3;
    private EditText e4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fabu);
        init();
    }

    public void init() {
        home = (Button) findViewById(R.id.home_button);
        fabu = (Button) findViewById(R.id.fabubotton);
        e1=(EditText)findViewById(R.id.edit1);
        e2=(EditText)findViewById(R.id.edit2);
        e3=(EditText)findViewById(R.id.edit3);
        e4=(EditText)findViewById(R.id.edit4);
        home.setOnClickListener(this);
        fabu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_button:
                finish();
                break;
            case R.id.fabubotton:
                String s1=e1.getText().toString();
                String s2=e1.getText().toString();
                String s3=e1.getText().toString();
                String s4=e1.getText().toString();
                //传值逻辑、判空逻辑未写
                Toast.makeText(FabuActivity.this,"发布成功"+" ✔️ ",Toast.LENGTH_LONG).show();
                finish();
        }
    }
}
