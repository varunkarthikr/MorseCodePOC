package StepData;

import DTO.StepDataDTO;
import DTO.TrieNode;

import java.util.ArrayList;

public class InputMorseCodeListPopulator {

    public InputMorseCodeListPopulator(StepDataDTO dto){

        dto.inputWords = new ArrayList<>();
    }
    public void populateInputList(String s,StepDataDTO stepData){
        stepData.inputWords.add(s);
    }
}
