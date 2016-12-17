package com.example.cristianverdes.calculateit.NumberButtons;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Cristian Verdes on 9/4/2016.
 */
public class NumberButtonListener implements View.OnClickListener{
    private TextView textView;

    public NumberButtonListener(TextView textView){
        this.textView = textView;
    }

    @Override
    public void onClick(View v) {
        textView.append(((Button) v).getText());
    }
}
