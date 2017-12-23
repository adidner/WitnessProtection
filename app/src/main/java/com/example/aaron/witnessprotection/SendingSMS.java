package com.example.aaron.witnessprotection;

import android.Manifest;
import android.app.Application;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.InputFilter;
import android.text.InputType;
import android.text.format.DateFormat;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TimePicker;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SendingSMS extends AppCompatActivity {

    //List<EditText> editTextList = new ArrayList<EditText>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sending_sms);


        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        SharedPreferences prefs = getSharedPreferences("Global", getApplicationContext().MODE_PRIVATE);
        final int total = prefs.getInt("numberplayers", 0);

        //the edittext array
        final EditText[] storage = new EditText[total];

        final EditText[] names = new EditText[total];

        //permission to access sending messages
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 1);

        //initializing buttons
        Button save = (Button) this.findViewById(R.id.save);
        Button load = (Button) this.findViewById(R.id.load);
        Button search = (Button) this.findViewById(R.id.digcontacts);
        Button gameover = (Button) this.findViewById(R.id.gameover);

        TableLayout SMS = (TableLayout) findViewById(R.id.layoutSMS);

        //creating a bunch of edit texts for contacts based on the number of players
        for (int i = 0; i < total; i++) {


            TableRow row = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);


            names[i] = new EditText(this);
            names[i].setHint("Player Name");

            names[i].setFilters(new InputFilter[]{new InputFilter.LengthFilter(10)});
            //names[i].setWidth(600);
            row.addView(names[i]);


            EditText blankedittext = new EditText(this);
            //blankedittext.setId(0);
            blankedittext.setHint("Phone Number, no dashes");
            blankedittext.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_CLASS_NUMBER);

            blankedittext.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});

            //blankedittext.setWidth(800);

            storage[i] = blankedittext;

            row.addView(blankedittext);


//            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

