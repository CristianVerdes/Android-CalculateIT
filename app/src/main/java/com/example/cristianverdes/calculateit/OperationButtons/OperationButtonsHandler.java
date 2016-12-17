package com.example.cristianverdes.calculateit.OperationButtons;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cristianverdes.calculateit.R;
import com.example.cristianverdes.calculateit.TypesOfNumbers.TypesOfNumbersButtonsHandler;

/**
 * Created by Cristian Verdes on 9/4/2016.
 */
public class OperationButtonsHandler {
    private final OperationButtonListener operationButtonListener;
    private Activity activity;
    private TextView textView;

    Button buttonPlus;
    Button buttonMinus;
    Button buttonMultiply;
    Button buttonDivide;
    Button buttonEquals;

    TypesOfNumbersButtonsHandler typesOfNumbersButtonsHandler;

    public OperationButtonsHandler(Activity activity, TypesOfNumbersButtonsHandler typesOfNumbersButtonsHandler){
        this.activity = activity;
        this.typesOfNumbersButtonsHandler = typesOfNumbersButtonsHandler;
        this.injectButtons();

        textView = (TextView) activity.findViewById(R.id.textView);
        this.operationButtonListener = new OperationButtonListener(textView, this.typesOfNumbersButtonsHandler);

        this.addListeners();

    }

    private void injectButtons() {
        buttonPlus = (Button) activity.findViewById(R.id.buttonPlus);
        buttonMinus = (Button) activity.findViewById(R.id.buttonMinus);
        buttonMultiply = (Button) activity.findViewById(R.id.buttonMultiply);
        buttonDivide = (Button) activity.findViewById(R.id.buttonDivide);
        buttonEquals = (Button) activity.findViewById(R.id.buttonEquals);
    }

    public void onDestroy(){
        this.activity = null;
    }

    private void addListeners(){
        buttonPlus.setOnClickListener(operationButtonListener);
        buttonMinus.setOnClickListener(operationButtonListener);
        buttonDivide.setOnClickListener(operationButtonListener);
        buttonMultiply.setOnClickListener(operationButtonListener);

        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Take the numbers and do the operations
                calculate(textView.getText().toString());
                operationButtonListener.changeSignIsUsed(false);
                //Toast.makeText(activity.getBaseContext(),"Operation done, BITCH!!!",Toast.LENGTH_SHORT).show();
                //Toast.makeText(activity.getBaseContext(),"Use me for something real..",Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void calculate(String text) {
        int operatorIndex = isOperator(text,text.length());
        String firstNumber = text.substring(0,operatorIndex);
        int secondOperator = isOperator(text.substring(operatorIndex+1,text.length()),text.length());
        String secondNumber = text.substring(operatorIndex+1,secondOperator);

        float nr0 = Float.parseFloat(firstNumber);
        float nr1 = Float.parseFloat(secondNumber);

        String result = Float.toString(doOperation(nr0,nr1,text.charAt(operatorIndex)));

        String restOfTextView = text.substring(secondOperator,text.length());
        textView.setText(result + restOfTextView);
    }

    private float doOperation(float nr0, float nr1, char operator) {
        if(operator == '+'){
            return nr0 + nr1;
        }
        if(operator == '-'){
            return nr0 - nr1;
        }
        if(operator == '*'){
            return nr0 * nr1;
        }
        if(operator == '/'){
            return nr0 / nr1;
        }
        return 0;
    }

    private int isOperator(String text, int fullLength){
        for(int i= 0; i<text.length(); i++){
            char c = text.charAt(i);

            if(c == '+' || c == '-' || c == '*' || c == '/'){
                return text.indexOf(c) + fullLength - text.length();
            }
        }
        return fullLength;
    }
}
