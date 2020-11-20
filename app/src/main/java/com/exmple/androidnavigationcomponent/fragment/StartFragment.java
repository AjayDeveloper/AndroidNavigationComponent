package com.exmple.androidnavigationcomponent.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.exmple.androidnavigationcomponent.R;
import com.exmple.androidnavigationcomponent.model.User;


public class StartFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        NavController navController = Navigation.findNavController(view);

        Button startGameButton = view.findViewById(R.id.startGameButton);

        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             /* StartFragmentDirections.ActionStartFragmentToGameFragment action = StartFragmentDirections.actionStartFragmentToGameFragment();
              action.setMessage("this is the message ");
              navController.navigate(action);*/

                User user = new User(1,"Ajay");
                StartFragmentDirections.ActionStartFragmentToGameFragment action = StartFragmentDirections.actionStartFragmentToGameFragment(user);
                action.setMessage("this is the user message");
                navController.navigate(action);

            }
        });

    }
}