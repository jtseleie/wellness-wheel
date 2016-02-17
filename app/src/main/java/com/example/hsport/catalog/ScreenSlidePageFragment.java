package com.example.hsport.catalog;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by jtsel on 2016-02-07.
 */
public class ScreenSlidePageFragment  extends Fragment{


    public static final String ARG_PAGE="page";
    private int mPageNumber;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.frag_intro, container, false);
        TextView txtScore = (TextView) rootView.findViewById(R.id.introBodyText);
        TextView txtScoreHeader = (TextView) rootView.findViewById(R.id.introHeaderText);


        switch (getPageNumber()){
            case 1:
                txtScore.setText(R.string.wwIntro);
                txtScoreHeader.setText(R.string.introHeader);
            case 2:
                txtScore.setText(R.string.instructions);
                txtScoreHeader.setText(R.string.instructionsHeader);
        }

        return rootView;
    }

    public static ScreenSlidePageFragment create(int pageNumber){
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE,pageNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public ScreenSlidePageFragment(){

    }

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mPageNumber = getArguments().getInt(ARG_PAGE);
    }

    public int getPageNumber() {
        return mPageNumber;
    }
}

