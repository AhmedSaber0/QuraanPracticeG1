package com.route.quraanpractice2.fragment;

import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    protected void showAlertDialog(String title, String message, int positiveButton, int negativeButton,
                         DialogInterface.OnClickListener positiveClick,
                         DialogInterface.OnClickListener negativeClick) {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(positiveButton, positiveClick)
                .setNegativeButton(negativeButton, negativeClick)
                .show();
    }

    protected void showAlertDialog(String title, String message, int positiveButton,
                         DialogInterface.OnClickListener positiveClick) {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(positiveButton, positiveClick)
                .show();
    }

    protected void showAlertDialog(String message, int positiveButton,
                         DialogInterface.OnClickListener positiveClick) {
        new AlertDialog.Builder(this)
                .setTitle(null)
                .setMessage(message)
                .setPositiveButton(positiveButton, positiveClick)
                .show();
    }
}
