package com.ydws.game.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ydws.game.R;
import com.ydws.game.activity.GoldSearchActivity;
import com.ydws.game.activity.RepoSearchActivity;
import com.ydws.game.adapter.GoldRecordAdapter;
import com.ydws.game.base.BaseFragment;
import com.ydws.game.bean.GoldRecordBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 道具回收
 */
public class PropRecoveryFragment extends BaseFragment implements BaseQuickAdapter.OnItemChildClickListener {
    private RecyclerView goldRv;
    private GoldRecordAdapter recordAdapter;

    @Override
    protected int initLayoutId() {
        return R.layout.fragment_gold_record;
    }

    @Override
    protected void initView() {
        goldRv = mRootView.findViewById(R.id.rv_record);
    }

    @Override
    protected void initData() {
        recordAdapter = new GoldRecordAdapter(R.layout.item_gold_record);
        List<GoldRecordBean>datas=new ArrayList<>();
        datas.add(new GoldRecordBean());
        datas.add(new GoldRecordBean());
        datas.add(new GoldRecordBean());
        recordAdapter.setNewData(datas);
        goldRv.setAdapter(recordAdapter);
        goldRv.setLayoutManager(new LinearLayoutManager(getContext()));


        recordAdapter.setOnItemChildClickListener(this);
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        switch (view.getId()) {
            case R.id.iv_right_gold:
                startActivity(new Intent(mActivity, RepoSearchActivity.class));
                break;
        }
    }
}
