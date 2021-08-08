import Abstraction.MorseCodeTask;
import DTO.StepDataDTO;
import DTO.StepResultDTO;
import com.google.gson.Gson;
import implementation.ReadInputTask;

import java.io.File;
import java.io.IOException;

public class MorseCodeMain {

    public static void main(String[] args)  throws IOException {
        File directory = new File("./src/input/input.txt");
        StepDataDTO step = new StepDataDTO();
        MorseCodeTask decodeMorseCodes = new ReadInputTask(step);
        decodeMorseCodes.process();
        Gson gson = new Gson();
        System.out.println(gson.toJson(step.trieRoot));
        System.out.println("==================");
        System.out.println(gson.toJson(step.resultWords));

    }
}


