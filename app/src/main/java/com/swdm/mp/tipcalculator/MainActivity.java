package com.swdm.mp.tipcalculator;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Context context;
    private int duration = Toast.LENGTH_LONG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();

        final RadioGroup percent = (RadioGroup) findViewById(R.id.percent);
        final EditText tot = (EditText) findViewById(R.id.tot);//input value
        final EditText value = (EditText) findViewById(R.id.value);//other value
        final Button cal = (Button) findViewById(R.id.cal);//calculate button

        cal.setOnClickListener(new View.OnClickListener() {

            @Override
/*
* Tip Calculate process
* */
            public void onClick(View v) {

                String str = tot.getText().toString();//total amount input value
                float total = Float.parseFloat(str);//total amount value to float
                RadioButton rd = (RadioButton) findViewById(percent.getCheckedRadioButtonId());//Selected Button Id value return
                String str_what = rd.getText().toString();
                float ftotal;//final total;
                if (str_what.equals("other")) {
// other이니까 value값으로 나눠서 더해야함 value값도 float값으로 바꿔서

                    String temp = value.getText().toString();
                    float tmp = Float.parseFloat(temp);//value 값을 Float로
                    tmp=tmp/100;
                    ftotal = total + (total *tmp);
                    Toast.makeText(context,"Tip : "+total*tmp+ "\nTotal : "+ftotal,duration).show();

                } else {
                    String str_num =str_what.substring(0, 2);
                    float rate = Float.parseFloat(str_num);
                    rate=rate/100;
                    ftotal = total +  (total * rate);
                    Toast.makeText(context,"Tip : "+total*rate +"\nTotal :"+ftotal,duration).show();
                }


            }


        });


    }
    /*
    * To save onPause()
    * */
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        EditText tota = (EditText) findViewById(R.id.tot);//input value
        savedInstanceState.putString("TextEdit", tota.getText().toString());
    }

}
