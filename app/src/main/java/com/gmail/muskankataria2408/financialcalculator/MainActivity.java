package com.gmail.muskankataria2408.financialcalculator;

import android.app.FragmentManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import static com.gmail.muskankataria2408.financialcalculator.R.*;
import static com.gmail.muskankataria2408.financialcalculator.R.id.barrier;
import static com.gmail.muskankataria2408.financialcalculator.R.id.drawer_layout;

public class MainActivity extends AppCompatActivity implements OnFragmentInteractionListener{
    private DrawerLayout mDrawerLayout;
    Button b,calculate;
    EditText monthly,yearly,rate,edit;
    TextView sipTenure,sipmonthly,returnview,total;
    SeekBar seekBar;
    double amount=1000;
    double rateofreturn=13, futurevale,totalinvest,duration=12;
    double time=12;
    double invest;
    boolean check=true;
    private OnFragmentInteractionListener mListener;
    InputFragment obj;
String amt="1000";

    int t;
    ViewPager viewPager;
    public static SeekBar seekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
//          if(savedInstanceState==null)
//          {
//              getSupportFragmentManager().beginTransaction().add(R.id.drawer_layout,new InputFragment()).commit();
//          }


       viewPager = (ViewPager) findViewById(id.viewpage);

        // Create an adapter that knows which fragment should be shown on each page
        CategoryAdapter adapter = new CategoryAdapter(this,getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);



        // Find the tab layout that shows the tabs
        final TabLayout tabLayout = (TabLayout) findViewById(id.tabs);

        // Connect the tab layout with the view pager. This will
        //   1. Update the tab layout when the view pager is swiped
        //   2. Update the view pager when a tab is selected
        //   3. Set the tab layout's tab names with the view pager's adapter's titles
        //      by calling onPageTitle()
      tabLayout.setupWithViewPager(viewPager);

