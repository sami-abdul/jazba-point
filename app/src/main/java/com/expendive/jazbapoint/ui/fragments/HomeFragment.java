package com.expendive.jazbapoint.ui.fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.expendive.jazbapoint.R;
import com.expendive.jazbapoint.domain.api.CategoryLoaderTask;
import com.expendive.jazbapoint.ui.activities.ECartHomeActivity;
import com.expendive.jazbapoint.util.Utils;
import com.expendive.jazbapoint.util.Utils.AnimationType;

public class HomeFragment extends Fragment {
    int mutedColor = R.attr.colorPrimary;
    private RecyclerView recyclerView;
    private ScrollView scrollView;
    private boolean doubleBackToExitPressedOnce;
    private final Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            doubleBackToExitPressedOnce = false;
        }
    };
    private Handler mHandler = new Handler();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

//        view.findViewById(R.id.search_item).setOnClickListener(
//                new OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Utils.switchFragmentWithAnimation(R.id.frag_container,
//                                new SearchProductFragment(),
//                                ((ECartHomeActivity) getActivity()), null,
//                                AnimationType.SLIDE_UP);
//                    }
//                });

        final Toolbar toolbar = (Toolbar) view.findViewById(R.id.anim_toolbar);
        ((ECartHomeActivity) getActivity()).setSupportActionBar(toolbar);
        ((ECartHomeActivity) getActivity()).getSupportActionBar()
                .setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationIcon(R.drawable.ic_drawer);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ECartHomeActivity) getActivity()).getmDrawerLayout()
                        .openDrawer(GravityCompat.START);
            }
        });

//        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
//            @SuppressWarnings("ResourceType")
//            @Override
//            public void onGenerated(Palette palette) {
//                mutedColor = palette.getMutedColor(R.color.primary_500);
//                collapsingToolbar.setContentScrimColor(mutedColor);
//                collapsingToolbar.setStatusBarScrimColor(R.color.black_trans80);
//            }
//        });

        recyclerView = (RecyclerView) view.findViewById(R.id.computing_recyclerView);
        scrollView = (ScrollView) view.findViewById(R.id.homeScrollView);

//        recyclerView.setHasFixedSize(true);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
//                getActivity());
//        recyclerView.setLayoutManager(linearLayoutManager);
//
        new CategoryLoaderTask(scrollView, recyclerView, getActivity()).execute();

//
//		if (simpleRecyclerAdapter == null) {
//			simpleRecyclerAdapter = new CategoryListAdapter(getActivity());
//			recyclerView.setAdapter(simpleRecyclerAdapter);
//
//			simpleRecyclerAdapter
//					.SetOnItemClickListener(new OnItemClickListener() {
//
//						@Override
//						public void onItemClick(View view, int position) {
//
//							if (position == 0) {
//								CenterRepository.getCenterRepository()
//										.getAllElectronics();
//							} else if (position == 1) {
//								CenterRepository.getCenterRepository()
//										.getAllFurnitures();
//							}
//							Utils.switchFragmentWithAnimation(
//									R.id.frag_container,
//									new ProductOverviewFragment(),
//									((ECartHomeActivity) getActivity()), null,
//									AnimationType.SLIDE_LEFT);
//
//						}
//					});
//		}

        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_UP
                        && keyCode == KeyEvent.KEYCODE_BACK) {

                    if (doubleBackToExitPressedOnce) {
                        // super.onBackPressed();

                        if (mHandler != null) {
                            mHandler.removeCallbacks(mRunnable);
                        }

                        getActivity().finish();

                        return true;
                    }

                    doubleBackToExitPressedOnce = true;
                    Toast.makeText(getActivity(),
                            "Please click BACK again to exit",
                            Toast.LENGTH_SHORT).show();

                    mHandler.postDelayed(mRunnable, 2000);

                }
                return true;
            }
        });

        return view;

    }

}
