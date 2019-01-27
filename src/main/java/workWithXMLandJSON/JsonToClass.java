package workWithXMLandJSON;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonToClass {

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        try {
            MateGroup mateGroup = mapper.readValue(new File("C:\\Users\\witch\\IdeaProjects\\Homework\\src\\main\\resources\\file.gson"),
                    MateGroup.class);
            System.out.println(mateGroup);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

