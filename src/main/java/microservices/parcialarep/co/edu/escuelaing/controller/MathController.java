package microservices.parcialarep.co.edu.escuelaing.controller;


import microservices.parcialarep.co.edu.escuelaing.model.Operation;
import microservices.parcialarep.co.edu.escuelaing.services.MathServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("")
public class MathController {

    private final MathServices mathServices;

    public MathController(@Autowired  MathServices mathServices) {
        this.mathServices = mathServices;
    }

    @GetMapping("/linearsearch")
    public ResponseEntity<Operation> linearSearch(@RequestParam (value = "list") String[] list,
                                                  @RequestParam (value = "value") String value){
        ArrayList<Integer> nums = new ArrayList<>();
        Integer numToSearch = Integer.parseInt(value);
        for (String l: list) {
            nums.add(Integer.parseInt(l));
        }
        Operation operation = mathServices.linearSearch(nums,numToSearch);
        return ResponseEntity.ok(operation);
    }

    @GetMapping("/binarysearch")
    public ResponseEntity<Operation> binarySearch(@RequestParam (value = "list") String[] list,
                                                  @RequestParam (value = "value") String value){
        List<Integer> nums = new ArrayList<>();
        Integer numToSearch = Integer.parseInt(value);
        Integer index;
        for (String l: list) {
            nums.add(Integer.parseInt(l));
        }
        index = mathServices.binarySearch(0, nums, numToSearch);
        Operation operation = new Operation("binarySearch",nums,numToSearch, index);
        return ResponseEntity.ok(operation);
    }
}
