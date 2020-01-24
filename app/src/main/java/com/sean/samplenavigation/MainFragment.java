package com.sean.samplenavigation;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    TextView textView;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textView = view.findViewById(R.id.tv_main);

        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // MainFragment 에서 SecondFragment 로 데이터 전달 (Safe args)
                MainFragmentDirections.ActionMainFragmentToSecondFragment action = MainFragmentDirections.actionMainFragmentToSecondFragment("Hello !!!");
//                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_secondFragment);
                Navigation.findNavController(view).navigate(action);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        String var = getArguments().getString("varback");
        if(var != null) {
            Log.d("MainFragment", "onResume varback : " + var);
            textView.setText(var);
        }
    }
}
