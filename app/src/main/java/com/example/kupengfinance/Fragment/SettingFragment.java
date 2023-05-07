package com.example.kupengfinance.Fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kupengfinance.Activity.ChangePasswordActivity;
import com.example.kupengfinance.Activity.MainActivity;
import com.example.kupengfinance.Activity.PreviewLoginActivity;
import com.example.kupengfinance.R;

import org.w3c.dom.Text;


public class SettingFragment extends DialogFragment {

    TextView changepass;
    TextView logout;


    public SettingFragment() {
        // Required empty public constructor
    }


    public static SettingFragment getInstance() {
        return new SettingFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        changepass = (TextView) view.findViewById(R.id.changespassword);
        logout = (TextView) view.findViewById(R.id.logout);
        changepass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ChangePasswordActivity.class);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
        return view;
    }

    public void showDialog() {
        final AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle("Logout");

        builder.setMessage("Do you want to log out from the app?");

        builder.setCancelable(false);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getActivity(), "You has been logout", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), PreviewLoginActivity.class);
                startActivity(intent);
            }
        });

        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                builder.create().dismiss();
            }
        });
        builder.show();
    }
}