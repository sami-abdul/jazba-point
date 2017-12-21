package com.expendive.jazbapoint.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.expendive.jazbapoint.R;

/**
 * Created by Abdul Sami on 12/14/2017.
 */
public class PhonesTabletsFragment extends Fragment {

    public PhonesTabletsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_phones_tablets, container, false);
    }
}
