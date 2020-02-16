package com.example.library.ui.updateinfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.example.library.Main3Activity;
import com.example.library.R;


public class UpdateInformation extends Fragment {

    TextView textView;

    private UpdateInformationViewModel updateInformationViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        updateInformationViewModel =
                ViewModelProviders.of(this).get(UpdateInformationViewModel.class);
        View root = inflater.inflate(R.layout.fragment_updateinformation, container, false);
          textView =  root.findViewById(R.id.uname);
        Main3Activity main3Activity=(Main3Activity)getActivity();
        textView.setText(main3Activity.getEmail());
        return root;
    }

}