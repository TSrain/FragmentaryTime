package activitytest.example.com.myapplication;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import activitytest.example.com.myapplication.util.CommonUtils;

/**
 * Created by lawrence on 2017/3/4.
 */

public class LoginActivity extends BaseActivity {


        EditText et_username, et_password;
        Button btn_login;
        TextView btn_register;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            // TODO Auto-generated method stub
            super.onCreate(savedInstanceState);
            setContentView(R.layout.login_activity);
            init();


//		showNotice();
        }

//        public void showNotice() {
//            DialogTips dialog = new DialogTips(this,"��ʾ",getResources().getString(R.string.show_notice), "ȷ��",true,true);
//
//            dialog.SetOnSuccessListener(new DialogInterface.OnClickListener() {
//                public void onClick(DialogInterface dialogInterface, int userId) {
//
//                }
//            });
//
//            dialog.show();
//            dialog = null;
//        }

        private void init() {
            et_username = (EditText) findViewById(R.id.et_username);
            et_password = (EditText) findViewById(R.id.et_password);
            btn_login = (Button) findViewById(R.id.btn_login);
            btn_register = (TextView) findViewById(R.id.btn_register);
            btn_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                                                 String name = et_username.getText().toString();
                                                 String password = et_password.getText().toString();

                                                 if (TextUtils.isEmpty(name)) {
                                                     ShowToast(R.string.toast_error_username_null);
                                                     return;
                                                 }

                                                 if (TextUtils.isEmpty(password)) {
                                                     ShowToast(R.string.toast_error_password_null);
                                                     return;
                                                 }

                                                 final ProgressDialog progress = new ProgressDialog(
                                                         LoginActivity.this);
                                                 progress.setMessage("正在登陆...");
                                                 progress.setCanceledOnTouchOutside(false);
                                                 progress.show();
                                                 if (name.equals("admin")&&password.equals("123456"))
                                                 { progress.setMessage("登陆成功...");
                                                     progress.dismiss();
                                                     Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                                                     startActivity(intent);
                                                 }
                                                 else {
                                                     progress.setMessage("登陆失败...");
                                                 }

                                             }
                                         });
                    btn_register.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (v == btn_register) {
                                Intent intent = new Intent(LoginActivity.this,
                                        RegisterActivity.class);
                                startActivity(intent);
                            } else {
                                boolean isNetConnected = CommonUtils.isNetworkAvailable(LoginActivity.this);
                                if (!isNetConnected) {
                                    ShowToast(R.string.network_tips);
                                    return;
                                }
                            }
                        }
                    });
        }



    }


