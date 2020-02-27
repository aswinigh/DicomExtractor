package com.aswinighosh;

import ij.plugin.*;
import ij.util.DicomTools;
import java.util.*;

public class DicomImage
{
    DICOM dcm;
    HashMap<String,String> metaData = new HashMap<>();
    DicomImage(String path)
    {
        dcm = new DICOM();
        try{
        dcm.run(path);
        
        storeMetaData();
        }
        catch(Exception e)
        {
            System.err.println("Could not load dicom image "+e);
        }
    }

    void storeMetaData()
    { String tags[] = {"0002,0001","0002,0002","0002,0003","0008,0060","0008,0070","0028,0010","0028,0011"}; //sample tags for metadata
        for (String id : tags) {
            if(DicomTools.getTag(dcm, id)!=null)
             {
                 metaData.put(DicomTools.getTagName(id), DicomTools.getTag(dcm, id));   
             }
        } 
        
        
    }

    public void showImage()
    {
        dcm.show();
    }

    public void showMetaData()
    {
        try{
            
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