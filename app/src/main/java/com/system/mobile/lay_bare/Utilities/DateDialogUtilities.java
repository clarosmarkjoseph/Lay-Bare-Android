package com.system.mobile.lay_bare.Utilities;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.system.mobile.lay_bare.R;

import org.json.JSONObject;

import java.util.Calendar;

/**
 * Created by Mark on 25/09/2017.
 */

public class DateDialogUtilities extends Activity {

    EditText txtData;
    Context context;
    Calendar dateTime;
    DatePickerDialog.OnDateSetListener dialogDate;
    DatePickerDialog dpDialog;
    Utilities utilities;
    int year    = 0;
    int month   = 0;
    int day     = 0;
    TextView lblDate;


    public DateDialogUtilities(Context ctx, EditText txtData1 ,Calendar clndr){
        this.txtData = txtData1;
        this.context = ctx;
        this.dateTime = clndr;
        this.utilities = new Utilities(ctx);
        setDatePickerDialog();
        txtData1.setFocusable( true );
        txtData1.setFocusableInTouchMode( true );
        txtData1.requestFocus();
        txtData1.setKeyListener(null);
    }

    public DateDialogUtilities(Context ctx,  Calendar clndr){
        this.context = ctx;
        this.dateTime = clndr;
        this.utilities = new Utilities(ctx);
        setDatePickerDialog();
    }


    public void setDatePickerDialog(){

        dialogDate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                dateTime.set(Calendar.YEAR,year);
                dateTime.set(Calendar.MONTH,month);
                dateTime.set(Calendar.DAY_OF_MONTH,day);
//                updateTextLabel(year,day,month+1);
                setDate(year,day,month);
            }
        };
    }

    public void setBirthday() {

        dpDialog = new DatePickerDialog(context, R.style.DialogTheme,dialogDate,dateTime.get(Calendar.YEAR),dateTime.get(Calendar.MONTH),dateTime.get(Calendar.DAY_OF_MONTH));
        DatePicker datePicker = dpDialog.getDatePicker();
        Calendar calendar = Calendar.getInstance();//get the current day
        datePicker.setMaxDate(calendar.getTimeInMillis());
        dpDialog.show();
    }


    public void updateTextLabel(int year, int day, int month) {
        txtData.setText((year)+"-"+(month<10?("0"+month):(month))+"-"+(day<10?("0"+day):(day)));
    }

    public void setDate(int year1, int day1, int month1){
        this.year   = year1;
        this.day    = day1;
        this.month  = month1;
    }
    public String returnDate(){
        return String.valueOf(this.year)+"-"+String.valueOf(this.month)+"-"+String.valueOf(this.day);
    }



}