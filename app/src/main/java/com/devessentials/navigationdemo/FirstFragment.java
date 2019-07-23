package com.devessentials.navigationdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.navigation.Navigation;

public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.first_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final View view = getView();
        if (view == null) return;

        Button button = getView().findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = view.findViewById(R.id.userText);
                String userText = editText.getText().toString();

                // SOS: these classes are auto-generated on build when I change the navigation_graph
                // I can't create a FirstToSecond obj w/o passing a String arg. This ensures that
                // FirstFragment will always pass a String arg to SecondFragment!
                FirstFragmentDirections.FirstToSecond action =
                        FirstFragmentDirections.firstToSecond(userText);

                Navigation.findNavController(v).navigate(action);
            }
        });
    }
}
