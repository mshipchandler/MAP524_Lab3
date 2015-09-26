package com.example.student.map524_lab3;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_help)
        {
            // Code inspired from http://stackoverflow.com/questions/5152564/calling-one-activity-from-another-in-android
            Intent intent = new Intent(this, HelpActivity.class);
            startActivity(intent);
        }

        else if(id == R.id.action_about)
        {
            // Code inspired from http://www.mkyong.com/android/android-alert-dialog-example/
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

            //Setting title
            alertDialogBuilder.setTitle(R.string.about_title);
            //Setting message
            alertDialogBuilder.setMessage(R.string.about_message);
            //To close
            alertDialogBuilder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            //Create an alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();
            //Show the dialog
            alertDialog.show();
        }

        return super.onOptionsItemSelected(item);
    }

    public void terminologyClicked(View view)
    {
        // Code inspired from http://stackoverflow.com/questions/5152564/calling-one-activity-from-another-in-android
        Intent intent = new Intent(this, TerminologyActivity.class);
        startActivity(intent);
    }
}
