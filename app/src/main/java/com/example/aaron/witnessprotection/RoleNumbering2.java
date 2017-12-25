package com.example.aaron.witnessprotection;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;




public class RoleNumbering2 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role_numbering2);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);


        SharedPreferences prefs = getSharedPreferences("Global", getApplicationContext().MODE_PRIVATE);
        int total = prefs.getInt("numberplayers", 0);
        EditText total2 = (EditText) findViewById(R.id.total2);
        total2.setText(String.valueOf(total));


        ArrayList<TextView> RoleCounting = new ArrayList<>();
        String[] Backgrounds = declareBackgrounds();

        String[] Identities = {"Witness","Detective","SuicideBomber","Interrogator","Executioner","Negotitor","BounteryHunter"
                ,"Trasient","Civilian","ProtectedDignitary","Bodyguard","PoliceOfficer","Neighborhood","SWAT","Handler","Doctor",
                "Mole","Assassin","Lawyer","Kingpin","Traitor","BlackMailer","Murderer","HostageTaker"};


        //initialize Good Guys and title
        for(int i = 0; i< Identities.length;i++){
            initialize(Identities[i],Backgrounds[i],RoleCounting);
        }

        //confirm button
            confirm(Backgrounds,RoleCounting);

    }

    public void confirm(final String[] Backgrounds, final ArrayList<TextView> RoleCounting){
        TableLayout Capsule = (TableLayout) findViewById(R.id.capsule);
            /* Create a new row to be added. */
        TableRow tr = new TableRow(this);
        tr.setGravity(Gravity.CENTER_HORIZONTAL);
        tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));

        Button Confirm = new Button(this);
        Confirm.setText("Confirm");

        Confirm.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getting the number of total players from shared preferences, saved in MainActivity
                SharedPreferences prefs = getSharedPreferences("Global", getApplicationContext().MODE_PRIVATE);
                int total = prefs.getInt("numberplayers", 0);

                //total roles is the number of roles in you have entered into the slots for this screen
                int totalroles = totalroles(RoleCounting);

                //if your total number of player is equal to the number of roles you've assigned
                if(total== totalroles){
                    Toast.makeText(getApplicationContext(), "we're good",
                            Toast.LENGTH_LONG).show();

                    ArrayList<String> RolesSMS = new ArrayList<>();

                    //checking every edit text and based on that number put, that many sets of the coresponding string into the
                    //RolesSMS
                    //this probably should have been a method
                    for(int i = 0; i < RoleCounting.size();i++) {
                        if (!(RoleCounting.get(i).getText().toString().matches(""))) {
                            int counter = Integer.parseInt(RoleCounting.get(i).getText().toString());
                            while (counter != 0) {
                                RolesSMS.add(Backgrounds[i]);
                                counter--;
                            }
                        }
                    }

                    //parse the list into shared preferences
                    SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(RoleNumbering2.this);
                    SharedPreferences.Editor mEdit1 = sp.edit();

                    mEdit1.putInt("Status_size", RolesSMS.size());

                    for(int i=0;i<RolesSMS.size();i++)
                    {
                        mEdit1.remove("Status_" + i);
                        mEdit1.putString("Status_" + i, RolesSMS.get(i));

                    }

                    mEdit1.commit();

                    startActivity(new Intent(RoleNumbering2.this, SendingSMS.class));
                }

                else if(total > totalroles){
                    Toast.makeText(getApplicationContext(), "enter more roles",
                            Toast.LENGTH_LONG).show();

                }
                else if(total < totalroles){
                    Toast.makeText(getApplicationContext(), "enter fewer roles",
                            Toast.LENGTH_LONG).show();

                }
            }
        });

        tr.addView(Confirm);
        Capsule.addView(tr, new TableLayout.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));

    }




    public void createtitle(String titleText){
        TableLayout Capsule = (TableLayout) findViewById(R.id.capsule);

    /* Create a new row to be added. */
        TableRow tr = new TableRow(this);
        tr.setGravity(Gravity.CENTER_HORIZONTAL);
        tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));

        TextView Title = new TextView(this);
        Title.setText(titleText);
        //Title.setTextAppearance(android.R.style.TextAppearance_Large);
        //Title.setGravity(Gravity.CENTER);

        tr.addView(Title);
        Capsule.addView(tr, new TableLayout.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
    }

    public void initialize(String identity,String background,ArrayList<TextView> RoleCounting){
        /* Find Tablelayout defined in main.xml */
        TableLayout Capsule = (TableLayout) findViewById(R.id.capsule);
    /* Create a new row to be added. */
        TableRow tr = new TableRow(this);
        tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
        tr.setGravity(Gravity.CENTER_HORIZONTAL);


        EditText filled = (EditText) findViewById(R.id.OutOff2);

         /* Create a Button to be the row-content. */
        Button minus = new Button(this, null, android.R.attr.buttonStyleSmall);
        minus.setText("-");

        minus.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
        /* Add Button to row. */
        tr.addView(minus);



        TextView TV = new TextView(this);
        TV.setText(identity);
        //TV.setTextSize(20);
        //TV.setGravity(Gravity.CENTER|Gravity.LEFT);
        info(TV,background);
        TV.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
        tr.addView(TV);

        TextView number = new TextView(this);
        number.setText("0");
        RoleCounting.add(number);
        //number.setTextSize(20);
        //number.setGravity(Gravity.CENTER|Gravity.LEFT);
        number.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
        tr.addView(number);

        /* Create a Button to be the row-content. */
        Button plus = new Button(this, null, android.R.attr.buttonStyleSmall);
        plus.setText("+");

        plus.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
        /* Add Button to row. */
        tr.addView(plus);

        plus(plus,number,filled);
        minus(minus,number,filled);

    /* Add row to TableLayout. */
        Capsule.addView(tr, new TableLayout.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
    }

    public void info(TextView TV, final String info){
        TV.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                AlertDialog ad = new AlertDialog.Builder(RoleNumbering2.this).create();
                ad.setCancelable(false); // This blocks the 'BACK' button
                ad.setMessage(info);
                ad.setButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                ad.show();

                return true;
            }
        });
    }


    public void minus(Button minus, final TextView changes, final EditText filled){
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!changes.getText().toString().matches("0")){
                    int number=Integer.parseInt(changes.getText().toString());
                    number--;
                    changes.setText(String.valueOf(number));

                    int number2=Integer.parseInt(filled.getText().toString());
                    number2--;
                    filled.setText(String.valueOf(number2));
                }
            }
        });
    }

    public void plus(Button plus, final TextView changes, final EditText filled){
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number=Integer.parseInt(changes.getText().toString());
                number++;
                changes.setText(String.valueOf(number));

                int number2=Integer.parseInt(filled.getText().toString());
                number2++;
                filled.setText(String.valueOf(number2));
            }
        });
    }





    public int totalroles(ArrayList<TextView> RoleCounting){
        int total=0;
        TextView counter = (TextView) findViewById(R.id.OutOff2);
            try{
                total=Integer.parseInt(counter.getText().toString());
            }
            catch(Exception e){

            }


        return total;
    }

    public String[] declareBackgrounds(){
        String[] backgrounds = {
                "Witness:\n" +
                        "Mission: Hide! If ⅓ the number of players joins you, all Good Characters win.\n" +
                        "Skill: If the murderers find you and kill you or time runs out all Bad Characters win. You will have a certain number of minutes to hide\n",

                "Detective: \n" +
                        "Mission: Find and hide with the witness\n" +
                        "Skill: You can talk to dead players to find out who they were and which player killed them (They have to tell you the truth). If playing in the dark, you may use a handheld light source. \n",

                "Suicide Bomber:\n" +
                        "Mission: Find and hide with the Witness.\n" +
                        "Skill: Sacrifice your life to kill another player by hugging them. All players within a 5 foot radius are also killed.\n",

                "Interrogator:\n" +
                        "Mission: Find and hide with the Witness.\n" +
                        "Skill: Place your hand on another player’s shoulder to make them reveal their identity to you. They must be honest. You won’t die if you discover the Traitor this way. \n",

                "Executioner:\n" +
                        "Mission: Find and hide with the witness\n" +
                        "Skill: You may kill one player during the game by running your hand across their neck\n",

                "Negotiator:\n" +
                        "Mission: Find and hide with the Witness\n" +
                        "Skill: Permanently remove the Hostage Taker’s ability by grabbing their elbow. You can only do this while they have a hostage. You cannot use this ability while you are taken hostage. \n",

                "Bounty Hunter:\n" +
                        "Mission: Find and hide with the Witness\n" +
                        "Skill: You may kill once during the game. If you kill the Murderer, you will be the Witness in the next round.\n",

                "Transient:\n" +
                        "Mission: Find and hide with the Witness.\n" +
                        "Skill: If you stay in place for longer than 15 seconds, you die.\n",

                "Civilian:\n" +
                        "Mission: Find and hide with the Witness\n" +
                        "Skill: Be creative -- not having extra abilities doesn’t mean you can’t be valuable to your team.\n",

                "Protected Dignitary:\n" +
                        "Mission: Find and hide with the Witness\n" +
                        "Skill: You are immune to all negative effects aside from death. The player who kills you also dies. \n",

                "Bodyguard:\n" +
                        "Mission: Find and hide with the Witness.\n" +
                        "Skill: Sacrifice your own life to revive another player. Do this by drawing a cross on their arm.\n",

                "Police Officer:\n" +
                        "Mission: Find and hide with the Witness\n" +
                        "Skill: Grab both wrists of another player to freeze them for 30 seconds (arrest them). You may only arrest each player once. You do not need to stay with the player while they are frozen.\n",

                "Neighborhood Watch:\n" +
                        "Mission: Find and hide with the Witness.\n" +
                        "Skill: The first player you make physical contact with dies, whether intentional or not.\n",

                "SWAT:\n" +
                        "Mission: Find and hide with the Witness.\n" +
                        "Skill: If you witness a player die, you may kill the player who caused the death.\n",

                "Handler:\n" +
                        "Mission: Find and hide with the Witness.\n" +
                        "Skill: Before the Witness hides, reveal yourself as a Handler. Follow the Witness until they have hidden.  \n",

                "Doctor:\n" +
                        "Mission: Find and hide with the Witness.\n" +
                        "Skill: You revive players by drawing a cross on their arms. You cannot use this ability while you are taken hostage. \n",

                "Mole:\n" +
                        "Mission: use your ability to get the Witness killed.\n" +
                        "Skill: Before the Witness hides, reveal yourself as a Handler. Follower the Witness until they have hidden. Return to Base before the game begins. \n",

                "Assassin:\n" +
                        "Mission: Use your ability to get the Witness killed.\n" +
                        "Skill: Kill players by running your hand across their necks; then place your hand on the victim's shoulder to make them reveal their identity to you. You die if the player you killed was a Civilian, or if you do not check their identity. \n",

                "Lawyer:\n" +
                        "Mission: Use your ability to get the Witness killed.\n" +
                        "Skill: You can revive the Murderer by drawing a cross on their arm. You may only use this ability twice.\n",

                "Kingpin:\n" +
                        "Mission: Use your ability to get the Witness killed.\n" +
                        "Skill: If the Murderer dies, you become a new Murderer. If the Murderer or Assassin attempts to kill you, that player dies (you do not).\n",

                "Traitor:\n" +
                        "Mission: Use your ability to get the Witness killed.\n" +
                        "Skill: Any player (Good or Evil) dies when they verbally reveal their identity to you, or when they ask you to reveal your identity.",

                "Blackmailer:\n" +
                        "Mission: Use your ability to get the Witness killed.\n" +
                        "Skill: As long as you are touching the Witness, they cannot win the game\n",

                "Murderer:\n" +
                        "Mission: Use your ability to get the Witness killed.\n" +
                        "Skill: Kill players by running your hand across their necks.\n",

                "Hostage Taker:\n" +
                        "Mission: Use your ability to get the Witness killed.\n" +
                        "Skill: Grab a player’s elbow to hold them hostage. They must stay with you until you let go or until the Negotiator removes your ability. You may only hold one player at a time. \n"
        };

        return backgrounds;
    }

}