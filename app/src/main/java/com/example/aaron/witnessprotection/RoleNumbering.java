package com.example.aaron.witnessprotection;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpanWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RoleNumbering extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role_numbering);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);


        SharedPreferences prefs = getSharedPreferences("Global", getApplicationContext().MODE_PRIVATE);
        int total = prefs.getInt("numberplayers", 0);

        final ArrayList<EditText> numberboxes = new ArrayList<>();
        ArrayList<Button> plus = new ArrayList<>();
        ArrayList<Button> minus = new ArrayList<>();




        Button m1 = (Button) this.findViewById(R.id.m1);
        Button m2 = (Button) this.findViewById(R.id.m2);
        Button m3 = (Button) this.findViewById(R.id.m3);
        Button m4 = (Button) this.findViewById(R.id.m4);
        Button m5 = (Button) this.findViewById(R.id.m5);
        Button m6 = (Button) this.findViewById(R.id.m6);
        Button m7 = (Button) this.findViewById(R.id.m7);
        Button m8 = (Button) this.findViewById(R.id.m8);
        Button m9 = (Button) this.findViewById(R.id.m9);
        Button m10 = (Button) this.findViewById(R.id.m10);
        Button m11 = (Button) this.findViewById(R.id.m11);
        Button m12 = (Button) this.findViewById(R.id.m12);
        Button m13 = (Button) this.findViewById(R.id.m13);
        Button m14 = (Button) this.findViewById(R.id.m14);
        Button m15 = (Button) this.findViewById(R.id.m15);
        Button m16 = (Button) this.findViewById(R.id.m16);
        Button m17 = (Button) this.findViewById(R.id.m17);
        Button m18 = (Button) this.findViewById(R.id.m18);
        Button m19 = (Button) this.findViewById(R.id.m19);
        Button m20 = (Button) this.findViewById(R.id.m20);
        Button m21 = (Button) this.findViewById(R.id.m21);
        Button m22 = (Button) this.findViewById(R.id.m22);
        Button m23 = (Button) this.findViewById(R.id.m23);
        Button m24 = (Button) this.findViewById(R.id.m24);

        Button p1 = (Button) this.findViewById(R.id.p1);
        Button p2 = (Button) this.findViewById(R.id.p2);
        Button p3 = (Button) this.findViewById(R.id.p3);
        Button p4 = (Button) this.findViewById(R.id.p4);
        Button p5 = (Button) this.findViewById(R.id.p5);
        Button p6 = (Button) this.findViewById(R.id.p6);
        Button p7 = (Button) this.findViewById(R.id.p7);
        Button p8 = (Button) this.findViewById(R.id.p8);
        Button p9 = (Button) this.findViewById(R.id.p9);
        Button p10 = (Button) this.findViewById(R.id.p10);
        Button p11 = (Button) this.findViewById(R.id.p11);
        Button p12 = (Button) this.findViewById(R.id.p12);
        Button p13 = (Button) this.findViewById(R.id.p13);
        Button p14 = (Button) this.findViewById(R.id.p14);
        Button p15 = (Button) this.findViewById(R.id.p15);
        Button p16 = (Button) this.findViewById(R.id.p16);
        Button p17 = (Button) this.findViewById(R.id.p17);
        Button p18 = (Button) this.findViewById(R.id.p18);
        Button p19 = (Button) this.findViewById(R.id.p19);
        Button p20 = (Button) this.findViewById(R.id.p20);
        Button p21 = (Button) this.findViewById(R.id.p21);
        Button p22 = (Button) this.findViewById(R.id.p22);
        Button p23 = (Button) this.findViewById(R.id.p23);
        Button p24 = (Button) this.findViewById(R.id.p24);


        EditText filled = (EditText) this.findViewById(R.id.OutOff2);

        EditText murderer =(EditText) this.findViewById(R.id.murderer);
        plus(p1, murderer, filled);
        minus(m1, murderer, filled);
        EditText hostagetaker =(EditText) this.findViewById(R.id.hostagetaker);
        plus(p2, hostagetaker, filled);
        minus(m2, hostagetaker, filled);
        EditText blackmailer =(EditText) this.findViewById(R.id.blackmailer);
        plus(p3, blackmailer, filled);
        minus(m3, blackmailer, filled);
        EditText traitor =(EditText) this.findViewById(R.id.traitor);
        plus(p4, traitor, filled);
        minus(m4, traitor, filled);
        EditText assasin =(EditText) this.findViewById(R.id.assasin);
        plus(p5, assasin, filled);
        minus(m5, assasin, filled);
        EditText kingpin =(EditText) this.findViewById(R.id.kingpin);
        plus(p6, kingpin, filled);
        minus(m6, kingpin, filled);
        EditText lawyer =(EditText) this.findViewById(R.id.lawyer);
        plus(p7, lawyer, filled);
        minus(m7, lawyer, filled);
        EditText mole =(EditText) this.findViewById(R.id.mole);
        plus(p8, mole, filled);
        minus(m8, mole, filled);
        EditText witness =(EditText) this.findViewById(R.id.witness);
        plus(p9, witness, filled);
        minus(m9, witness, filled);
        EditText handler =(EditText) this.findViewById(R.id.handler);
        plus(p10, handler, filled);
        minus(m10, handler, filled);
        EditText SWAT =(EditText) this.findViewById(R.id.SWAT);
        plus(p11, SWAT, filled);
        minus(m11, SWAT, filled);
        EditText neighborhoodwatch =(EditText) this.findViewById(R.id.neighborhoodwatch);
        plus(p12, neighborhoodwatch, filled);
        minus(m12, neighborhoodwatch, filled);
        EditText police =(EditText) this.findViewById(R.id.police);
        plus(p13, police, filled);
        minus(m13, police, filled);
        EditText bodyguard =(EditText) this.findViewById(R.id.bodyguard);
        plus(p14, bodyguard, filled);
        minus(m14, bodyguard, filled);
        EditText protecteddignitary =(EditText) this.findViewById(R.id.protecteddignitary);
        plus(p15, protecteddignitary, filled);
        minus(m15, protecteddignitary, filled);
        EditText civilian =(EditText) this.findViewById(R.id.civilian);
        plus(p16, civilian, filled);
        minus(m16, civilian, filled);
        EditText trans =(EditText) this.findViewById(R.id.trans);
        plus(p17, trans, filled);
        minus(m17, trans, filled);
        EditText bountyhunter =(EditText) this.findViewById(R.id.bountyhunter);
        plus(p18, bountyhunter, filled);
        minus(m18, bountyhunter, filled);
        EditText negotiator =(EditText) this.findViewById(R.id.negotiator);
        plus(p19, negotiator, filled);
        minus(m19, negotiator, filled);
        EditText excecutioner =(EditText) this.findViewById(R.id.excecutioner);
        plus(p20, excecutioner, filled);
        minus(m20, excecutioner, filled);
        EditText detective =(EditText) this.findViewById(R.id.detective);
        plus(p21, detective, filled);
        minus(m21, detective, filled);
        EditText doctor =(EditText) this.findViewById(R.id.doctor);
        plus(p22, doctor, filled);
        minus(m22, doctor, filled);
        EditText suicidebomber =(EditText) this.findViewById(R.id.suicidebomber);
        plus(p23, suicidebomber, filled);
        minus(m23, suicidebomber, filled);
        EditText interrogator =(EditText) this.findViewById(R.id.interrogator);
        plus(p24, interrogator, filled);
        minus(m24, interrogator, filled);

        EditText total2 = (EditText) findViewById(R.id.total2);
        total2.setText(String.valueOf(total));

        String Detectivetext = "Detective: \n" +
                "Mission: Find and hide with the witness\n" +
                "Skill: You can talk to dead players to find out who they were and which player killed them (They have to tell you the truth). If playing in the dark, you may use a handheld light source. \n";
        String SuicideBombertext = "Suicide Bomber:\n" +
                "Mission: Find and hide with the Witness.\n" +
                "Skill: Sacrifice your life to kill another player by hugging them. All players within a 5 foot radius are also killed.\n";
        String Interrogatortext = "Interrogator:\n" +
                "Mission: Find and hide with the Witness.\n" +
                "Skill: Place your hand on another player’s shoulder to make them reveal their identity to you. They must be honest. You won’t die if you discover the Traitor this way. \n";
        String Executionertext = "Executioner:\n" +
                "Mission: Find and hide with the witness\n" +
                "Skill: You may kill one player during the game by running your hand across their neck\n";
        String Negotiatortext = "Negotiator:\n" +
                "Mission: Find and hide with the Witness\n" +
                "Skill: Permanently remove the Hostage Taker’s ability by grabbing their elbow. You can only do this while they have a hostage. You cannot use this ability while you are taken hostage. \n";
        String BountyHuntertext = "Bounty Hunter:\n" +
                "Mission: Find and hide with the Witness\n" +
                "Skill: You may kill once during the game. If you kill the Murderer, you will be the Witness in the next round.\n";
        String Transienttext = "Transient:\n" +
                "Mission: Find and hide with the Witness.\n" +
                "Skill: If you stay in place for longer than 15 seconds, you die.\n";
        String Civiliantext = "Civilian:\n" +
                "Mission: Find and hide with the Witness\n" +
                "Skill: Be creative -- not having extra abilities doesn’t mean you can’t be valuable to your team.\n";
        String ProtectedDignitarytext = "Protected Dignitary:\n" +
                "Mission: Find and hide with the Witness\n" +
                "Skill: You are immune to all negative effects aside from death. The player who kills you also dies. \n";
        String Bodyguardtext = "Bodyguard:\n" +
                "Mission: Find and hide with the Witness.\n" +
                "Skill: Sacrifice your own life to revive another player. Do this by drawing a cross on their arm.\n";
        String PoliceOfficertext = "Police Officer:\n" +
                "Mission: Find and hide with the Witness\n" +
                "Skill: Grab both wrists of another player to freeze them for 30 seconds (arrest them). You may only arrest each player once. You do not need to stay with the player while they are frozen.\n";
        String NeighborhoodWatchtext = "Neighborhood Watch:\n" +
                "Mission: Find and hide with the Witness.\n" +
                "Skill: The first player you make physical contact with dies, whether intentional or not.\n";
        String SWATtext = "SWAT:\n" +
                "Mission: Find and hide with the Witness.\n" +
                "Skill: If you witness a player die, you may kill the player who caused the death.\n";
        String Witnesstext = "Witness:\n" +
                "Mission: Hide! If ⅓ the number of players joins you, all Good Characters win.\n" +
                "Skill: If the murderers find you and kill you or time runs out all Bad Characters win. You will have a certain number of minutes to hide\n";
        String Handlertext = "Handler:\n" +
                "Mission: Find and hide with the Witness.\n" +
                "Skill: Before the Witness hides, reveal yourself as a Handler. Follow the Witness until they have hidden.  \n";
        String Doctortext = "Doctor:\n" +
                "Mission: Find and hide with the Witness.\n" +
                "Skill: You revive players by drawing a cross on their arms. You cannot use this ability while you are taken hostage. \n";
        String Moletext = "Mole:\n" +
                "Mission: use your ability to get the Witness killed.\n" +
                "Skill: Before the Witness hides, reveal yourself as a Handler. Follower the Witness until they have hidden. Return to Base before the game begins. \n";
        String Assassintext = "Assassin:\n" +
                "Mission: Use your ability to get the Witness killed.\n" +
                "Skill: Kill players by running your hand across their necks; then place your hand on the victim's shoulder to make them reveal their identity to you. You die if the player you killed was a Civilian, or if you do not check their identity. \n";
        String Lawyertext = "Lawyer:\n" +
                "Mission: Use your ability to get the Witness killed.\n" +
                "Skill: You can revive the Murderer by drawing a cross on their arm. You may only use this ability twice.\n";
        String Kingpintext = "Kingpin:\n" +
                "Mission: Use your ability to get the Witness killed.\n" +
                "Skill: If the Murderer dies, you become a new Murderer. If the Murderer or Assassin attempts to kill you, that player dies (you do not).\n";
        String Traitortext = "Traitor:\n" +
                "Mission: Use your ability to get the Witness killed.\n" +
                "Skill: Any player (Good or Evil) dies when they verbally reveal their identity to you, or when they ask you to reveal your identity.";
        String Blackmailertext = "Blackmailer:\n" +
                "Mission: Use your ability to get the Witness killed.\n" +
                "Skill: As long as you are touching the Witness, they cannot win the game\n";
        String Murderertext = "Murderer:\n" +
                "Mission: Use your ability to get the Witness killed.\n" +
                "Skill: Kill players by running your hand across their necks.\n";
        String HostageTakertext = "Hostage Taker:\n" +
                "Mission: Use your ability to get the Witness killed.\n" +
                "Skill: Grab a player’s elbow to hold them hostage. They must stay with you until you let go or until the Negotiator removes your ability. You may only hold one player at a time. \n";


        TextView Murderer = (TextView) findViewById(R.id.MurdererText);
        info(Murderer,Murderertext);
        TextView HostageTaker = (TextView) findViewById(R.id.HostageTakerText);
        info(HostageTaker,HostageTakertext);
        TextView BlackMailer = (TextView) findViewById(R.id.BlackMailerText);
        info(BlackMailer,Blackmailertext);
        TextView Traitor = (TextView) findViewById(R.id.TraitorText);
        info(Traitor,Traitortext);
        TextView Assasin = (TextView) findViewById(R.id.AssasinText);
        info(Assasin,Assassintext);
        TextView Kingpin = (TextView) findViewById(R.id.KingpinText);
        info(Kingpin,Kingpintext);
        TextView Lawyer = (TextView) findViewById(R.id.LawyerText);
        info(Lawyer, Lawyertext);
        TextView Mole = (TextView) findViewById(R.id.MoleText);
        info(Mole, Moletext);
        TextView Witness = (TextView) findViewById(R.id.WitnessText);
        info(Witness,Witnesstext);
        TextView Handler = (TextView) findViewById(R.id.HandlerText);
        info(Handler,Handlertext);
        TextView Doctor = (TextView) findViewById(R.id.DoctorText);
        info(Doctor, Doctortext);
        TextView Swat = (TextView) findViewById(R.id.SWATText);
        info(Swat, SWATtext);
        TextView Neighborhoodwatch = (TextView) findViewById(R.id.NeighborhoodWatchText);
        info(Neighborhoodwatch,NeighborhoodWatchtext);
        TextView Police = (TextView) findViewById(R.id.PoliceText);
        info(Police, PoliceOfficertext);
        TextView BodyGuard = (TextView) findViewById(R.id.BodyGuardText);
        info(BodyGuard,Bodyguardtext);
        TextView ProtectedDignitary = (TextView) findViewById(R.id.ProtectedDignitaryText);
        info(ProtectedDignitary,ProtectedDignitarytext);
        TextView Civilian = (TextView) findViewById(R.id.CivilanText);
        info(Civilian,Civiliantext);
        TextView Transient = (TextView) findViewById(R.id.TransientText);
        info(Transient,Transienttext);
        TextView BountyHunter = (TextView) findViewById(R.id.BountyHuntrText);
        info(BountyHunter,BountyHuntertext);
        TextView Negotiator = (TextView) findViewById(R.id.NegotiatoText);
        info(Negotiator,Negotiatortext);
        TextView Executioner = (TextView) findViewById(R.id.ExecutionerText);
        info(Executioner,Executionertext);
        TextView Interrogator = (TextView) findViewById(R.id.InterrogatorText);
        info(Interrogator,Interrogatortext);
        TextView SuicideBomber = (TextView) findViewById(R.id.SuicideBomberText);
        info(SuicideBomber,SuicideBombertext);
        TextView Detective = (TextView) findViewById(R.id.DetectiveText);
        info(Detective,Detectivetext);





    }


    public void info(TextView TV, final String info){
        TV.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                AlertDialog ad = new AlertDialog.Builder(RoleNumbering.this).create();
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

    public void minus(Button minus, final EditText changes, final EditText filled){
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

    public void plus(Button plus, final EditText changes, final EditText filled){
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

    //click listener for the roleconfirm button (declared in XLM)
    public void roleconfirm(View view){

        //getting the number of total players from shared preferences, saved in MainActivity
        SharedPreferences prefs = getSharedPreferences("Global", getApplicationContext().MODE_PRIVATE);
        int total = prefs.getInt("numberplayers", 0);


        //total roles is the number of roles in you have entered into the slots for this screen
        int totalroles = totalroles();

        //if your total number of player is equal to the number of roles you've assigned
        if(total== totalroles){
            Toast.makeText(getApplicationContext(), "we're good",
                    Toast.LENGTH_LONG).show();


            ArrayList<String> RolesSMS = new ArrayList<String>();
            String Detectivetext = "Detective: \n" +
                    "Mission: Find and hide with the witness\n" +
                    "Skill: You can talk to dead players to find out who they were and which player killed them (They have to tell you the truth). If playing in the dark, you may use a handheld light source. \n";
            String SuicideBombertext = "Suicide Bomber:\n" +
                    "Mission: Find and hide with the Witness.\n" +
                    "Skill: Sacrifice your life to kill another player by hugging them. All players within a 5 foot radius are also killed.\n";
            String Interrogatortext = "Interrogator:\n" +
                    "Mission: Find and hide with the Witness.\n" +
                    "Skill: Place your hand on another player’s shoulder to make them reveal their identity to you. They must be honest. You won’t die if you discover the Traitor this way. \n";
            String Executionertext = "Executioner:\n" +
                    "Mission: Find and hide with the witness\n" +
                    "Skill: You may kill one player during the game by running your hand across their neck\n";
            String Negotiatortext = "Negotiator:\n" +
                    "Mission: Find and hide with the Witness\n" +
                    "Skill: Permanently remove the Hostage Taker’s ability by grabbing their elbow. You can only do this while they have a hostage. You cannot use this ability while you are taken hostage. \n";
            String BountyHuntertext = "Bounty Hunter:\n" +
                    "Mission: Find and hide with the Witness\n" +
                    "Skill: You may kill once during the game. If you kill the Murderer, you will be the Witness in the next round.\n";
            String Transienttext = "Transient:\n" +
                    "Mission: Find and hide with the Witness.\n" +
                    "Skill: If you stay in place for longer than 15 seconds, you die.\n";
            String Civiliantext = "Civilian:\n" +
                    "Mission: Find and hide with the Witness\n" +
                    "Skill: Be creative -- not having extra abilities doesn’t mean you can’t be valuable to your team.\n";
            String ProtectedDignitarytext = "Protected Dignitary:\n" +
                    "Mission: Find and hide with the Witness\n" +
                    "Skill: You are immune to all negative effects aside from death. The player who kills you also dies. \n";
            String Bodyguardtext = "Bodyguard:\n" +
                    "Mission: Find and hide with the Witness.\n" +
                    "Skill: Sacrifice your own life to revive another player. Do this by drawing a cross on their arm.\n";
            String PoliceOfficertext = "Police Officer:\n" +
                    "Mission: Find and hide with the Witness\n" +
                    "Skill: Grab both wrists of another player to freeze them for 30 seconds (arrest them). You may only arrest each player once. You do not need to stay with the player while they are frozen.\n";
            String NeighborhoodWatchtext = "Neighborhood Watch:\n" +
                    "Mission: Find and hide with the Witness.\n" +
                    "Skill: The first player you make physical contact with dies, whether intentional or not.\n";
            String SWATtext = "SWAT:\n" +
                    "Mission: Find and hide with the Witness.\n" +
                    "Skill: If you witness a player die, you may kill the player who caused the death.\n";
            String Witnesstext = "Witness:\n" +
                    "Mission: Hide! If ⅓ the number of players joins you, all Good Characters win.\n" +
                    "Skill: If the murderers find you and kill you or time runs out all Bad Characters win. You will have a certain number of minutes to hide\n";
            String Handlertext = "Handler:\n" +
                    "Mission: Find and hide with the Witness.\n" +
                    "Skill: Before the Witness hides, reveal yourself as a Handler. Follow the Witness until they have hidden.  \n";
            String Doctortext = "Doctor:\n" +
                    "Mission: Find and hide with the Witness.\n" +
                    "Skill: You revive players by drawing a cross on their arms. You cannot use this ability while you are taken hostage. \n";
            String Moletext = "Mole:\n" +
                    "Mission: use your ability to get the Witness killed.\n" +
                    "Skill: Before the Witness hides, reveal yourself as a Handler. Follower the Witness until they have hidden. Return to Base before the game begins. \n";
            String Assassintext = "Assassin:\n" +
                    "Mission: Use your ability to get the Witness killed.\n" +
                    "Skill: Kill players by running your hand across their necks; then place your hand on the victim's shoulder to make them reveal their identity to you. You die if the player you killed was a Civilian, or if you do not check their identity. \n";
            String Lawyertext = "Lawyer:\n" +
                    "Mission: Use your ability to get the Witness killed.\n" +
                    "Skill: You can revive the Murderer by drawing a cross on their arm. You may only use this ability twice.\n";
            String Kingpintext = "Kingpin:\n" +
                    "Mission: Use your ability to get the Witness killed.\n" +
                    "Skill: If the Murderer dies, you become a new Murderer. If the Murderer or Assassin attempts to kill you, that player dies (you do not).\n";
            String Traitortext = "Traitor:\n" +
                    "Mission: Use your ability to get the Witness killed.\n" +
                    "Skill: Any player (Good or Evil) dies when they verbally reveal their identity to you, or when they ask you to reveal your identity.";
            String Blackmailertext = "Blackmailer:\n" +
                    "Mission: Use your ability to get the Witness killed.\n" +
                    "Skill: As long as you are touching the Witness, they cannot win the game\n";
            String Murderertext = "Murderer:\n" +
                    "Mission: Use your ability to get the Witness killed.\n" +
                    "Skill: Kill players by running your hand across their necks.\n";
            String HostageTakertext = "Hostage Taker:\n" +
                    "Mission: Use your ability to get the Witness killed.\n" +
                    "Skill: Grab a player’s elbow to hold them hostage. They must stay with you until you let go or until the Negotiator removes your ability. You may only hold one player at a time. \n";




            //checking every edit text and based on that number put, that many sets of the coresponding string into the
            //RolesSMS
            //this probably should have been a method
            EditText murderer =(EditText) this.findViewById(R.id.murderer);
            if(!(murderer.getText().toString().matches(""))){
                int Smurderer=Integer.parseInt(murderer.getText().toString());
                while(Smurderer!=0){
                    RolesSMS.add(Murderertext);
                    Smurderer--;
                }
            }
            EditText hostagetaker =(EditText) this.findViewById(R.id.hostagetaker);
            if(!(hostagetaker.getText().toString().matches(""))){
                int Shostagetaker=Integer.parseInt(hostagetaker.getText().toString());
                while(Shostagetaker!=0){
                    RolesSMS.add(HostageTakertext);
                    Shostagetaker--;
                }
            }
            EditText blackmailer =(EditText) this.findViewById(R.id.blackmailer);
            if(!(blackmailer.getText().toString().matches(""))){
                int Sblackmailer=Integer.parseInt(blackmailer.getText().toString());
                while(Sblackmailer!=0){
                    RolesSMS.add(Blackmailertext);
                    Sblackmailer--;
                }
            }
            EditText traitor =(EditText) this.findViewById(R.id.traitor);
            if(!(traitor.getText().toString().matches(""))){
                int Straitor=Integer.parseInt(traitor.getText().toString());
                while(Straitor!=0){
                    RolesSMS.add(Traitortext);
                    Straitor--;
                }
            }
            EditText assasin =(EditText) this.findViewById(R.id.assasin);
            if(!(assasin.getText().toString().matches(""))){
                int Sassasin=Integer.parseInt(assasin.getText().toString());
                while(Sassasin!=0){
                    RolesSMS.add(Assassintext);
                    Sassasin--;
                }
            }
            EditText kingpin =(EditText) this.findViewById(R.id.kingpin);
            if(!(kingpin.getText().toString().matches(""))){
                int Skingpin=Integer.parseInt(kingpin.getText().toString());
                while(Skingpin!=0){
                    RolesSMS.add(Kingpintext);
                    Skingpin--;
                }
            }
            EditText lawyer =(EditText) this.findViewById(R.id.lawyer);
            if(!(lawyer.getText().toString().matches(""))){
                int Slawyer=Integer.parseInt(lawyer.getText().toString());
                while(Slawyer!=0){
                    RolesSMS.add(Lawyertext);
                    Slawyer--;
                }
            }
            EditText mole =(EditText) this.findViewById(R.id.mole);
            if(!(mole.getText().toString().matches(""))){
                int Smole=Integer.parseInt(mole.getText().toString());
                while(Smole!=0){
                    RolesSMS.add(Moletext);
                    Smole--;
                }
            }

            EditText witness =(EditText) this.findViewById(R.id.witness);
            if(!(witness.getText().toString().matches(""))){
                int Switness=Integer.parseInt(witness.getText().toString());
                while(Switness!=0){
                    RolesSMS.add(Witnesstext);
                    Switness--;
                }
            }
            EditText handler =(EditText) this.findViewById(R.id.handler);
            if(!(handler.getText().toString().matches(""))){
                int Shandler=Integer.parseInt(handler.getText().toString());
                while(Shandler!=0){
                    RolesSMS.add(Handlertext);
                    Shandler--;
                }
            }
            EditText SWAT =(EditText) this.findViewById(R.id.SWAT);
            if(!(SWAT.getText().toString().matches(""))){
                int SSWAT=Integer.parseInt(SWAT.getText().toString());
                while(SSWAT!=0){
                    RolesSMS.add(SWATtext);
                    SSWAT--;
                }
            }
            EditText neighborhoodwatch =(EditText) this.findViewById(R.id.neighborhoodwatch);
            if(!(neighborhoodwatch.getText().toString().matches(""))){
                int Sneighborhoodwatch=Integer.parseInt(neighborhoodwatch.getText().toString());
                while(Sneighborhoodwatch!=0){
                    RolesSMS.add(NeighborhoodWatchtext);
                    Sneighborhoodwatch--;
                }
            }
            EditText police =(EditText) this.findViewById(R.id.police);
            if(!(police.getText().toString().matches(""))){
                int Spolice=Integer.parseInt(police.getText().toString());
                while(Spolice!=0){
                    RolesSMS.add(PoliceOfficertext);
                    Spolice--;
                }
            }
            EditText bodyguard =(EditText) this.findViewById(R.id.bodyguard);
            if(!(bodyguard.getText().toString().matches(""))){
                int Sbodyguard=Integer.parseInt(bodyguard.getText().toString());
                while(Sbodyguard!=0){
                    RolesSMS.add(Bodyguardtext);
                    Sbodyguard--;
                }
            }
            EditText protecteddignitary =(EditText) this.findViewById(R.id.protecteddignitary);
            if(!(protecteddignitary.getText().toString().matches(""))){
                int Sprotecteddignitary=Integer.parseInt(protecteddignitary.getText().toString());
                while(Sprotecteddignitary!=0){
                    RolesSMS.add(ProtectedDignitarytext);
                    Sprotecteddignitary--;
                }
            }
            EditText civilian =(EditText) this.findViewById(R.id.civilian);
            if(!(civilian.getText().toString().matches(""))){
                int Scivilian=Integer.parseInt(civilian.getText().toString());
                while(Scivilian!=0){
                    RolesSMS.add(Civiliantext);
                    Scivilian--;
                }
            }
            EditText trans =(EditText) this.findViewById(R.id.trans);
            if(!(trans.getText().toString().matches(""))){
                int Strans=Integer.parseInt(trans.getText().toString());
                while(Strans!=0){
                    RolesSMS.add(Transienttext);
                    Strans--;
                }
            }
            EditText bountyhunter =(EditText) this.findViewById(R.id.bountyhunter);
            if(!(bountyhunter.getText().toString().matches(""))){
                int Sbountyhunter=Integer.parseInt(bountyhunter.getText().toString());
                while(Sbountyhunter!=0){
                    RolesSMS.add(BountyHuntertext);
                    Sbountyhunter--;
                }
            }
            EditText negotiator =(EditText) this.findViewById(R.id.negotiator);
            if(!(negotiator.getText().toString().matches(""))){
                int Snegotiator=Integer.parseInt(negotiator.getText().toString());
                while(Snegotiator!=0){
                    RolesSMS.add(Negotiatortext);
                    Snegotiator--;
                }
            }
            EditText excecutioner =(EditText) this.findViewById(R.id.excecutioner);
            if(!(excecutioner.getText().toString().matches(""))){
                int Sexecutioner=Integer.parseInt(excecutioner.getText().toString());
                while(Sexecutioner!=0){
                    RolesSMS.add(Executionertext);
                    Sexecutioner--;
                }
            }
            EditText detective =(EditText) this.findViewById(R.id.detective);
            if(!(detective.getText().toString().matches(""))){
                int Sdetective=Integer.parseInt(detective.getText().toString());
                while(Sdetective!=0){
                    RolesSMS.add(Detectivetext);
                    Sdetective--;
                }
            }
            EditText doctor =(EditText) this.findViewById(R.id.doctor);
            if(!(doctor.getText().toString().matches(""))){
                int Sdoctor=Integer.parseInt(doctor.getText().toString());
                while(Sdoctor!=0){
                    RolesSMS.add(Doctortext);
                    Sdoctor--;
                }
            }
            EditText suicidebomber =(EditText) this.findViewById(R.id.suicidebomber);
            if(!(suicidebomber.getText().toString().matches(""))){
                int Ssuicidebomber=Integer.parseInt(suicidebomber.getText().toString());
                while(Ssuicidebomber!=0){
                    RolesSMS.add(SuicideBombertext);
                    Ssuicidebomber--;
                }
            }
            EditText interrogator =(EditText) this.findViewById(R.id.interrogator);
            if(!(interrogator.getText().toString().matches(""))){
                int Sinterrogator=Integer.parseInt(interrogator.getText().toString());
                while(Sinterrogator!=0){
                    RolesSMS.add(Interrogatortext);
                    Sinterrogator--;
                }
            }

            //parse the list into shared preferences
            SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor mEdit1 = sp.edit();

            mEdit1.putInt("Status_size", RolesSMS.size());

            for(int i=0;i<RolesSMS.size();i++)
            {
                mEdit1.remove("Status_" + i);
                mEdit1.putString("Status_" + i, RolesSMS.get(i));

            }

           mEdit1.commit();

            startActivity(new Intent(view.getContext(), SendingSMS.class));
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

    //passes in a string, if it has nothing in it, you pass back a zero, otherwise bass back the number
    public int checknull(String therolenumber){
        if(therolenumber.matches("")){
            return 0;
        }
        else{
           return Integer.parseInt(therolenumber);
        }
    }

    //goes through all the edit texts and returns the total number of roles chosen
    public int totalroles(){

        EditText murderer =(EditText) this.findViewById(R.id.murderer);
        EditText hostagetaker =(EditText) this.findViewById(R.id.hostagetaker);
        EditText blackmailer =(EditText) this.findViewById(R.id.blackmailer);
        EditText traitor =(EditText) this.findViewById(R.id.traitor);
        EditText assasin =(EditText) this.findViewById(R.id.assasin);
        EditText kingpin =(EditText) this.findViewById(R.id.kingpin);
        EditText lawyer =(EditText) this.findViewById(R.id.lawyer);
        EditText mole =(EditText) this.findViewById(R.id.mole);

        EditText witness =(EditText) this.findViewById(R.id.witness);
        EditText handler =(EditText) this.findViewById(R.id.handler);
        EditText SWAT =(EditText) this.findViewById(R.id.SWAT);
        EditText neighborhoodwatch =(EditText) this.findViewById(R.id.neighborhoodwatch);
        EditText police =(EditText) this.findViewById(R.id.police);
        EditText bodyguard =(EditText) this.findViewById(R.id.bodyguard);
        EditText protecteddignitary =(EditText) this.findViewById(R.id.protecteddignitary);
        EditText civilian =(EditText) this.findViewById(R.id.civilian);
        EditText trans =(EditText) this.findViewById(R.id.trans);
        EditText bountyhunter =(EditText) this.findViewById(R.id.bountyhunter);
        EditText negotiator =(EditText) this.findViewById(R.id.negotiator);
        EditText excecutioner =(EditText) this.findViewById(R.id.excecutioner);
        EditText detective =(EditText) this.findViewById(R.id.detective);
        EditText doctor =(EditText) this.findViewById(R.id.doctor);
        EditText suicidebomber =(EditText) this.findViewById(R.id.suicidebomber);
        EditText interrogator =(EditText) this.findViewById(R.id.interrogator);


        int totalroles =
                checknull(murderer.getText().toString())+
                checknull(hostagetaker.getText().toString())+
                checknull(blackmailer.getText().toString())+
                checknull(lawyer.getText().toString())+
                checknull(mole.getText().toString())+
                checknull(traitor.getText().toString())+
                checknull(kingpin.getText().toString())+
                checknull(assasin.getText().toString())+
                checknull(witness.getText().toString())+
                checknull(SWAT.getText().toString())+
                checknull(neighborhoodwatch.getText().toString())+
                checknull(handler.getText().toString())+
                checknull(police.getText().toString())+
                checknull(bodyguard.getText().toString())+
                checknull(protecteddignitary.getText().toString())+
                checknull(civilian.getText().toString())+
                checknull(bountyhunter.getText().toString())+
                checknull(trans.getText().toString())+
                checknull(negotiator.getText().toString())+
                checknull(excecutioner.getText().toString())+
                checknull(detective.getText().toString())+
                checknull(doctor.getText().toString())+
                checknull(suicidebomber.getText().toString())+
                checknull(interrogator.getText().toString());

        return totalroles;
    }
}

