package com.example.lab5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


public class ProfileFragment extends Fragment {


    public static ProfileFragment newInstance() {
        ProfileFragment profileFragment = new ProfileFragment();
        Bundle bundle = new Bundle();
        profileFragment.setArguments(bundle);
        return profileFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile,
                container, false);

        TextView textView = view.findViewById(R.id.profile_text);
        ImageView imgView = view.findViewById(R.id.profile_image);
        imgView.setImageResource(R.drawable.duck);
        textView.setText("Пицик Юлия, группа Р3419");
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.profile);
        return view;
    }
}
