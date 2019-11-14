package com.example.lab5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


public class MessagesFragment extends Fragment {

    private static final String ARGS_MESSAGE = "args:message";

    public static MessagesFragment newInstance(String message) {
        MessagesFragment messagesFragment = new MessagesFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARGS_MESSAGE, message);
        messagesFragment.setArguments(bundle);

        return messagesFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_messages,
                container, false);

        TextView textView = view.findViewById(R.id.messages_text);
        String message = getArguments().getString(ARGS_MESSAGE);
        textView.setText(message);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.messages);
        return view;
    }
}
