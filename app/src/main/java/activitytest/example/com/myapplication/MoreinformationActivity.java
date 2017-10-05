package activitytest.example.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MoreinformationActivity extends AppCompatActivity implements View.OnClickListener {
    private Button back;
    private Button queding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moreinformation);
        back = (Button) findViewById(R.id.back_button);
        queding = (Button) findViewById(R.id.fabubotton);
        back.setOnClickListener(this);
        queding.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_button:
                finish();
                break;
            case R.id.fabubotton:
                finish();
        }
    }
}
