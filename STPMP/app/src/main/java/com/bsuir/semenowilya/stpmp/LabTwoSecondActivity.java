package com.bsuir.semenowilya.stpmp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LabTwoSecondActivity extends AppCompatActivity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_two_second);

        Intent intent = getIntent();
        final String message = intent.getStringExtra(LabTwoFirstActivity.EXTRA_MESSAGE);
        editText = (EditText) this.findViewById(R.id.editTextLabTwoSecond);
        editText.setText(message);

        editText.post(new Runnable() {
            @Override
            public void run() {
                editText.setSelection(message.length());
            }
        });
    }


    public void sendTextSecondBtn(View view) {
        String enteredText = editText.getText().toString();
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

            Intent intent = new Intent();
            intent.putExtra(LabTwoFirstActivity.EXTRA_MESSAGE, enteredText);
            setResult(1, intent);
            finish();
        }
    }
}
