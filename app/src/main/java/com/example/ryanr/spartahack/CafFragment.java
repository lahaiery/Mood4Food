package com.example.ryanr.spartahack;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CafFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class CafFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private int cafNum;
    private View view;
    private String currentMeal;
    Date todaysdate = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("EEEE, MMMM dd");
    Date d = new Date();
    String dayOfTheWeek = sdf.format(d);
    public CafFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static CafFragment newInstance(int cafID) {
        Bundle args = new Bundle();
        args.putInt("cafID", cafID);

        CafFragment fragment = new CafFragment();
        fragment.setArguments(args);

        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_caf, container, false);

        final Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.CustomTheme);

        if (getArguments() != null) {
            int cafID = 0;
            Bundle args = getArguments();
            cafNum = args.getInt("cafID");
            PageSetup();
            TextView textView = (TextView) view.findViewById(R.id.dateTextView);
            textView.setText(dayOfTheWeek);

        }

        final Spinner spinner =(Spinner) view.findViewById(R.id.mealSpinner);
        ///Function to get current selected value of the Meal selection spinner
        spinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                        Object item = parent.getItemAtPosition(pos);
                        currentMeal = item.toString();
                    }
                    public void onNothingSelected(AdapterView<?> parent) {
                    }

           });



        Button prev = (Button) view.findViewById(R.id.prevDaybutton);
        prev.setOnClickListener(new View.OnClickListener() {
            //Function to add subtract day every time prev day button is clicked
            public void onClick(View paramView) {
                Calendar cal = new GregorianCalendar();
                cal.setTime(d);
                cal.add(Calendar.DATE, -1);
                d = cal.getTime();
                dayOfTheWeek = sdf.format(d);
                TextView textView = (TextView) view.findViewById(R.id.dateTextView);
                textView.setText(dayOfTheWeek);
            }
        });

        Button next = (Button) view.findViewById(R.id.nextDaybutton);
        next.setOnClickListener(new View.OnClickListener() {
            //Function to add one day every time next day button is clicked
            public void onClick(View paramView) {
                Calendar cal = new GregorianCalendar();
                cal.setTime(d);
                cal.add(Calendar.DATE, +1);
                d = cal.getTime();
                dayOfTheWeek = sdf.format(d);
                TextView textView = (TextView) view.findViewById(R.id.dateTextView);
                textView.setText(dayOfTheWeek);
            }
        });
        return view;
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

    public void PageSetup() {
        ImageView img = (ImageView) view.findViewById(R.id.cafImageView);
        switch (cafNum) {
            case 0:
                img.setImageResource(R.drawable.akerscaf);
                break;
            case 1:
                img.setImageResource(R.drawable.brodycaf);
                break;
            case 2:
                img.setImageResource(R.drawable.casehall);
                break;
            case 3:
                img.setImageResource(R.drawable.landoncaf);
                break;
            case 4:
                img.setImageResource(R.drawable.holdencaf);
                break;
            case 5:
                img.setImageResource(R.drawable.holmescaf);
                break;
            case 6:
                img.setImageResource(R.drawable.owencaf);
                break;
            case 7:
                img.setImageResource(R.drawable.snyphicaf);
                break;
            case 8:
                img.setImageResource(R.drawable.wilsoncaf);
                break;
            case 9:
                img.setImageResource(R.drawable.shawcaf);
                break;
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

    // references to our images
    private Integer[] mCafImages = {
            R.drawable.akerscaf,  R.drawable.snyphicaf,  R.drawable.brodycaf, R.drawable.holdencaf,
            R.drawable.landoncaf, R.drawable.shawcaf, R.drawable.wilsoncaf, R.drawable.owencaf,
            R.drawable.holmescaf, R.drawable.casehall,
    };
}