        Toolbar toolbar = findViewById(id.toolbar);
        setSupportActionBar(toolbar);
       // sipmonthly=(TextView)findViewById(R.id.textView4);
         final ActionBar actionbar = getSupportActionBar();
//         actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        actionbar.setDisplayHomeAsUpEnabled(true);
       actionbar.setHomeAsUpIndicator(drawable.ic_menu);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
//             tabLayout.setSelectedNavigationItem(position);
//
//                android.support.v4.app.Fragment fragment = ((CategoryAdapter)viewPager.getAdapter()).getFragment(position);

//                if (position ==1 && fragment != null)
//                {
                  // fragment.onResume();
//                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
//        calculate=(Button)findViewById(R.id.button);
      // edit=(EditText)findViewById(R.id.edit);
//        rate=(EditText)findViewById(R.id.editText2);
       seekBar=(SeekBar)findViewById(id.sb);
        total=(TextView)findViewById(id.total);
        returnview=(TextView)findViewById(id.returnView);
        edit=(EditText)findViewById(id.edittext);
//        amt = edit.getText().toString();


//        amount=Double.parseDouble(edit.getText().toString());
//        totalinvest=Double.parseDouble(total.getText().toString());
//        if((edit.getText().toString())!=null) {
//            rateofreturn=13;
//            if (amount < 500) {
//                Toast.makeText(MainActivity.this, "SIP must be greater then 500", Toast.LENGTH_SHORT).show();
//            } else {
//                if (amount > 500) {
//
//                    rateofreturn=rateofreturn/100;
//                    rateofreturn=rateofreturn/time;
//                    futurevale=amount*((1+rateofreturn)*(time-1))*(1+rateofreturn)/rateofreturn;
//                    if(futurevale>1000 && futurevale<100000)
//                    {
//                        futurevale=futurevale/1000;
//                        returnview.setText(""+  String.format("%.2f",futurevale)+" thou." );
//                        total.setText(""+String.format("%.2f",totalinvest*time)+" thou.");
//                    }
//                    if(futurevale>100000 && futurevale<10000000)
//                    {
//                        futurevale=futurevale/1000;
//                        returnview.setText(""+  String.format("%.2f",futurevale)+" Lac" );
//                        total.setText(""+String.format("%.2f",totalinvest*time)+" Lac");
//                    }
//                    if(futurevale>10000000 )
//                    {
//                        futurevale=futurevale/1000;
//                        returnview.setText(""+  String.format("%.2f",futurevale)+"Cr." );
//                        total.setText(""+String.format("%.2f",totalinvest*time)+" Lac");
//                    }
//
//
//                } else {
//                    Toast.makeText(MainActivity.this, "Enter values in both fields", Toast.LENGTH_SHORT).show();
//
//                }
//
//            }
//        }

//      seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//           @Override
//           public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//              // sipTenure.setText(String.valueOf(progress));
//               switch (progress)
//               {
//                   case 0:
//                       time=1;
//                       break;
//                   case 1:
//                       time=3;
//                       break;
//                   case 2:
//                       time=6;
//                       break;
//                   case 3:
//                       t=12;
//                       break;
//                   case 4:
//                       t=24;
//                       break;
//                   case 5:
//                       t=36;
//                       break;
//                   case 6:
//                       t=60;
//                       break;
//               }
//
//           }
//           @Override
//           public void onStartTrackingTouch(SeekBar seekBar) {
//
//           }
//
//           @Override
//           public void onStopTrackingTouch(SeekBar seekBar) {
//
//           }
//       });
//       if(check==true) {
//           aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//               @Override
//               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                   sipmonthly.setText("LumpSum Amount");
//                   check = false;
//               }
//           });
//       }
//       else
//       {
//           aSwitch.setOnCheckedChangeListener(null);
//           aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//               @Override
//               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                   sipmonthly.setText("Monthly SIP Amount");
//                   check = true;
//               }
//           });
//       }
//       // aSwitch.setOnCheckedChangeListener(null);
//        calculate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                amount=Double.parseDouble(monthly.getText().toString());
//                if((monthly.getText().toString())!=null) {
//                    rateofreturn=Double.parseDouble(rate.getText().toString());
//                    time=Double.parseDouble(sipTenure.getText().toString());
//                    if (amount < 500) {
//                        Toast.makeText(MainActivity.this, "SIP must be greater then 500", Toast.LENGTH_SHORT).show();
//                    } else {
//                        if (amount > 500) {
//
//
//                            rateofreturn=rateofreturn/100;
//                            rateofreturn=rateofreturn/time;
//                            futurevale=amount*((1+rateofreturn)*(time-1))*(1+rateofreturn)/rateofreturn;
//                            if(futurevale>1000 && futurevale<100000)
//                            {
//                                futurevale=futurevale/1000;
//                                returnview.setText("SIP return Amount: "+  String.format("%.2f",futurevale)+"thou." );
//                            }
//                            if(futurevale>100000 && futurevale<10000000)
//                            {
//                                futurevale=futurevale/1000;
//                                returnview.setText("SIP return Amount: "+  String.format("%.2f",futurevale)+"Lac" );
//                            }
//                            if(futurevale>10000000 )
//                            {
//                                futurevale=futurevale/1000;
//                                returnview.setText("SIP return Amount: "+  String.format("%.2f",futurevale)+"Cr." );
//                            }
//
//
//                        } else {
//                            Toast.makeText(MainActivity.this, "Enter values in both fields", Toast.LENGTH_SHORT).show();
//
//                        }
//                    }
//
//
//                }
//
//
//            }
//        });
//

        mDrawerLayout = findViewById(drawer_layout);
        mDrawerLayout.addDrawerListener(
                new DrawerLayout.DrawerListener() {
                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {
                        // Respond when the drawer's position changes
                    }

                    @Override
                    public void onDrawerOpened(View drawerView) {
                        // Respond when the drawer is opened
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                        // Respond when the drawer is closed
                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {
                        // Respond when the drawer motion state changes
                    }
                }
        );
        NavigationView navigationView = findViewById(id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        switch (menuItem.getItemId()) {
                            case id.nav_simple:
                                Intent i=new Intent(MainActivity.this,Simple.class);
                                startActivity(i);
                                break;
                            case id.nav_spi:
                                Intent a=new Intent(MainActivity.this,MainActivity.class);
                                startActivity(a);
                                break;
                            case id.nav_compound:
                                Intent s=new Intent(MainActivity.this,Compound.class);
                                startActivity(s);
                                break;
//                            case R.id.nav_loan:
//                                Intent d=new Intent(MainActivity.this,Loan.class);
//                                startActivity(d);
//                                break;


                            case id.nav_learn:
                                PrefManager prefManager = new PrefManager(getApplicationContext());
                                // make first time launch TRUE
                                prefManager.setFirstTimeLaunch(true);
                                startActivity(new Intent(MainActivity.this, WelcomeActivity.class));
                                finish();
                                break;
//                            case R.id.nav_income:
//                                Intent f=new Intent(MainActivity.this,IncomeTax.class);
//                                startActivity(f);
//                                break;
                            case id.nav_share:
                                Intent sendIntent = new Intent();
                                sendIntent.setAction(Intent.ACTION_SEND);
                                sendIntent.putExtra(Intent.EXTRA_TEXT, "http://play.google.com/store/apps/details?id=com.gmail.muskankataria2408.financialcalculator");
                                sendIntent.setType("text/plain");
                                startActivity(sendIntent);
                                break;
                            case id.nav_rate:
                                final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
                                try {
                                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                                } catch (android.content.ActivityNotFoundException anfe) {
                                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                                }
                        }
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here


                        return true;
                    }
                });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
            case id.nav_simple:
                Intent i=new Intent(MainActivity.this,Simple.class);
                startActivity(i);
                break;
            case id.nav_spi:
                Intent a=new Intent(MainActivity.this,MainActivity.class);
                startActivity(a);
                break;
            case id.nav_compound:
                Intent s=new Intent(MainActivity.this,Compound.class);
                startActivity(s);
                break;
