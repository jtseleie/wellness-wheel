package com.example.hsport.catalog;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by jtsel on 2016-02-07.
 */
public class QuestionSSPFragment extends Fragment {


    public static final String ARG_QPAGE = "page";
    private static final String FRAG_NUMBER = "intFragmentNumber";
    private int mPageNumber;

    public static final String wheelPrefs = "MyPrefs";
    SharedPreferences sharedpreferences;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.frag_question, container, false);
//        TextView txtScore = (TextView) rootView.findViewById(R.id.introBodyText);
//        TextView txtScoreHeader = (TextView) rootView.findViewById(R.id.introHeaderText);
        TextView txtQuestion = (TextView) rootView.findViewById(R.id.questionText);
        final TextView txtQuestionPercent = (TextView) rootView.findViewById(R.id.questionPercent);
        SeekBar mySeek = (SeekBar) rootView.findViewById(R.id.seekBar);

        sharedpreferences = this.getActivity().getSharedPreferences(wheelPrefs, Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedpreferences.edit();


        mySeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            String curPage = Integer.toString(sharedpreferences.getInt(FRAG_NUMBER, 0));

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtQuestionPercent.setText(Integer.toString(progress) + "%");
                curPage = Integer.toString(sharedpreferences.getInt(FRAG_NUMBER,0));

//                Only commit changes if the event was fired by user interaction
                if (fromUser==true){
                    editor.putInt("strWedge" + curPage,progress);
                    editor.commit();
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Integer testPageNum = getPageNumber();



        switch (testPageNum) {
            case 0:
                txtQuestion.setText(R.string.Statement1);
//                txtScore.setText(R.string.wwIntro);
//                txtScoreHeader.setText(R.string.introHeader);
                break;
            case 1:
                txtQuestion.setText(R.string.Statement2);
//                txtScore.setText(R.string.instructions);
//                txtScoreHeader.setText(R.string.instructionsHeader);
                break;
            case 2:
                txtQuestion.setText(R.string.Statement3);
                break;
            case 3:
                txtQuestion.setText(R.string.Statement4);
                break;
            case 4:
                txtQuestion.setText(R.string.Statement5);
                break;
            case 5:
                txtQuestion.setText(R.string.Statement6);
                break;
            case 6:
                txtQuestion.setText(R.string.Statement7);
                break;
            case 7:
                txtQuestion.setText(R.string.Statement8);
                break;
            case 8:
                txtQuestion.setText(R.string.Statement9);
                break;
            case 9:
                txtQuestion.setText(R.string.Statement10);
                break;
            case 10:
                txtQuestion.setText(R.string.Statement11);
                break;
            case 11:
                txtQuestion.setText(R.string.Statement12);
                break;
            case 12:
                txtQuestion.setText(R.string.Statement13);
                break;
            case 13:
                txtQuestion.setText(R.string.Statement14);
                break;
            case 14:
                txtQuestion.setText(R.string.Statement15);
                break;
            case 15:
                txtQuestion.setText(R.string.Statement16);
                break;
            case 16:
                txtQuestion.setText(R.string.Statement17);
                break;
            case 17:
                txtQuestion.setText(R.string.Statement18);
                break;
            case 18:
                txtQuestion.setText(R.string.Statement19);
                break;
            case 19:
                txtQuestion.setText(R.string.Statement20);
                break;
            case 20:
                txtQuestion.setText(R.string.Statement21);
                break;
            case 21:
                txtQuestion.setText(R.string.Statement22);
                break;
            case 22:
                txtQuestion.setText(R.string.Statement23);
                break;
            case 23:
                txtQuestion.setText(R.string.Statement24);
                break;
            case 24:
                txtQuestion.setText(R.string.Statement25);
                break;
            case 25:
                txtQuestion.setText(R.string.Statement26);
                break;
            case 26:
                txtQuestion.setText(R.string.Statement27);
                break;
            case 27:
                txtQuestion.setText(R.string.Statement28);
                break;
            case 28:
                txtQuestion.setText(R.string.Statement29);
                break;
            case 29:
                txtQuestion.setText(R.string.Statement30);
                break;
            case 30:
                txtQuestion.setText(R.string.Statement31);
                break;
            case 31:
                txtQuestion.setText(R.string.Statement32);
                break;
            case 32:
                txtQuestion.setText(R.string.Statement33);
                break;
            case 33:
                txtQuestion.setText(R.string.Statement34);
                break;
            case 34:
                txtQuestion.setText(R.string.Statement35);
                break;
            case 35:
                txtQuestion.setText(R.string.Statement36);
                break;

        }

        return rootView;
    }

    public static QuestionSSPFragment create(int pageNumber) {

        QuestionSSPFragment fragment = new QuestionSSPFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_QPAGE, pageNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public QuestionSSPFragment() {

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPageNumber = getArguments().getInt(ARG_QPAGE);
    }

    public int getPageNumber() {
        return mPageNumber;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    public void onResume() {
        super.onResume();
    }




}


