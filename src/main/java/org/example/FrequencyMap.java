package org.example;

import java.util.HashMap;
import java.util.Map;

public class FrequencyMap {

    public static void main(String[] args) {
        String input = "qqwasdascavbgfbsknfkvsngjbnslgnntlrnslfvnfvnsdkvfnsdbnslgnsjnv";


    }

    public FrequencyMap(String input) {
        Map<Character, Integer> characterFrequencyMap = new HashMap<>(26);

        char[] charArray = input.toCharArray();


        for(char c: charArray){
           if(characterFrequencyMap.containsKey(c)){
               int value = characterFrequencyMap.get(c);
               characterFrequencyMap.put( c, value+1  );
           }else{
               characterFrequencyMap.put( c, 1);
           }
        }


        for(char c: charArray) {
            characterFrequencyMap.compute(c, (k, value) -> value + 1);
        }

        for(char c: charArray){
            // getOrDefault() retrieves the value( if present ) or takes a default mentioned as second parameter
            characterFrequencyMap.put(c, characterFrequencyMap.getOrDefault(c,0)+1);
        }
    }
}
