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
    {   
        String path = "/Users/aswinighosh/Downloads/DicomImages/cine_data/CAP_SCD0000101_MR__hrt_raw_20120813120605087_119.dcm";
        //File f = new File();
        //InputStream is = new FileInputStream(f);
        
        DicomImage di = new DicomImage(path);
        di.showMetaData();
        
        di.showImage();
        
        
        
    }
}
