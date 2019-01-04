package com.ydws.game.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ydws.game.R;
import com.ydws.game.adapter.GameRecordAdapter;
import com.ydws.game.base.BaseAbstractActivity;
import com.ydws.game.bean.GameRecordBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 游戏记录
 */
public class GameRecordActivity extends BaseAbstractActivity {
    private GameRecordAdapter gameRecordAdapter;
    private RecyclerView gameRecordRv;

    @Override
    public int getContentLayoutID() {
        return R.layout.activity_game_record;
    }

    @Override
    public void initViews() {
        gameRecordRv = findViewById(R.id.rv_game_record);
    }

    @Override
    public void initData() {
        gameRecordAdapter = new GameRecordAdapter(R.layout.item_gold_record);
        List<GameRecordBean> datas = new ArrayList<>();
        datas.add(new GameRecordBean());
        datas.add(new GameRecordBean());
        datas.add(new GameRecordBean());
        gameRecordAdapter.setNewData(datas);
        gameRecordRv.setAdapter(gameRecordAdapter);
        gameRecordRv.setLayoutManager(new LinearLayoutManager(this));
    }
}
