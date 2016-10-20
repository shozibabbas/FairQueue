/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fairqueue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/**
 *
 * @author Sayyed Shozib Abbas
 */
public class FairQueue {

    public static LinkedList<String> priorityTable;
    public static LinkedList<activity> activities;
    public static LinkedList<csvFile> parsedData; // contains all the csv data
    
    //implementation of lab task 1 and 2
    public static void csvParser() throws ParseException {
        String fileName = "E:\\academic_schedule.csv";
        String colSplit = ",";
        String lineSplit = "";
        String line = null;
                
        System.out.println("Initializing Data...");
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            int i = 0;
            
            while ((line = br.readLine()) != null) {
                
                if(i < 1)
                {
                    i++;
                    continue;
                }
                
                String[] row = line.split(colSplit);
                
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                Date sDate = dateFormat.parse(row[0]);
                Date eDate = dateFormat.parse(row[1]);
                
                csvFile temp = new csvFile(sDate, eDate, row[2]);
                
                parsedData.add(temp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Data Initialization Completed...");
    }
    
    public static void generatePriorityTable() {
        Set<String> activityNames = new HashSet<String>();
        for(int i = 0; i < parsedData.size(); i++) {
            activityNames.add(parsedData.get(i).activity);
        }
        
        System.out.println(activityNames);
        
        for (Iterator<String> it = activityNames.iterator(); it.hasNext(); )
        {
            String a = it.next();
            switch(a) {
                case "New User Registration":
                    System.out.println(a);
                break;
                case "Lab Task Upload(5pm)":
                break;
                case "Course Registration":
                break;  
                case "Lecture Preparation":
                break;  
                case "Data Backup(3am-4am)":
                break;  
                case "Assignment Upload":
                break;  
                case "Lecture Download":
                break;  
                case "Assignment Submission(12am)":
                break;  
                case "Assignment Grading":
                break;  
                case "Quiz Grading":
                break;  
                case "Final Grading":
                break;  
                case "1st Student Feedback":
                break;  
                case "2nd Student Feedback":
                break;  
                case "ESE GuideLine Update":
                break;  
                case "Student Result Comments":
                break;  
                case "Project Submission(12am)":
                break;  
                case "Project Grading":
                break; 
                case "Data Backup(1am-2am)":
                break; 
                case "Project Upload Link Creation":
                break; 
                case "Maintenance":
                break; 
            }
        }
    }

    public static void main(String[] args) throws ParseException {
        parsedData = new LinkedList<csvFile>();
        
        csvParser();
        generatePriorityTable();
    }
    
}
