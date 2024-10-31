package microservices.parcialarep.co.edu.escuelaing.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Operation {
    private String operation;

    private List<Integer> inputList;

    private int value;

    private int output;

    public Operation(String operation, List<Integer> nums, Integer numToSearch, int position) {
        this.operation = operation;
        this.inputList = nums;
        this.value = numToSearch;
        this.output = position;
    }
}
