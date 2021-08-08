package StepData;

import DTO.StepDataDTO;

import java.util.HashMap;
import java.util.Map;

public class CharacterMorseCodePopulator {
    public CharacterMorseCodePopulator(StepDataDTO stepData){

        stepData.characterToMorseCodeMap = new HashMap<>();
    }
    public void populateMap(String input,StepDataDTO stepData){
        Character key = input.charAt(0);
        String value = input.substring(1).trim();
        stepData.characterToMorseCodeMap.put(key,value);
    }
}
