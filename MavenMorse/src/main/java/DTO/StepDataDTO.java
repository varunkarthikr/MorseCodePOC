package DTO;

import java.util.*;

public class StepDataDTO {
    public Map<Character,Integer> morseArrayMap = new HashMap<>();
    public Map<Character,String> characterToMorseCodeMap = new HashMap<>();
    public List<String> validWords = new ArrayList<>();
    public List<String> inputWords = new ArrayList<>();
    public List<String> resultWords = new ArrayList<>();
    public TrieNode trieRoot = new TrieNode();
    public StepResultDTO stepResults = new StepResultDTO();
    public boolean testMode = false;
    public StepDataDTO(){
        morseArrayMap = new HashMap<>();
        characterToMorseCodeMap = new HashMap<>();
        validWords = new ArrayList<>();
        inputWords = new ArrayList<>();
        resultWords = new ArrayList<>();
        trieRoot = new TrieNode();
        stepResults = new StepResultDTO();
        testMode = false;
        morseArrayMap.put('-',0);
        morseArrayMap.put('.',1);
    }
}
