package cn.nju.lee.walked.view.recordlist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.nju.lee.walked.R;
import cn.nju.lee.walked.model.vopo.RecordVO;
import cn.nju.lee.walked.view.recordlist.adapter.RecordListAdapter;

import static com.baidu.mapapi.BMapManager.getContext;

/**
 * Created by 果宝 on 2018/1/20.
 */

public class RecordListActivity extends AppCompatActivity {
    @BindView(R.id.recordlist_rcl_list)
    RecyclerView mRecyclerView;

    private List<RecordVO> recordVOList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordlist);
        ButterKnife.bind(this);
        initRecordList();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(new RecordListAdapter(getContext(), recordVOList));
    }

    @Override
    public void onResume() {
        super.onResume();
        mRecyclerView.setAdapter(new RecordListAdapter(getContext(), recordVOList));
    }

    private void initRecordList() {
        recordVOList = new ArrayList<>();
        for(int i = 0; i < 10; i ++) {
            recordVOList.add(new RecordVO("周围子", "2017年9月7日",
                    "一个专拍表情包的伪文青我对韩寒并不是很了解，小时候忠于漫画却不是很爱小说。第一次接触到跟韩寒有关的是《后会无期》这部电影。我喜欢那里面的人物那种没有结局的结局，人生不到最后一刻，哪有结局。"
                     +
                    "\n",
                    "100"));
        }
    }
}
