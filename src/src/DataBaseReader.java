package src;

import java.io.*;
import java.util.*;
public class DataBaseReader {
    DataBaseReader(){
        
    }
    public Task[] readTasks(BufferedReader inS){
        
        int lenght = (int) this.getLines();
        Task[] tasks = new Task[lenght];
        System.out.println(tasks.length);
        for(int i = 0; i < tasks.length; i++)
        {
            try {
                String line = inS.readLine();
                StringTokenizer tokens = new StringTokenizer(line, "|");
                this.dateString = tokens.nextToken();
                this.taskText = tokens.nextToken();
                tasks[i] = new Task(dateString, taskText);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            
        }
        return tasks;
    }
    int getLines(){
        int linesNumber = 0;
        try{
            
            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("db" + File.separator + "db.txt"));
            lineNumberReader.skip(Integer.MAX_VALUE);
            linesNumber = lineNumberReader.getLineNumber();
            lineNumberReader.close();

        }
        catch(IOException e){
            e.printStackTrace();
        }
        return linesNumber;
    }
    private String taskText;
    private String dateString;
    
}
