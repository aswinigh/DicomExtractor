package com.aswinighosh;
import com.mongodb.DB;
import com.mongodb.client.MongoClient; 
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoCredential;
import java.util.*;

import org.bson.Document;

import com.google.gson.*;
class DataConnect{
    String collectionName = "DicomImages";
    Scanner input = new Scanner(System.in);
    MongoClient mongoClient = MongoClients.create();
    MongoDatabase database = mongoClient.getDatabase("DicomData");
    MongoCollection<Document>  collection = database.getCollection(collectionName); 

    Gson gson = new Gson();
    
    public void saveHashMap(ArrayList<Document> document){
        if(collection.countDocuments()>0){
            System.out.println("\nCollection \'DicomImages\' already exists.Do you want to overwrite?");
            System.out.println("[Y/N]:");
            char choice = input.next().charAt(0);
            
            switch (choice) {
                case 'Y'|'y':
                    collection.drop();
                    database.createCollection(collectionName);
                    collection = database.getCollection(collectionName);
                    collection.insertMany(document);
                    
                    break;
                case 'N'|'n':
                    System.out.println("Enter new collection name:");
                    String newCollectionName = input.next();
                    database.createCollection(newCollectionName);
                    collection = database.getCollection(newCollectionName);
                    collection.insertMany(document);
                    break;
                default:
                    System.out.println("Wrong choice");
                    break;
            }    

        }
        else{
            collection.insertMany(document);
        }

        input.close();
    }
    


}