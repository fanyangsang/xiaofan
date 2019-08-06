package com.zut.fy.xiaofan.activity;

import android.content.pm.ActivityInfo;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.rwq.framworkapp.base.BaseActivity;
import com.rwq.framworkapp.base.BaseView;
import com.zut.fy.xiaofan.R;

import butterknife.BindView;

public class TudouActivity extends BaseActivity {
    @BindView(R.id.webView)
    WebView webView;
    @BindView(R.id.iv_return_key)
    ImageView ivReturnkey;
    @BindView(R.id.mFrameLayout)
    FrameLayout mFrameLayout;
    private MyWebChromeClient mMyWebChromeClient;
    @BindView(R.id.tv_content)
    TextView  tvContent;
    public String url;
    public String tvName;
    @Override
    public int getLayoutId() {
        return R.layout.activity_tudou;
    }

    @Override
    public void initView() {
        //设置禁止浏览器打开
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        //获取跳转所传的值
        url = getIntent().getStringExtra("url");
        tvName = getIntent().getStringExtra("tvName");
        tvContent.setText(tvName);
        webView.loadUrl(url);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //支持缩放
        webSettings.setSupportZoom(true);
        //支持播放视频
        webSettings.setDomStorageEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setDefaultTextEncodingName("utf-8");
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);

        mMyWebChromeClient = new MyWebChromeClient();
        webView.setWebChromeClient(mMyWebChromeClient);
    }

    @Override
    public void onEvent() {
        //设置左上角返回键
        ivReturnkey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (webView.canGoBack()) {
                    webView.goBack();//返回上个页面
                    return;
                } else {
                    finish();
                }
            }
        });
    }

    //物理键返回到上一个h5页面
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    //一个页面不在焦点上，视频便停止播放
    @Override
    protected void onPause(){
        webView.reload();
        super.onPause();
    }

    @Override
    public BaseView getBaseView() {
        return null;
    }

    //支持视频全屏播放
    private class MyWebChromeClient extends WebChromeClient {
        private View mCustomView;
        private CustomViewCallback mCustomViewCallback;

        @Override
        public void onShowCustomView(View view, CustomViewCallback callback) {
            super.onShowCustomView(view, callback);
            if (mCustomView != null) {
                callback.onCustomViewHidden();
                return;
            }
            mCustomView = view;
            mFrameLayout.addView(mCustomView);
            mCustomViewCallback = callback;
            webView.setVisibility(View.GONE);
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }

        public void onHideCustomView() {
            webView.setVisibility(View.VISIBLE);
            if (mCustomView == null) {
                return;
            }
            mCustomView.setVisibility(View.GONE);
            mFrameLayout.removeView(mCustomView);
            mCustomViewCallback.onCustomViewHidden();
            mCustomView = null;
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            super.onHideCustomView();
        }
    }
}
