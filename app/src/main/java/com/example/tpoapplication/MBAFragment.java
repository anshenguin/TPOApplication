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
public class MBAFragment extends Fragment {
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

    public MBAFragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_mba, container, false);
        RecyclerView mRecyclerView = rootView.findViewById(R.id.recycler_view);
        mAdapter = new CompaniesAdapter(companiesList,itemsCopy);
        prepareRecyclerView();
        android.support.v7.app.ActionBar actionBar = ((AppCompatActivity )getActivity()).getSupportActionBar();
        actionBar.setTitle("Home");
        Button regButton = rootView.findViewById(R.id.regbutton);
        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://davietjal.org/ggn/registration.php";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
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
        Companies companies = new Companies("HDFC","-","-","Eligibility: Graduation/MBA",R.drawable.hdfc);
        companiesList.add(companies);
        companies = new Companies("Angel Broking","-","-","Eligibility: Graduation/MBA",R.drawable.angel_broking);
        companiesList.add(companies);
        companies = new Companies("Tikona Digital","-","-","Eligibility: Graduation/MBA",R.drawable.tikona_digital);
        companiesList.add(companies);
        companies = new Companies("Videocon","-","-","Eligibility: Graduation/MBA",R.drawable.videocon);
        companiesList.add(companies);
        companies = new Companies("Maruti Suzuki","-","-","Eligibility: Graduation/MBA",R.drawable.maruti_suzuki);
        companiesList.add(companies);
        companies = new Companies("Airtel","-","-","Eligibility: Graduation/MBA",R.drawable.airtel);
        companiesList.add(companies);
        companies = new Companies("Policybazaar","-","-","Eligibility: Graduation/MBA",R.drawable.policy_bazaar);
        companiesList.add(companies);
        companies = new Companies("Tholons","-","-","Eligibility: Graduation/MBA",R.drawable.tholons);
        companiesList.add(companies);
        companies = new Companies("Collabera","-","-","Eligibility: Graduation/MBA",R.drawable.collabera);
        companiesList.add(companies);
        companies = new Companies("Accurate Accounting","-","-","Eligibility: Graduation/MBA",R.drawable.accurate_accounting);
        companiesList.add(companies);
        companies = new Companies("Om Careers","-","-","Eligibility: Graduation/MBA",R.drawable.om_careers);
        companiesList.add(companies);
        companies = new Companies("Grazitti","-","-","Eligibility: Graduation/MBA",R.drawable.grazitti);
        companiesList.add(companies);
        companies = new Companies("Birla Life","-","-","Eligibility: Graduation/MBA",R.drawable.birla);
        companiesList.add(companies);
        companies = new Companies("Ralson India","-","-","Eligibility: Graduation/MBA",R.drawable.ralson);
        companiesList.add(companies);
        companies = new Companies("Investors Clinic","-","-","Eligibility: Graduation/MBA",R.drawable.investors_clinic);
        companiesList.add(companies);
        companies = new Companies("PNB Metlife","-","-","Eligibility: Graduation/MBA",R.drawable.pnb_metlife);
        companiesList.add(companies);
        companies = new Companies("Max Life","-","-","Eligibility: Graduation/MBA",R.drawable.maxlife);
        companiesList.add(companies);
        companies = new Companies("Capital Trust","-","-","Eligibility: Graduation/MBA",R.drawable.capitaltrust);
        companiesList.add(companies);
        companies = new Companies("Patel Hospital","-","-","Eligibility: Graduation/MBA",R.drawable.patelhospital);
        companiesList.add(companies);
        companies = new Companies("UAE Exchange","-","-","Eligibility: Graduation/MBA",R.drawable.uae_exchange);
        companiesList.add(companies);
        companies = new Companies("Jackson Tech Solutions","-","-","Eligibility: Graduation/MBA",R.drawable.no_logo);
        companiesList.add(companies);
        companies = new Companies("Paytm","-","-","Eligibility: Graduation/MBA",R.drawable.paytm);
        companiesList.add(companies);
        companies = new Companies("Teleperformance","-","-","Eligibility: Graduation/MBA",R.drawable.teleperformance);
        companiesList.add(companies);
        companies = new Companies("TeamLease","-","-","Eligibility: Graduation/MBA",R.drawable.teamlease);
        companiesList.add(companies);
        companies = new Companies("AR Tech Solutions","-","-","Eligibility: Graduation/MBA",R.drawable.ar_tech_solns);
        companiesList.add(companies);
        companies = new Companies("Swipecubes Soft Pvt. Ltd.","-","-","Eligibility: Graduation/MBA",R.drawable.swipecubes);
        companiesList.add(companies);
        companies = new Companies("Intersoft Professional","-","-","Eligibility: Graduation/MBA",R.drawable.intersoft_professional);
        companiesList.add(companies);
        companies = new Companies("WebAstral","-","-","Eligibility: Graduation/MBA",R.drawable.webastral);
        companiesList.add(companies);
        companies = new Companies("Webze Technologies","-","-","Eligibility: Graduation/MBA",R.drawable.webze_technologies);
        companiesList.add(companies);
        companies = new Companies("Pisoft","-","-","Eligibility: Graduation/MBA",R.drawable.pisoft);
        companiesList.add(companies);
        companies = new Companies("G. Tech Solutions","-","-","Eligibility: Graduation/MBA",R.drawable.gtech_solns);
        companiesList.add(companies);
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
