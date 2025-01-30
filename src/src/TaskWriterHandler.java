package src;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class TaskWriterHandler{
    private TaskWriterHandler(){
        this.taskTekst = " ";
        this.date = new GregorianCalendar().getTime();
    }
     public TaskWriterHandler(String taskTekst, Date date){
        this(); 
        try{
        PrintWriter taskWriter = new PrintWriter (new BufferedWriter(new FileWriter("db" + File.separator + "db.txt", true)));
        this.taskTekst = taskTekst;
        this.date = date;
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy hh:mm");
        taskWriter.write(formatter.format(date) + "|" + taskTekst + "|");
        taskWriter.println();
        taskWriter.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
        public static void deleteTask(String date, String task, File f)
        {
            String lineToRemove = date + "|" + task + "|";
            StringBuilder sb = new StringBuilder();
            try (Scanner sc = new Scanner(f))
            {
                String currentLine;
                while(sc.hasNext())
                {
                    currentLine = sc.nextLine();
                    if(currentLine.equals(lineToRemove))
                        {
                        continue; //skips lineToRemove
                        }
                sb.append(currentLine).append("\n");
                }
                
              //Delete File Content
                PrintWriter pw = new PrintWriter(f);
                pw.close();                
                BufferedWriter writer = new BufferedWriter(new FileWriter(f, true));
                writer.append(sb.toString());
                writer.close();
             }
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        } 
    private String taskTekst;
    private Date date;
    private String dateString;
}
