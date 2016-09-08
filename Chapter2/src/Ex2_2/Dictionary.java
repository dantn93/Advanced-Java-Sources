/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex2_2;

import java.util.TreeMap;

/**
 *
 * @author snow
 */
public class Dictionary {

    private TreeMap<String, String> listWord;

    public Dictionary() {
        listWord = new TreeMap<String, String>();
    }

    public void add(String key, String value) {
        if (listWord.containsKey(key) == false) {
            listWord.put(key, value);
            System.out.println("Add a word successfully!");
        } else {
            System.out.println("The word has existed. I don't add into dictionay");
        }
    }

    public void search(String key) {
        if (listWord.containsKey(key) == true) {
            System.out.println("[meanning]: " + listWord.get(key));
        } else {
            System.out.println("Dictionay don't have [word]: " + key);
        }
    }

    public void deleteWord(String key) {
        if (listWord.containsKey(key) == true) {
            listWord.remove(key);
            System.out.println("Deleteing is successfully!");
        } else {
            System.out.println("Dictionay don't have [word]: " + key);
        }
    }

}
