package com.example.shock.memelauncher.view;

import android.content.Context;
import android.media.Image;
import android.support.annotation.BinderThread;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.shock.memelauncher.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Compound layout representing an App view
 */
public class CompoundAppView extends LinearLayout {

    @Bind(R.id.image_view) ImageView mImageView;
    @Bind(R.id.text_view) TextView mTextView;

    public CompoundAppView(Context context) {
        this(context, null, 0);
    }

    public CompoundAppView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CompoundAppView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews(context);
    }

    private void initViews(Context context) {
        // Inflate the layout and attach it to root
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.compound_app_view_layout, this, true);
        this.setOrientation(VERTICAL);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
    }

    public void setTextAndImage(@DrawableRes int resId, String text) {
        mTextView.setText(text);
        if (resId != 0)
            mImageView.setImageResource(resId);
    }
}
