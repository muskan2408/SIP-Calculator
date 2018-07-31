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

public class Simple extends AppCompatActivity {
  private DrawerLayout mDrawerLayout;
  Button calculate;
  EditText editamount,rate;
    double time=6,amount=1000,annualrate=8;
  SeekBar seekbar;
  TextView interest;
  double simpleinterest;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Simple Interest Calculator");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);
        NavigationView navigationView = findViewById(R.id.nav_view);
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
                if(editamount.getText().toString()!=null&&rate.getText().toString()!=null){
                  amount=Double.parseDouble(editamount.getText().toString());
                  annualrate=Double.parseDouble(rate.getText().toString());
                if(annualrate>100)
                {

                    Toast.makeText(Simple.this,"Rate must be under hundred",Toast.LENGTH_SHORT).show();
                }
                else{
                  simpleinterest=amount*annualrate*time/100;
                  interest.setText(String.valueOf(simpleinterest));
                    if(simpleinterest<1000){

                        interest.setText("" + String.format("%.2f", simpleinterest) + " Rs.");

                    }
                if(simpleinterest>1000 && simpleinterest<100000)
                {
                    simpleinterest=simpleinterest/1000;
                    interest.setText(""+  String.format("%.2f",simpleinterest)+" thou." );
                        }
                if(simpleinterest>100000 && simpleinterest<10000000)
                {
                    simpleinterest=simpleinterest/100000;
                    interest.setText(""+  String.format("%.2f",simpleinterest)+" Lac" );
                }
                if(simpleinterest>10000000 )
                {
                    simpleinterest=simpleinterest/10000000;
                    interest.setText(""+  String.format("%.2f",simpleinterest)+" Cr." );
                }

            }}}
        });

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
