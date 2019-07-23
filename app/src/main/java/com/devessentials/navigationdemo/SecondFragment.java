package com.devessentials.navigationdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SecondFragment extends Fragment {

    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.second_fragment, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        if (getView() == null || getArguments() == null) return;

        TextView argText = getView().findViewById(R.id.argText);

        // SOS: SecondFragmentArgs is auto-generated when I add the safeargs plugin. Note the
        // getMessage method, which ensures that SecondFragment will get the right type of arg!
        SecondFragmentArgs args = SecondFragmentArgs.fromBundle(getArguments());
        String message = args.getMessage();

        argText.setText(message);
    }
}
