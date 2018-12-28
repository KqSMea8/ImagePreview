package com.wj.base.intent;

import android.content.Context;
import android.content.Intent;

import com.wj.base.preview.PhotoPreviewActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 预览照片
 */
public class PhotoPreviewIntent extends Intent {

    public PhotoPreviewIntent(Context packageContext) {
        super(packageContext, PhotoPreviewActivity.class);
    }

    /**
     * 照片地址
     * @param paths
     */
    public void setPhotoPaths(List<String> paths){
        this.putStringArrayListExtra(PhotoPreviewActivity.EXTRA_PHOTOS, new ArrayList<>(paths));
    }

    /**
     * 当前照片的下标
     * @param currentItem
     */
    public void setCurrentItem(int currentItem){
        this.putExtra(PhotoPreviewActivity.EXTRA_CURRENT_ITEM, currentItem);
    }
    /**
     * 是否显示下边导航 1/1
     * @param showGuide  默认为true
     */
    public void setShowGuide(boolean showGuide){
        this.putExtra(PhotoPreviewActivity.SHOW_GUIDE,showGuide);
    }
}
