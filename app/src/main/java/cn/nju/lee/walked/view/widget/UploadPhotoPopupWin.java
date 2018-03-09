package cn.nju.lee.walked.view.widget;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import cn.nju.lee.walked.R;

/**
 * Created by 果宝 on 2018/3/9.
 */

public class UploadPhotoPopupWin {
//    private PopupWindow popupWindow;
//
//    void bottomwindow(View view) {
//        if (popupWindow != null && popupWindow.isShowing()) {
//            return;
//        }
//        LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.window_popup, null);
//        popupWindow = new PopupWindow(layout,
//                ViewGroup.LayoutParams.MATCH_PARENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT);
//        //点击空白处时，隐藏掉pop窗口
//        popupWindow.setFocusable(true);
//        popupWindow.setBackgroundDrawable(new BitmapDrawable());
//        //添加弹出、弹入的动画
//        popupWindow.setAnimationStyle(R.style.upload_photo_anim);
//        int[] location = new int[2];
//        view.getLocationOnScreen(location);
//        popupWindow.showAtLocation(view, Gravity.LEFT | Gravity.BOTTOM, 0, -location[1]);
//        //添加pop窗口关闭事件，主要是实现关闭时改变背景的透明度
//        popupWindow.setOnDismissListener(new poponDismissListener());
//        backgroundAlpha(1f);
//    }
}
