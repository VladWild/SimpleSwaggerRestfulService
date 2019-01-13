package com.example.demo.controllers;

import com.example.demo.data.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@RequestMapping("/simple")
@Api("простой контроллер для примеров")
public class SimpleController {

    @PostMapping(value = "/upload-zip-body",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiOperation("передача zip-архива через тело")
    public ResponseEntity<String> uploadZipBody(@ApiParam("ЭТО multipartFile!!!!")
            @RequestBody MultipartFile multipartFile){
        System.out.println(multipartFile);
        return new ResponseEntity<>("Zip Upload Body", HttpStatus.OK);
    }

    @PostMapping(value = "/upload-zip-param",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiOperation("передача zip-архива через параметры")
    public String uploadZipParameters(@RequestParam("multipartFile") MultipartFile multipartFile){
        System.out.println(multipartFile);
        return "Zip Upload Parameters";
    }

    @PostMapping(value = "/add-user",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addUser(@Valid @RequestBody User user){
        System.out.println(user);
        return "Add User";
    }

    @PostMapping(value = "/upload-zip-add-user/{id}/{name}",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadZipAndAddUserParameters(@RequestParam("id") int id,
                                                @RequestParam("name") String name,
                                                @RequestParam("multipartFile") MultipartFile multipartFile){
       System.out.println(id);
       System.out.println(name);
       System.out.println(multipartFile);
       return "Zip Upload And Add User With Parameters";
    }

    @PostMapping(value = "/upload-zip-add-user",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadZipAndAddUser(@ModelAttribute User user,
            @RequestBody MultipartFile multipartFile){
       System.out.println(user);
       System.out.println(multipartFile.getName());
       return new ResponseEntity<>("Zip Upload And Add User", HttpStatus.OK);
    }

}

