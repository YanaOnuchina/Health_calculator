package hc.model;

import java.util.*;
import java.text.*;

public class DateTest {
    public static void main(String[] args){
        Calendar calendar = new GregorianCalendar();
        java.util.Date date = calendar.getTime();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy HH:mm");
    }
}
