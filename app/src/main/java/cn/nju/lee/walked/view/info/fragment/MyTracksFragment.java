package cn.nju.lee.walked.view.info.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.nju.lee.walked.R;
import cn.nju.lee.walked.model.vopo.TrackVO;
import cn.nju.lee.walked.view.seek.adapter.TrackListAdapter;

/**
 * Created by 果宝 on 2018/3/22.
 */

public class MyTracksFragment extends Fragment {
    private View root;

    private List<TrackVO> trackVOList;

    private TrackListAdapter adapter;

    @BindView(R.id.seek_rcl_list)
    RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(root == null) {
            root = inflater.inflate(R.layout.activity_seek, container,false);
        }

        ButterKnife.bind(this, root);

        initTrackList();
        adapter = new TrackListAdapter(this.getActivity(), trackVOList);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        mRecyclerView.setAdapter(new TrackListAdapter(this.getActivity(), trackVOList));
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
}
