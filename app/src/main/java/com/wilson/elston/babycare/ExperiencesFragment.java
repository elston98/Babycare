package com.wilson.elston.babycare;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ExperiencesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ExperiencesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExperiencesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ProgressBar pb3;
    ImageButton storage;
    String link;
   private StorageReference sref;
    String  id= FirebaseAuth.getInstance().getCurrentUser().getUid();
    private  static final  int GALLERY=2;
    private ProgressDialog dialog;
    private OnFragmentInteractionListener mListener;
    ImageView ib;

    private RecyclerView mRecyclerView;
    private ImageAdapter mAdapter;

    private DatabaseReference mDatabaseRef;
    private List<Upload> mUploads;
    private StorageTask mUploadTask;



    public ExperiencesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ExperiencesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ExperiencesFragment newInstance(String param1, String param2) {
        ExperiencesFragment fragment = new ExperiencesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    Button logout;
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
        View v=inflater.inflate(R.layout.fragment_photo_diary, container, false);


       sref= FirebaseStorage.getInstance().getReference();
        setHasOptionsMenu(true);
        dialog=new ProgressDialog(getActivity());
        dialog.setCanceledOnTouchOutside(false);
        pb3=v.findViewById(R.id.pb3);
       // ib=v.findViewById(R.id.is);


        setHasOptionsMenu(true);


        mRecyclerView=v.findViewById(R.id.recycler_view);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mUploads=new ArrayList<>();
        mDatabaseRef= FirebaseDatabase.getInstance().getReference().child("Photos").child(""+id);


        pb3.setVisibility(View.VISIBLE);
        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                mUploads.clear();
                for (DataSnapshot postsnapshot: dataSnapshot.getChildren())
                {
                    Upload upload=postsnapshot.getValue(Upload.class);
                    mUploads.add(upload);
                    mAdapter=new ImageAdapter(getContext(),mUploads);
                    mRecyclerView.setAdapter(mAdapter);
                   pb3.setVisibility(View.INVISIBLE);

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(getContext(),databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });





        return v;
    }




    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.menu, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.photo_upload:
                Intent intent=new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, GALLERY);


        }
        return  true;
    }

    public void onActivityResult(int requestcode, int resultcode, Intent data)
    {
        super.onActivityResult(requestcode,resultcode,data);
        if(requestcode==GALLERY && resultcode==RESULT_OK)
        {
            dialog.setMessage("Uploading");
            dialog.show();



            final Uri uri=data.getData();



            final StorageReference child=sref.child("Photos").child(id).child(uri.getLastPathSegment());

            child.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot)
                {

                    child.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                               Upload upload=new Upload(uri.toString());
                               FirebaseDatabase.getInstance().getReference().child("Photos").child(id).push().setValue(upload);
                               dialog.dismiss();

                        }
                    });



                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getActivity(),"Failed",Toast.LENGTH_LONG).show();
                    dialog.dismiss();
                }
            });
        }


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
