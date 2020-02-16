package com.example.library.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.example.library.CustomAdapter;
import com.example.library.Main3Activity;
import com.example.library.R;
import com.example.library.CustomAdapter;
import com.example.library.Whislist;
import com.example.library.book_information;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    int[] osImages  = {
            R.drawable.e12341,R.drawable.e12342,R.drawable.e12343,R.drawable.e12344,R.drawable.e12345,R.drawable.e12346,
            R.drawable.e12347,R.drawable.e12348,R.drawable.e12349,R.drawable.e12350,R.drawable.e12351,R.drawable.e12352,
            R.drawable.e12353,R.drawable.e12354,R.drawable.e12355,R.drawable.e12356,R.drawable.e12357,R.drawable.e12358,
            R.drawable.e12359,R.drawable.e12360
    };



    GridView gridview;
    ArrayAdapter<String> adapter;


    public static HomeFragment newInstance(){
        HomeFragment home = new HomeFragment();
        return  home;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);

        View view = inflater.inflate(R.layout.fragment_home,container,false);
        gridview =  view.findViewById(R.id.grid_books);
        gridview.setAdapter(new CustomAdapter(view.getContext()));


        gridview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView,View view,int i,long l) {
                Intent intent = new Intent(getActivity(), Whislist.class);
                intent.putExtra("val",String.valueOf(i));
                return true;
            }
        });


        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,View view,int i,long l) {
                Intent intent = new Intent(getActivity(), book_information.class);
                intent.putExtra("val",String.valueOf(i));
                startActivity(intent);
                        }
        });

        return view;

    }


    @Override
    public String toString(){
        return "home";
    }

}