/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author harsh
 */
public class DatabaseMusic extends Database{
    
    @Override
    void add(DbObjectMusic d, RandomAccessFile database) throws IOException {
        database.seek(0);
        int id = 0;
        String line = null;
        String[] tokens;
        while((line=database.readLine())!=null){
            tokens = line.split(" ");
            id = Integer.parseInt(tokens[0].toString());
        }
     database.seek(database.length());
     String s = String.valueOf(id+1)+" "+d.newSongName+" "+d.newSongDuration+" "+d.newSongArtist+System.lineSeparator();
//        for (int i = 0; i < s.length(); i++) {
//            database.writeChar(s.charAt(i));
//        }
    database.write(s.getBytes());
//     database.writeUTF(d.newSongId+" "+d.newSongName+" "+d.newSongDuration+" "+d.newSongArtist+System.lineSeparator());    
    }

    @Override
    void modify(DbObjectMusic d, RandomAccessFile database) throws IOException {
        database.seek(0);
        String[] tokens;
        String line = null;
        long prevPointer = 0;
//        System.out.println("key: "+d.songFindKey);
     while((line=database.readLine())!=null){
         
         tokens = line.split(" ");
      
        if(tokens.length>=1){
//    
               d.songFindKey = d.songFindKey.trim();
              tokens[0] = tokens[0].trim();
         if(d.songFindKey.equals(tokens[0]) || d.songFindKey.equals(tokens[1])){
             System.out.println("-------------------------");
             System.out.println("Record found:  "+line);
             System.out.println("-------------------------");
//             prevPointer = database.getFilePointer();
             System.out.print("Do you want to modify this? (y/n): ");
             String flag = kb.next();
             if(flag.charAt(0) == 'y' | flag.charAt(0) =='Y'){
//                 kb.nextLine();
                 d.readFromConsoleToModify();
             database.seek(prevPointer);
     String s = d.songFindKey+" "+d.newSongName+" "+d.newSongDuration+" "+d.newSongArtist;
//        for (int i = 0; i < s.length(); i++) {
//            database.writeChar(s.charAt(i));
//        }
            database.write(s.getBytes());
                 System.out.println("Data Modified Successfully...");
                 break;
         }
             
         }
         
        }
//         line = database.readLine();
         prevPointer = database.getFilePointer();
     }
    }

    @Override
    boolean find(DbObjectMusic d, RandomAccessFile database) throws IOException {
        database.seek(0);
        String[] tokens;
        String line = database.readLine();
//        System.out.println("key: "+d.songFindKey);
     while(line!=null){
         
         tokens = line.split(" ");
      
        if(tokens.length>=1){
//    
               d.songFindKey = d.songFindKey.trim();
              tokens[0] = tokens[0].trim();
         if(d.songFindKey.equals(tokens[0]) || d.songFindKey.equals(tokens[1])){
             System.out.println("-------------------------");
             System.out.println("Record found:  "+line);
             System.out.println("-------------------------");
             return true;
         }
        }
         line = database.readLine();
     }
        return false;
    }

    @Override
    void printDb(DbObjectMusic d) throws IOException {
    }

    @Override
    boolean view(RandomAccessFile database) throws IOException {
        StringBuilder buffer = new StringBuilder();
     database.seek(0);
     String line = database.readLine();
     while(line!=null){
         buffer.append(line).append(System.lineSeparator());
         line = database.readLine();
     }
     if(buffer.toString().equals("")){
         return false;
     }
        System.out.println(buffer.toString());     
        return true;
    }
    
}
