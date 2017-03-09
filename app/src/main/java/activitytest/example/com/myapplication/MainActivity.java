package activitytest.example.com.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import activitytest.example.com.myapplication.Fragment.FragmentAt;
import activitytest.example.com.myapplication.Fragment.FragmentAuth;
import activitytest.example.com.myapplication.Fragment.FragmentMore;
import activitytest.example.com.myapplication.Fragment.FragmentSpace;
import activitytest.example.com.myapplication.entity.offer;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener{


    private FragmentAt fragmentAt;
    private FragmentAuth fragmentAuth;
    private FragmentSpace fragmentSpace;
    private FragmentMore fragmentMore;
    // ���岼�ֶ���
    private FrameLayout atFl, authFl, spaceFl, moreFl;

    // ����ͼƬ�������
    private ImageView atIv, authIv, spaceIv, moreIv;

    // ���尴ťͼƬ���
    private ImageView toggleImageView, plusImageView;

    // ����PopupWindow
    private PopupWindow popWindow;
    // ��ȡ�ֻ���Ļ�ֱ��ʵ���
    private DisplayMetrics dm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
//        点击滑动菜单图标变幻
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        initView();

        initData();

        // ��ʼ��Ĭ��Ϊѡ�е���ˡ���̬����ť
        clickAtBtn();

    }


  @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.only_xuanshang) {
            Intent logg=new Intent(MainActivity.this,LoginActivity.class);
            startActivity(logg);
            return true;
        }
        else if (id ==R.id.only_lingshi){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {

        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {
            Toast.makeText(MainActivity.this,"123123123",Toast.LENGTH_LONG).show();
        } else if (id == R.id.nav_send) {
            Intent log=new Intent(MainActivity.this,LoginActivity.class);
            startActivity(log);
        }else if(id==R.id.nav_header_main){

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void initView() {
        // ʵ�������ֶ���
        atFl = (FrameLayout) findViewById(R.id.layout_at);
        authFl = (FrameLayout) findViewById(R.id.layout_auth);
        spaceFl = (FrameLayout) findViewById(R.id.layout_space);
        moreFl = (FrameLayout) findViewById(R.id.layout_more);

        // ʵ����ͼƬ�������
        atIv = (ImageView) findViewById(R.id.image_at);
        authIv = (ImageView) findViewById(R.id.image_auth);
        spaceIv = (ImageView) findViewById(R.id.image_space);
        moreIv = (ImageView) findViewById(R.id.image_more);

        // ʵ������ťͼƬ���
        toggleImageView = (ImageView) findViewById(R.id.toggle_btn);
        plusImageView = (ImageView) findViewById(R.id.plus_btn);

    }

    /**
     * ��ʼ������
     */
    private void initData() {
        // �����ֶ������ü���
        atFl.setOnClickListener(this);
        authFl.setOnClickListener(this);
        spaceFl.setOnClickListener(this);
        moreFl.setOnClickListener(this);

        // ����ťͼƬ���ü���
        toggleImageView.setOnClickListener(this);
    }

    /**
     * ����¼�
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // �����̬��ť
            case R.id.layout_at:
                clickAtBtn();
                break;
            // ���������ذ�ť
            case R.id.layout_auth:
                clickAuthBtn();
                break;
            // ����ҵĿռ䰴ť
            case R.id.layout_space:
                clickSpaceBtn();
                break;
            // ������ఴť
            case R.id.layout_more:
                clickMoreBtn();
                break;
            // ����м䰴ť
            case R.id.toggle_btn:
                clickToggleBtn();
                break;
        }
    }

    /**
     * ����ˡ���̬����ť
     */
    private void clickAtBtn() {
        // ʵ����Fragmentҳ��
        fragmentAt = new FragmentAt();
        // �õ�Fragment���������
        FragmentTransaction fragmentTransaction = this
                .getSupportFragmentManager().beginTransaction();
        // �滻��ǰ��ҳ��
        fragmentTransaction.replace(R.id.frame_content, fragmentAt);
        // ��������ύ
        fragmentTransaction.commit();
        // �ı�ѡ��״̬
        atFl.setSelected(true);
        atIv.setSelected(true);

        authFl.setSelected(false);
        authIv.setSelected(false);

        spaceFl.setSelected(false);
        spaceIv.setSelected(false);

        moreFl.setSelected(false);
        moreIv.setSelected(false);
    }

    /**
     * ����ˡ�������ء���ť
     */
    private void clickAuthBtn() {
        // ʵ����Fragmentҳ��
        fragmentAuth = new FragmentAuth();
        // �õ�Fragment���������
        FragmentTransaction fragmentTransaction = this
                .getSupportFragmentManager().beginTransaction();
        // �滻��ǰ��ҳ��
        fragmentTransaction.replace(R.id.frame_content, fragmentAuth);
        // ��������ύ
        fragmentTransaction.commit();

        atFl.setSelected(false);
        atIv.setSelected(false);

        authFl.setSelected(true);
        authIv.setSelected(true);

        spaceFl.setSelected(false);
        spaceIv.setSelected(false);

        moreFl.setSelected(false);
        moreIv.setSelected(false);
    }

    /**
     * ����ˡ��ҵĿռ䡱��ť
     */
    private void clickSpaceBtn() {
        // ʵ����Fragmentҳ��
        fragmentSpace = new FragmentSpace();
        // �õ�Fragment���������
        FragmentTransaction fragmentTransaction = this
                .getSupportFragmentManager().beginTransaction();
        // �滻��ǰ��ҳ��
        fragmentTransaction.replace(R.id.frame_content, fragmentSpace);
        // ��������ύ
        fragmentTransaction.commit();

        atFl.setSelected(false);
        atIv.setSelected(false);

        authFl.setSelected(false);
        authIv.setSelected(false);

        spaceFl.setSelected(true);
        spaceIv.setSelected(true);

        moreFl.setSelected(false);
        moreIv.setSelected(false);
    }

    /**
     * ����ˡ����ࡱ��ť
     */
    private void clickMoreBtn() {
        // ʵ����Fragmentҳ��
        fragmentMore = new FragmentMore();
        // �õ�Fragment���������
        FragmentTransaction fragmentTransaction = this
                .getSupportFragmentManager().beginTransaction();
        // �滻��ǰ��ҳ��
        fragmentTransaction.replace(R.id.frame_content, fragmentMore);
        // ��������ύ
        fragmentTransaction.commit();

        atFl.setSelected(false);
        atIv.setSelected(false);

        authFl.setSelected(false);
        authIv.setSelected(false);

        spaceFl.setSelected(false);
        spaceIv.setSelected(false);

        moreFl.setSelected(true);
        moreIv.setSelected(true);
    }

    /**
     * ������м䰴ť
     */
    private void clickToggleBtn() {
        showPopupWindow(toggleImageView);
        // �ı䰴ť��ʾ��ͼƬΪ����ʱ��״̬
        plusImageView.setSelected(true);
    }

    /**
     * �ı���ʾ�İ�ťͼƬΪ����״̬
     */
    private void changeButtonImage() {
        plusImageView.setSelected(false);
    }

    /**
     * ��ʾPopupWindow�����˵�
     */
    private void showPopupWindow(View parent) {
        if (popWindow == null) {
            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(R.layout.popwindow_layout, null);
            dm = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(dm);
            // ����һ��PopuWidow����
            popWindow = new PopupWindow(view, dm.widthPixels, LinearLayout.LayoutParams.WRAP_CONTENT);
        }
        // ʹ��ۼ� ��Ҫ������˵���ؼ����¼��ͱ���Ҫ���ô˷���
        popWindow.setFocusable(true);
        // ����������������ʧ
        popWindow.setOutsideTouchable(true);
        // ���ñ����������Ϊ�˵��������Back��Ҳ��ʹ����ʧ�����Ҳ�����Ӱ����ı���
        popWindow.setBackgroundDrawable(new BitmapDrawable());
        // PopupWindow����ʾ��λ������
        // popWindow.showAtLocation(parent, Gravity.FILL, 0, 0);
        popWindow.showAsDropDown(parent, 0,0);

        popWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                // �ı���ʾ�İ�ťͼƬΪ����״̬
                changeButtonImage();
            }
        });

        // ���������¼�
        popWindow.setTouchInterceptor(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                // �ı���ʾ�İ�ťͼƬΪ����״̬
                changeButtonImage();
                popWindow.dismiss();
                return false;
            }
        });
    }
}
