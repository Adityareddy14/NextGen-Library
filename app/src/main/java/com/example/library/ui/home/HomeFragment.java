package com.example.library.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

import com.example.library.CustomAdapter;
import com.example.library.LoginActivity;
import com.example.library.Main3Activity;
import com.example.library.R;
import com.example.library.Retrofit.INodeJs;
import com.example.library.Retrofit.RetroClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import com.example.library.CustomAdapter;
import com.example.library.book_information;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    int[] osImages  = {
            R.drawable.e12341,R.drawable.e12342,R.drawable.e12343,R.drawable.e12344,R.drawable.e12345,R.drawable.e12346,
            R.drawable.e12347,R.drawable.e12348,R.drawable.e12349,R.drawable.e12350,R.drawable.e12351,R.drawable.e12352,
            R.drawable.e12353,R.drawable.e12354,R.drawable.e12355,R.drawable.e12356,R.drawable.e12357,R.drawable.e12358,
            R.drawable.e12359,R.drawable.e12360
    };

    private static String[] names={"Aditya","Akash","Charan","Bharath"};



    GridView gridview;
    ArrayAdapter<String> adapter;

    public static HomeFragment newInstance(){
        HomeFragment home = new HomeFragment();
        return  home;
    }



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
//        View root = inflater.inflate(R.layout.fragment_home, container, false);
//
//       gridview = (GridView) root.findViewById(R.id.grid_books);
//
//
//
//       gridview.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,names));
//
//        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView,View view,int i,long l) {
//                Toast.makeText(getActivity(),names[i],Toast.LENGTH_SHORT).show();
//            }
//        });

//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        View view = inflater.inflate(R.layout.fragment_home,container,false);
        gridview = (GridView) view.findViewById(R.id.grid_books);
        gridview.setAdapter(new CustomAdapter(view.getContext()));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,View view,int i,long l) {
                Intent intent = new Intent(getActivity(), book_information.class);
                intent.putExtra("val",String.valueOf(i));
                startActivity(intent);
                //Toast.makeText(getActivity(),String.valueOf(i),Toast.LENGTH_SHORT).show();
            }
        });


        return view;

    }

    public String toString(){
        return "home";
    }

}