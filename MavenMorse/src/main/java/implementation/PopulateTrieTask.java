package implementation;

import Abstraction.MorseCodeTask;
import DTO.StepDataDTO;
import DTO.StepResultDTO;
import DTO.TrieNode;
import com.google.gson.Gson;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PopulateTrieTask extends MorseCodeTask {
    public PopulateTrieTask(StepDataDTO inputData) {
        super(inputData);
    }
    @Override
    public void setCurrentStepData() {
        this.taskName = "Populate Trie";
        this.nextTask = new populateOutputTask(this.inputData);
    }
    @Override
    public StepDataDTO run() {

        inputData.trieRoot = new TrieNode();
        populateTrie(inputData.trieRoot,inputData.validWords,inputData.characterToMorseCodeMap,inputData.morseArrayMap);

        return inputData;
    }
    private void populateTrie(TrieNode root, List<String> validWords, Map<Character,String> morseMap,Map<Character,Integer> morseArrayMap){
        Gson gson = new Gson();
       // System.out.println("###"+gson.toJson(morseMap));
        for(String word : validWords){
            char[] chars = word.toCharArray();
            TrieNode node = root;
            for(int i=0;i<chars.length;i++){
                String value = morseMap.getOrDefault(chars[i],"");
                //System.out.println(value+"@@@"+chars[i]);
                if(!value.equals("")) {
                    for(char c : value.toCharArray()) {
                        if(c == '-' || c == '.') {
                            TrieNode child = node.children[morseArrayMap.get(c)];
                            child = child == null ? new TrieNode() : child;
                            child.words.add(word);
                            node.children[morseArrayMap.get(c)] = child;
                            node = child;
                        }
                    }
                }
                if(i == chars.length-1)
                    node.leaf.add(word);
            }
        }
    }
    @Override
    public void runPostExecutionTask(){}
}
