package implementation;

import DTO.StepDataDTO;
import DTO.StepResultDTO;
import Abstraction.MorseCodeTask;
import StepData.StepDataPopulator;
import com.google.gson.Gson;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class ReadInputTask extends MorseCodeTask{

    public ReadInputTask(StepDataDTO inputData) {
        super(inputData);
    }


    @Override
    public void setCurrentStepData() {
        this.taskName = "Read Input file";
        this.nextTask = new PopulateTrieTask(this.inputData);
    }
    @Override
    public StepDataDTO run()  throws FileNotFoundException{

        File text = new File("./src/input/input.txt");
        Scanner sc = new Scanner(text);
        StepDataPopulator populator = new StepDataPopulator(this.inputData);
        while (sc.hasNextLine()){
            String line = sc.nextLine();

            populator.populateStepData(line);
        }
        return inputData;

    }
    @Override
    public void runPostExecutionTask(){

    }
}
