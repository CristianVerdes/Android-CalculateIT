package com.example.cristianverdes.calculateit.TypesOfNumbers;

import android.app.Activity;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cristianverdes.calculateit.R;

/**
 * Created by Cristian Verdes on 9/8/2016.
 */
public class TypesOfNumbersButtonsHandler {
    private final Activity activity;
    private TextView textView;

    Button buttonMinusOrPlus;
    Button buttonPoint;
    boolean pointIsPossible = true;


    public TypesOfNumbersButtonsHandler(Activity activity){
        this.activity = activity;
        this.textView = (TextView) activity.findViewById(R.id.textView);

        this.injectButtons();
        this.addListeners();
    }

    private void injectButtons() {
        buttonMinusOrPlus = (Button) activity.findViewById(R.id.buttonPlusOrMinus);
        buttonPoint = (Button) activity.findViewById(R.id.buttonPoint);
    }

    private void addListeners() {
        buttonMinusOrPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = textView.getText().toString();
                if(text.length() == 0){
                    textView.append("(-)");
                } else {
                    if (isPossibleToAddType(text)) {
                        textView.append("(-)");
                    }
                }
            }

        });

        buttonPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isPossibleToAddPoint();
            }
        });
    }

    private void isPossibleToAddPoint(){
        String text = textView.getText().toString();
        if(text.length()!=0){
            String lastCharacter = text.substring(text.length()-1,text.length());
            if(isNumeric(lastCharacter) && pointIsPossible){
                textView.append(".");
                pointIsPossible = false;
            }
        }
    }

    public static boolean isNumeric(String str)
    {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

    public void setPointIsPossible (boolean setPointIsPossible){
        this.pointIsPossible = setPointIsPossible;
    }

    private boolean isPossibleToAddType(String text) {
        String sign = text.substring(text.length()-1,text.length());
        switch (sign){
            case "+":
                return true;
            case "-":
                return true;
            case "/":
                return true;
            case "*":
                return true;
            default:
                break;
        }
        return false;
    }
}
