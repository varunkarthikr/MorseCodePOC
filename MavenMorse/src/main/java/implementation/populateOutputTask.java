package implementation;

import Abstraction.MorseCodeTask;
import DTO.StepDataDTO;
import DTO.StepResultDTO;
import DTO.TrieNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 */
public class populateOutputTask extends MorseCodeTask {
    public populateOutputTask(StepDataDTO inputData) {
        super(inputData);
    }

    /**
     *
     */
    @Override
    public void setCurrentStepData() {
        this.taskName = "Populate Output";
        //this.nextTask =
    }
    @Override
    public StepDataDTO run() {

        inputData.resultWords = new ArrayList<>();
        for(String input : inputData.inputWords){
            populateResult(inputData,input);
        }

        return inputData;
    }

    /**
     * @param a 
     * @param b
     * @return
     */
    private int sortResults(String a,String b){
        if(a.length() == b.length())
            return -1;
        return a.length()-b.length();
    }
    private void populateResult(StepDataDTO inputData,String input){
        TrieNode root = inputData.trieRoot;

        TrieNode node = root;
        StringBuilder res = new StringBuilder();
        String[] inputSplit = input.split(" ");
        for(int i=0;i<inputSplit.length;i++) {
            node = root;
            if(inputSplit[i].length() > 0) {
                if(res.length() > 0)
                    res.append(' ');
                List<String> temp = new ArrayList<>();
                boolean valid = true;
                for (char c : inputSplit[i].toCharArray()) {
                    int index = inputData.morseArrayMap.get(c);
                    if (node.children[index] != null){
                        node = node.children[index];
                        temp = node.words;
                    }else{
                        valid = false;
                        break;

                    }
                }
                if(!valid) {
                    addWord(1,new ArrayList<>(),"");
                }
                else if(temp.size() > 1) {
                    Collections.sort(temp,
                            (a,b)->{return sortResults(a,b);});

                    addWord(2,node.leaf,temp.get(0));
                }else if(temp.size() == 1){
                    addWord(1,node.leaf,temp.get(0));
                }

            }
        }
    }
    private void addWord(int size,List<String> leaf,String word){
        StringBuilder sb = new StringBuilder(word);

        if(leaf.size()  == 0 && size > 1)
            sb.append('!');
        else if(leaf.size() > 1) {
            sb = new StringBuilder(leaf.get(0));
            sb.append("!");
        }else if(leaf.size() == 0)
            sb.append('?');
        else if(leaf.size() == 1)
            sb.append(leaf.get(0));
        inputData.resultWords.add(sb.toString());
    }
    @Override
    public void runPostExecutionTask(){}
}
