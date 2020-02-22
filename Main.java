package com.company;


import org.junit.*;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class Main {
    public boolean isAnagram(List<String> words) {
        if (!Objects.isNull(words) && words.size() > 1) {
            List<Map<Character, Integer>> charNumbersMapList = new ArrayList<>();
            int counter = 1;
            words.forEach(word -> {
                List<Character> characters = word.toLowerCase().chars().mapToObj(e -> (char) e).collect(Collectors.toList());
                Map<Character, Integer> wordCharactersAndNumbers = new HashMap<>();
                characters.forEach(character -> {
                    if (!Objects.isNull(wordCharactersAndNumbers.get(character))) {
                        int charCounter = wordCharactersAndNumbers.get(character);
                        wordCharactersAndNumbers.put(character, charCounter + 1);
                    } else {
                        wordCharactersAndNumbers.put(character, counter);
                    }
                });
                charNumbersMapList.add(wordCharactersAndNumbers);
            });
            for (int i = 0; i < charNumbersMapList.size(); i++) {
                if (charNumbersMapList.get(i).keySet().equals(charNumbersMapList.get(++i).keySet())) {
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }
    @Test
    public void testIsAnagramsWhenTrue(){
        List<String> keys= new ArrayList<>();
        keys.add("volkan");
        keys.add("ahmet");
        assertTrue(!this.isAnagram(keys));
    }
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("volkan");
        words.add("mehmet");
        Main main = new Main();
        System.out.println(main.isAnagram(words));
    }

}


