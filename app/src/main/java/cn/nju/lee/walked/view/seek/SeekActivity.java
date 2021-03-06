package cn.nju.lee.walked.view.seek;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.nju.lee.walked.R;
import cn.nju.lee.walked.model.vopo.TrackVO;
import cn.nju.lee.walked.view.seek.adapter.TrackListAdapter;

import static com.baidu.mapapi.BMapManager.getContext;

/**
 * Created by 果宝 on 2018/1/20.
 */

public class SeekActivity extends AppCompatActivity {

    private boolean isRefresh;

    private List<TrackVO> trackVOList;

    private TrackListAdapter adapter;

    @BindView(R.id.seek_rcl_list)
    RecyclerView mRecyclerView;

    @BindView(R.id.seek_srl_refresh)
    SwipeRefreshLayout mSwipeRefreshLayout;

    public static void activityStart(Context context) {
        Intent intent = new Intent(context, SeekActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek);
        ButterKnife.bind(this);
        initTrackList();
        adapter = new TrackListAdapter(this, trackVOList);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mSwipeRefreshLayout.setOnRefreshListener(new RefreshListener());
    }

    @Override
    public void onResume() {
        super.onResume();
        mRecyclerView.setAdapter(new TrackListAdapter(this, trackVOList));
    }

    private void initTrackList() {
        trackVOList = new ArrayList<>();
        for(int i = 0; i < 10; i ++) {
            trackVOList.add(new TrackVO("周围子", "2017年9月7日",
                    "一个专拍表情包的伪文青我对韩寒并不是很了解，小时候忠于漫画却不是很爱小说。第一次接触到跟韩寒有关的是《后会无期》这部电影。我喜欢那里面的人物那种没有结局的结局，人生不到最后一刻，哪有结局。"
                     +
                    "\n",
                    "100"));
        }
    }

    private class RefreshListener implements SwipeRefreshLayout.OnRefreshListener {

        @Override
        public void onRefresh() {
            if (!isRefresh) {
                isRefresh = true;

                new Handler().postDelayed(new Runnable() {

                    public void run() {
                        mSwipeRefreshLayout.setRefreshing(false);
                        Toast.makeText(getApplicationContext(), "刷新成功", Toast.LENGTH_SHORT).show();
                        adapter.notifyDataSetChanged();
                        isRefresh = false;
                    }
                }, 3000);
            } else {
                Log.e("Refresh", "Refreshing");
                Toast.makeText(getApplicationContext(), "正在刷新", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
