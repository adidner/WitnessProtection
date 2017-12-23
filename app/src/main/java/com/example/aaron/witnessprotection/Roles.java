package com.example.aaron.witnessprotection;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Roles extends ListActivity {



    String roles[]= {"Murderers", "HostageTaker", "BlackMailers", "Traitors", "Assasins", "KingPins",
            "Lawyers", "Moles", "Witnesses", "Handler", "SWAT","Neighborhood","Police","BodyGuard","ProtectedDignitary",
            "Civilian","Transient","BountryHunter","Negotiator","Executioner","Detective","Doctor","SuicideBomber","Interrogator"};


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_roles);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, roles));

    }

    protected void onListItemClick(ListView lv, View v, int position, long id){
        Toast toast = Toast.makeText(getApplicationContext(), "Hello", Toast.LENGTH_LONG);
        toast.show();
        super.onListItemClick(lv, v, position, id);
        String openClass = roles[position];
        try{
            Class selected = Class.forName("com.example.aaron.witnessprotection."+ openClass);
            Intent selectedIntent = new Intent(this, selected);
            startActivity(selectedIntent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
