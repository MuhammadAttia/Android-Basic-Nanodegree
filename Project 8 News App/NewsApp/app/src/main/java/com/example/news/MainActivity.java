package com.example.news;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<News>> {

    public static final String TARGET_URL =
            "http://content.guardianapis.com/search?tag=technology%2Fgames&from-date=2016-01-01&order-by=newest&page-size=20&show-fields=thumbnail%2Cbyline%2CtrailText&api-key=test";

    private NewsAdapter mAdapter;
    private TextView mEmptyStateTextView;
    private SwipeRefreshLayout mRefreshLayout;
    private ListView mNewsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        mAdapter = new NewsAdapter(MainActivity.this, new ArrayList<News>());
        mNewsListView = (ListView) findViewById(R.id.list);
        mEmptyStateTextView = (TextView) findViewById(R.id.empty_view);
        mRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swiperefresh);
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        checkConnectivity();
                    }
                }, 1200);
            }
        });

        mNewsListView.setEmptyView(mEmptyStateTextView);
        mNewsListView.setAdapter(mAdapter);
        checkConnectivity();
        mNewsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                News currentNews = mAdapter.getItem(position);
                Uri uri = Uri.parse(currentNews.getUrl());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
    private void checkConnectivity() {
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            getSupportLoaderManager().initLoader(0, null, this);

        } else {

            mRefreshLayout.setRefreshing(false);
            mEmptyStateTextView.setText(R.string.no_internet);

        }
    }

    @Override
    public Loader<List<News>> onCreateLoader(int id, Bundle args) {
        return new NewsLoader(MainActivity.this, TARGET_URL);
    }

    @Override
    public void onLoadFinished(Loader<List<News>> loader, List<News> data) {

        mRefreshLayout.setRefreshing(false);
        mEmptyStateTextView.setText(R.string.no_news);
        mAdapter.clear();
        mAdapter.setNewsList(data);
    }
    @Override
    public void onLoaderReset(Loader<List<News>> loader) {
        mAdapter.setNewsList(new ArrayList<News>());
    }
}
