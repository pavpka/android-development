package com.example.lab5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


public class HomeFragment extends Fragment {

    private static final String ARGS_MESSAGE = "args:message";

    public static HomeFragment newInstance(String message) {
        HomeFragment homeFragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARGS_MESSAGE, message);
        homeFragment.setArguments(bundle);

        return homeFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,
                container, false);

        TextView textView = view.findViewById(R.id.home_text);
        String message = getArguments().getString(ARGS_MESSAGE);
        textView.setText(message);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.home);
        return view;
    }
}
