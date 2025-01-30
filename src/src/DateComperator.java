package src;

import java.util.Comparator;
import java.util.Date;


public class DateComperator implements Comparator<Date>{

    @Override
    public int compare(Date o1, Date o2) {
        int result = o1.compareTo(o2);
        
        return result;
    }
    
}
