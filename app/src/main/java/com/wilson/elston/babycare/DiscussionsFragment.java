package com.wilson.elston.babycare;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.chip.ChipGroup;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.concurrent.ConcurrentHashMap;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DiscussionsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DiscussionsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DiscussionsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    DatabaseReference data;
    EditText input;
    private OnFragmentInteractionListener mListener;
    DatabaseReference databaseReference;

    private FirebaseListAdapter<ChatMessage> adapter;

   ProgressBar pb2;


    ListView listOfMessages;
    TextView messageText;
    TextView messageUser;
    TextView messageTime;
    FloatingActionButton fab;
    public DiscussionsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DiscussionsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DiscussionsFragment newInstance(String param1, String param2) {
        DiscussionsFragment fragment = new DiscussionsFragment();
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
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v= inflater.inflate(R.layout.fragment_discussions, container, false);

        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN | WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);


        fab =v.findViewById(R.id.fab);
        pb2=v.findViewById(R.id.pb2);

        databaseReference=FirebaseDatabase.getInstance().getReference().child("message");


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input = v.findViewById(R.id.input);

                String text=input.getText().toString();
                if(text.equals("")|| text.length()==0) //to make sure the user doesn't enter empty text
                {
                    Toast.makeText(getContext(),"Enter the text",Toast.LENGTH_LONG).show();
                }
                else
                {

                    FirebaseDatabase.getInstance()
                            .getReference()
                            .child("message")
                            .push()
                            .setValue(new ChatMessage(input.getText().toString(),
                                    FirebaseAuth.getInstance()
                                            .getCurrentUser()
                                            .getDisplayName())
                            ); //add the message to the database with the user name and the message


                    // Clear the input
                    input.setText(""); //to empty the textbox after the user has  sent the message.

                }


            }
        });

        listOfMessages=v.findViewById(R.id.list_of_messages);




        pb2.setVisibility(View.VISIBLE);
        displaychatmessages();


        return v;
    }

    private void displaychatmessages()
    {

        adapter = new FirebaseListAdapter<ChatMessage>(getActivity(), ChatMessage.class,
                R.layout.messages, FirebaseDatabase.getInstance().getReference().child("message")) {


            @Override

            protected void populateView(View v, ChatMessage model, int position) {
                pb2.setVisibility(View.INVISIBLE);

                // Get references to the views of message.xml
                 messageText = v.findViewById(R.id.message_text);
                messageUser = v.findViewById(R.id.message_user);
                 messageTime =v.findViewById(R.id.message_time);

                // Set their text
                messageText.setText(model.getMessageText());
                messageUser.setText(model.getMessageUser());

                // Format the date before showing it
                messageTime.setText(DateFormat.format("dd-MM-yyyy (HH:mm:ss)",
                        model.getMessageTime()));
            }

        };
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                pb2.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        listOfMessages.setAdapter(adapter);

        listOfMessages.smoothScrollToPosition(adapter.getCount()-1);
        listOfMessages.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);




    } //to display the messages in list view format to the user with the message,username and the time

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
