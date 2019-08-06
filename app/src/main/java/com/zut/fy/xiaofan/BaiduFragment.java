package com.zut.fy.xiaofan;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rwq.framworkapp.base.BaseFragment;
import com.rwq.framworkapp.base.BaseView;
import com.zut.fy.xiaofan.activity.TudouActivity;
import com.zut.fy.xiaofan.adapter.SportAdapter;

import butterknife.BindView;


public class BaiduFragment extends BaseFragment implements SportAdapter.SportAdapterListener {
    private SportAdapter sportAdapter;
    @BindView(R.id.rv_content)
    RecyclerView rvContent;
    @BindView(R.id.ll_soccer)
    LinearLayout llSoccer;
    @BindView(R.id.ll_basketball)
    LinearLayout llBasketball;
    @BindView(R.id.ll_tennis)
    LinearLayout llTennis;
    @BindView(R.id.tv_soccer)
    TextView tvSoccer;
    @BindView(R.id.tv_basketball)
    TextView tvBasketball;
    @BindView(R.id.tv_tennis)
    TextView tvTennis;
    @BindView(R.id.v_line_soccer)
    View vLineSoccer;
    @BindView(R.id.v_line_basketball)
    View vLineBasketball;
    @BindView(R.id.v_line_tennis)
    View vLineTennis;

    private int code = 1;
    private String url;
    private String tvName;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_baidu;
    }

    @Override
    protected void initView(Bundle bundle) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rvContent.setLayoutManager(linearLayoutManager);
        sportAdapter = new SportAdapter(getContext());
        sportAdapter.setSportAdapterListener(this);
        rvContent.setAdapter(sportAdapter);
    }

    @Override
    protected void onEvent() {
        //设置顶部导航栏点击事件
        llSoccer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code = 1;
                sportAdapter.setCode(code);
                //字体变成红色
                tvSoccer.setTextColor(Color.parseColor("#e10e05"));
                tvBasketball.setTextColor(Color.parseColor("#000000"));
                tvTennis.setTextColor(Color.parseColor("#000000"));
                //设置view的显示与隐藏
                vLineSoccer.setVisibility(View.VISIBLE);
                vLineBasketball.setVisibility(View.INVISIBLE);
                vLineTennis.setVisibility(View.INVISIBLE);
                //数据进行更改
                sportAdapter.notifyDataSetChanged();
            }
        });

        llBasketball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code = 2;
                sportAdapter.setCode(code);
                //字体变成红色
                tvSoccer.setTextColor(Color.parseColor("#000000"));
                tvBasketball.setTextColor(Color.parseColor("#e10e05"));
                tvTennis.setTextColor(Color.parseColor("#000000"));
                //设置view的显示与隐藏
                vLineSoccer.setVisibility(View.INVISIBLE);
                vLineBasketball.setVisibility(View.VISIBLE);
                vLineTennis.setVisibility(View.INVISIBLE);
                //数据进行更改
                sportAdapter.notifyDataSetChanged();
            }
        });

        llTennis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code = 3;
                sportAdapter.setCode(code);
                //字体变成红色
                tvSoccer.setTextColor(Color.parseColor("#000000"));
                tvBasketball.setTextColor(Color.parseColor("#000000"));
                tvTennis.setTextColor(Color.parseColor("#e10e05"));
                //设置view的显示与隐藏
                vLineSoccer.setVisibility(View.INVISIBLE);
                vLineBasketball.setVisibility(View.INVISIBLE);
                vLineTennis.setVisibility(View.VISIBLE);
                //通知数据进行更改
                sportAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onPause(){
        super.onPause();
    }

    @Override
    protected BaseView getViewImp() {
        return null;
    }

    @Override
    protected void lazyFetchData() {

    }

    @Override
    public void openSina(String url,String tvName) {
        //进行跳转
        this.url = url;
        this.tvName = tvName;
        Intent intent = new Intent(getContext(),TudouActivity.class);
        intent.putExtra("tvName",tvName);
        intent.putExtra("url",url);
        startActivity(intent);

    }
    @Override
    public void openSouda() {

    }

    @Override
    public void openCctv() {

    }
}

