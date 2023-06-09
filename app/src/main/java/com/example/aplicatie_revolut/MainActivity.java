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
        initButton();


    }

    private void initButton() {
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!inputBalance.getText().toString().equals("")) {
                    int currentBalance = Integer.parseInt(balanceNr.getText().toString());
                    int addBalance = Integer.parseInt(inputBalance.getText().toString());
                    currentBalance += addBalance;
                    balanceNr.setText(String.valueOf(currentBalance));


                }
            }
        });


        buybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!inputMarket.getText().toString().equals("")) {
                    Log.d("spinner", spinner.getSelectedItem().toString());
                    int currentBalance = Integer.parseInt(balanceNr.getText().toString());
                    int buyNum = Integer.parseInt(inputMarket.getText().toString());
                    int totalSpend = Integer.parseInt(spendNrText.getText().toString());
                    currentBalance = currentBalance - buyNum;
                    totalSpend += buyNum;
                    balanceNr.setText(String.valueOf(currentBalance));
                    spendNrText.setText(String.valueOf(totalSpend));
                    int foodNum = Integer.parseInt(foodNrText.getText().toString());
                    int drinksNum = Integer.parseInt(drinksNrText.getText().toString());
                    if (spinner.getSelectedItem().toString() == "Food") {
                        foodNum += buyNum;
                    } else {
                        drinksNum += buyNum;
                    }
                    foodNrText.setText(String.valueOf(foodNum));
                    drinksNrText.setText(String.valueOf(drinksNum));
                    double vatNum;
                    vatNum = (double) foodNum * 0.1 + (double) drinksNum * 0.2;
                    vatNrText.setText(String.valueOf(vatNum));
                }
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
