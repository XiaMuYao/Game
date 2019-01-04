package com.ydws.game.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ydws.game.R;
import com.ydws.game.bean.VoteBean;

public class VoteAdapter extends BaseQuickAdapter<VoteBean, BaseViewHolder> {
    public VoteAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, VoteBean item) {
        helper.addOnClickListener(R.id.iv_vote_detail);
    }


}
