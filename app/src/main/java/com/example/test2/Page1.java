package com.example.test2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Page1 extends Fragment {
    int position;

TextView text;
    public Page1(int position) {
        this.position = position;
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page1, container, false);
        text = view.findViewById(R.id.text);
        text.setText("This is Page "+position);
        // Inflate the layout for this fragment
        return view;
    }
}