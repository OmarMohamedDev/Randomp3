package com.omarmohamed.randomp3.utilities;

import android.os.Environment;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class that permit to retrieve data from the device folders
 */
public class MusicManager {

    /**
     * Represent the path to the media folder
     */
    private final String MEDIA_PATH = Environment.getExternalStorageDirectory()
            .getPath() + "/";

    /**
     * String object that contains the representation of the extension of a mp3 file
     */
    private String mp3Pattern = ".mp3";

    /**
     * Arraylist that contains hashmaps that represent the mp3 songs in the devices representing
     * them as HashMap with the song title as key and the song path as value
     */
    private ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String, String>>();

    /**
     * Method that read all the mp3 files stored in the device and store the details in an ArrayList
     * */
    public ArrayList<HashMap<String, String>> getPlayList() {
        if (MEDIA_PATH != null) {
            File home = new File(MEDIA_PATH);
            File[] listFiles = home.listFiles();

            if (listFiles != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    System.out.println(file.getAbsolutePath());
                    if (file.isDirectory()) {
                        scanDirectory(file);
                    } else {
                        addSongToList(file);
                    }
                }
            }
        }

        // Return the list of songs retrieved
        return songsList;
    }

    /**
     * Method that a directory
     * @param directory
     */
    private void scanDirectory(File directory) {
        if (directory != null) {
            File[] listFiles = directory.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    if (file.isDirectory()) {
                        scanDirectory(file);
                    } else {
                        addSongToList(file);
                    }

                }
            }
        }
    }

    /**
     * Method that add a song to the song list, using an hashmap and storing the the song title as
     * key and the song path as value
     * @param song
     */
    private void addSongToList(File song) {
        if (song.getName().endsWith(mp3Pattern)) {
            HashMap<String, String> songMap = new HashMap<String, String>();
            songMap.put("songTitle",
                    song.getName().substring(0, (song.getName().length() - 4)));
            songMap.put("songPath", song.getPath());

            // Adding each song to SongList
            songsList.add(songMap);
        }
    }
}
