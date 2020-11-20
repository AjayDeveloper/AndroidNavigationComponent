package com.exmple.androidnavigationcomponent.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.exmple.androidnavigationcomponent.R;
import com.exmple.androidnavigationcomponent.model.User;


public class GameFragment extends Fragment {

    private static final String TAG = "GameFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        NavController navController = Navigation.findNavController(view);

        Button finishGameButton = view.findViewById(R.id.finishGameButton);
        finishGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getArguments()!=null){
                    GameFragmentArgs args = GameFragmentArgs.fromBundle(getArguments());
                    String message = args.getMessage();
                    Log.d(TAG, "onClick: "+message);
                    User user = args.getUser();
                    Log.d(TAG, "onClick: "+user.toString());
                }

                navController.navigate(R.id.action_gameFragment_to_endGameFragment);

            }
        });

    }
}