//            case R.id.nav_loan:
//                Intent d=new Intent(MainActivity.this,Loan.class);
//                startActivity(d);
//                break;
            case id.nav_learn:
            PrefManager prefManager = new PrefManager(getApplicationContext());
            // make first time launch TRUE
            prefManager.setFirstTimeLaunch(true);
            startActivity(new Intent(MainActivity.this, WelcomeActivity.class));
            finish();
            break;
//            case R.id.nav_income:
//                Intent f=new Intent(MainActivity.this,IncomeTax.class);
//                startActivity(f);
//                break;
            case id.nav_share:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "http://play.google.com/store/apps/details?id=com.gmail.muskankataria2408.financialcalculator");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
                break;
            case id.nav_rate:
                final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                } catch (android.content.ActivityNotFoundException anfe) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                }
        }
        return super.onOptionsItemSelected(item);

    }
    public void help(View view)
    {
                PrefManager prefManager = new PrefManager(getApplicationContext());
                // make first time launch TRUE
                prefManager.setFirstTimeLaunch(true);
                startActivity(new Intent(MainActivity.this, WelcomeActivity.class));
                finish();
    }


//    public void previous_fragment(int i,boolean t) {
//        viewPager.setCurrentItem(viewPager.getCurrentItem()-1);
//    }
//    public void setCurrentItem (int item, boolean smoothScroll) {
//        viewPager.setCurrentItem(item, smoothScroll);
//    }

    public void next_fragment(View view) {
//        time=change();
//        Log.v("InputFragment",String.valueOf(time));
//        FragmentTransaction transection=getFragmentManager().beginTransaction();
//        RateFragment ldf = new RateFragment ();
//        Bundle args = new Bundle();
//        // Bundle args1=new Bundle();
//        args.putDouble("Time",time);
//        args.putDouble("Edittext",amount );
//        ldf.setArguments(args);
//     //   transection.replace(R.id.rate, ldf);
////        transection.commit();
//
        viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
    }
    public void prev_fragment(View view) {
        viewPager.setCurrentItem(viewPager.getCurrentItem()-1);
    }


    @Override
    public double changeFragment(int id,String amt){

       if (id == 2) {

       try {
           if (amt != "") {
               invest = Double.parseDouble(amt);
               rateofreturn = 13;
               totalinvest = invest * time;

               if (invest < 500) {
                   Toast.makeText(MainActivity.this, "SIP must be greater then 500", Toast.LENGTH_SHORT).show();
               } else {
                   if (invest > 500) {

                       rateofreturn = rateofreturn / 100;
                       rateofreturn = rateofreturn / time;
                       futurevale = invest * ((1 + rateofreturn) * (time - 1)) * (1 + rateofreturn) / rateofreturn;
                       if (futurevale > 1000 && futurevale < 100000) {
                           futurevale = futurevale / 1000;
                           returnview.setText("" + String.format("%.2f", futurevale) + " thou.");
                           total.setText("" + String.format("%.2f", totalinvest * time) + " thou.");
                       }
                       if (futurevale > 100000 && futurevale < 10000000) {
                           futurevale = futurevale / 100000;
                           returnview.setText("" + String.format("%.2f", futurevale) + " Lac");
                           total.setText("" + String.format("%.2f", totalinvest * time) + " Lac");
                       }
                       if (futurevale > 10000000) {
                           futurevale = futurevale / 10000000;
                           returnview.setText("" + String.format("%.2f", futurevale) + " Cr.");
                           total.setText("" + String.format("%.2f", totalinvest * time) + " Cr.");
                       }


                   } else {
                       Toast.makeText(MainActivity.this, "Enter values in both fields", Toast.LENGTH_SHORT).show();

                       }
                   }
               }}
           catch (NumberFormatException e)
           {
               Log.v("numberformat","efffasssssshhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
           }


               viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
           }


    return futurevale;
    }

    @Override
    public void getFromUser(String edit) {


          Log.v("helloooooooooo","dsssssssssssssssssssssssssssssssssssss");

    }
    public void getFromUser(View view)
    {
//        obj=(InputFragment)getSupportFragmentManager().findFragmentById(R.id.input);
////        if (mListener != null) {
////            EditText edit = (EditText)findViewById(R.id.edit1);
////            mListener.getFromUser(edit.getText().toString());
////
////
////        }
//
//        String amountinvest=obj.edit.getText().toString();
//        Log.v("Helllllllll",amountinvest);

        viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
    }

    public void next(String amt,double duration) {

        this.amt=amt;
         this.duration=duration;
         Log.v("dfaagurrrrrrrrr",String.valueOf(duration));
        //seekbar = (SeekBar) view.findViewById(R.id.sb);
         Log.v("gbbbbbbbbbbb",amt);
        if(amt != null) {
//
            amount = Double.parseDouble(amt);
            //amount = 1000;

            Log.v("efssssssssssssssss",String.valueOf(amount));
            if (amount < 500) {
                Toast.makeText(MainActivity.this, "SIP must be greater then 500", Toast.LENGTH_SHORT).show();
            } else {
                if (amount > 500) {
                    Log.v("efstttttttttttt",String.valueOf(amount));


                    rateofreturn=0.13;
                   // Log.v("rate of return",String.valueOf(rateofreturn));
                    futurevale=amount*((Math.pow((1+(0.0183)),duration)-1)/0.0183);
                    //futurevale=1000*((Math.pow(1.0183,12)-1)/0.0183);
//bs abb future value ko display karwao ek barrierok ruko  tumne return mai amount ihnnnvested ko




                    // futurevale =( amount * (((1 + rateofreturn) * (duration - 1))/ rateofreturn)) * (1 + rateofreturn) ;
                    Log.v("dnfssffs", String.valueOf(futurevale));
                    double rateOfFd=0.0675;

                   // double fdamount = ((amount) * (Math.pow((1 + (rateOfFd / 12), (12 * duration)))-1);//yaha se formula galat hai ok(amount);
                       double fdamount=amount*((Math.pow((1+(0.0675/12)),duration)-1)/(0.0675/12));
//
//  RateFragment rateFragment=(RateFragment) getSupportFragmentManager().findFragmentById(R.id.rate);
                    //is it ok??
//                 rateFragment.getValue(5666666,120000);
                    android.support.v4.app.FragmentManager fm=getSupportFragmentManager();
                   Fragment fragment=new RateFragment();
                    RateFragment rateFragment=new RateFragment();
                    Fragment fragment1=new SIPVsFDFragment();
                    android.support.v4.app.FragmentManager fm1=getSupportFragmentManager();

                    // r.getValue(futurevale,amount*duration);
//                        ((RateFragment) getSupportFragmentManager().findFragmentById(R.id.rate)).getValue(futurevale,(amount*duration));
                    Bundle bundle=new Bundle();
                    bundle.putDouble("futurevalue", futurevale);
                    bundle.putDouble("amount",amount*duration);
                    bundle.putDouble("FdAmount",fdamount);
                    //set Fragmentclass Arguments
                    fragment.setArguments(bundle);
                    fm.beginTransaction().replace(id.ratelayout, fragment,fragment.getTag()).commit();
                    fragment1.setArguments(bundle);
                    fm1.beginTransaction().replace(id.sipVsfd, fragment1,fragment1.getTag()).commit();
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);

                }


            }


        }

    }
//    public double change ()
//    {
//        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                // sipTenure.setText(String.valueOf(progress));
//                switch (progress) {
//                    case 0:
//                        time = 1;
//                        break;
//                    case 1:
//                        time = 3;
//                        break;
//                    case 2:
//                        time = 6;
//                        break;
//                    case 3:
//                        time = 12;
//                        break;
//                    case 4:
//                        time = 24;
//                        break;
//                    case 5:
//                        time = 36;
//                        break;
//                    case 6:
//                        time = 60;
//                        break;
//                }
//
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//            }
//
//        });
//        return time;
//    }
}
