package com.aswinighosh;

import ij.plugin.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.IllegalArgumentException;
import java.util.ArrayList;

import com.google.gson.Gson;

import org.bson.Document;
/**
 * Hello world!
 *
 */
public class App 
{
    
    public static DataConnect dConnect = new DataConnect();
    public static void main( String[] args )
    {   
        Gson gson = new Gson();
        //File f = new File();
        //InputStream is = new FileInputStream(f);
        try{
        if(args.length==0)
            throw new IllegalArgumentException();
        DicomImage di = new DicomImage(args[0]);

        di.showMetaData();
        
        di.show();
        ArrayList<Document> documents = new ArrayList<Document>();
        documents.add(Document.parse(gson.toJson(di.metaData)));
        dConnect.saveHashMap(documents);
        }
        catch(Exception e){
            System.err.println("ERROR:Dicom path not specified  "+e);
        }
        
        
        
    }
}
