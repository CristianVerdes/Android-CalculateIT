package com.example.cristianverdes.calculateit.NumberButtons;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;

import com.example.cristianverdes.calculateit.R;

/**
 * Created by Cristian Verdes on 9/8/2016.
 */
public class NumberButtonHandler {
    private final Activity activity;
    private final NumberButtonListener numberButtonListener;

    private Button button0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;

    private TextView textView;

    public NumberButtonHandler(Activity activity){
        this.activity = activity;
        this.injectButtons();

        this.textView = (TextView) activity.findViewById(R.id.textView);

        this.numberButtonListener = new NumberButtonListener(textView);
        this.addListeners();

    }

    private void injectButtons() {
        button0 = (Button) activity.findViewById(R.id.button0);
        button1 = (Button) activity.findViewById(R.id.button1);
        button2 = (Button) activity.findViewById(R.id.button2);
        button3 = (Button) activity.findViewById(R.id.button3);
        button4 = (Button) activity.findViewById(R.id.button4);
        button5 = (Button) activity.findViewById(R.id.button5);
        button6 = (Button) activity.findViewById(R.id.button6);
        button7 = (Button) activity.findViewById(R.id.button7);
        button8 = (Button) activity.findViewById(R.id.button8);
        button9 = (Button) activity.findViewById(R.id.button9);
    }

    private void addListeners(){
        button0.setOnClickListener(numberButtonListener);
        button1.setOnClickListener(numberButtonListener);
        button2.setOnClickListener(numberButtonListener);
        button3.setOnClickListener(numberButtonListener);
        button4.setOnClickListener(numberButtonListener);
        button5.setOnClickListener(numberButtonListener);
        button6.setOnClickListener(numberButtonListener);
        button7.setOnClickListener(numberButtonListener);
        button8.setOnClickListener(numberButtonListener);
        button9.setOnClickListener(numberButtonListener);
    }
}
