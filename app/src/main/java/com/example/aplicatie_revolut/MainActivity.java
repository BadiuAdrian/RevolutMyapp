package com.example.aplicatie_revolut;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button addbtn, buybtn;
    TextView balanceText, balanceNr, marketText, foodText, drinksText, spendText, vatText, foodNrText, drinksNrText, spendNrText, vatNrText;
    EditText inputBalance, inputMarket;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addbtn = findViewById(R.id.add_btn);
        buybtn = findViewById(R.id.buy_btn);
        balanceText = findViewById(R.id.textBalance);
        balanceNr = findViewById(R.id.texthowmuchBalance);
        marketText = findViewById(R.id.textMarket);
        foodText = findViewById(R.id.textViewfood);
        drinksText = findViewById(R.id.textViewDrinks);
        spendText = findViewById(R.id.textViewSpend);
        vatText = findViewById(R.id.textViewVAT);
        foodNrText = findViewById(R.id.textViewfoodnr);
        drinksNrText = findViewById(R.id.textViewdrinksnr);
        spendNrText = findViewById(R.id.textViewspendnr);
        vatNrText = findViewById(R.id.textViewvatnr);
        inputBalance = findViewById(R.id.editTextBalance);
        inputMarket = findViewById(R.id.editTextMarket);
        spinner = findViewById(R.id.spinner);
        initSpinner();

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int num1 = Integer.parseInt(inputBalance.getText().toString());
                balanceNr.setText("" + num1);
            }
        });

        buybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("spinner", spinner.getSelectedItem().toString());
            }
        });
    }

    public void initSpinner() {
        GroceriesType[] spinnerItems = GroceriesType.values();
        ArrayAdapter<GroceriesType> adapter = new ArrayAdapter<GroceriesType>(this, android.R.layout.simple_spinner_item, spinnerItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

}
