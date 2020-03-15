package com.example.library.ui.updateinfo;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.example.library.Main3Activity;
import com.example.library.R;
import com.example.library.issuebookform;


public class UpdateInformation extends Fragment {

    TextView textView,textView1,textView2,textView3;

    private UpdateInformationViewModel updateInformationViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        updateInformationViewModel =
                ViewModelProviders.of(this).get(UpdateInformationViewModel.class);
        View root = inflater.inflate(R.layout.fragment_updateinformation, container, false);
          textView =  root.findViewById(R.id.textView5);
        textView1 =  root.findViewById(R.id.textView3);
        textView2 =  root.findViewById(R.id.textView8);
        textView3 =  root.findViewById(R.id.textView11);

        Main3Activity main3Activity=(Main3Activity)getActivity();
        textView.setText(main3Activity.getEmail());
        textView1.setText("Aditya");
        textView2.setText("9384163595");
        textView3.setText("cse17431");

//        issuebookform issue = (issuebookform)getActivity();
        //Log.e("ochinadate",issue.sendate());

        return root;
    }

}