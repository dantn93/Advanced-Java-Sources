/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex6_2;

import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * @author Tran Ngoc Dan
 * @version 1.0
 * @since 08/09/2016
 */
public class Document {

    private HashMap<String, Integer> words;

    public Document() {
        this.words = new HashMap<String, Integer>();
    }

    public void tokenize(String document) {
        //Split sentence;
        StringTokenizer multiTokenizer = new StringTokenizer(document);
        while (multiTokenizer.hasMoreTokens()) {
            String word = multiTokenizer.nextToken();
            if (this.words.containsKey(word) == true) {
                int oldValue = this.words.get(word);
                this.words.replace(word, oldValue + 1);
            } else {
                this.words.put(word, 1);
            }
        }
    }

    public void searchToken(String token) {
        if (this.words.size() > 0) {
            if (this.words.containsKey(token)) {
                System.out.println("[Document has token]: " + token);
            } else {
                System.out.println("Document has NOT token");
            }
        } else {
            System.out.println("List of tokens is empty");
        }
    }

    public void showInfo() {
        System.out.println("== Tokens in document ==");
        for (Object object : words.keySet()) {
            System.out.print("[" + object + "]");
            System.out.println(" " + this.words.get(object));
        }
    }
}
