package com.user.work.testing.binaryoptions;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  private static final String BASE_URL = "file:///android_asset/";
  private static final String INDEX_PAGE = "index.html";

  private WebView mWebView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    checkNetworkConnection();

    initUI();

    webViewSetup();
    loadPage();
  }

  @Override
  public void onBackPressed() {
    if (mWebView.canGoBack())
      mWebView.goBack();
    else
      super.onBackPressed();
  }

  private void checkNetworkConnection() {
    if (!NetworkInfo.isConnected(this))
      Toast.makeText(this, R.string.no_network_connection, Toast.LENGTH_LONG)
          .show();
  }

  private void initUI() {
    mWebView = (WebView) findViewById(R.id.web_view);
  }

  @SuppressLint("SetJavaScriptEnabled")
  private void webViewSetup() {
    mWebView.getSettings().setJavaScriptEnabled(true);
    mWebView.setWebViewClient(new WebViewClient() {
      @Override
      public boolean shouldOverrideUrlLoading(
          WebView view, WebResourceRequest request) {
        return false;
      }
    });
  }

  private void loadPage() {
    mWebView.loadUrl(BASE_URL + INDEX_PAGE);
  }
}