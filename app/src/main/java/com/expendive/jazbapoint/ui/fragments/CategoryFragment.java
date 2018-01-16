package com.expendive.jazbapoint.ui.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.expendive.jazbapoint.R;
import com.expendive.jazbapoint.util.Utils;

public class CategoryFragment extends Fragment {

    public CategoryFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        TextView textView = view.findViewById(R.id.categoryFragmentText);
        textView.setText(Utils.CURRENT_TAG);
        return view;
    }
}
