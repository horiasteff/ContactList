package ro.jademy.contactlist.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateInputImpl implements ValidateInput {

    @Override
    public boolean validatePhoneNumber(String number) {
        Pattern p = Pattern.compile("(0)?[7][0-9]{8}");
        Matcher m = p.matcher(number);
        return (m.find() && m.group().equals(number));
    }

}
