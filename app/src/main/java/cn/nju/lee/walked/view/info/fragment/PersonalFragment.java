package cn.nju.lee.walked.view.info.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.nju.lee.walked.R;
import cn.nju.lee.walked.util.AppData;

/**
 * Created by 果宝 on 2018/3/22.
 */

public class PersonalFragment extends Fragment {
    private View root;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(root == null) {
            root = inflater.inflate(R.layout.fragment_personal, container,false);
        }

        ButterKnife.bind(this, root);
        return root;
    }

    @OnClick(R.id.personal_tv_exit)
    public void exit() {
        AppData.clear();
        this.getActivity().finish();
    }
}
