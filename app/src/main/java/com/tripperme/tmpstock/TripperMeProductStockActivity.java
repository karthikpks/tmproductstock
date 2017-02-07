package com.tripperme.tmpstock;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.tripperme.tmpstock.ui.tabs.TripperMeProductStockTabsActivity;

public class TripperMeProductStockActivity extends AppCompatActivity {

    private Button tmpsSignIn;
    private Button tmpsSignUp;
    private EditText tmpsUserName;
    private EditText tmpsPassword;
    private TextView tmpsForgetPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tripper_me_product_stock);

        tmpsUserName = (EditText) findViewById(R.id.tmps_user_name);
        tmpsPassword = (EditText) findViewById(R.id.tmps_password);
        tmpsForgetPassword = (TextView) findViewById(R.id.tmps_forget_password);
        tmpsSignIn = (Button) findViewById(R.id.tmps_sign_in);
        tmpsSignUp = (Button) findViewById(R.id.tmps_sign_up);

        editTextClickListener();
        textViewClickListener();
        signInBtnClickListener();
        signUpBtnClickListener();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        destroyAttribute();
    }

    private void editTextClickListener() {
        tmpsUserName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                tmpsUserName.setHintTextColor(!b ? ContextCompat.getColor(getApplicationContext(), R.color.colorHintText) : ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryText));
            }
        });

        tmpsPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                tmpsPassword.setHintTextColor(!b ? ContextCompat.getColor(getApplicationContext(), R.color.colorHintText) : ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryText));
            }
        });
    }

    private void textViewClickListener() {
        tmpsForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                forgetPasswordAlertDialog();
            }
        });
    }

    private void forgetPasswordAlertDialog() {
        // 1. Instantiate an AlertDialog.Builder with its constructor
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

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
        AlertDialog dialog = builder.create();
        try {
            //noinspection ConstantConditions
            dialog.getWindow().getAttributes().windowAnimations = R.style.DialogUpBottomAnimation;
        }catch (NullPointerException npe) {
            Log.d("Dialog::Animations", npe.getMessage());
        }
        dialog.show();
    }

    private void signInBtnClickListener() {
        tmpsSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToTabs();
            }
        });
    }

    private void switchToTabs() {
        Intent intent = new Intent(TripperMeProductStockActivity.this, TripperMeProductStockTabsActivity.class);
        startActivity(intent);
    }

    private void signUpBtnClickListener() {
        tmpsSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void destroyAttribute() {
        tmpsUserName.setOnFocusChangeListener(null);
        tmpsPassword.setOnFocusChangeListener(null);
        tmpsSignIn.setOnClickListener(null);
        tmpsSignUp.setOnClickListener(null);
    }
}
