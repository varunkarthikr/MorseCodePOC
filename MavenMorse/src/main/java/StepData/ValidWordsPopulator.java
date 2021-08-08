package StepData;

import DTO.StepDataDTO;

import java.util.ArrayList;

public class ValidWordsPopulator {
    public ValidWordsPopulator(StepDataDTO stepData){
        stepData.validWords = new ArrayList<>();
    }
    public void ValidWordsPopulator(String s,StepDataDTO stepData){
        stepData.validWords.add(s);
    }
}
