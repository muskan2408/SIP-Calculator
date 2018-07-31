package com.gmail.muskankataria2408.financialcalculator;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class Compound extends AppCompatActivity {
 private DrawerLayout mDrawerLayout;
    Button calculate;
    EditText editamount,rate;
    double time=6,amount=1000,annualrate=8;
    SeekBar seekbar;
    TextView interest;
    double compoundinterest;
    double n=12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compound);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Compound Interest Calculator");
        //actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        calculate=(Button)findViewById(R.id.button);
        interest=(TextView)findViewById(R.id.finalvalue);
        rate=(EditText)findViewById(R.id.annualrate);
        editamount=(EditText)findViewById(R.id.amount);
        seekbar=(SeekBar)findViewById(R.id.sb);


        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                time=progress+1;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editamount.getText().toString()!=null&& rate.getText().toString()!=null){
                amount=Double.parseDouble(editamount.getText().toString());
                annualrate=Double.parseDouble(rate.getText().toString());
                if(annualrate>100)
                {

                    Toast.makeText(Compound.this,"Rate must be under hundred",Toast.LENGTH_SHORT).show();
                }
                else {
                    annualrate = annualrate / 100;
                    compoundinterest = (amount * Math.pow((1 + (annualrate / n)), (n * time))) - amount;
                    // interest.setText(String.valueOf(compoundinterest));
                    if(compoundinterest<1000){

                        interest.setText("" + String.format("%.2f", compoundinterest) + " Rs.");

                    }
                    if (compoundinterest > 1000 && compoundinterest < 100000) {
                        compoundinterest = compoundinterest / 1000;
                        interest.setText("" + String.format("%.2f", compoundinterest) + " thou.");
                    }
                    if (compoundinterest > 100000 && compoundinterest < 10000000) {
                        compoundinterest = compoundinterest / 100000;
                        interest.setText("" + String.format("%.2f", compoundinterest) + " Lac");
                    }
                    if (compoundinterest > 10000000) {
                        compoundinterest = compoundinterest / 10000000;
                        interest.setText("" + String.format("%.2f", compoundinterest) + " Cr.");
                    }
                }
            }}
        });


        NavigationView navigationView = findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(
//                new NavigationView.OnNavigationItemSelectedListener() {
//                    @Override
//                    public boolean onNavigationItemSelected(MenuItem menuItem) {
//                        // set item as selected to persist highlight
//                        menuItem.setChecked(true);
//                        // close drawer when item is tapped
//                        mDrawerLayout.closeDrawers();
//
//                        // Add code here to update the UI based on the item selected
//                        // For example, swap UI fragments here
//
//                        return true;
//                    }
//                });
    }
}
