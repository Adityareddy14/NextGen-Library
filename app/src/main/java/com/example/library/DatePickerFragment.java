package com.example.library;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.DatePicker;

import java.text.DateFormat;
import java.util.Calendar;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener  {

    @NonNull

    @Override

    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Calendar c = Calendar.getInstance();

        int year = c.get(Calendar.YEAR);

        int month = c.get(Calendar.MONTH);

        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog;

        datePickerDialog = new DatePickerDialog(getActivity(),this,year,month,day);

        return datePickerDialog;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        Calendar c = Calendar.getInstance();

        c.set(Calendar.YEAR, year);

        c.set(Calendar.MONTH, month);

        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());

        Log.e("from",currentDateString);

        Intent intent = new Intent(getActivity(), Main3Activity.class);
        intent.putExtra("fromdate",currentDateString);
    }


}
