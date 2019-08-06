package com.zut.fy.xiaofan.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zut.fy.xiaofan.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SportAdapter extends RecyclerView.Adapter {
    private SportAdapterListener sportAdapterListener;
    private Context context;
    private int code = 1;
    private String url;
    private String tvName;

    public SportAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.item_sport, parent, false);
        return new ViewHolderGoodsList(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final ViewHolderGoodsList viewHolderGoodsList = (ViewHolderGoodsList) holder;
        switch (code) {
            case 1:
                viewHolderGoodsList.qianyuqianxun.setBackgroundResource(R.drawable.corners_bg_green);
                Glide.with(context).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1563116045970&di=e4569f5b9315ee45e6c1ce3f085e0bd9&imgtype=0&src=http%3A%2F%2Fimg.mp.itc.cn%2Fupload%2F20161229%2F54bd999b5f694b34b32172a95e2e5534_th.jpeg").into(viewHolderGoodsList.imageSport1);
                Glide.with(context).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1563116704632&di=8ca16320800685c83bbe72f179901444&imgtype=0&src=http%3A%2F%2Fn.sinaimg.cn%2Fsports%2F99_img%2Fvcg%2F4f160954%2F452%2Fw1152h1700%2F20180716%2F1V-s-fzrwiaz8848708.jpg").into(viewHolderGoodsList.imageSport2);
                Glide.with(context).load("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1542371776,2572419620&fm=26&gp=0.jpg").into(viewHolderGoodsList.imageSport3);
                viewHolderGoodsList.titleSport1.setText("新浪足球");
                viewHolderGoodsList.titleSport2.setText("搜达足球");
                viewHolderGoodsList.titleSport3.setText("央视足球");
                viewHolderGoodsList.qianyuqianxun.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                         url = "http://sports.sina.com.cn/global/";
                         tvName = "新浪足球";
                        sportAdapterListener.openSina(url,tvName);
                    }
                });
                break;
            case 2:
                viewHolderGoodsList.qianyuqianxun.setBackgroundResource(R.drawable.corners_bg_green2);
                Glide.with(context).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1563116045970&di=e4569f5b9315ee45e6c1ce3f085e0bd9&imgtype=0&src=http%3A%2F%2Fimg.mp.itc.cn%2Fupload%2F20161229%2F54bd999b5f694b34b32172a95e2e5534_th.jpeg").into(viewHolderGoodsList.imageSport1);
                Glide.with(context).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1563116704632&di=8ca16320800685c83bbe72f179901444&imgtype=0&src=http%3A%2F%2Fn.sinaimg.cn%2Fsports%2F99_img%2Fvcg%2F4f160954%2F452%2Fw1152h1700%2F20180716%2F1V-s-fzrwiaz8848708.jpg").into(viewHolderGoodsList.imageSport2);
                Glide.with(context).load("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1542371776,2572419620&fm=26&gp=0.jpg").into(viewHolderGoodsList.imageSport3);
                viewHolderGoodsList.titleSport1.setText("新浪篮球");
                viewHolderGoodsList.titleSport2.setText("搜达篮球");
                viewHolderGoodsList.titleSport3.setText("央视篮球");
                viewHolderGoodsList.qianyuqianxun.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        url = "http://sports.sina.com.cn/nba/";
                        tvName = "新浪篮球";
                        sportAdapterListener.openSina(url,tvName);
                    }
                });
                break;
            case 3:
                viewHolderGoodsList.qianyuqianxun.setBackgroundResource(R.drawable.corners_bg_green3);
                Glide.with(context).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1563116045970&di=e4569f5b9315ee45e6c1ce3f085e0bd9&imgtype=0&src=http%3A%2F%2Fimg.mp.itc.cn%2Fupload%2F20161229%2F54bd999b5f694b34b32172a95e2e5534_th.jpeg").into(viewHolderGoodsList.imageSport1);
                Glide.with(context).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1563116704632&di=8ca16320800685c83bbe72f179901444&imgtype=0&src=http%3A%2F%2Fn.sinaimg.cn%2Fsports%2F99_img%2Fvcg%2F4f160954%2F452%2Fw1152h1700%2F20180716%2F1V-s-fzrwiaz8848708.jpg").into(viewHolderGoodsList.imageSport2);
                Glide.with(context).load("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1542371776,2572419620&fm=26&gp=0.jpg").into(viewHolderGoodsList.imageSport3);
                viewHolderGoodsList.titleSport1.setText("新浪网球");
                viewHolderGoodsList.titleSport2.setText("搜达网球");
                viewHolderGoodsList.titleSport3.setText("央视网球");
                viewHolderGoodsList.qianyuqianxun.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        url = "http://sports.sina.com.cn/tennis/";
                        tvName = "新浪网球";
                        sportAdapterListener.openSina(url,tvName);
                    }
                });
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public interface SportAdapterListener {
        void openSina(String url,String tvName);

        void openSouda();

        void openCctv();

    }

    public void setSportAdapterListener(SportAdapterListener sportAdapterListener) {
        this.sportAdapterListener = sportAdapterListener;
    }

    public void setCode(int code) {
        this.code = code;
    }

    static class ViewHolderGoodsList extends RecyclerView.ViewHolder {
        @BindView(R.id.qianyuqianxun)
        LinearLayout qianyuqianxun;
        @BindView(R.id.fanghua)
        LinearLayout fanghua;
        @BindView(R.id.wuwenxidong)
        LinearLayout wuwenxidong;

        @BindView(R.id.image_sport1)
        ImageView imageSport1;
        @BindView(R.id.image_sport2)
        ImageView imageSport2;
        @BindView(R.id.image_sport3)
        ImageView imageSport3;

        @BindView(R.id.title_sport1)
        TextView titleSport1;
        @BindView(R.id.title_sport2)
        TextView titleSport2;
        @BindView(R.id.title_sport3)
        TextView titleSport3;

        @BindView(R.id.content_sport1)
        TextView contentSport1;
        @BindView(R.id.content_sport2)
        TextView contentSport2;
        @BindView(R.id.content_sport3)
        TextView contentSport3;


        public ViewHolderGoodsList(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
