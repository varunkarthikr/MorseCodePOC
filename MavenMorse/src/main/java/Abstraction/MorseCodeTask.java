package Abstraction;

import DTO.StepDataDTO;
import DTO.StepResultDTO;
import com.google.gson.Gson;

import java.io.IOException;

public abstract class MorseCodeTask{
    public MorseCodeTask(StepDataDTO inputData){
        this.inputData = inputData;
    }


    public StepDataDTO runNextTask()  throws IOException{
        Gson gson = new Gson();
        //System.out.println(gson.toJson(this.inputData));
        if(nextTask != null && !this.inputData.testMode)
            return nextTask.process();
        return this.inputData;
    }
    public MorseCodeTask nextTask = null;
    public StepDataDTO inputData = null;
    public abstract StepDataDTO run() throws IOException;

    public StepDataDTO process() throws IOException {
        setCurrentStepData();
        run();
        //System.out.println(this.taskName);
        StepDataDTO result =  this.runNextTask();
        runPostExecutionTask();
        return result;
    }
    public abstract void setCurrentStepData();
    public abstract void runPostExecutionTask();
    public String taskName = "";
}
