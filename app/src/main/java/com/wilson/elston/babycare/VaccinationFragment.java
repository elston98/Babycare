package com.wilson.elston.babycare;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.jar.Attributes;


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
    FirebaseListAdapter adapter;


    int myear;
    int mmonth;
    int mday;
    TextView na;
    TextView date;
    int notificationId=123;
    ListView list;
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
        Button date=(Button)v.findViewById(R.id.et);
        id= FirebaseAuth.getInstance().getUid();
        Button time=(Button) v.findViewById(R.id.time);
        list=v.findViewById(R.id.list_of_vaccine);
        display_vaccine();



        return v;

        }

    private void display_vaccine() {

        adapter = new FirebaseListAdapter<Vaccine>(getActivity(), Vaccine.class,
                R.layout.vac_details, FirebaseDatabase.getInstance().getReference().child("Vaccination").child(id)) {
            @Override
            protected void populateView(View v, Vaccine model, int position) {
                na=v.findViewById(R.id.name);
                date=v.findViewById(R.id.date);
                na.setText(model.name);
                date.setText(model.date);

            }


        };

        list.setAdapter(adapter);


    }



    @Override
public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    menuInflater.inflate(R.menu.vaccination, menu);
    super.onCreateOptionsMenu(menu, menuInflater);
}
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.vaccination:
                Intent intent=new Intent(getContext(),Details.class);
                startActivity(intent);
                break;
            default:
                break;

        }
        return  true;
    }



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
