package activitytest.example.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BriefActivity extends AppCompatActivity implements View.OnClickListener{
    private Button back;
    private Button fabu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brief);
        back = (Button) findViewById(R.id.back_button);
        fabu = (Button) findViewById(R.id.fabubotton);
        back.setOnClickListener(this);
        fabu.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_button:
                finish();
                break;
            case R.id.fabubotton:
                Toast.makeText(BriefActivity.this,"修改成功"+" ✔️ ",Toast.LENGTH_LONG).show();
                finish();
        }
    }
}
