package com.zut.fy.xiaofan;

import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.rwq.framworkapp.base.BaseActivity;
import com.rwq.framworkapp.base.BaseView;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements MovieFragment.OpenSlideMenuListener {
    FragmentManager fragmentManager;
    MovieFragment movieFragment;
    BaiduFragment baiduFragment;
    PersonalFragment personalFragment;
    ZiyuanFragment ziyuanFragment;

    @BindView(R.id.fl_fragment)
    FrameLayout flFragment;
    @BindView(R.id.rb_home_page)
    RadioButton rbHomePage;
    @BindView(R.id.rb_news)
    RadioButton rbNews;
    @BindView(R.id.rb_release)
    RadioButton rbRelease;
    @BindView(R.id.rb_personal_center)
    RadioButton rbPersonalCenter;
    @BindView(R.id.rg_rg)
    RadioGroup rgRg;

    @BindView(R.id.ll_slide_menu)
    LinearLayout llSlideMenu;
    @BindView(R.id.dl_layout)
    DrawerLayout dlLayout;

    @Override
    public int getLayoutId() {
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.GRAY); //也可以设置成灰色透明的，比较符合Material Design的风格
        }

        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        rgRg.check(R.id.rb_home_page);
        fragmentManager = getSupportFragmentManager();

        if (movieFragment == null) {
            movieFragment = new MovieFragment();
            movieFragment.setListener(this);
        }

        if (ziyuanFragment == null) {
           ziyuanFragment = new ZiyuanFragment();
        }

        if (baiduFragment == null){
            baiduFragment = new BaiduFragment();
        }

        if (personalFragment == null){
            personalFragment = new PersonalFragment();
        }

        //将fragment文件放入到FrameLayout布局文件中
        fragmentManager.beginTransaction()
                .add(R.id.fl_fragment, movieFragment)
                .add(R.id.fl_fragment,ziyuanFragment)
                .add(R.id.fl_fragment,baiduFragment)
                .add(R.id.fl_fragment,personalFragment)
                .hide(ziyuanFragment)
                .hide(baiduFragment)
                .hide(personalFragment)
                .commit();
    }

    @Override
    public void onEvent() {
        rgRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_home_page:
                        fragmentManager.beginTransaction()
                                .show(movieFragment)
                                .hide(ziyuanFragment)
                                .hide(baiduFragment)
                                .hide(personalFragment)
                                .commit();
                        break;
                    case R.id.rb_news:
                        fragmentManager.beginTransaction()
                                .show(ziyuanFragment)
                                .hide(movieFragment)
                                .hide(baiduFragment)
                                .hide(personalFragment)
                                .commit();
                        break;
                    case R.id.rb_release:
                        fragmentManager.beginTransaction()
                                .show(baiduFragment)
                                .hide(movieFragment)
                                .hide(ziyuanFragment)
                                .hide(personalFragment)
                                .commit();
                        break;
                    case R.id.rb_personal_center:
                        fragmentManager.beginTransaction()
                                .show(personalFragment)
                                .hide(movieFragment)
                                .hide(ziyuanFragment)
                                .hide(baiduFragment)
                                .commit();
                        break;
                }
            }
        });

    }

    @Override
    public BaseView getBaseView() {
        return null;
    }

    @Override
    public void openSlideMenu() {
        dlLayout.openDrawer(llSlideMenu);
    }
}
