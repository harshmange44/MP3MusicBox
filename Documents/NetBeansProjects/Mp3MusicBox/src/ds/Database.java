/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;

/**
 *
 * @author harsh
 */
import java.io.*;

public abstract class Database {
private RandomAccessFile database;
private String fName = new String();
java.util.Scanner kb = new java.util.Scanner(System.in);
Database(){
}

abstract void add(DbObjectMusic d, RandomAccessFile database1)throws IOException ;
abstract void modify(DbObjectMusic d, RandomAccessFile database1)throws IOException ;
abstract boolean find(DbObjectMusic d, RandomAccessFile database1)throws IOException ;
abstract boolean view(RandomAccessFile database1)throws IOException ;
abstract void printDb(DbObjectMusic d)throws IOException ;


public void run(DbObjectMusic rec) throws IOException {
    String option;
    System.out.print("Enter File name: ");
    fName = kb.next();
    database = new RandomAccessFile(fName, "rw");
    System.out.println("--------MP3 MUSIC BOX--------\n");
    System.out.println("1. Add\n2. Find\n3. Modify a record\n4. View all \n5. EXIT");
    System.out.print("Enter an option: ");
    option = kb.next();
    System.out.println("------------------------------");
    while (true) {
        if (option.charAt(0) == '1') {
             rec.readFromConsole();
             add(rec,database);
        }
        else if (option.charAt(0) == '2') {
             rec.readKey();
             if (find(rec,database) == false)
                 System.out.println("Data NOT found...");
        }
        else if (option.charAt(0) == '3') {
             rec.readKey();
             modify(rec,database);
        }
        else if (option.charAt(0) == '4') {
             if(view(database)==false)
                 System.out.println("There is NO Data available...");
        }
        else if (option.charAt(0) != '5'){
             database.close();
             System.out.println("Wrong option");
        }
        else{ 
            System.out.println("Signing Off...!\n\nThank You");
            return;
        
        }
//        printDb(rec);
        System.out.println("------------------------------");
    System.out.println("1. Add\n2. Find\n3. Modify a record\n4. View all \n5. EXIT");
        System.out.print("Enter an option: ");
        option = kb.next();
    System.out.println("------------------------------");
    }
}


static public void main(String[] args) throws IOException {
//create database and run it
}
}

