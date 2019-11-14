package com.example.lab5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


public class ContactsFragment extends Fragment {


    public static ContactsFragment newInstance() {
        ContactsFragment contactsFragment = new ContactsFragment();
        Bundle bundle = new Bundle();
        contactsFragment.setArguments(bundle);

        return contactsFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contacts,
                container, false);

        TextView textView = view.findViewById(R.id.contacts_text);
        textView.setText("You haven`t some contacts yet...");
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.contacts);
        return view;
    }
}
