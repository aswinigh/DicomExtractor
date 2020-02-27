package com.aswinighosh;

import ij.plugin.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.IllegalArgumentException;
/**
 * Hello world!
 *
 */
public class App 
{
    

    public static void main( String[] args )
    {   
        
        //File f = new File();
        //InputStream is = new FileInputStream(f);
        try{
        if(args.length==0)
            throw new IllegalArgumentException();
        DicomImage di = new DicomImage(args[0]);
        di.showMetaData();
        
        di.showImage();
        }
        catch(Exception e){
            System.err.println("ERROR:Dicom path not specified  "+e);
        }
        
        
        
    }
}
