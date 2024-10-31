package microservices.parcialarep.co.edu.escuelaing.services;

import microservices.parcialarep.co.edu.escuelaing.model.Operation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class MathServices {
    public Operation linearSearch(ArrayList<Integer> nums, Integer numToSearch) {
        int position = -1;
        for (int i=0; i < nums.size(); i++) {
            if (nums.get(i).equals(numToSearch)){
                position = i;
            }
        }
        return new Operation("linearSearch",nums,numToSearch,position);
    }

    public Integer binarySearch(int sizelist, List<Integer> nums, Integer numToSearch) {
        if (nums.isEmpty()) {
            return -1;
        }
        Integer numMaybe = nums.get(nums.size()/2 );
        if (numMaybe == numToSearch){
            return sizelist + nums.indexOf(numMaybe);
        }else {
            if (numMaybe > numToSearch){
                List arrayLeft = nums.subList(0,nums.indexOf(numMaybe));
                return binarySearch(sizelist , arrayLeft, numToSearch);
            }else {
                List arrayRight = nums.subList(nums.indexOf(numMaybe),nums.size());
                return binarySearch( sizelist + nums.indexOf(numMaybe), arrayRight, numToSearch);
            }
        }
    }
}
