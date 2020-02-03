package com.example.library.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

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
import com.example.library.R;
import com.example.library.Retrofit.INodeJs;
import com.example.library.Retrofit.RetroClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import com.example.library.CustomAdapter;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    int[] osImages  = {
            R.drawable.e12341,R.drawable.e12342,R.drawable.e12343,R.drawable.e12344,R.drawable.e12345,R.drawable.e12346,
            R.drawable.e12347,R.drawable.e12348,R.drawable.e12349,R.drawable.e12350,R.drawable.e12351,R.drawable.e12352,
            R.drawable.e12353,R.drawable.e12354,R.drawable.e12355,R.drawable.e12356,R.drawable.e12357,R.drawable.e12358,
            R.drawable.e12359,R.drawable.e12360
    };

    String dataParsed = "";
    String singleParsed = "";
    INodeJs myAPI;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    GridView androidGridView;
    GridView gridview;


    public void onStop(){
        super.onStop();
    }

    public void onDestroy(){
        compositeDisposable.clear();
        super.onDestroy();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        Retrofit retrofit = RetroClient.getInstance();
        myAPI = retrofit.create(INodeJs.class);



//        homeViewModel =
//                ViewModelProviders.of(this).get(HomeViewModel.class);
//        View root = inflater.inflate(R.layout.fragment_home, container, false);
//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//
//                //textView.setText(s);
//            }
//        });
        return null;

    }

    private void books(String val){
        compositeDisposable.add(myAPI.books(val)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        //   Toast.makeText(productsdisplay.this, s, Toast.LENGTH_SHORT).show();
                        json(s);
                    }
                })

        );
    }

    public ArrayList<String> json(String s) throws JSONException {

        // Toast.makeText(productsdisplay.this, s, Toast.LENGTH_SHORT).show();

        ArrayList<String> stringArray = new ArrayList<String>();

        JSONArray jsonArray = new JSONArray(s);

        for(int i=0;i<jsonArray.length();i++){
            stringArray.add(jsonArray.getString(i));
            JSONObject JO = (JSONObject) jsonArray.get(i);
            singleParsed = "Name:" + JO.get("productName");
            dataParsed = dataParsed + singleParsed;

        }

        Log.e("fucku",dataParsed);


        gridview = (GridView) androidGridView.findViewById(R.id.customgrid);
        gridview.setAdapter(new CustomAdapter(this.getActivity(), stringArray, osImages));

        return stringArray;

    }



}