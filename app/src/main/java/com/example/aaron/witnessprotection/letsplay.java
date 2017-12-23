package com.example.aaron.witnessprotection;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class letsplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letsplay);

        //initializing data for the search, button and flipping between screens/activities
        //using shared preferences
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor mEdit1 = sp.edit();

        mEdit1.putInt("Storage_size", 0);
        mEdit1.putInt("SearchExist", 0);
        mEdit1.putInt("SearchNameE", 0);

        mEdit1.putInt("RolesNumbers", 0);

        mEdit1.commit();
        Button confirm =(Button) this.findViewById(R.id.confirm);

    }

    //click listener for the confirm button (set up in XLM)
    public void confirm(View view){

        //initializing the edit text (finding it)
        EditText numberofplayers = (EditText) this.findViewById(R.id.numberofplayers);

        int numberplayers = 0;
        assert numberofplayers != null;

        //getting the number if player from the edit text
        String stringplayernumber = numberofplayers.getText().toString();

        //if the edit text is NULL (blank)
        if(stringplayernumber.matches("")){
            Toast.makeText(getApplicationContext(), "To Few Players",
                    Toast.LENGTH_LONG).show();
        }
        else{
            //if the edit text has stuff in it
            //get the string from the edit text and convert it into an int
            numberplayers = Integer.parseInt(numberofplayers.getText().toString());
            //if the number is more than 1
            if(numberplayers>1) {
                //System.out.println("moving on");
                Toast.makeText(getApplicationContext(), "Moving on",
                        Toast.LENGTH_LONG).show();

                //put the number of players in shared preferences
                SharedPreferences sharedpreferences = getSharedPreferences("Global", Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putInt("numberplayers", numberplayers);
                editor.commit();


                //start the role numbering activity
                startActivity(new Intent(view.getContext(), RoleNumbering.class));

            }
            else{
                Toast.makeText(getApplicationContext(), "to low of a number",
                        Toast.LENGTH_LONG).show();

            }
        }
    }
}
