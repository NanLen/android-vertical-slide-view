package com.stone.verticalslide.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stone.verticalslide.R;
import com.stone.verticalslide.view.DragDownWebView;

public class DragDownWebViewFragment extends Fragment {

	private View progressBar;
	private DragDownWebView webView;
	private boolean init = false;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_drag_down_webview, null);
		webView = (DragDownWebView) rootView.findViewById(R.id.webView);
		progressBar = rootView.findViewById(R.id.progressbar);
		return rootView;
	}

	public void initView() {
		if (null != webView && !init) {
			init = true;
			progressBar.setVisibility(View.GONE);
			webView.loadUrl("http://m.zol.com/tuan/");
		}
	}
}
