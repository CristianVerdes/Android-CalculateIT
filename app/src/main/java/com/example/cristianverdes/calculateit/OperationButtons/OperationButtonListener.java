package com.example.cristianverdes.calculateit.OperationButtons;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cristianverdes.calculateit.TypesOfNumbers.TypesOfNumbersButtonsHandler;

/**
 * Created by Cristian Verdes on 9/8/2016.
 */
public class OperationButtonListener implements View.OnClickListener {
    private final TypesOfNumbersButtonsHandler typesOfNumbersButtonsHandler;
    private TextView textView;
    private boolean signUsed = false;

    public OperationButtonListener(TextView textView, TypesOfNumbersButtonsHandler typesOfNumbersButtonsHandler){
        this.typesOfNumbersButtonsHandler = typesOfNumbersButtonsHandler;
        this.textView = textView;
    }

    @Override
    public void onClick(View v) {
        String text = textView.getText().toString();
        int textLength = text.length();

        if( text.charAt(textLength-1) == '+' ||
            text.charAt(textLength-1) == '-' ||
            text.charAt(textLength-1) == '/' ||
            text.charAt(textLength-1) == '*' ){
            String firstPartOfTextView = text.substring(0,textLength-1);
            String secondPart = (String)((Button) v).getText();
            String finalString = firstPartOfTextView + secondPart;

            textView.setText(finalString);
        } else {
            if(textLength != 0){
                String lastCharacter = text.substring(text.length()-1,text.length());
                if(signUsed){
                    calculate();
                    textView.append(((Button) v).getText());
                } else {
                    if(isLastCharacterANumber(lastCharacter)) {
                        textView.append(((Button) v).getText());
                        typesOfNumbersButtonsHandler.setPointIsPossible(true);

                        signUsed = true;
                    }
                }
            }
        }
    }

    private boolean isLastCharacterANumber(String sign){
        if(sign.length() != 0) {
            if(sign.equals("+")){
                return false;
            }
            if(sign.equals("-")){
                return false;
            }
            if(sign.equals("/")){
                return false;
            }
            if(sign.equals("*")){
                return false;
            }
            return true;
        }
        return false;
    }

    private void calculate() {
        String text = textView.getText().toString();
        int operatorIndex = isOperator(text,text.length());
        if(operatorIndex != 0) {
            String firstNumber = text.substring(0, operatorIndex);
            int lastIndex = text.length();
            String secondNumber = text.substring(operatorIndex + 1, lastIndex);

            float nr0 = Float.parseFloat(firstNumber);
            float nr1 = Float.parseFloat(secondNumber);

            String result = Float.toString(doOperation(nr0, nr1, text.charAt(operatorIndex)));

            textView.setText(result);
        }
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

    public void changeSignIsUsed(boolean change){
        this.signUsed = change;
    }
}
