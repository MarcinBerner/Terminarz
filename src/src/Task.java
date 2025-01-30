package src;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author marci
 */
public class Task {
    public Task(String dateString, String taskText)
    {
        this.taskText = taskText;
        this.dateString = dateString;
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy hh:mm");
         try {
            date = formatter.parse(dateString);
        } catch (ParseException ex) {
            Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    String getTaskText(){
        return taskText;
    }
    String getDateString(){
        return dateString;
    }
    Date getDate(){
        return date;
    }
    String taskText;
    String dateString;
    Date date;
}
