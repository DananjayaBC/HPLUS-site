package com.test.hplusapp.convertors;

import com.test.hplusapp.beans.Gender;
import org.springframework.core.convert.converter.Converter;

public class StringToEnumConvertor implements Converter<String, Gender>{

    @Override
    public Gender convert(String s) {
       if(s.equals("Male")){
           return Gender.MALE;
       }
       else if (s.equals("Female")){
           return Gender.FEMALE;
       }
       else {
           return Gender.OTHER;
       }
    }
}
