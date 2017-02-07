package com.tripperme.tmpstock.ui.tabs.pages;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tripperme.tmpstock.R;
import com.tripperme.tmpstock.ui.tabs.TripperMeProductStockTabsFragment;
import com.tripperme.tmpstock.util.Constants;

/**
 * Created by karthik on 2/7/17.
 */

public class TripperMeProductStockTodayPageFragment extends TripperMeProductStockTabsFragment {
    private String pageTitle;

    public static TripperMeProductStockTodayPageFragment newInstance(String pageTitle) {
        TripperMeProductStockTodayPageFragment mTripperMeProductStockTodayPageFragment = new TripperMeProductStockTodayPageFragment();
        Bundle args = new Bundle();
        args.putString(Constants.PAGE_TITLE, pageTitle);
        mTripperMeProductStockTodayPageFragment.setArguments(args);
        return mTripperMeProductStockTodayPageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        pageTitle = getArguments().getString(Constants.PAGE_TITLE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tripper_me_product_stock_tabs, container, false);
        TextView sectionLabel = (TextView) view.findViewById(R.id.section_label);
        sectionLabel.setText(pageTitle);
        return  view;
    }
}
