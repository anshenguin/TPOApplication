package com.example.tpoapplication;

import android.app.ActionBar;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Movie;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MCAFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private List<Companies> companiesList = new ArrayList<>();
    private List<Companies> itemsCopy = new ArrayList<>();
    private CompaniesAdapter mAdapter;
    private SearchView searchView;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public MCAFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_mca, container, false);
        RecyclerView mRecyclerView = rootView.findViewById(R.id.recycler_view);
        mAdapter = new CompaniesAdapter(companiesList,itemsCopy);
        prepareRecyclerView();
        android.support.v7.app.ActionBar actionBar = ((AppCompatActivity )getActivity()).getSupportActionBar();
        actionBar.setTitle("Home");
        Button regButton = rootView.findViewById(R.id.regbutton);
        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),WebViewActivity.class));
            }
        });
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);
        return rootView;
    }

    private void prepareRecyclerView(){
        Companies companies = new Companies("Wipro","21/02/2018","Venue: R-11 CORE BLOCK SECOND FLOOR","Eligibility: B.Tech in CSE (75% Min)",R.mipmap.ic_launcher);
        companiesList.add(companies);
//        companies = new Companies("Adobe","21/02/2018","Venue: K-2 KNOWLEDGE CENTRE SECOND FLOOR","Eligibility: B.Tech in CSE or IT (80% Min)");
//        companiesList.add(companies);
//        companies = new Companies("TATA Consultancy Service","21/02/2018","Venue: R-12 CORE BLOCK SECOND FLOOR","Eligibility: B.Tech (70% Min)");
//        companiesList.add(companies);
//        companies = new Companies("Google","21/02/2018","Venue: R-11 CORE BLOCK SECOND FLOOR","Eligibility: B.Tech in CSE or IT (85% Min)");
//        companiesList.add(companies);
//        companies = new Companies("Ford","22/02/2018","Venue: K-4 KNOWLEDGE CENTRE THIRD FLOOR","Eligibility: MBA (70% Min)");
//        companiesList.add(companies);
//        companies = new Companies("Maruti Suzuki","22/02/2018","Venue: R-12 CORE BLOCK SECOND FLOOR","Eligibility: B.Tech in Mech. (70% Min)");
//        companiesList.add(companies);
        itemsCopy.addAll(companiesList);
        mAdapter.notifyDataSetChanged();
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
//    @Override
//    public void onCreateOptionsMenu(Menu menu,MenuInflater inflater) {
//
//        inflater.inflate(R.menu.main,menu);
//        MenuItem item = menu.findItem(R.id.search);
//        Toast.makeText(getActivity(),"aaaaaaaa",Toast.LENGTH_SHORT).show();
//
//        searchView = (SearchView)item.getActionView();
//
//
//
//
//        super.onCreateOptionsMenu(menu,inflater);
//    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {

        MenuItem mSearchMenuItem = menu.findItem(R.id.search);
        searchView = (SearchView) mSearchMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                mAdapter.filter(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mAdapter.filter(newText);
                return true;
            }


        });
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
