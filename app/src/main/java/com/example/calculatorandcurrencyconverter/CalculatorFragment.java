package com.example.calculatorandcurrencyconverter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.LinkedList;


public class CalculatorFragment extends Fragment implements View.OnClickListener{
    private View view;
    private EditText editTextInputAmount;

    private Button buttonOneCalc;
    private Button buttonTwoCalc;
    private Button buttonThreeCalc;
    private Button buttonFourCalc;
    private Button buttonFiveCalc;
    private Button buttonSixCalc;
    private Button buttonSevenCalc;
    private Button buttonEightCalc;
    private Button buttonNineCalc;
    private Button buttonZeroCalc;

    private Button buttonMinusCalc;
    private Button buttonMultiplyCalc;
    private Button buttonDivideCalc;
    private Button buttonAddCalc;
    private Button buttonEqualCalc;

    private Button buttonDeleteCalc;
    private Button buttonDotCalc;
    private Button buttonDeleteAll;


    public CalculatorFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_calculator, container, false);

        setFindViewsById(view);
        setOnButtonClickListeners();
        return view;
    }


    private void setFindViewsById(View view){


        editTextInputAmount=view.findViewById(R.id.editTextCalc);

        buttonOneCalc=view.findViewById(R.id.buttonOneCalcXml);
        buttonTwoCalc=view.findViewById(R.id.buttonTwoCalcXml);
        buttonThreeCalc=view.findViewById(R.id.buttonThreeCalcXml);
        buttonFourCalc=view.findViewById(R.id.buttonFourCalcXml);
        buttonFiveCalc=view.findViewById(R.id.buttonFiveCalcXml);
        buttonSixCalc=view.findViewById(R.id.buttonSixCalcXml);
        buttonSevenCalc=view.findViewById(R.id.buttonSevenCalcXml);
        buttonEightCalc=view.findViewById(R.id.buttonEightCalcXml);
        buttonNineCalc=view.findViewById(R.id.buttonNineCalcXml);
        buttonZeroCalc=view.findViewById(R.id.buttonZeroCalcXml);

        buttonDotCalc=view.findViewById(R.id.buttonDotCalcXml);

        buttonDeleteCalc=view.findViewById(R.id.buttonDeleteCalcXml);
        buttonDeleteAll=view.findViewById(R.id.buttonDeleteAllCalcXml);

        buttonMultiplyCalc=view.findViewById(R.id.buttonMultiplyCalcXml);
        buttonDivideCalc=view.findViewById(R.id.buttonDivideCalcXml);
        buttonAddCalc=view.findViewById(R.id.buttonAddCalcXml);
        buttonMinusCalc=view.findViewById(R.id.buttonMinusCalcXml);

        buttonEqualCalc=view.findViewById(R.id.buttonEqualCalcXml);


    }

    private void setOnButtonClickListeners(){

        buttonOneCalc.setOnClickListener(this);
        buttonTwoCalc.setOnClickListener(this);
        buttonThreeCalc.setOnClickListener(this);
        buttonFourCalc.setOnClickListener(this);
        buttonFiveCalc.setOnClickListener(this);
        buttonSixCalc.setOnClickListener(this);
        buttonSevenCalc.setOnClickListener(this);
        buttonEightCalc.setOnClickListener(this);
        buttonNineCalc.setOnClickListener(this);
        buttonZeroCalc.setOnClickListener(this);

        buttonMinusCalc.setOnClickListener(this);
        buttonDeleteCalc.setOnClickListener(this);
        buttonMultiplyCalc.setOnClickListener(this);
        buttonDivideCalc.setOnClickListener(this);
        buttonDeleteAll.setOnClickListener(this);

        buttonDotCalc.setOnClickListener(this);
        buttonAddCalc.setOnClickListener(this);
        buttonEqualCalc.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {


        switch (v.getId() ) {
            case R.id.buttonOneCalcXml:

                editTextInputAmount.setText(editTextInputAmount.getText().toString()+"1");

                break;
            case R.id.buttonTwoCalcXml:

                editTextInputAmount.setText(editTextInputAmount.getText().toString()+"2");


                break;
            case R.id.buttonThreeCalcXml:

                editTextInputAmount.setText(editTextInputAmount.getText().toString()+"3");


                break;
            case R.id.buttonFourCalcXml:

                editTextInputAmount.setText(editTextInputAmount.getText().toString()+"4");


                break;
            case R.id.buttonFiveCalcXml:

                editTextInputAmount.setText(editTextInputAmount.getText().toString()+"5");

                break;
            case R.id.buttonSixCalcXml:

                editTextInputAmount.setText(editTextInputAmount.getText().toString()+"6");


                break;

            case R.id.buttonSevenCalcXml:

                editTextInputAmount.setText(editTextInputAmount.getText().toString()+"7");


                break;
            case R.id.buttonEightCalcXml:

                editTextInputAmount.setText(editTextInputAmount.getText().toString()+"8");


                break;
            case R.id.buttonNineCalcXml:

                editTextInputAmount.setText(editTextInputAmount.getText().toString()+"9");


                break;

            case R.id.buttonZeroCalcXml:

                editTextInputAmount.setText(editTextInputAmount.getText().toString()+"0");

                break;

            case R.id.buttonDivideCalcXml:

                if (editTextInputAmount.getText().length()>0&&
                        editTextInputAmount.getText().toString().charAt(editTextInputAmount.getText().length()-1)!='*'&&
                        editTextInputAmount.getText().toString().charAt(editTextInputAmount.getText().length()-1)!='-'&&
                        editTextInputAmount.getText().toString().charAt(editTextInputAmount.getText().length()-1)!='/'&&
                        editTextInputAmount.getText().toString().charAt(editTextInputAmount.getText().length()-1)!='+'
                ) {
                    editTextInputAmount.setText(editTextInputAmount.getText().toString()+"/");
                }


                break;
            case R.id.buttonAddCalcXml:

                if (editTextInputAmount.getText().length()>0&&
                        editTextInputAmount.getText().toString().charAt(editTextInputAmount.getText().length()-1)!='*'&&
                        editTextInputAmount.getText().toString().charAt(editTextInputAmount.getText().length()-1)!='-'&&
                        editTextInputAmount.getText().toString().charAt(editTextInputAmount.getText().length()-1)!='/'&&
                        editTextInputAmount.getText().toString().charAt(editTextInputAmount.getText().length()-1)!='+')
                {
                    editTextInputAmount.setText(editTextInputAmount.getText().toString()+"+");
                }


                break;
            case R.id.buttonMinusCalcXml:

                if (editTextInputAmount.getText().length()>0&&
                        editTextInputAmount.getText().toString().charAt(editTextInputAmount.getText().length()-1)!='*'&&
                        editTextInputAmount.getText().toString().charAt(editTextInputAmount.getText().length()-1)!='-'&&
                        editTextInputAmount.getText().toString().charAt(editTextInputAmount.getText().length()-1)!='/'&&
                        editTextInputAmount.getText().toString().charAt(editTextInputAmount.getText().length()-1)!='+')
                {
                    editTextInputAmount.setText(editTextInputAmount.getText().toString()+"-");
                }


                break;
            case R.id.buttonMultiplyCalcXml:

                if (editTextInputAmount.getText().length()>0&&
                        editTextInputAmount.getText().toString().charAt(editTextInputAmount.getText().length()-1)!='*'&&
                        editTextInputAmount.getText().toString().charAt(editTextInputAmount.getText().length()-1)!='-'&&
                        editTextInputAmount.getText().toString().charAt(editTextInputAmount.getText().length()-1)!='/'&&
                        editTextInputAmount.getText().toString().charAt(editTextInputAmount.getText().length()-1)!='+')
                {
                    editTextInputAmount.setText(editTextInputAmount.getText().toString()+"*");
                }


                break;
            case R.id.buttonDotCalcXml:

                if (editTextInputAmount.getText().length()>0) {
                    editTextInputAmount.setText(editTextInputAmount.getText().toString()+".");
                }


                break;
            case R.id.buttonEqualCalcXml:

                if (editTextInputAmount.getText().length()>0) {
                    makeCalculation(editTextInputAmount.getText().toString());
                }


                break;

            case R.id.buttonDeleteCalcXml:

                int length = editTextInputAmount.getText().length();
                if (length > 0) {
                    editTextInputAmount.getText().delete(length - 1, length);
                }

                break;

            case R.id.buttonDeleteAllCalcXml:

             editTextInputAmount.setText("");

                break;
    }
}

  private void makeCalculation(String s){
      int counter=0;
      LinkedList<String> list=new LinkedList<>();
      for(int i=0;i<s.length();i++){
          if(s.charAt(i)=='+'||s.charAt(i)=='-'||s.charAt(i)=='*'||s.charAt(i)=='/'){
              list.add(s.substring(counter,i));
              String oper=""+s.charAt(i);
              list.add(oper);
              counter=i+1;
          }
      }
      list.add(s.substring(counter,s.length()));


      for(int j=0;j<list.size();j++){
          if(list.get(j).equals("*")){
              Double value=Double.parseDouble(list.get(j-1))*Double.parseDouble(list.get(j+1));
              list.remove(j-1);
              list.remove(j-1);
              list.remove(j-1);
              list.add(j-1,String.valueOf(value));
              j=j-1;
          }
          if(list.get(j).equals("/")){
              Double value=Double.parseDouble(list.get(j-1))/Double.parseDouble(list.get(j+1));
              list.remove(j-1);
              list.remove(j-1);
              list.remove(j-1);
              list.add(j-1,String.valueOf(value));
              j=j-1;
          }

      }

      for(int j=0;j<list.size();j++){
          if(list.get(j).equals("+")){
              Double value=Double.parseDouble(list.get(j-1))+Double.parseDouble(list.get(j+1));
              list.remove(j-1);
              list.remove(j-1);
              list.remove(j-1);
              list.add(j-1,String.valueOf(value));
              j=j-1;
          }
          if(list.get(j).equals("-")){
              Double value=Double.parseDouble(list.get(j-1))-Double.parseDouble(list.get(j+1));
              list.remove(j-1);
              list.remove(j-1);
              list.remove(j-1);
              list.add(j-1,String.valueOf(value));
              j=j-1;
          }

      }

      editTextInputAmount.setText(list.get(0));

  }



}
