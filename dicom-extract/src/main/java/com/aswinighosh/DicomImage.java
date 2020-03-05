package com.aswinighosh;

import ij.plugin.*;
import ij.util.DicomTools;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;


public class DicomImage extends DICOM
{
    //DICOM dcm;
    String path;
    ArrayList<String> tags=new ArrayList<String>();
    HashMap<String,String> metaData = new HashMap<>();
    
    DicomImage(String path)
    {
        //dcm = new DICOM();
        super();
        this.path = path;
        try{
        super.run(path);
        
        storeMetaData();
        
        }
        catch(Exception e)
        {
            System.err.println("Could not load dicom image "+e);
        }
    }

    void storeMetaData()
    { //String tg[] = {"0002,0001","0002,0002","0002,0003","0008,0060","0008,0070","0028,0010","0028,0011"}; //sample tags for metadata
        
       
       // System.out.println(dcm.getInfo(path));
        String info = super.getInfo(path);
        Pattern regex = Pattern.compile("[0-9A-Fx]{4},[0-9A-Fx]{4}");   //regular expression for getting tags from info
        Matcher matcher = regex.matcher(info);
    
        while(matcher.find())
        {   tags.add(matcher.group());
            
        }
       // String tg[] = GetStringArray(tags);
        
        
        
        for (String id : tags) {
            if(DicomTools.getTag(this, (String)id)!=null)
             {  //System.out.println(id+":"+DicomTools.getTagName(id)+" : "+DicomTools.getTag(dcm,id));
                 metaData.put(DicomTools.getTagName((String)id), DicomTools.getTag(this, (String)id));   
             }
            
        } 
        
    }


    public void showMetaData()
    {
        try{    System.out.println("size:"+metaData.size());
            
            for (String k : metaData.keySet()) {
                System.out.println(k+" : "+metaData.get(k));
            }
        }
        catch(Exception e)
        {
            System.err.println("Improper metadata " + e);
        }
    }
 


}