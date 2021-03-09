package pl.markowska.addapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.markowska.addapp.pojo.SumUpDataReponseBody;
import pl.markowska.addapp.service.DataSumService;

import java.io.IOException;

@Controller
public class DataSumController {

    @Autowired
    private DataSumService dataSumService;

    @RequestMapping("/")
    public String showMainPage() {
        return "mainPage";
    }

    @RequestMapping("/sum")
    public ResponseEntity sumUpData(@RequestBody SumUpDataReponseBody sumUpDataReponseBody) throws IOException {
        System.out.println(sumUpDataReponseBody.getDataSources());
        return ResponseEntity.ok(dataSumService.computeSum(sumUpDataReponseBody.getDataSources()));
    }
}
