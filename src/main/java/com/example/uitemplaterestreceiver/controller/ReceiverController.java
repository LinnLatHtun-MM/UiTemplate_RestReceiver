package com.example.uitemplaterestreceiver.controller;

import com.example.uitemplaterestreceiver.model.response.Employee;
import com.example.uitemplaterestreceiver.model.response.EmployeeList;
import com.example.uitemplaterestreceiver.model.response.StringList;
import com.example.uitemplaterestreceiver.service.ReceiverService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

/**
 * @author: Linn Lat Htun
 * @created: 11/09/2022
 * @project: uitemplate-restreceiver
 * @package: com.example.uitemplaterestreceiver.controller
 */

@RestController
@RequestMapping("/api")
@Slf4j
public class ReceiverController {

    @Autowired
    ReceiverService receiverService;

    @PostMapping("/requestBodyObjectURL")
    public ResponseEntity requestBodyObjectMethod(@RequestBody Employee employee) {
        try {
            log.info("==== Start Calling Request Body Object Method ====");
            Employee response = receiverService.requestBodyObj(employee);
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/receiver-service/api/requestBodyObjectURL").toUriString());
            log.info("==== Stop Calling Request Body Object Method ====");

            return ResponseEntity.created(uri).body(response);  // if need to return data as body
            //return ResponseEntity.created(uri).build();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error Calling Request Body Method: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }

    }

    @PostMapping("/requestBodyObjectListURL")
    public ResponseEntity requestBodyObjectListMethod(@RequestBody EmployeeList employeeList) {
        try {
            log.info("==== Start Calling Request Body Object List Method ====");
            List<Employee> response = receiverService.requestBodyObjList(employeeList);
            log.info("==== Stop Calling Request Body Object List Method ====");
            return ResponseEntity.ok(employeeList);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error Calling Request Body Object List Method: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }

    }

    @PostMapping("/requestBodyStringListURL")
    public ResponseEntity requestBodyStringListMethod(@RequestBody StringList stringList) {
        try {
            log.info("==== Start Calling Request Body String List Method ====");
            List<String> response = receiverService.requestBodyStringList(stringList);
            log.info("==== Stop Calling Request Body String List Method ====");
            return ResponseEntity.ok(stringList);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error Calling Request Body Object List Method: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }

    }

    @GetMapping("/requestPathVariableURL/{id}")
    public ResponseEntity requestPathVariableMethod(@PathVariable("id") Integer id) {
        try {
            log.info("==== Start Calling Request PathVariable Method ====");
            receiverService.requestPathVariable(id);
            log.info("==== Stop Calling Request PathVariable Method ====");
            return ResponseEntity.ok("PathVariable Integer is " + id);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error Calling Request PathVariable Method: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }

    }

    @GetMapping("/requestMultiPathVariablesURL/{id}/{name}")
    public ResponseEntity requestPathVariableMethod(@PathVariable("id") Integer id, @PathVariable("name") String name) {
        try {
            log.info("==== Start Calling Request Multiple PathVariables Method ====");
            receiverService.requestMultiplePathVariables(id, name);
            log.info("==== Stop Calling Request Multiple PathVariables Method ====");
            return ResponseEntity.ok("PathVariable Integer and String  are: " + id + " " + name);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error Calling Request Multiple PathVariables Method: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }

    }

    @GetMapping("/requestParamURL")
    public ResponseEntity requestParamMethod(@RequestParam Integer id) {
        try {
            log.info("==== Start Calling Request Param Method ====");
            receiverService.requestParamInteger(id);
            log.info("==== Stop Calling Request Param Method ====");
            return ResponseEntity.ok("Param Integer is : " + id);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error Calling Request Param Method: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/requestMultiParamsURL")
    public ResponseEntity requestMultipleParamMethod(@RequestParam Integer id, @RequestParam String name) {
        try {
            log.info("==== Start Calling Multiple Request Param Method ====");
            receiverService.requestMultiParams(id, name);
            log.info("==== Stop Calling Multiple Request Param Method ====");
            return ResponseEntity.ok("Params Integer and String are : " + id + " " + name);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error Calling Multipl Request Param Method: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }

    }

    @GetMapping("/requestPathVariableAndParamsURL/{id}")
    public ResponseEntity requestPathVariableAndParamsMethod(@PathVariable Integer id, @RequestParam String name) {
        try {
            //@RequestParam(defaultValue = "0") Integer pageNo,
            log.info("==== Start Calling PathVariable and Param Request Method ====");
            receiverService.requestPathVariableAndParam(id, name);
            log.info("==== Stop Calling PathVariable and Param Request Method ====");
            return ResponseEntity.ok("PathVariable Integer and Param String are : " + id + " " + name);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error Calling Request Param and PathVariable Method: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }

    }

    @GetMapping("/requestFromHeaderURL")
    public ResponseEntity requestFromHeaderMethod(@RequestHeader Map<String, String> headerMap) {
        try {
            log.info("==== Start Calling Request From Header Method ====");
            receiverService.requestFromHeader(headerMap);
            log.info("==== Stop Calling Request From Header Method ====");
            return ResponseEntity.ok("Header Request : " + headerMap);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error Calling Request Param and PathVariable Method: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }

    }

    @GetMapping("/requestFromHeaderAndRequestParamURL")
    public ResponseEntity requestFromHeaderAndRequestParamMethod(@RequestHeader Map<String, String> headerMap, @RequestParam String name) {
        try {
            log.info("==== Start Calling Request From Header and Param Method ====");
            receiverService.requestFromHeaderAndRequestParam(headerMap, name);
            log.info("==== Stop Calling Request From Header and Param Method ====");
            return ResponseEntity.ok("Header Request and Param : " + headerMap + " Name is: " + name);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error Calling Request From Header and Param Method: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }

    }

    @PostMapping("/requestFromHeaderAndRequestBodyURL")
    public ResponseEntity requestFromHeaderAndRequestBodyMethod(@RequestHeader Map<String, String> headerMap, @RequestBody Employee employee) {
        try {
            log.info("==== Start Calling Request From Header and Request Body Method ====");
            receiverService.requestFormHeaderAndRequestBody(headerMap, employee);
            log.info("==== Stop Calling Request From Header and Request Body Method ====");
            return ResponseEntity.ok("Header Request and Body : " + headerMap + " " + employee);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error Calling Request From Header and Request Body Method: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }

    }


    @PostMapping("/requestFileUploadURL")
    public ResponseEntity requestFileUploadMethod(@RequestParam("file") MultipartFile file) {
        try {
            log.info("==== Start Calling File Upload Method ====");
            receiverService.requestFileUpload(file);

            log.info("==== Stop Calling Request File Upload Method ====");
            return ResponseEntity.ok("File Upload is Successfully! ");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error Calling Request From File Upload Method: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }


    @PostMapping("/requestFromHeaderAndBulkFileUploadURL")
    public ResponseEntity requestBulkFileUploadMethod(@RequestHeader Map<String, String> allHeaderMap, @RequestParam("file") List<MultipartFile> files) {
        try {
            log.info("==== Start Calling Bulk File Upload Method ====");
            for (MultipartFile file : files) {
                log.info("request file name: {}", file.getOriginalFilename());
                log.info("request file content type: {}", file.getContentType());
                receiverService.requestBulkFileUpload(allHeaderMap, file);
            }
            log.info("==== Stop Calling Bulk File Upload Method ====");
            return ResponseEntity.ok("Header and BulkFile Upload is Successfully! ");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error Calling Request From Bulk File Upload Body Method: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }


}
