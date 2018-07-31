package com.gmail.muskankataria2408.financialcalculator;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
    eate an instance of this fragment.
 */
public class RateFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    TextView totalamount,returnview;
    double d;
   double amount=1000,time, futurevalue=1655847;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Button calculate;


    public RateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)

    {
      View view=  inflater.inflate(R.layout.fragment_rate, container, false);
      totalamount=(TextView)view.findViewById(R.id.total);
      final String totalinvest=totalamount.getText().toString();
   //  calculate=(Button)view.findViewById(R.id.calculate);
      returnview=(TextView)view.findViewById(R.id.returnView);
          returnview.setVisibility(View.GONE);
          totalamount.setVisibility(View.GONE);


          Bundle bundle=getArguments();
        if (bundle != null) {
            futurevalue = bundle.getDouble("futurevalue");
            amount=bundle.getDouble("amount");


        if(futurevalue<1000)
        {
            returnview.setText("" + String.format("%.2f", futurevalue) + " Rs.");
            returnview.setVisibility(View.VISIBLE);

        }
        if (futurevalue > 1000 && futurevalue < 100000) {
            futurevalue = futurevalue / 1000;
            returnview.setText("" + String.format("%.2f", futurevalue) + " thou.");
            returnview.setVisibility(View.VISIBLE);
        }
        if (futurevalue > 100000 && futurevalue < 10000000) {
            futurevalue = futurevalue / 100000;
            returnview.setText("" + String.format("%.2f", futurevalue) + " Lac");
            returnview.setVisibility(View.VISIBLE);
        }
        if (futurevalue > 10000000) {
            futurevalue = futurevalue / 10000000;
            returnview.setText("" + String.format("%.2f", futurevalue) + " Cr.");
            returnview.setVisibility(View.VISIBLE);
        }


            if(amount<1000)
            {
                totalamount .setText("" + String.format("%.2f", amount) + " Rs.");
                totalamount.setVisibility(View.VISIBLE);

            }
            if (amount > 1000 && amount < 100000) {
                amount = amount / 1000;
                totalamount.setText("" + String.format("%.2f", amount ) + " thou.");
                totalamount.setVisibility(View.VISIBLE);
            }
            if (amount > 100000 && amount < 10000000) {
                amount = amount / 100000;
                totalamount.setText("" + String.format("%.2f", amount ) + " Lac");
                totalamount.setVisibility(View.VISIBLE);
            }
            if (amount > 10000000) {
                amount = amount / 10000000;
                totalamount.setText("" + String.format("%.2f", amount) + " Cr.");
                totalamount.setVisibility(View.VISIBLE);
            }
        }


//         Bundle b= getArguments();
//         if(b!=null){
//
//
//             futurevalue = b.getDouble("futurevalue");
//             amount = b.getDouble("amount");
//             getValue(futurevalue,amount);
//             if (futurevalue < 1000) {
//                 returnview.setText("" + String.format("%.2f", futurevalue) + " Rs.");
//                 totalamount.setText("" + String.format("%.2f", amount) + " Rs.");
//
//             }
//             if (futurevalue > 1000 && futurevalue < 100000) {
//                 futurevalue = futurevalue / 1000;
//                 returnview.setText("" + String.format("%.2f", futurevalue) + " thou.");
//                 totalamount.setText("" + String.format("%.2f", amount) + " thou.");
//             }
//             if (futurevalue > 100000 && futurevalue < 10000000) {
//                 futurevalue = futurevalue / 100000;
//                 returnview.setText("" + String.format("%.2f", futurevalue) + " Lac");
//                 totalamount.setText("" + String.format("%.2f", amount) + " Lac");
//             }
//             if (futurevalue > 10000000) {
//                 futurevalue = futurevalue / 10000000;
//                 returnview.setText("" + String.format("%.2f", futurevalue) + "Cr.");
//                 totalamount.setText("" + String.format("%.2f", amount) + " Lac");
//             }
//
//
        return view;
    }

    private void readBundle(Bundle bundle) {

    }


    public void getValue(double futurevalue, double total)
    {
        this.futurevalue=futurevalue;
        amount=total;
        Log.v("dsssfsefseres",String.valueOf(futurevalue));
        Log.v("rrrrrrrrrrrrrr",String.valueOf(amount));
        if(futurevalue<1000)
        {
            returnview.setText("" + String.format("%.2f", futurevalue) + " Rs.");
            totalamount .setText("" + String.format("%.2f", amount) + " Rs.");
            returnview.setVisibility(View.VISIBLE);
            totalamount.setVisibility(View.VISIBLE);

        }
        if (futurevalue > 1000 && futurevalue < 100000) {
            futurevalue = futurevalue / 1000;
            returnview.setText("" + String.format("%.2f", futurevalue) + " thou.");
            totalamount.setText("" + String.format("%.2f", amount ) + " thou.");
            returnview.setVisibility(View.VISIBLE);
            totalamount.setVisibility(View.VISIBLE);
        }
        if (futurevalue > 100000 && futurevalue < 10000000) {
            futurevalue = futurevalue / 100000;
            returnview.setText("" + String.format("%.2f", futurevalue) + " Lac");
            totalamount.setText("" + String.format("%.2f", amount ) + " Lac");
            returnview.setVisibility(View.VISIBLE);
            totalamount.setVisibility(View.VISIBLE);
        }
        if (futurevalue > 10000000) {
            futurevalue = futurevalue / 10000000;
            returnview.setText("" + String.format("%.2f", futurevalue) + " Cr.");
            totalamount.setText("" + String.format("%.2f", amount) + " Cr.");
            returnview.setVisibility(View.VISIBLE);
            totalamount.setVisibility(View.VISIBLE);
        }
    }
    // TODO: Rename method, update argument and hook method into UI event
    @Override
    public void onResume() {
        super.onResume();


    }



}
