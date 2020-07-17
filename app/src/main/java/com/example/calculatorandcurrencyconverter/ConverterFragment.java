package com.example.calculatorandcurrencyconverter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.content.Context.MODE_PRIVATE;


public class ConverterFragment extends Fragment implements View.OnClickListener{

    View view;
    private EditText editTextInputAmount;
    private TextView textViewShowEquivalent;
    private Button buttonOne;
    private Button buttonTwo;
    private Button buttonThree;
    private Button buttonFour;
    private Button buttonFive;
    private Button buttonSix;
    private Button buttonSeven;
    private Button buttonEight;
    private Button buttonNine;
    private Button buttonZero;
    private Button buttonReverseCurrency;
    private Button buttonHistory;
    private Button buttonDelete;
    private Button buttonDot;
    private Button buttonChangeCurrencyTop;
    private Button buttonChangecurrencyBottom;


    public ConverterFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_converter, container, false);
        // Inflate the layout for this fragment
        setFindViewsById(view);
        setOnButtonClickListeners();
        setButtonsText();
        setConversion();
        setReverseButton();

        return view;
    }

    private void setFindViewsById(View view){


        editTextInputAmount=view.findViewById(R.id.editTextInputAmountXml);
        textViewShowEquivalent=view.findViewById(R.id.textViewShowEquivalentXml);
        buttonOne=view.findViewById(R.id.buttonOneXml);
        buttonTwo=view.findViewById(R.id.buttonTwoXml);
        buttonThree=view.findViewById(R.id.buttonThreeXml);
        buttonFour=view.findViewById(R.id.buttonFourXml);
        buttonFive=view.findViewById(R.id.buttonFiveXml);
        buttonSix=view.findViewById(R.id.buttonSixXml);
        buttonSeven=view.findViewById(R.id.buttonSevenXml);
        buttonEight=view.findViewById(R.id.buttonEightXml);
        buttonNine=view.findViewById(R.id.buttonNineXml);
        buttonZero=view.findViewById(R.id.buttonZeroXml);
        buttonDot=view.findViewById(R.id.buttonDotXml);
        buttonDelete=view.findViewById(R.id.buttonDeleteXml);
        buttonHistory=view.findViewById(R.id.buttonHistoryXml);
        buttonReverseCurrency=view.findViewById(R.id.buttonReverseXml);
        buttonChangeCurrencyTop=view.findViewById(R.id.buttonChangeCurrencyTopXml);
        buttonChangecurrencyBottom=view.findViewById(R.id.buttonChangeCurrencyBottomXml);

    }

    private void setOnButtonClickListeners(){

        buttonOne.setOnClickListener(this);
        buttonTwo.setOnClickListener(this);
        buttonThree.setOnClickListener(this);
        buttonFour.setOnClickListener(this);
        buttonFive.setOnClickListener(this);
        buttonSix.setOnClickListener(this);
        buttonSeven.setOnClickListener(this);
        buttonEight.setOnClickListener(this);
        buttonNine.setOnClickListener(this);
        buttonZero.setOnClickListener(this);
        buttonDelete.setOnClickListener(this);
        buttonReverseCurrency.setOnClickListener(this);
        buttonDot.setOnClickListener(this);
        buttonChangecurrencyBottom.setOnClickListener(this);
        buttonChangeCurrencyTop.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId() ) {
            case R.id.buttonOneXml:

                editTextInputAmount.setText(editTextInputAmount.getText().toString()+"1");

                break;
            case R.id.buttonTwoXml:

                editTextInputAmount.setText(editTextInputAmount.getText().toString()+"2");


                break;
            case R.id.buttonThreeXml:

                editTextInputAmount.setText(editTextInputAmount.getText().toString()+"3");


                break;
            case R.id.buttonFourXml:

                editTextInputAmount.setText(editTextInputAmount.getText().toString()+"4");


                break;
            case R.id.buttonFiveXml:

                editTextInputAmount.setText(editTextInputAmount.getText().toString()+"5");

                break;
            case R.id.buttonSixXml:

                editTextInputAmount.setText(editTextInputAmount.getText().toString()+"6");


                break;

            case R.id.buttonSevenXml:

                editTextInputAmount.setText(editTextInputAmount.getText().toString()+"7");


                break;
            case R.id.buttonEightXml:

                editTextInputAmount.setText(editTextInputAmount.getText().toString()+"8");


                break;
            case R.id.buttonNineXml:

                editTextInputAmount.setText(editTextInputAmount.getText().toString()+"9");


                break;

            case R.id.buttonZeroXml:

                editTextInputAmount.setText(editTextInputAmount.getText().toString()+"0");

                break;

            case R.id.buttonReverseXml:
                setReverseButton();
                break;

            case R.id.buttonDeleteXml:

                int length = editTextInputAmount.getText().length();
                if (length > 0) {
                    editTextInputAmount.getText().delete(length - 1, length);
                }

                break;

            case R.id.buttonDotXml:

                editTextInputAmount.setText(editTextInputAmount.getText().toString()+".");


                break;
            case R.id.buttonChangeCurrencyTopXml:

                goToListBottomCurrencyActivity();

                break;
            case R.id.buttonChangeCurrencyBottomXml:

                goToListTopCurrencyActivity();

                break;

        }
    }

    private void setReverseButton() {

        String tempBaseName=readPreferencesBaseName();
        float tempBase=readPreferencesBase();
        SharedPreferences.Editor editor = this.getActivity().getSharedPreferences("Currency", MODE_PRIVATE).edit();
        editor.putString("baseName", readPreferencesCoinName());
        editor.putFloat("base",readPreferencesCoin());
        editor.putString("coinName", tempBaseName);
        editor.putFloat("coin",tempBase);
        editor.apply();
        buttonChangeCurrencyTop.setText(readPreferencesBaseName());
        buttonChangecurrencyBottom.setText(readPreferencesCoinName());

        if(readPreferencesBase()!=0&&readPreferencesCoin()!=0){
            if (editTextInputAmount.getText().length()>0) {
                textViewShowEquivalent.setText(String.valueOf(Float.parseFloat(editTextInputAmount.getText().toString())*(readPreferencesCoin()/readPreferencesBase())));
            }
            editTextInputAmount.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    if (editTextInputAmount.getText().length()>0) {
                        textViewShowEquivalent.setText(String.valueOf(Float.parseFloat(editTextInputAmount.getText().toString())*(readPreferencesCoin()/readPreferencesBase())));
                    }else if(editTextInputAmount.getText().length()==0){
                        textViewShowEquivalent.setText("");
                    }
                }
            });

        }
    }

    private void goToListTopCurrencyActivity() {

        Intent intent = new Intent(this.getActivity(), ListOfCurrenciesTopActivity.class);
        startActivity(intent);
    }

    private void goToListBottomCurrencyActivity() {

        Intent intent = new Intent(this.getActivity(), ListOfCurrenciesBottomActivity.class);
        startActivity(intent);
    }


    private String readPreferencesBaseName() {

        SharedPreferences prefs =this.getActivity().getSharedPreferences("Currency", MODE_PRIVATE);
        String baseName = prefs.getString("baseName", null);

        return baseName;
    }

    private void setConversion(){

        final float base=readPreferencesBase();
        final float coin=readPreferencesCoin();
        if(base!=0&&coin!=0){
            editTextInputAmount.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    if (editTextInputAmount.getText().length()>0) {
                        textViewShowEquivalent.setText(String.valueOf(Float.parseFloat(editTextInputAmount.getText().toString())*(coin/base)));
                    }else if(editTextInputAmount.getText().length()==0){
                        textViewShowEquivalent.setText("");
                    }
                }
            });

        }

    }


    private String readPreferencesCoinName() {

        SharedPreferences prefs = this.getActivity().getSharedPreferences("Currency", MODE_PRIVATE);
        String coinName = prefs.getString("coinName", null);

        return coinName;
    }

    private float readPreferencesCoin() {

        SharedPreferences prefs = this.getActivity().getSharedPreferences("Currency", MODE_PRIVATE);
        float coin = prefs.getFloat("coin",0);

        return coin;
    }

    private float readPreferencesBase() {

        SharedPreferences prefs = this.getActivity().getSharedPreferences("Currency", MODE_PRIVATE);
        float coin = prefs.getFloat("base",0);

        return coin;
    }

    private void setButtonsText(){

        String baseName=readPreferencesBaseName();
        String coinName=readPreferencesCoinName();

        if(baseName==null){
            buttonChangeCurrencyTop.setText("FROM");
        }
        else{
            buttonChangeCurrencyTop.setText(baseName);
        }
        if(coinName==null){
            buttonChangecurrencyBottom.setText("TO");
        }
        else{
            buttonChangecurrencyBottom.setText(coinName);
        }
    }
}
