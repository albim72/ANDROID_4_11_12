package com.marcin.sqlitecontact;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView txt = (TextView) findViewById(R.id.outputTV);
        DatabaseHandler db = new DatabaseHandler(this);

        db.addContact(new Contact("Robert","544222445"));
        db.addContact(new Contact("Olaf","599222445"));
        db.addContact(new Contact("Nora","546222445"));
        db.addContact(new Contact("Maria","523222445"));
        db.addContact(new Contact("Nadia","589222445"));
        db.addContact(new Contact("Piotr","500222445"));
        db.addContact(new Contact("Marta","513222445"));

        txt.setText("Czytani: czytanie wszystkich kontaktów");
        List<Contact> contacts = db.getAllContacts();

        for (Contact cn:contacts){
            String log = "ID: " + cn.getId() +", imię: " + cn.getName() + ", telefon: " + cn.getPhone()
                    + "\n\r";
            txt.setText(txt.getText() + "\nkontakty: " + log);
        }
    }
}
