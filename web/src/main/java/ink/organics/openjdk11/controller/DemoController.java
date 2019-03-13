package ink.organics.openjdk11.controller;


import ink.organics.openjdk11.application.DemoService;
import ink.organics.openjdk11.dto.DemoSearchDTO;
import ink.organics.openjdk11.dto.ResponseDTO;
import ink.organics.openjdk11.dto.TestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
@RequestMapping("/demo")
public class DemoController {


    @Resource
    private DemoService demoService;

    @RequestMapping(value = "/save/{name}", method = RequestMethod.GET)
    public ResponseEntity add(@PathVariable String name) {
        demoService.add(name);
        return new ResponseEntity<>(new ResponseDTO(), HttpStatus.OK);
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResponseEntity getDemoPage(@RequestBody DemoSearchDTO dto) {
        return new ResponseEntity<>(demoService.getDemoPage(dto), HttpStatus.OK);
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public ResponseEntity getDemoPage(@Valid @RequestBody TestDTO dto) {
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}
