package com.ydws.game.widget.chooser;


import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

public interface OnChooseListener {
     void onChoose(@NonNull DialogFragment dialogFragment, @NonNull Object content);

}
