package com.example.cristianverdes.calculateit.RefactorButtons;

import android.app.Activity;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cristianverdes.calculateit.R;
import com.example.cristianverdes.calculateit.TypesOfNumbers.TypesOfNumbersButtonsHandler;

/**
 * Created by Cristian Verdes on 9/8/2016.
 */
public class RefactorButtonHandler {
    private final Activity activity;
    private TextView textView;

    private Button buttonDelete;
    private Button buttonClear;
    private TypesOfNumbersButtonsHandler typesOfNumbersButtonsHandler;

    public RefactorButtonHandler(Activity activity, TypesOfNumbersButtonsHandler typesOfNumbersButtonsHandler){
        this.activity = activity;
        this.typesOfNumbersButtonsHandler = typesOfNumbersButtonsHandler;
        this.textView = (TextView) activity.findViewById(R.id.textView);

        this.injectButtons();
        this.addListeners();


    }

    private void injectButtons() {
        this.buttonDelete = (Button) activity.findViewById(R.id.buttonDelete);
        this.buttonClear = (Button) activity.findViewById(R.id.buttonClear);
    }

    private void addListeners(){
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = textView.getText().toString();
                if(text.length() != 0){
                    textView.setText(text.substring(0,text.length()-1));
                    if(text.substring(text.length()-1,text.length()).equals(".")){
                        typesOfNumbersButtonsHandler.setPointIsPossible(true);
                    }
                }
            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("");
            }
        });
    }

}
