package org.taskManager.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class DateService {
    private Date date = new Date();

    public String getDay(){
        String [] arr = {"понедельник","вторник","среда","четверг","пятница","суббота","воскресенье"};
        List<String> days = Arrays.asList(arr);
        return days.get(date.getDay());
    }

    public int getDate(){
        return date.getDate();
    }

    public String getMonth(){
        String [] arr = {"января", "февраль","марта","апреля", "мая","июня","июля","августа","сентабря","октября","ноября","декабря"};
        List<String> months = Arrays.asList(arr);
        return months.get(date.getMonth());
    }
}
