package com.bsuir.semenowilya.stpmp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class LabThreeActivity extends AppCompatActivity {

    MyTask backgroundTask;
    TextView textViewInfo;
    Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_three);

        textViewInfo = (TextView) this.findViewById(R.id.textViewThree);
        startButton = (Button) this.findViewById(R.id.buttonForBackgroundTaskid);

    }

    public void onStartExecuteBackgroundTaskClick(View view) {
        backgroundTask = new MyTask();
        backgroundTask.execute(10);
    }

    class MyTask extends AsyncTask<Integer, Integer, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            startButton.setEnabled(false);
            textViewInfo.setText("Время: 0");
        }

        @Override
        protected Void doInBackground(Integer... integers) {
            try {
                Integer timerSeconds = integers[0];
                for (int second = 0; second < timerSeconds; second++) {
                    TimeUnit.SECONDS.sleep(1);
                    publishProgress(second+1);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            textViewInfo.setText("Время: " + values[0]);
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            startButton.setEnabled(true);
            textViewInfo.setText(textViewInfo.getText().toString() + ".\nВыполнение закончено");
        }


        private void downloadFile(String url) throws InterruptedException {
            TimeUnit.SECONDS.sleep(2);
        }
    }
}
