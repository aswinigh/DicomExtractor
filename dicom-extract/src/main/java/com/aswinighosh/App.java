package com.aswinighosh;

import ij.plugin.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
/**
 * Hello world!
 *
 */
public class App 
{
    

    public static void main( String[] args )
    {   try{
        File f = new File("/Users/aswinighosh/Desktop/DicomExtractor/dicom-extract/src/resources/bmode.dcm");
        InputStream is = new FileInputStream(f);
        DICOM dcm = new DICOM(is);
        dcm.show();
        }
        catch(Exception e)
        {
            System.out.println("Cannot open");
        }
        /*
        try{
            dcm.open("/Users/aswinighosh/Desktop/DicomExtractor/dicom-extract/src/resources/bmode.dcm");
        }
        catch(Exception e)
        {
            System.out.println("Error"+e);
        }
        
        try{
            System.out.println("Showing:"+dcm.getNSlices());
            dcm.run("Name");
            dcm.show();
        }
        catch(Exception e){
            System.out.println("Unable to show:"+e);
        }*/
        System.out.println( "Hello World!" );
    }
}
