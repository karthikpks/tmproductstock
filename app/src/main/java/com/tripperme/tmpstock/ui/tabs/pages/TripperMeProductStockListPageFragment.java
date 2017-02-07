package com.tripperme.tmpstock.ui.tabs.pages;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tripperme.tmpstock.R;
import com.tripperme.tmpstock.ui.tabs.TripperMeProductStockTabsFragment;
import com.tripperme.tmpstock.util.Constants;

/**
 * Created by karthik on 2/6/17.
 */

public class TripperMeProductStockListPageFragment extends TripperMeProductStockTabsFragment {

    private AlertDialog dialog;
    private String pageTitle;
    private AlertDialog.Builder builder;
    private boolean isVisible;
    private boolean isDialogShow;


    public static TripperMeProductStockListPageFragment newInstance(String pageTitle) {
        TripperMeProductStockListPageFragment mProductStockListPageFragment = new TripperMeProductStockListPageFragment();
        Bundle args = new Bundle();
        args.putString(Constants.PAGE_TITLE, pageTitle);
        mProductStockListPageFragment.setArguments(args);
        return mProductStockListPageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageTitle = getArguments().getString(Constants.PAGE_TITLE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tripper_me_product_stock_tabs, container, false);
        TextView sectionLabel = (TextView) view.findViewById(R.id.section_label);
        sectionLabel.setText(pageTitle);
        isVisible = isVisible || savedInstanceState.getBoolean(Constants.FLAG_DIALOG_IS_SHOWN);
        if (isVisible) createSampleDialog();
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.
        isDialogShow = dialog != null && dialog.isShowing();
        savedInstanceState.putInt(Constants.FLAG_CURRENTLY_SELECTED_TAB_INDEX, 1);
        savedInstanceState.putBoolean(Constants.FLAG_DIALOG_IS_SHOWN, isDialogShow);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isVisible = isVisibleToUser;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        builder = null;
        dialog = null;
        isDialogShow = false;
        pageTitle = null;
        isVisible = false;
    }

    private void createSampleDialog() {
        // 1. Instantiate an AlertDialog.Builder with its constructor
        if (builder == null) builder = new AlertDialog.Builder(getTripperMeProductStockActivity());

        // 2. Chain together various setter methods to set the dialog characteristics
        builder.setMessage(R.string.app_name)
                .setTitle(R.string.tmps_forgot_password);

        // Add the buttons
        builder.setPositiveButton(R.string.tmps_sign_in, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
            }
        });
        builder.setNegativeButton(R.string.tmps_sign_up, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
            }
        });
        // 3. Get the AlertDialog from create()
        if (dialog == null) dialog = builder.create();
        try {
            //noinspection ConstantConditions
            dialog.getWindow().getAttributes().windowAnimations = R.style.DialogUpBottomAnimation;
        } catch (NullPointerException npe) {
            Log.d("Dialog::Animations", npe.getMessage());
        }

        if (!dialog.isShowing()) dialog.show();
    }


}
