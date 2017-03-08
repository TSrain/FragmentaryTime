package activitytest.example.com.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import activitytest.example.com.myapplication.entity.offer;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {
  private offer[] offers={new offer("帮打扫","20元","1小时",R.drawable.bang_dasao),
                          new offer("帮取快递","8元","少于20分钟",R.drawable.bang_qukuaidi),
                          new offer("代课","面议","1.5小时",R.drawable.dai_ke),
                          new offer("接孩子","25元","40分钟",R.drawable.jie_haizi),
                          new offer("陪跑步","20元","1小时",R.drawable.pei_paobu),
                          new offer("陪备考","面议（女士优先）","不定时",R.drawable.pei_beikao),
                          new offer("帮修电脑","40元","1次",R.drawable.xiu_diannao)};
    private List<offer> offerList=new ArrayList<>();
    private OfferAdapter adapter;
    private SwipeRefreshLayout swipeRefresh;
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
        initOffers();
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        adapter =new OfferAdapter(offerList);
        recyclerView.setAdapter(adapter);
        swipeRefresh=(SwipeRefreshLayout)findViewById(R.id.swipe_refresh);
        swipeRefresh.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshOffers();
            }
        });
    }
    private void refreshOffers(){
        new Thread(new Runnable(){
            @Override
            public void run(){
      try{
    Thread.sleep(2000);
}catch (InterruptedException e){
    e.printStackTrace();
}
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initOffers();
                        adapter.notifyDataSetChanged();
                        swipeRefresh.setRefreshing(false);
                    }
                });
            }
        }).start();
    }
  private void initOffers(){
      offerList.clear();
      for (int j=0;j<6;j++){
          for (int i = 0; i < 6; i++) {
              offerList.add(offers[i]);
          }
      }

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
}
