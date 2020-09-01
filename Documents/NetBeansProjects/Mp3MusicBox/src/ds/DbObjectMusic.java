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
public class DbObjectMusic extends DbObject{

    int newSongId;
    String newSongName;
    int newSongDuration;
    String newSongArtist;
    String songFindKey;
    
    @Override
    public void writeToFile(RandomAccessFile out) throws IOException {
    }

    @Override
    public void readFromFile(RandomAccessFile in) throws IOException {
    }

    @Override
    public void readFromConsole() {
        System.out.println("-------------------------");
        System.out.print("Enter the Song ID: ");
        newSongId = Integer.parseInt(kb.nextLine());
//        kb.nextLine();
        System.out.print("Enter the Song Name: ");
        newSongName = kb.nextLine();
        System.out.print("Enter the Song Duration (seconds): ");
        newSongDuration = kb.nextInt();
        kb.nextLine();
        System.out.print("Enter the Song Artist name: ");
        newSongArtist = kb.nextLine();
        System.out.println("-------------------------");
    }
    public void readFromConsoleToModify() {
        System.out.println("-------------------------");
        System.out.print("Enter the Song Name: ");
        newSongName = "";
        newSongName = kb.nextLine();
        System.out.print("Enter the Song Duration (seconds): ");
        newSongDuration = 0;
        newSongDuration = kb.nextInt();
        kb.nextLine();
        System.out.print("Enter the Song Artist name: ");
        newSongArtist = "";
        newSongArtist = kb.nextLine();
        System.out.println("-------------------------");
    }
    @Override
    public void writeLegibly() {
    }

    @Override
    public void readKey() {
        System.out.println("=================================================");
        System.out.print("Enter the Song ID that you want to search or modify: ");
        songFindKey = kb.nextLine();
    }

    @Override
    public void copy(DbObject[] db) {
    }

    @Override
    public int size() {
        return -1;
    }
    
}
