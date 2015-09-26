package com.example.student.map524_lab3;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

public class TerminologyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terminology);

        // Code to handle the autocomplete text view.
        // Inspired from http://developer.android.com/guide/topics/ui/controls/text.html

        // Get a reference to the AutoCompleteTextView in the layout
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.commandAutoCompleteTextView);

        // Getting the string arrays
        final String commands[] = getResources().getStringArray(R.array.commands_array);
        final String def[] = getResources().getStringArray(R.array.def_array);

        // Create the adaptor and set it to the AutoCompleteTextView
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, commands);
        autoCompleteTextView.setAdapter(adapter);

        // Code to display handle text input and toast display
        // Inspired from http:http://stackoverflow.com/questions/13621762/how-to-find-the-position-of-item-in-a-autocompletetextview-filled-with-array
        // Inspired from http://developer.android.com/guide/topics/ui/notifiers/toasts.html

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Getting position of selected item from the array so it can be corresponded to the def array
                String selection = (String) parent.getItemAtPosition(position);
                int pos = -1;

                for(int i = 0; i < commands.length; i++)
                {
                    if(commands[i].equals(selection))
                    {
                        pos = i;
                        break;
                    }
                }

                Toast.makeText(getApplicationContext(), def[pos], Toast.LENGTH_SHORT).show();
            }
        });
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
            setContentView(R.layout.activity_help);
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
}