//            SMS.addView(blankedittext, lp);

            SMS.addView(row, i);

        }

        //looking to see if I manipulated the storage size from the initially set value of 0
        //So if its been manipulated I just came back from the search screen and I need to put saved values back into the
        //table
        SharedPreferences mSharedPreference1 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        if (mSharedPreference1.getInt("Storage_size", 0) != 0) {

            int size = mSharedPreference1.getInt("Storage_size", 0);

            for (int i = 0; i < size; i++) {
                storage[i].setText(mSharedPreference1.getString("Storage_" + i, null));
                names[i].setText(mSharedPreference1.getString("StorageN_" + i, null));
            }

        }

        //same as before but in respect to the number you searched for
        SharedPreferences mSharedPreference2 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        if (mSharedPreference2.getInt("SearchExist", 0) == 1 && mSharedPreference2.getInt("SearchNameE", 0) == 1) {
            boolean once = false;
            for (int i = 0; i < storage.length; i++) {
                if (storage[i].getText().toString().matches("") && once == false && names[i].getText().toString().matches("")) {
                    String phonenumber = (mSharedPreference2.getString("SearchNumber", null).replaceAll("[^\\d.]", ""));
                    String phonename = (mSharedPreference2.getString("SearchName", null));

                    Toast.makeText(getApplicationContext(), phonenumber + "::this one",
                            Toast.LENGTH_LONG).show();

                    Toast.makeText(getApplicationContext(), phonename,
                            Toast.LENGTH_LONG).show();


                    if (phonenumber.charAt(0) == '1') {
                        phonenumber = phonenumber.substring(1);
                        //phonenumber.replaceFirst("1","");
                        storage[i].setText(phonenumber);
                        once = true;
                    } else {
                        storage[i].setText(phonenumber);
                        once = true;
                    }

                    names[i].setText(phonename);
                }
            }
        }


        //send text button
        Button sendtext = (Button) findViewById(R.id.sendtext);

        final EditText hideTime = (EditText) this.findViewById(R.id.editText4);
        final EditText gameTime = (EditText) this.findViewById(R.id.editText3);
        final EditText hideSec = (EditText) this.findViewById(R.id.editText);
        final EditText gameSec = (EditText) this.findViewById(R.id.editText2);


        assert sendtext != null;
        //click listener for sedn text button
        sendtext.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        boolean cont = true;

                        if (cont == true) {
                            //check if every spot has numbers
                            int counter = 0;

                            //editing input for dashes
                            int toshort = 0;

                            if (toshort > 0) {
                                Toast.makeText(getApplicationContext(), "One of you numbers is to short",
                                        Toast.LENGTH_LONG).show();
                            }
                            if (toshort == 0 && counter == 0) {

                                //get out the array (parse) from shared preferences
                                ArrayList<String> RolesSMS = new ArrayList<String>();
                                SharedPreferences mSharedPreference1 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                                RolesSMS.clear();
                                int size = mSharedPreference1.getInt("Status_size", 0);

                                for (int i = 0; i < size; i++) {
                                    RolesSMS.add(mSharedPreference1.getString("Status_" + i, null));
                                }

                                //randomizes contents of my arraylist (RolesSMS)
                                Collections.shuffle(RolesSMS);

                                //sending multipart messages for each of the strings in the sending message array
                                try {
                                    int notfilled = 0;
                                    for (int i = 0; i < total; i++) {
                                        SmsManager manager = SmsManager.getDefault();
                                        //divides messages into text message size and puts them in an array for sending multipart messages
                                        //Toast.makeText(getApplicationContext(), storage[i].getText().toString(), Toast.LENGTH_LONG).show();
                                        if (storage[i].getText().toString().trim().length() != 0) {
                                            ArrayList<String> sendingpart = manager.divideMessage(RolesSMS.get(i));
                                            manager.sendMultipartTextMessage(storage[i].getText().toString(), null, sendingpart, null, null);
                                        } else {
                                            notfilled++;
                                        }
                                    }
                                    if (notfilled > 0) {
                                        Toast.makeText(getApplicationContext(), "Some of your contact numbers aren't filled, Just FYI",
                                                Toast.LENGTH_LONG).show();
                                    }
                                    Toast.makeText(getApplicationContext(), "we good",
                                            Toast.LENGTH_LONG).show();
                                } catch (Exception e) {
                                    Toast.makeText(getApplicationContext(), "failed",
                                            Toast.LENGTH_LONG).show();
                                    e.printStackTrace();
                                }
                            }


                            //Fix timer stuff to use both edit texts


                            if (!(gameSec.getText().toString().matches("")&&gameTime.getText().toString().matches(""))) {


                                new CountDownTimer((Integer.parseInt(gameSec.getText().toString()) * 1000) + (Integer.parseInt(gameTime.getText().toString()) * 1000 * 60), 1000) {

                                    public void onTick(long millisUntilFinished) {
                                        //gameTime.setText("Time: " + millisUntilFinished / 1000);
                                        //int hideSecInt = Integer.parseInt(hideSec.getText().toString());
                                        //int hideMinInt = Integer.parseInt(hideTime.getText().toString());
                                        int gameSecInt = Integer.parseInt(gameSec.getText().toString());
                                        int gameMinInt = Integer.parseInt(gameTime.getText().toString());

                                        if (gameSecInt == 0 && gameMinInt > 0) {
                                            gameSecInt = 59;
                                            gameMinInt--;

                                        } else if (gameSecInt > 0) {
                                            gameSecInt--;
                                        } else if (gameSecInt == 0 && gameMinInt == 0) {

                                            //potential finsih condition

                                            //hideTime.setText("Min: " + );
                                            //hideSec.setText("Sec: " + );

                                        }

                                        gameTime.setText(Integer.toString(gameMinInt));
                                        gameSec.setText(Integer.toString(gameSecInt));

                                    }

                                    public void onFinish() {
                                        gameTime.setText("done!");
                                    }
                                }.start();
                            }

                            if( !(hideSec.getText().toString().matches("")&&hideTime.getText().toString().matches("")) ) {

                                new CountDownTimer((Integer.parseInt(hideSec.getText().toString()) * 1000) + (Integer.parseInt(hideTime.getText().toString()) * 1000 * 60), 1000) {

                                    public void onTick(long millisUntilFinished) {
                                        //gameTime.setText("Time: " + millisUntilFinished / 1000);
                                        int hideSecInt = Integer.parseInt(hideSec.getText().toString());
                                        int hideMinInt = Integer.parseInt(hideTime.getText().toString());

                                        if (hideSecInt == 0 && hideMinInt > 0) {
                                            hideSecInt = 59;
                                            hideMinInt--;

                                        } else if (hideSecInt > 0) {
                                            hideSecInt--;
                                        } else if (hideSecInt == 0 && hideMinInt == 0) {

                                            //potential finsih condition

                                        }

                                        hideTime.setText(Integer.toString(hideMinInt));
                                        hideSec.setText(Integer.toString(hideSecInt));

                                    }

                                    public void onFinish() {
                                        hideTime.setText("done!");
                                    }
                                }.start();

                            }
                        }
                    }
                }

        );


        assert save != null;
        //save button click listener
        save.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {

                //this may not work but we'll see. I'm gonna try recursively adding to the text file. It might just override it though.
                //The easy fix if it overrides is to change the thing so every file has a name that ends in the number i
                //I'll be able to read them all in one file at a time then
                //alternatley I can parse it and then deparse it upon loading

//                for(int i =0; i<total; i++) {
//                    try {
//                        FileOutputStream fileOutputStream = openFileOutput("contacts", MODE_PRIVATE);
//                        fileOutputStream.write(storage[i].getText().toString().getBytes());
//                        fileOutputStream.close();
//
//                    } catch (FileNotFoundException e) {
//                        e.printStackTrace();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//                Toast.makeText(getApplicationContext(), "Messages Saved",
//                        Toast.LENGTH_LONG).show();

                if (!(storage[0].getText().toString().matches("") || names[0].getText().toString().matches(""))) {
                    String longstorage = new String();
                    longstorage = storage[0].getText().toString();

                    String namestorage;
                    namestorage = names[0].getText().toString();

                    //when you save it, you put it all into a super huge string seperated by commas
                    for (int i = 1; i < total; i++) {
                        longstorage = longstorage + "," + storage[i].getText().toString();
                        namestorage = namestorage + "," + names[i].getText().toString();
                    }


                    //saving the string in internal storage
                    try {
                        FileOutputStream fileOutputStream = openFileOutput("contacts", MODE_PRIVATE);
                        fileOutputStream.write(longstorage.getBytes());
                        fileOutputStream.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
                        FileOutputStream fileOutputStream = openFileOutput("contactsName", MODE_PRIVATE);
                        fileOutputStream.write(namestorage.getBytes());
                        fileOutputStream.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Toast.makeText(getApplicationContext(), "Messages Saved",
                            Toast.LENGTH_LONG).show();
                }

            }
        });

        //load click listener
        assert load != null;
        load.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                //load the contact string out of interal storage
                try {
                    String Message;
                    final String longmessage;
                    FileInputStream fileInputStream = openFileInput("contacts");
                    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    StringBuffer stringBuffer = new StringBuffer();
                    while ((Message = bufferedReader.readLine()) != null) {
                        stringBuffer.append(Message + "\n");
                    }
                    longmessage = stringBuffer.toString();
                    Toast.makeText(getApplicationContext(), longmessage,
                            Toast.LENGTH_LONG).show();


                    String namemessage;
                    final String longname;
                    FileInputStream fileInputStream2 = openFileInput("contactsName");
                    InputStreamReader inputStreamReader2 = new InputStreamReader(fileInputStream2);
                    BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader2);
                    StringBuffer stringBuffer2 = new StringBuffer();
                    while ((Message = bufferedReader2.readLine()) != null) {
                        stringBuffer2.append(Message + "\n");
                    }
                    namemessage = stringBuffer2.toString();
                    Toast.makeText(getApplicationContext(), namemessage,
                            Toast.LENGTH_LONG).show();

                    //split the long message into a bunch of individual strings and put them into an array
                    final List<String> menuitems = Arrays.asList(longmessage.split("\\s*,\\s*"));
                    final List<String> menunames = Arrays.asList(namemessage.split("\\s*,\\s*"));
                    ArrayList<String> Trueitems = new ArrayList<String>();

                    //making a true set of items by combinging the names and numbers
                    for (int i = 0; i < menuitems.size(); i++) {
                        Trueitems.add((menunames.get(i)) + ',' + (menuitems.get(i)));
                    }


                    //declare a popup menu
                    final PopupMenu loadmenu = new PopupMenu(getApplicationContext(), v);

                    //add the strings to the popup menu and make them checkable
                    ArrayList<Integer> itemID = new ArrayList<Integer>();
                    for (int i = 0; i < menuitems.size(); i++) {
                        loadmenu.getMenu().add(i, i, i, Trueitems.get(i)).setCheckable(true);
                        itemID.add(i);
                    }

                    //setting the click listeners for the loading popup menu
                    for (int i = 0; i < menuitems.size(); i++) {


                        loadmenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(final MenuItem item) {
                                //check it or uncheck it based on state
                                item.setChecked(!item.isChecked());

                                //make the menu stay open after a single click
                                item.setShowAsAction(MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW);
                                item.setActionView(new View(getApplicationContext()));
                                item.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {
                                    @Override
                                    public boolean onMenuItemActionExpand(MenuItem item) {
                                        return false;
                                    }

                                    @Override
                                    public boolean onMenuItemActionCollapse(MenuItem item) {
                                        return false;
                                    }
                                });


                                return false;
                            }


                        });


                    }


                    //when you dissmiss or click of the menu
                    loadmenu.setOnDismissListener(new PopupMenu.OnDismissListener() {
                        @Override
                        public void onDismiss(PopupMenu menu) {


                            ArrayList<String> Checked = new ArrayList<String>();

                            //if the item is checked add the number to the Checked array
                            for (int i = 0; i < menuitems.size(); i++) {
                                if (loadmenu.getMenu().getItem(i).isChecked()) {
                                    Checked.add(loadmenu.getMenu().getItem(i).getTitle().toString());
                                }
                            }


                            int spot = 0;

                            //go through the array and put the number into any blank spot in the edittext array (called storage)
//                                for(int i =0; i<storage.length || 1<=(Checked.size()); i++){
//                                    if (storage[i].getText().toString().matches("")) {
//                                        if(Checked.size()!=0) {
//                                            storage[i].setText(Checked.get(spot));
//                                            Checked.remove(spot);
//                                        }
//                                    }
//                                }


                            if (Checked.isEmpty() == false) {
                                int i = 0;
                                boolean once = true;
                                do {

                                    List<String> temp = Arrays.asList(Checked.get(i).split("\\s*,\\s*"));

                                    for (int a = 0; a < storage.length; a++) {
                                        if (storage[a].getText().toString().matches("") && names[a].getText().toString().matches("") && once == true) {
                                            names[a].setText(temp.get(0));
                                            storage[a].setText(temp.get(1));
                                            once = false;
                                            //temp.clear();
                                        }
                                    }
                                    once = true;
                                    i++;

                                } while (i < Checked.size());


                            }

                        }
                    });


                    loadmenu.show();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        //search click listener
        assert search != null;
        search.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {

                //saving everything in the edittext into shared preferences
                SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor mEdit1 = sp.edit();

                mEdit1.putInt("Storage_size", storage.length);

                for (int i = 0; i < storage.length; i++) {
                    mEdit1.remove("Storage_" + i);
                    mEdit1.putString("Storage_" + i, storage[i].getText().toString());

                    mEdit1.remove("StorageN_" + i);
                    mEdit1.putString("StorageN_" + i, names[i].getText().toString());
                }

                mEdit1.commit();

                //starting the contactdig activity
                startActivity(new Intent(getApplicationContext(), Contactdig.class));
                finish();


                //When they type in a letter change your filter and dump all results into the list view
                //When they click on an item, For loop through contacts for a match, take that moblie number and save it
                //recreate the Sending SMS activity, and throw the mobile number into the first empty spot

            }
        });


        assert gameover != null;
        gameover.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                try {

                    hideTime.setText(Integer.toString(0));
                    hideSec.setText(Integer.toString(0));
                    gameTime.setText(Integer.toString(0));
                    gameSec.setText(Integer.toString(0));

                    for (int i = 0; i < total; i++) {
                        SmsManager manager = SmsManager.getDefault();
                        manager.sendTextMessage(storage[i].getText().toString(), null, "The Game of Witness Protection is over.", null, null);
                    }




                    Toast.makeText(getApplicationContext(), "we good",
                            Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "failed",
                            Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });


    }

    public void digcontacts(View view) {


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.isChecked()) {
            item.setChecked(false);

        } else if (!(item.isChecked())) {
            item.setChecked(true);
        }
        return true;
    }


//    @Override
//    public void onBackPressed(){
//
//        startActivity(new Intent(getApplicationContext(), RoleNumbering.class));
//
//    }


    public int checknull(String therolenumber) {
        if (therolenumber.matches("")) {
            return 0;
        } else {
            return Integer.parseInt(therolenumber);
        }
    }

    public void sendtext(View view) {


    }

    public void create(int total, int counter, List<EditText> editTextList) {
        if (total == counter) {
            //we're done

        } else {
            EditText blankedittext = new EditText(this);
            //blankedittext.setId(0);
            blankedittext.setHint("Phone Number");
            blankedittext.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_CLASS_NUMBER);

            //storage[counter] = blankedittext;
            editTextList.add(blankedittext);

            LinearLayout SMS = (LinearLayout) findViewById(R.id.layoutSMS);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            //lp.addRule(RelativeLayout.BELOW, ID--);

            SMS.addView(blankedittext, lp);

            create(total, counter++, editTextList);
        }
    }







}
