package com.ydws.game.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ydws.game.R;
import com.ydws.game.adapter.VoteAdapter;
import com.ydws.game.base.BaseAbstractActivity;
import com.ydws.game.bean.VoteBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 投票
 */
public class VoteActivity extends BaseAbstractActivity implements BaseQuickAdapter.OnItemChildClickListener {
    private RecyclerView voteRv;
    private VoteAdapter voteAdapter;

    @Override
    public int getContentLayoutID() {
        return R.layout.activity_vote;
    }

    @Override
    public void initViews() {
        voteRv = findViewById(R.id.rv_vote);
    }

    @Override
    public void initData() {
        voteAdapter = new VoteAdapter(R.layout.item_vote);
        List<VoteBean> datas = new ArrayList<>();
        datas.add(new VoteBean());
        datas.add(new VoteBean());
        datas.add(new VoteBean());
        voteAdapter.setNewData(datas);
        voteRv.setAdapter(voteAdapter);
        voteRv.setLayoutManager(new LinearLayoutManager(this));


        voteAdapter.setOnItemChildClickListener(this);
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        switch (view.getId()) {
            case R.id.iv_vote_detail:
                startActivity(new Intent(this,VoteDetailActivity.class));
                break;
        }
    }
}
