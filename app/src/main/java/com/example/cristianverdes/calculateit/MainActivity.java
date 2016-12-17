package com.example.cristianverdes.calculateit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.cristianverdes.calculateit.NumberButtons.NumberButtonHandler;
import com.example.cristianverdes.calculateit.OperationButtons.OperationButtonsHandler;
import com.example.cristianverdes.calculateit.RefactorButtons.RefactorButtonHandler;
import com.example.cristianverdes.calculateit.TypesOfNumbers.TypesOfNumbersButtonsHandler;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    private NumberButtonHandler numberButtonHandler;
    private OperationButtonsHandler operationButtonsHandler;
    private RefactorButtonHandler refactorButtonHandler;
    private TypesOfNumbersButtonsHandler typesOfNumbersButtonsHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        this.injectViews();

        this.typesOfNumbersButtonsHandler = new TypesOfNumbersButtonsHandler(this);
        this.operationButtonsHandler = new OperationButtonsHandler(this, typesOfNumbersButtonsHandler);
        this.numberButtonHandler = new NumberButtonHandler(this);
        this.refactorButtonHandler = new RefactorButtonHandler(this,typesOfNumbersButtonsHandler);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        operationButtonsHandler.onDestroy();
    }

    private void injectViews() {
        textView =(TextView) findViewById(R.id.textView);
    }

}
