package com.ydws.game.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ydws.game.R;
import com.ydws.game.bean.PersonalBean;

public class PersonalAdapter extends BaseQuickAdapter<PersonalBean, BaseViewHolder> {
    public PersonalAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, PersonalBean item) {
        Glide.with(mContext).load(item.getImgId()).into((ImageView) helper.getView(R.id.iv_personal));
    }
}
