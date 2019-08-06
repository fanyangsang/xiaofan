package com.zut.fy.xiaofan;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.rwq.framworkapp.base.BaseFragment;
import com.rwq.framworkapp.base.BaseView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;
import com.zut.fy.xiaofan.activity.DaTiActivity;
import com.zut.fy.xiaofan.activity.LIstViewActivity;
import com.zut.fy.xiaofan.activity.TudouActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;

public class PersonalFragment extends BaseFragment {
    @BindView(R.id.ll_tudouyouku)
    LinearLayout linearLayout;
    @BindView(R.id.ll_tudouyouku2)
    LinearLayout linearLayout2;
    @BindView(R.id.ll_tudouyouku3)
    LinearLayout linearLayout3;
    @BindView(R.id.ll_tudouyouku4)
    LinearLayout linearLayout4;
    @BindView(R.id.ll_tudouyouku5)
    LinearLayout linearLayout5;
    @BindView(R.id.banner)
    Banner banner;
    private ArrayList<String> list_path;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_personal;
    }

    @Override
    protected void initView(Bundle bundle) {

        initBanner();

    }

    /**
     * 初始化轮播图
     */
    private void initBanner() {
        //放图片地址的集合
//        Integer[] images = {R.drawable.p2181503417,R.drawable.p2181503428,R.drawable.p2181503450};
        list_path = new ArrayList<>();
        list_path.add("https://img3.doubanio.com/view/photo/l/public/p2563001761.jpg");
        list_path.add("https://img3.doubanio.com/view/photo/l/public/p2563001760.jpg");
        list_path.add("https://img3.doubanio.com/view/photo/l/public/p2563001765.jpg");
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load((String) path).into(imageView);
                }
        }

        );
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.Default);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(3000);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.setImages(list_path);
        banner.start();
    }

    @Override
    protected void onEvent() {
        //设置监听事件，分别跳转到不同的activity中
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tvName = "土豆优酷网";
                String url = "https://www.itudou.org";
                Intent intent = new Intent(getContext(), TudouActivity.class);
                //进行跳转传值
                intent.putExtra("url", url);
                intent.putExtra("tvName", tvName);
                startActivity(intent);
            }
        });

        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tvName = "猫眼票房";
                String url = "https://piaofang.maoyan.com/?ver=normal";
                Intent intent = new Intent(getContext(), TudouActivity.class);
                //进行跳转传值
                intent.putExtra("url", url);
                intent.putExtra("tvName", tvName);
                startActivity(intent);
            }
        });

        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), DaTiActivity.class);
                //进行跳转传值
                startActivity(intent);
            }
        });

        linearLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), LIstViewActivity.class);
                //进行跳转传值
                startActivity(intent);
            }
        });

        linearLayout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tvName = "商品列表";
                String url = "https://www.itudou.org";
                Intent intent = new Intent(getContext(), TudouActivity.class);
                //进行跳转传值
                intent.putExtra("url", url);
                intent.putExtra("tvName", tvName);
                startActivity(intent);
            }
        });

    }

    @Override
    protected BaseView getViewImp() {
        return null;
    }

    @Override
    protected void lazyFetchData() {

    }
}
