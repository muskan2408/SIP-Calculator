package com.gmail.muskankataria2408.financialcalculator;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the

 * create an instance of this fragment.
 */
public class SIPVsFDFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
        TextView sipAmount, FDAmount;
        double sipamount,fdamount;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

  //  private OnFragmentInteractionListener mListener;

    public SIPVsFDFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_sipvs_fd, container, false);
        sipAmount=(TextView)view.findViewById(R.id.sipAmount);
        FDAmount=(TextView)view.findViewById(R.id.fdamount);
//      sipAmount.setVisibility(View.GONE);
//       FDAmount.setVisibility(View.GONE);
//

        Bundle bundle=getArguments();
        if (bundle != null) {
          sipamount = bundle.getDouble("futurevalue");
            fdamount=bundle.getDouble("FdAmount");


            if(sipamount<1000)
            {
                sipAmount.setText("" + String.format("%.2f", sipamount) + " Rs.");
                sipAmount.setVisibility(View.VISIBLE);

            }
            if (sipamount > 1000 && sipamount < 100000) {
                sipamount = sipamount / 1000;
                sipAmount.setText("" + String.format("%.2f", sipamount) + " thou.");
                sipAmount.setVisibility(View.VISIBLE);
            }
            if (sipamount > 100000 && sipamount < 10000000) {
                sipamount = sipamount / 100000;
                sipAmount.setText("" + String.format("%.2f", sipamount) + " Lac");
                sipAmount.setVisibility(View.VISIBLE);
            }
            if (sipamount > 10000000) {
                sipamount = sipamount / 10000000;
                sipAmount.setText("" + String.format("%.2f", sipamount) + " Cr.");
                sipAmount.setVisibility(View.VISIBLE);
            }


            if(fdamount<1000)
            {
                FDAmount.setText("" + String.format("%.2f", fdamount) + " Rs.");
                FDAmount.setVisibility(View.VISIBLE);

            }
            if (fdamount > 1000 && fdamount < 100000) {
                fdamount = fdamount / 1000;
                FDAmount.setText("" + String.format("%.2f", fdamount ) + " thou.");
                FDAmount.setVisibility(View.VISIBLE);
            }
            if (fdamount > 100000 && fdamount < 10000000) {
                fdamount = fdamount / 100000;
                FDAmount.setText("" + String.format("%.2f", fdamount ) + " Lac");
                FDAmount.setVisibility(View.VISIBLE);
            }
            if (fdamount > 10000000) {
                fdamount = fdamount / 10000000;
                FDAmount.setText("" + String.format("%.2f", fdamount) + " Cr.");
                FDAmount.setVisibility(View.VISIBLE);
            }
        }

        return view;

    }

    // TODO: Rename method, update argument and hook method into UI event

}
