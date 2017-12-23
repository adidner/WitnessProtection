package com.example.aaron.witnessprotection;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.preference.PreferenceManager;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Contactdig extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactdig);


        //permission to read from contacts
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_CONTACTS},1);

        //array of items (they will go into the listview)
        final ArrayList<String> items = new ArrayList<String>();

        //array adapter for the listview
        final ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.listitem, R.id.itemtextview, items);

        //initializing the listview and adapter
        final ListView listview = (ListView) findViewById(R.id.contactlistview);
        listview.setAdapter(adapter);

        //the edittext where the user will enter the name of the person
        final EditText name = (EditText) findViewById(R.id.Name);

        //text change listener
        name.addTextChangedListener(new TextWatcher() {
                                        @Override
                                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                                        }

                                        @Override
                                        public void onTextChanged(CharSequence s, int start, int before, int count) {


                                            //clear the item array
                                            items.clear();

                                            //look through the contacts for any name that contains the same letter and add those to the item array
                                            ContentResolver resolver = getContentResolver();

                                            CharSequence filter;
                                            filter = name.getText().toString();

                                            Cursor cursor = resolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);

                                            while(cursor.moveToNext()){
                                                String contactname = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                                                if(contactname.contains(filter)) {
                                                    items.add(contactname);
                                                }
                                                else if((contactname.toLowerCase()).contains(filter)){//case for lower case
                                                    items.add(contactname);
                                                }
                                                else if((contactname.toUpperCase()).contains(filter)){//case for uppercase letter
                                                    items.add(contactname);
                                                }
                                            }
                                            listview.setAdapter(adapter);
                                            Toast.makeText(getApplicationContext(), "a letter change",
                                                    Toast.LENGTH_LONG).show();

                                        }

                                        @Override
                                        public void afterTextChanged(Editable s) {
                                            //after the text is changed


                                        }
                                    }


        );





        //on item click listener
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //get the string name
                String itemname = (String) parent.getItemAtPosition(position);

                Toast.makeText(getApplicationContext(), "click recieved"+":"+itemname,
                        Toast.LENGTH_LONG).show();


                SharedPreferences sps = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor mEdit2 = sps.edit();

                mEdit2.putInt("SearchNameE", 1);
                mEdit2.putString("SearchName", itemname);


                mEdit2.commit();


                ContentResolver resolver  = getContentResolver();
                Cursor cursor = resolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);


                //look through contacts for the same name and then for the coresponding number
                //save the number in shared preferences
                while(cursor.moveToNext()){
                    String ID  = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                    String comparename = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));




                        //while(phonecursor.moveToNext()){
                        if(itemname.equals(comparename)){

                            Cursor phonecursor = resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?", new String[]{ ID }, null);

                            while(phonecursor.moveToNext()) {
                                String phonenumber = phonecursor.getString(phonecursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));


                                Toast.makeText(getApplicationContext(), phonenumber,
                                        Toast.LENGTH_LONG).show();

                                //Save the phone number, in shared preferences
                                SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                                SharedPreferences.Editor mEdit1 = sp.edit();

                                mEdit1.putInt("SearchExist", 1);
                                    mEdit1.putString("SearchNumber", phonenumber);


                                mEdit1.commit();

                                //Then start sendingSMS activity
                                startActivity(new Intent(view.getContext(), SendingSMS.class));
                                finish();

                            }
                        }

                }

            }
        });

        /*TextWatcher autoFill = new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //clear the item array
                items.clear();

                //look through the contacts for any name that contains the same letter and add those to the item array
                ContentResolver resolver = getContentResolver();

                CharSequence filter=null;
                filter = name.getText().toString();

                Cursor cursor = resolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);

                while(cursor.moveToNext()){
                    String contactname = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                    if(contactname.contains(filter)) {
                        items.add(contactname);
                    }
                    else if((contactname.toLowerCase()).contains(filter)){//case for lower case
                        items.add(contactname);
                    }
                    else if((contactname.toUpperCase()).contains(filter)){//case for uppercase letter
                        items.add(contactname);
                    }
                }

                Toast.makeText(getApplicationContext(), "a letter change",
                        Toast.LENGTH_LONG).show();
            }


        };
        name.addTextChangedListener(autoFill);*/


        /*name.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //clear the item array
                items.clear();

                //look through the contacts for any name that contains the same letter and add those to the item array
                ContentResolver resolver = getContentResolver();

                CharSequence filter;
                filter = name.getText().toString();

                Cursor cursor = resolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);

                while(cursor.moveToNext()){
                    String contactname = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                    if(contactname.contains(filter)) {
                        items.add(contactname);
                    }
                    else if((contactname.toLowerCase()).contains(filter)){//case for lower case
                        items.add(contactname);
                    }
                    else if((contactname.toUpperCase()).contains(filter)){//case for uppercase letter
                        items.add(contactname);
                    }
                }

                Toast.makeText(getApplicationContext(), "a letter change",
                        Toast.LENGTH_LONG).show();
                return false;
            }
        });*/

    }


}
