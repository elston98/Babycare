package com.wilson.elston.babycare;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link VaccinationFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link VaccinationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VaccinationFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    String username;
    ImageButton logout;
    String email;
   TextView name;
   TextView mail;
    String id;


    int myear;
    int mmonth;
    int mday;
    int notificationId=123;
    int mhour;
    int mminute;
    EditText et;
    EditText et3;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private String CHANNEL_ID="123";

    public VaccinationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment VaccinationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VaccinationFragment newInstance(String param1, String param2) {
        VaccinationFragment fragment = new VaccinationFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View v= inflater.inflate(R.layout.fragment_vaccination, container, false);


        setHasOptionsMenu(true);


        final EditText et=(EditText) v.findViewById(R.id.et);
        final EditText et3=(EditText) v.findViewById(R.id.et1);
        Button date=(Button)v.findViewById(R.id.date);
        Button time=(Button) v.findViewById(R.id.time);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c=Calendar.getInstance();

                myear = c.get(Calendar.YEAR);
                mmonth = c.get(Calendar.MONTH);
                mday = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog  =new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                        et.setText(i2+"-"+(i1+1)+"-"+i);
                        mday=i2;
                        mmonth=i1+1;
                        myear=i;
                    }
                },myear,mmonth,mday);
                datePickerDialog.show();
            }
        });

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final  Calendar c=Calendar.getInstance();

                mhour = c.get(Calendar.HOUR_OF_DAY);
                mminute = c.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog=new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        et3.setText(i+":"+i1);
                        mhour=i;
                        mminute=i1;

                    }
                },mhour,mminute,false);
                timePickerDialog.show();

            }
        });

        Button b3=(Button) v.findViewById(R.id.b3);
        b3.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View view) {

                                      Calendar myAlarmDate = Calendar.getInstance();
                                      myAlarmDate.setTimeInMillis(System.currentTimeMillis());
                                      myAlarmDate.set(myear, mmonth-1, mday, mhour, mminute, 0);
                                      AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);

                                      Intent intent = new Intent(getContext(), AlarmReceiver.class);
                                      intent.putExtra("MyMessage", "HERE I AM PASSING THEPERTICULAR MESSAGE WHICH SHOULD BE SHOW ON RECEIVER OF ALARM");
                                      PendingIntent pendingIntent = PendingIntent.getBroadcast(getContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                                      alarmManager.set(AlarmManager.RTC_WAKEUP, myAlarmDate.getTimeInMillis(), pendingIntent);
                                  }
                              });



        return v;

        }



   /* @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.vaccination, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.vaccination:
                Toast.makeText(getContext(),"This is the vaccination Fragment",Toast.LENGTH_LONG).show();
                break;
            default:
                break;

        }
        return  true;
    }*/


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
