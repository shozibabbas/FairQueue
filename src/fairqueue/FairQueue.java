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
            int priority = 0;
            switch(a) {
                case "New User Registration":
                    priority = 2;
                break;
                case "Lab Task Upload(5pm)":
                    priority = 3;
                break;
                case "Course Registration":
                    priority = 2;
                break;  
                case "Lecture Preparation":
                    priority = 4;
                break;  
                case "Data Backup(3am-4am)":
                    priority = 1;
                break;  
                case "Assignment Upload":
                    priority = 3;
                break;  
                case "Lecture Download":
                    priority = 4;
                break;  
                case "Assignment Submission(12am)":
                    priority = 3;
                break;  
                case "Assignment Grading":
                    priority = 4;
                break;  
                case "Quiz Grading":
                    priority = 4;
                break;  
                case "Final Grading":
                    priority = 4;
                break;  
                case "1st Student Feedback":
                    priority = 7;
                break;  
                case "2nd Student Feedback":
                    priority = 8;
                break;  
                case "ESE GuideLine Update":
                    priority = 7;
                break;  
                case "Student Result Comments":
                    priority = 6;
                break;  
                case "Project Submission(12am)":
                    priority = 3;
                break;  
                case "Project Grading":
                    priority = 4;
                break; 
                case "Data Backup(1am-2am)":
                    priority = 1;
                break; 
                case "Project Upload Link Creation":
                    priority = 9;
                break; 
                case "Maintenance":
                    priority = 1;
                break; 
            }
            
            activities.add(new activity(a, priority));
        }
        
        
    }

    public static void main(String[] args) throws ParseException {
        parsedData = new LinkedList<csvFile>();
        activities = new LinkedList<activity>();
        
        csvParser();
        generatePriorityTable();
    }
    
}
