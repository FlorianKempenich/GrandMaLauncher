package com.example.shock.memelauncher.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.example.shock.memelauncher.R;

/**
 * Compound layout representing an App view
 */
public class CompoundAppView extends LinearLayout {

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
    }

}
