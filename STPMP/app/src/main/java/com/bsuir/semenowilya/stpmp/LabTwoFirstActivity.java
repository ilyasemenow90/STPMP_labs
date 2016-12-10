package com.bsuir.semenowilya.stpmp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class LabTwoFirstActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.bsuir.semenowiliya.stpmp.MESSAGE";
    EditText editTextItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_two_first);

        editTextItem = (EditText) this.findViewById(R.id.textViewLabTwo);
    }

    public void sendTextBtn(View view) {
        editTextItem = (EditText) this.findViewById(R.id.textViewLabTwo);
        String enteredText = editTextItem.getText().toString();
        if (enteredText.length() <= 0)
        {
            new AlertDialog.Builder(this)
                    .setTitle("Вам надо ввести текст")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // continue with delete
                        }
                    })
                    .show();
        } else {
            Intent intent = new Intent(this, LabTwoSecondActivity.class);
            intent.putExtra(EXTRA_MESSAGE, enteredText);
            startActivityForResult(intent, 1);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent)
    {
        if (intent == null) {return;}
        final String message = intent.getStringExtra(LabTwoFirstActivity.EXTRA_MESSAGE);
        editTextItem.setText(message);

        editTextItem.post(new Runnable() {
            @Override
            public void run() {
                editTextItem.setSelection(message.length());
            }
        });
    }
}
