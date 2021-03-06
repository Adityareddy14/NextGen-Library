package com.example.library.ui.ratings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.library.R;

public class RatingshowFragment extends Fragment {

    private RatingshowViewModel ratingshowViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ratingshowViewModel =
                ViewModelProviders.of(this).get(RatingshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_rating, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        ratingshowViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}