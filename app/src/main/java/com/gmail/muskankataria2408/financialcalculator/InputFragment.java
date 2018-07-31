package com.gmail.muskankataria2408.financialcalculator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
* create an instance of this fragment.
 */
public class InputFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public Button next;
    public TextView help;
    public EditText edit;
    Button show;
    public static SeekBar seekbar;
    double time;
    double amount = 1000, duration = 12, rateofreturn = 13, futurevale;
    String amt = "1000";
    private ImageView imageView;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;

    String edittext;

    public InputFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment InputFragment.
     */
    // TODO: Rename and change types and number of parameters
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input, container, false);
        next = (Button) view.findViewById(R.id.btn_next);
//        help = (TextView) view.findViewById(R.id.help);
        imageView = (ImageView) view.findViewById(R.id.image_help);
        edit = (EditText) view.findViewById(R.id.edittext);
        seekbar = (SeekBar) view.findViewById(R.id.sb);

//        show=(Button)view.findViewById(R.id.calculate);
//        show.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.v("errwwwwwwwwwwwwwwwwww",amt);
//
//            }
//        });
        if (amt != null) {


            amount = Double.parseDouble(amt);
            duration = change();

            if (amount < 500) {
                Toast.makeText(getActivity(), "SIP must be greater then 500", Toast.LENGTH_SHORT).show();
            } else {
                if (amount > 500) {

                    rateofreturn = rateofreturn / 100;
                    rateofreturn = rateofreturn / duration;
                    futurevale = amount * ((1 + rateofreturn) * (duration - 1)) * (1 + rateofreturn) / rateofreturn;

                    if (futurevale > 1000 && futurevale < 100000) {
                        futurevale = futurevale / 1000;
//                        returnview.setText("" + String.format("%.2f", futurevale) + " thou.");
//                        total.setText("" + String.format("%.2f", totalinvest * time) + " thou.");
                    }
                    if (futurevale > 100000 && futurevale < 10000000) {
                        futurevale = futurevale / 100000;
//                        returnview.setText("" + String.format("%.2f", futurevale) + " Lac");
//                        total.setText("" + String.format("%.2f", totalinvest * time) + " Lac");
                    }
                    if (futurevale > 10000000) {
                        futurevale = futurevale / 10000000;
//                        returnview.setText("" + String.format("%.2f", futurevale) + "Cr.");
//                        total.setText("" + String.format("%.2f", totalinvest * time) + " Lac");
                    }


           next.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   amt = edit.getText().toString();
                   duration = change();
                   Log.v("dccccccccc",amt);
                   if(duration==0) {
                       mListener.next(amt, 12);
                   }
               else
                   {
                       mListener.next(amt, duration);
                   }}
           });

        }
            }
        }
        return view;
    }

        @Override
        public void onAttach (Activity activity){
            super.onAttach(activity);
            try {
                mListener = (OnFragmentInteractionListener) activity;
            } catch (ClassCastException e) {
                throw new ClassCastException(activity.toString()
                        + " must implement OnFragmentInteractionListener");
            }
        }

        @Override
        public void onDetach () {
            super.onDetach();
            mListener = null;
        }

        public double change ()
        {
            seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    // sipTenure.setText(String.valueOf(progress));
                    switch (progress) {
                        case 0:
                            time = 1;
                            break;
                        case 1:
                            time = 3;
                            break;
                        case 2:
                            time = 6;
                            break;
                        case 3:
                            time = 12;
                            break;
                        case 4:
                            time = 24;
                            break;
                        case 5:
                            time = 36;
                            break;
                        case 6:
                            time = 60;
                            break;
                            default:
                                time=12;
                                break;
                    }

                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }

            });
            return time;
        }

        }

        // TODO: Rename method, update argument and hook method into UI event

