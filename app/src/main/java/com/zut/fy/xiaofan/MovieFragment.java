package com.zut.fy.xiaofan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rwq.framworkapp.base.BaseFragment;
import com.rwq.framworkapp.base.BaseView;
import com.zut.fy.xiaofan.activity.TudouActivity;

import butterknife.BindView;

public class MovieFragment extends BaseFragment {

    @BindView(R.id.iv_return_key)
    ImageView ivReturnKey;
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.qianyuqianxun)
    LinearLayout qianyuqianxun;
    @BindView(R.id.fanghua)
    LinearLayout fangHua;
    @BindView(R.id.wuwenxidong)
    LinearLayout wuWenxidong;
    @BindView(R.id.fyu)
    LinearLayout fyu;
    @BindView(R.id.baoliewusheng)
    LinearLayout baoliewusheng;
    @BindView(R.id.diqiu)
    LinearLayout diQiu;
    //左侧菜单栏
    private OpenSlideMenuListener openSlideMenuListener;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_movie;
    }

    @Override
    protected void initView(Bundle bundle) {
    }

    @Override
    protected void onEvent() {
        //左侧菜单栏
        ivReturnKey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSlideMenuListener.openSlideMenu();
            }
        });

        //点击图标，跳转到TuDouActivity中
        qianyuqianxun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),TudouActivity.class);
                //进行跳转传值
                String url = "https://www.itudou.org/v/10025-4-1.html";
                String tvName = "千与千寻";
                intent.putExtra("tvName",tvName);
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });

        fangHua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),TudouActivity.class);
                //进行跳转传值
                String url = "https://www.itudou.org/v/44521-1-2.html";
                String tvName = "芳华";
                intent.putExtra("tvName",tvName);
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });

        wuWenxidong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),TudouActivity.class);
                //进行跳转传值
                String url = "https://www.itudou.org/v/45808-3-1.html";
                String tvName = "无问西东";
                intent.putExtra("tvName",tvName);
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });

        fyu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),TudouActivity.class);
                //进行跳转传值
                String url = "https://www.itudou.org/v/65499-0-0.html";
                String tvName = "风中有朵雨做的云";
                intent.putExtra("tvName",tvName);
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });

        baoliewusheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),TudouActivity.class);
                //进行跳转传值
                String url = "https://www.itudou.org/v/49175-1-3.html";
                String tvName = "暴裂无声";
                intent.putExtra("tvName",tvName);
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });

        diQiu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),TudouActivity.class);
                //进行跳转传值
                String url = "https://www.itudou.org/v/41354-0-3.html";
                String tvName = "地球最后的夜晚";
                intent.putExtra("tvName",tvName);
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });

    }

    public interface OpenSlideMenuListener {
        void openSlideMenu();
    }

    public void setListener(OpenSlideMenuListener openSlideMenuListener) {
        this.openSlideMenuListener = openSlideMenuListener;

    }

    @Override
    protected BaseView getViewImp() {
        return null;
    }

    @Override
    protected void lazyFetchData() {

    }
}
