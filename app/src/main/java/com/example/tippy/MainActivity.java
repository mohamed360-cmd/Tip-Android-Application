package com.example.tippy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationBarView;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
private double userValue;
 private int currentProgress;
 private double Tip;
   private  double Total;
   private  String whatIsTheCurrency;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar percentBar=findViewById(R.id.skbUserPercentage);
        TextView percentValue=findViewById(R.id.lblPercent);
         TextView userTip=findViewById(R.id.txtTipValue);
         TextView total=findViewById(R.id.lblTotalValue);
        Spinner Countries=findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> Country= ArrayAdapter.createFromResource(this,R.array.countries, android.R.layout.simple_spinner_item);
        Country.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        Countries.setAdapter(Country);
        Countries.setOnItemSelectedListener(this);
        percentBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                 currentProgress=percentBar.getProgress();
                percentValue.setText(currentProgress+"%");
                Tip=(currentProgress/100.0)*userValue;
                userTip.setText(Double.toString(Tip));
                Total=Tip+userValue;
                total.setText(Double.toString(Total)+whatIsTheCurrency);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                 currentProgress=percentBar.getProgress();

                percentValue.setText(currentProgress+"%");
                Tip=(currentProgress/100.0)*userValue;
                userTip.setText(Double.toString(Tip));
                Total=Tip+userValue;
                total.setText(Double.toString(Total)+whatIsTheCurrency);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                 currentProgress=percentBar.getProgress();

                percentValue.setText(currentProgress+"%");
                Tip=(currentProgress/100.0)*userValue;
                userTip.setText(Double.toString(Tip));
                Total=Tip+userValue;
                total.setText(Double.toString(Total)+whatIsTheCurrency);
            }
        });

        EditText userInput=findViewById(R.id.txtUserInput);
        userInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String userStringValue= userInput.getText().toString();
                if(!userStringValue.isEmpty()){
                 userValue=Double.parseDouble(userStringValue);
                Tip=(currentProgress/100.0)*userValue;
                userTip.setText(Double.toString(Tip));
                Total=Tip+userValue;
                total.setText(Double.toString(Total)+whatIsTheCurrency);}
                else{
                    userValue = 0;
                    userTip.setText("Enter A value");
                    total.setText("?");

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
    String SelectedCurrency=adapterView.getSelectedItem().toString();
    whatIsTheCurrency=SelectedCurrency;
        Toast.makeText(adapterView.getContext(), "Currency Selected is :"+SelectedCurrency,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}