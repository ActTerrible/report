package mac.yk.report.view.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;

import mac.yk.report.R;
import mac.yk.report.view.adapter.MainTabAdpter;
import mac.yk.report.view.widget.FlowIndicator;
import mac.yk.report.view.widget.MyViewPager;

/**
 * Created by mac-yk on 2017/1/28.
 */

public class WeatherDetailActivity extends BaseActivity implements ViewPager.OnPageChangeListener{
    FlowIndicator fl;
    MyViewPager mv;
    MainTabAdpter adapter;
    int currentIndex;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_detail);
        initView();
    }

    private void initView() {
        fl= (FlowIndicator) findViewById(R.id.fl);
        mv= (MyViewPager) findViewById(R.id.mv);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        int page = preferences.getInt("page", 1);
        mv.setOffscreenPageLimit(page);
        adapter=new MainTabAdpter(getSupportFragmentManager());
        adapter.addFragment(new WeatherFragment(this));
        mv.setAdapter(adapter);
        mv.setCurrentItem(currentIndex);
        mv.setOnPageChangeListener(this);
        fl.setCount(page);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        currentIndex=position;
        mv.setCurrentItem(currentIndex);
        fl.setFocus(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
