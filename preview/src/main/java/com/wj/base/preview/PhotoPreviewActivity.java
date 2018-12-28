package com.wj.base.preview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;

public class PhotoPreviewActivity extends Activity {

    public static final String EXTRA_PHOTOS = "extra_photos";
    public static final String EXTRA_CURRENT_ITEM = "extra_current_item";
    public static final String SHOW_GUIDE = "show_guide";

    private ArrayList<String> paths;
    private ViewPagerFixed mViewPager;
    private PhotoPagerAdapter mPagerAdapter;
    private int currentItem = 0;
    private TextView mPreView;
    private boolean showGuide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_image_preview);
        initViews();
        initData();
        initEvent();
        updateActionBarTitle();
    }

    @SuppressLint("WrongViewCast")
    private void initViews() {
        mPreView = findViewById(R.id.preview_content);
        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(Color.parseColor("#4d000000"));
        drawable.setCornerRadius(50);
        mPreView.setBackgroundDrawable(drawable);
        mViewPager = findViewById(R.id.vp_photos);
    }

    private void initData() {
        paths = new ArrayList<>();
        ArrayList<String> pathArr = getIntent().getStringArrayListExtra(EXTRA_PHOTOS);
        if (pathArr != null) {
            paths.addAll(pathArr);
        }
        currentItem = getIntent().getIntExtra(EXTRA_CURRENT_ITEM, 0);
        showGuide = getIntent().getBooleanExtra(SHOW_GUIDE, true);
        if (showGuide) {
            mPreView.setVisibility(View.VISIBLE);
        } else {
            mPreView.setVisibility(View.GONE);
        }
        mPagerAdapter = new PhotoPagerAdapter(this, paths);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setCurrentItem(currentItem);
        mViewPager.setOffscreenPageLimit(5);
    }

    private void initEvent() {
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                updateActionBarTitle();
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mPagerAdapter.setPhotoViewClickListener(new PhotoPagerAdapter.PhotoViewClickListener() {
            @Override
            public void OnPhotoTapListener(View view, float v, float v1) {
                finish();
            }
        });
    }

    public void updateActionBarTitle() {
        mPreView.setText(getString(R.string.preview_image_index, mViewPager.getCurrentItem() + 1, paths.size()));
    }
}
