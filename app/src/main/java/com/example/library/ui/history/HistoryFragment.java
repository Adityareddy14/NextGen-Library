package com.example.library.ui.history;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.library.R;

import java.util.ArrayList;

public class HistoryFragment extends Fragment {

    private HistoryViewModel historyViewModel;
    private ArrayList<String> arrayList;
    Bundle b;
    int n;

    public String[] mThumbNames = {
            "Java Fundamentals", "Effective Java", "Java The Complete Reference", "Head First Java", "The C Language", "The C programming Language",
            "C Programming","C Programming A Model Approach","Expert C Programming","C++ From Control Structures",
            "C++ Primer","The C++","Effective Modern C++","Accelerated C++","Python Crash Course","Head First Python",
            "Learn Python The Hard Way","Python Programming","Learning With Python"

    };

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        historyViewModel =
                ViewModelProviders.of(this).get(HistoryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_history, container, false);

//        b = getArguments();
//        n = b.getInt("val");

        arrayList = new ArrayList<String>();

        final ListView listView =  root.findViewById(R.id.lv);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, arrayList);
        arrayList.add(mThumbNames[0]);
        arrayList.add(mThumbNames[1]);
        arrayList.add(mThumbNames[2]);
        arrayList.add(mThumbNames[3]);
        arrayList.add(mThumbNames[5]);
        arrayList.add(mThumbNames[7]);
        arrayList.add(mThumbNames[4]);
        arrayList.add(mThumbNames[6]);
        arrayList.add(mThumbNames[8]);
        arrayList.add(mThumbNames[2]);
        arrayList.add(mThumbNames[9]);
        arrayList.add(mThumbNames[10]);
        arrayList.add(mThumbNames[1]);
        arrayList.add(mThumbNames[0]);
        arrayList.add(mThumbNames[1]);
        arrayList.add(mThumbNames[0]);
        arrayList.add(mThumbNames[1]);
        arrayAdapter.notifyDataSetChanged();
        listView.setAdapter(arrayAdapter);

        return root;
    }
}