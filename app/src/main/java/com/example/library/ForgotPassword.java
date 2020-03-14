package com.example.library;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.library.Retrofit.INodeJs;
import com.example.library.Retrofit.RetroClient;




public class ForgotPassword extends AppCompatActivity {

    Button b1;

    EditText t1;
    EditText t2;
    EditText t3;

    INodeJs myAPI;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onStop(){
        super.onStop();
    }

    @Override
    protected void onDestroy(){
        compositeDisposable.clear();
        super.onDestroy();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        Retrofit retrofit = RetroClient.getInstance();
        myAPI = retrofit.create(INodeJs.class);

        b1 =  findViewById(R.id.verify);

        t1 =  findViewById(R.id.ename);
        t2 =  findViewById(R.id.email);
        t3 =  findViewById(R.id.emobile);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                forgot(t1.getText().toString(),t2.getText().toString(),t3.getText().toString());
            }
        });

    }


    private void forgot(final String name,final String email,final String mobile){
        compositeDisposable.add(myAPI.forgot(name,email,mobile)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        if(s.contains("user_email")) {
                            Toast.makeText(ForgotPassword.this, "New password has sent to your email", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(ForgotPassword.this, LoginActivity.class);
                            startActivity(intent);
                        }
                        else
                            Toast.makeText(ForgotPassword.this,""+s,Toast.LENGTH_SHORT).show();
                    }
                })

        );
    }

    public int testforgtpssfile(String a,String b,String c) {
        if (a.equals("") && b.equals("") && c.equals("")) {
            return 0;
        }

        return 1;
    }


}
