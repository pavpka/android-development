package com.example.lab5;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


public class SettingFragment extends Fragment {

    private static final String ARGS_MESSAGE = "args:message";

    public static SettingFragment newInstance(String message) {
        SettingFragment settingFragment = new SettingFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARGS_MESSAGE, message);
        settingFragment.setArguments(bundle);
        return settingFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting,
                container, false);

        TextView textView = view.findViewById(R.id.setting_text);
        String message = getArguments().getString(ARGS_MESSAGE);
        textView.setText(message);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.setting);
        return view;
    }
}
