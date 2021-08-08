package StepData;

import DTO.StepDataDTO;

public class StepDataPopulator {
    private StepDataDTO inputData = new StepDataDTO();
    private CharacterMorseCodePopulator charMap = new CharacterMorseCodePopulator(inputData);
    private ValidWordsPopulator validWords = new ValidWordsPopulator(inputData);
    private InputMorseCodeListPopulator inputWords = new InputMorseCodeListPopulator(inputData);
    public StepDataPopulator(StepDataDTO inputData){
        this.inputData = inputData;
        CharacterMorseCodePopulator charMap = new CharacterMorseCodePopulator(this.inputData);
        ValidWordsPopulator validWords = new ValidWordsPopulator(this.inputData);
        InputMorseCodeListPopulator inputWords = new InputMorseCodeListPopulator(this.inputData);
    }
    private int readDataCount = 0;
    public StepDataDTO populateStepData(String s){
        if(s.trim().equals("*")){
            readDataCount++;
        }else if(readDataCount == 0){

            charMap.populateMap(s.trim(),this.inputData);
        }else if(readDataCount == 1){
            validWords.ValidWordsPopulator(s.trim(),this.inputData);
        }else if(readDataCount == 2){
            inputWords.populateInputList(s.trim(),this.inputData);
        }
        return this.inputData;
    }
}
