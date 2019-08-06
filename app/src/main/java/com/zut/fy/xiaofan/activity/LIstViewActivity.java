package com.zut.fy.xiaofan.activity;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rwq.framworkapp.base.BaseActivity;
import com.rwq.framworkapp.base.BaseView;
import com.zut.fy.xiaofan.R;
import com.zut.fy.xiaofan.adapter.GoodsOrderAdapter;
import com.zut.fy.xiaofan.bean.LIstViewBean;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import butterknife.BindView;

public class LIstViewActivity extends BaseActivity {
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

    HttpNaviteUrl httpNaviteUrl;
    GoodsOrderAdapter goodsOrderAdapter;
    List<LIstViewBean> lIstViewBeanList;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    Log.d("数据是",""+msg.obj);
                    //在handler里面进行一个uI的更新操作
//                    goodsOrderAdapter = new GoodsOrderAdapter(getApplicationContext(),lIstViewBeanList);
//                    rvContent.setAdapter(goodsOrderAdapter);
//                    String data = (msg.obj).toString();
//                    try {
//                        //将object解析后，装到bean里面去
//                        JSONObject jsonObject = new JSONObject(data);
//                        String userId = jsonObject.getJSONObject("body").getString("userid");
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
                    break;
            }
        }
    };
    @Override
    public int getLayoutId() {
        return R.layout.activity_listview;
    }

    @Override
    public void initView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvContent.setLayoutManager(linearLayoutManager);
        goodsOrderAdapter = new GoodsOrderAdapter(getApplicationContext(),lIstViewBeanList);
        rvContent.setAdapter(goodsOrderAdapter);


    }

    @Override
    public void onEvent() {
        //设置顶部导航栏点击事件
        llSoccer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //字体变成红色
                tvSoccer.setTextColor(Color.parseColor("#e10e05"));
                tvBasketball.setTextColor(Color.parseColor("#000000"));
                tvTennis.setTextColor(Color.parseColor("#000000"));
                //设置view的显示与隐藏

                vLineSoccer.setVisibility(View.VISIBLE);
                vLineBasketball.setVisibility(View.INVISIBLE);
                vLineTennis.setVisibility(View.INVISIBLE);
                //进行网络的一个请求
                sendRequest();
            }
        });
        llBasketball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //字体变成红色
                tvSoccer.setTextColor(Color.parseColor("#000000"));
                tvBasketball.setTextColor(Color.parseColor("#e10e05"));
                tvTennis.setTextColor(Color.parseColor("#000000"));
                //设置view的显示与隐藏
                vLineSoccer.setVisibility(View.INVISIBLE);
                vLineBasketball.setVisibility(View.VISIBLE);
                vLineTennis.setVisibility(View.INVISIBLE);
            }
        });

        llTennis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //字体变成红色
                tvSoccer.setTextColor(Color.parseColor("#000000"));
                tvBasketball.setTextColor(Color.parseColor("#000000"));
                tvTennis.setTextColor(Color.parseColor("#e10e05"));
                //设置view的显示与隐藏
                vLineSoccer.setVisibility(View.INVISIBLE);
                vLineBasketball.setVisibility(View.INVISIBLE);
                vLineTennis.setVisibility(View.VISIBLE);
            }
        });
    }

    private void sendRequest(){
        httpNaviteUrl = new HttpNaviteUrl();
        //发送网络请求，请求的地址可以拼接
        String url = "http://shengzhicheng.com/admin/hm/api/public/goodsOrder/orderList?userId=1553062008214&orderStatus=1";
        httpNaviteUrl.getRequset(url);

    }

    @Override
    public BaseView getBaseView() {
        return null;
    }

    public class HttpNaviteUrl {
        private String data;
        LIstViewActivity lIstViewActivity = new LIstViewActivity();
        public void getRequset(final String url) {
            new Thread(){
                @Override
                public void run(){
                    final StringBuilder sb = new StringBuilder();
                    FutureTask<String> task = new FutureTask<String>(new Callable<String>() {
                        @Override
                        public String call() throws Exception {
                            HttpURLConnection connection = null;
                            BufferedReader reader = null;
                            try {
                                URL requestUrl = new URL(url);
                                connection = (HttpURLConnection) requestUrl.openConnection();
                                connection.setRequestMethod("GET");
                                connection.setConnectTimeout(8000);
                                connection.setReadTimeout(8000);
                                if (connection.getResponseCode() == 200) {
                                    InputStream in = connection.getInputStream();
                                    reader = new BufferedReader(new InputStreamReader(in));
                                    String line;
                                    while ((line = reader.readLine()) != null) {
                                        sb.append(line);
                                    }
                                    System.out.println(sb);
                                    data = sb.toString();

                                    //初始化json对象
                                    JSONObject jsonObject = new JSONObject(data);
                                    //此处应该把object中的数据解析到bean中去
                                    try {
                                        if (jsonObject.getBoolean("success")) {
                                            Gson gson = new Gson();
                                            List<LIstViewBean> goodsOrderBeans;
                                            //这一句用于解析数据
                                            goodsOrderBeans = gson.fromJson(jsonObject.getJSONObject("body").getJSONArray("data").toString(), new TypeToken<List<LIstViewBean>>() {
                                            }.getType());
                                            Log.d("数据解析成功",""+goodsOrderBeans.toString());
                                        } else {
                                            String msg = jsonObject.getString("msg");
                                            showToast("解析错误");
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }

                                    //给主线程发消息，把返回的object搞到主线程去
                                    Message msg = handler.obtainMessage(1);
////                                msg.arg1=Integer.parseInt(userId);
                                    msg.obj = sb;
                                    handler.sendMessage(msg);

                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            } finally {
                                if (reader != null) {
                                    reader.close();
                                }
                                if (connection != null) {
                                    connection.disconnect();
                                }
                            }
                            return sb.toString();
                        }
                    });
                    new Thread(task).start();
                    String s = null;
                    try {
                        s = task.get();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }
}
