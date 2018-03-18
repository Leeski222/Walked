package cn.nju.lee.walked.view.seek.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cn.nju.lee.walked.R;
import cn.nju.lee.walked.model.vopo.TrackVO;
import cn.nju.lee.walked.view.track.TrackActivity;

/**
 * Created by 果宝 on 2018/ic_create/20.
 */

public class SeekListAdapter extends RecyclerView.Adapter<SeekListAdapter.Holder> {
    private Activity mContext;
    private List<TrackVO> recordList;

    public SeekListAdapter(Activity context, List<TrackVO> recordList) {
        this.mContext = context;
        this.recordList = recordList;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(mContext).inflate(R.layout.view_text_record, parent, false);
        return new Holder(root);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        TrackVO trackVO = recordList.get(position);
//        holder.userProfile.setImageResource(trackVO.getProfile());
        holder.userName.setText(trackVO.getUsername());
        holder.textContent.setText(trackVO.getContent());
        holder.createDate.setText(trackVO.getCreateDate());
        holder.thumbUpNum.setText(trackVO.getThumbUpNum());
    }

    @Override
    public int getItemCount() {
        return recordList.size();
    }

    class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView userProfile;
        TextView userName;
        TextView createDate;
        TextView textContent;
        TextView thumbUpNum;

        Holder(View itemView) {
            super(itemView);

            userProfile = (ImageView) itemView.findViewById(R.id.text_record_civ_profile);
            userName = (TextView) itemView.findViewById(R.id.text_record_tv_username);
            createDate = (TextView) itemView.findViewById(R.id.text_record_create_date);
            textContent = (TextView) itemView.findViewById(R.id.text_record_tv_content);
            thumbUpNum = (TextView) itemView.findViewById(R.id.text_record_tv_thumbs_up);

            View textRecord = itemView.findViewById(R.id.text_record);
            textRecord.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int pos = getAdapterPosition();
            TrackVO trackVO = recordList.get(pos);
            switch (v.getId()) {
                case R.id.text_record:
//                    Intent intent = new Intent(getActivity(), VolDetailActivity.class);
//                    intent.putExtra("vol", vol);
//                    startActivity(intent);
                    TrackActivity.activityStart(mContext);
                    break;
            }
        }
    }
}
