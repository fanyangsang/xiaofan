package com.zut.fy.xiaofan.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rwq.framworkapp.net.HttpUtils;
import com.zut.fy.xiaofan.R;
import com.zut.fy.xiaofan.activity.LIstViewActivity;
import com.zut.fy.xiaofan.bean.LIstViewBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GoodsOrderAdapter extends RecyclerView.Adapter {

    private final Context context;
    private List<LIstViewBean> lIstViewBeans;

    public GoodsOrderAdapter (Context context,List<LIstViewBean> lIstViewBeans){
        this.context = context;
        this.lIstViewBeans = lIstViewBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.item_goods_order, parent, false);
        return new GoodsOrderAdapter.ViewHolderGoodsList(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final ViewHolderGoodsList viewHolderGoodsList = (ViewHolderGoodsList) holder;

        viewHolderGoodsList.btnCancel.setVisibility(View.VISIBLE);
        viewHolderGoodsList.btnGoToPay.setVisibility(View.VISIBLE);
        viewHolderGoodsList.tvState.setText("未付款");
        viewHolderGoodsList.btnCancel.setText("取消订单");
        viewHolderGoodsList.btnGoToPay.setText("去支付");

//        viewHolderGoodsList.tvGoodsName.setText(lIstViewBeans.get(position).getOrderContent().getGoodsName());
//        viewHolderGoodsList.tvGoodsSummary.setText(lIstViewBeans.get(position).getOrderContent().getSellPoint());
//        Glide.with(context).load("http://shengzhicheng.com:80/" + (lIstViewBeans.get(position).getOrderContent().getPic()).substring(1)).into(viewHolderGoodsList.ivImg);
    }

    @Override
    public int getItemCount() {
//        return lIstViewBeans.size();
        return 5;
    }

    static class ViewHolderGoodsList extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_state)
        TextView tvState;
        @BindView(R.id.iv_img)
        ImageView ivImg;
        @BindView(R.id.tv_goods_name)
        TextView tvGoodsName;
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.tv_goods_summary)
        TextView tvGoodsSummary;
        @BindView(R.id.tv_money)
        TextView tvMoney;
        @BindView(R.id.tv_goods_number)
        TextView tvGoodsNumber;
        @BindView(R.id.tv_real_payment_number)
        TextView tvRealPaymentNumber;
        @BindView(R.id.rl_content)
        RelativeLayout rlContent;
        @BindView(R.id.btn_cancel)
        Button btnCancel;
        @BindView(R.id.btn_go_to_pay)
        Button btnGoToPay;

        public ViewHolderGoodsList(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
