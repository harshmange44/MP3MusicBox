/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author harsh
 */
public class MP3MusicBox{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            DbObjectMusic dbObjectMusic = new DbObjectMusic();
            DatabaseMusic databaseMusic = new DatabaseMusic();
            databaseMusic.run(dbObjectMusic);
        } catch (IOException ex) {
            Logger.getLogger(MP3MusicBox.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}