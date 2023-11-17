package com.marcin.xmlparse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class MainActivity extends AppCompatActivity {

    List<XMLValuesModel> myData = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView output = (TextView) findViewById(R.id.textView);
        final Button bparsexml = (Button) findViewById(R.id.button);
        final String XMLData = "<?xml version=\"1.0\"?><login><status>OK</status><jobs><job><id>4</id><company_id>44</company_id><company>Android Corp</company><address>adres 1</address><city>Tokyo</city><state>Tokyo Dep</state> <postal_code>44444</postal_code><country>Japan</country><telephone>5454534543</telephone><fax>545454</fax><date>2016-10-10</date></job> <job><id>45</id><company_id>11</company_id><company>IOS Corp</company><address>adres 2</address><city>Sacramento</city><state>California</state><postal_code>222111</postal_code><country>USA</country><telephone>43333</telephone><fax>1111</fax><date>2016-10-21</date></job></jobs></login>";

        output.setText(XMLData);

        bparsexml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    BufferedReader br = new BufferedReader(new StringReader(XMLData));
                    InputSource is = new InputSource(br);
                    XMLParser parser = new XMLParser();

                    SAXParserFactory factory = SAXParserFactory.newInstance();

                    SAXParser sp = factory.newSAXParser();
                    XMLReader reader = sp.getXMLReader();
                    reader.setContentHandler(parser);
                    reader.parse(is);
                    myData = parser.list;

                    if(myData!=null)
                    {
                        String OutputData = "";
                        for(XMLValuesModel xmlRowData: myData){
                            if(xmlRowData!=null){
                                int id = xmlRowData.getId();
                                int companyid = xmlRowData.getCompany_id();
                                String company = xmlRowData.getCompany();
                                String address = xmlRowData.getAddress();
                                String city = xmlRowData.getCity();
                                String state = xmlRowData.getState();
                                String zipcode = xmlRowData.getZipcode();
                                String country = xmlRowData.getCountry();
                                String telephone = xmlRowData.getTelephone();
                                String date = xmlRowData.getDate();

                                OutputData += "Pola danych:\n\n" + company + " | " +
                                        address + " | " +
                                        city + " | " +
                                        state + " | " +
                                        zipcode + " | " +
                                        country + " | " +
                                        telephone + " | " +
                                        date + " | \n\n";

                            }
                            else {
                                output.setText("brak danych");
                            }
                            output.setText(OutputData);
                        }
                    }

                } catch (ParserConfigurationException e) {
                    throw new RuntimeException(e);
                } catch (SAXException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
