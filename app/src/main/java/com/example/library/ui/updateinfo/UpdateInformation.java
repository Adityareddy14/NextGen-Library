package com.example.library.ui.updateinfo;

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

public class UpdateInformation extends Fragment {

    private UpdateInformationViewModel updateInformationViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        updateInformationViewModel =
                ViewModelProviders.of(this).get(UpdateInformationViewModel.class);
        View root = inflater.inflate(R.layout.fragment_updateinformation, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        updateInformationViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}