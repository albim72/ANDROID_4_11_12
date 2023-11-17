package com.marcin.xmlparse;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class XMLParser extends DefaultHandler {
    List<XMLValuesModel> list = null;
    StringBuilder builder;
    XMLValuesModel jobsValues = null;

    @Override
    public void startDocument() throws SAXException {
        list = new ArrayList<XMLValuesModel>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        builder = new StringBuilder();

        if (localName.equals("login")) {
        } else if (localName.equals("status")) {
        } else if (localName.equals("jobs")) {
        } else if (localName.equals("job")) {
            jobsValues = new XMLValuesModel();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if(localName.equals("job")){
            list.add(jobsValues);
        }
        else if(localName.equalsIgnoreCase("status")){

        }
        else if(localName.equalsIgnoreCase("id")){
            jobsValues.setId(Integer.parseInt(builder.toString()));
        }
        else if(localName.equalsIgnoreCase("companyid")){
            jobsValues.setCompany_id(Integer.parseInt(builder.toString()));
        }
        else if(localName.equalsIgnoreCase("company")){
            jobsValues.setCompany(builder.toString());
        }
        else if(localName.equalsIgnoreCase("address")){
            jobsValues.setAddress(builder.toString());
        }
        else if(localName.equalsIgnoreCase("city")){
            jobsValues.setCity(builder.toString());
        }
        else if(localName.equalsIgnoreCase("state")){
            jobsValues.setState(builder.toString());
        }
        else if(localName.equalsIgnoreCase("zipcode")){
            jobsValues.setZipcode(builder.toString());
        }
        else if(localName.equalsIgnoreCase("country")){
            jobsValues.setCountry(builder.toString());
        }
        else if(localName.equalsIgnoreCase("telephone")){
            jobsValues.setTelephone(builder.toString());
        }
        else if(localName.equalsIgnoreCase("date")){
            jobsValues.setDate(builder.toString());
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        String tempString = new String(ch,start,length);
        builder.append(tempString);
    }
}
