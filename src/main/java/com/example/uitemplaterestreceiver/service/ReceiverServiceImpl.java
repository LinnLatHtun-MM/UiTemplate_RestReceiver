package com.example.uitemplaterestreceiver.service;

import com.example.uitemplaterestreceiver.model.response.Employee;
import com.example.uitemplaterestreceiver.model.response.EmployeeList;
import com.example.uitemplaterestreceiver.model.response.StringList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author: Linn Lat Htun
 * @created: 11/09/2022
 * @project: uitemplate-restreceiver
 * @package: com.example.uitemplaterestreceiver.service
 */

@Slf4j
@Service
public class ReceiverServiceImpl implements ReceiverService {

    @Override
    public Employee requestBodyObj(Employee employee) {
        return employee;
    }

    @Override
    public List<Employee> requestBodyObjList(EmployeeList employeeList) {
        //In this case, you want to save many employees to DB as your business application logic.
        //I will show only demo.
        return null;
    }

    @Override
    public List<String> requestBodyStringList(StringList stringList) {
        //In this case you want to save many roles (example as string) in db with only one api.
        List<String> strList = stringList.getStringList();
        return strList;
    }

    @Override
    public void requestPathVariable(Integer id) {
        System.out.println("Request Path Variable with Id : " + id);
    }

    @Override
    public void requestMultiplePathVariables(Integer id, String name) {
        System.out.println("Request Multiple PathVariables  with Id and Name : " + id + " " + name);
    }

    @Override
    public void requestParamInteger(Integer id) {
        System.out.println("Request Param with Id : " + id);
    }

    @Override
    public void requestMultiParams(Integer id, String name) {
        System.out.println("Request Multiple Params with Id and Name : " + id + " " + name);
    }

    @Override
    public void requestPathVariableAndParam(Integer id, String name) {
        System.out.println("Request Path Variable with Id : " + id);
        System.out.println("Request Param with Name : " + name);
    }

    @Override
    public void requestFromHeader(Map<String, String> allHeaderMap) {
        System.out.println("Request From Header with Map : " + allHeaderMap);
    }

    @Override
    public void requestFromHeaderAndRequestParam(Map<String, String> allHeaderMap, String name) {
        System.out.println("Request From Header with Map : " + allHeaderMap);
        System.out.println("Request Param with Name : " + name);
    }

    @Override
    public void requestFormHeaderAndRequestBody(Map<String, String> allHeaderMap, Employee employee) {
        System.out.println("Request From Header with Map : " + allHeaderMap);
        System.out.println("RequestBody with Obj : " + employee);
    }

    @Override
    public void requestFileUpload(MultipartFile multipartFile) {

        try {
            log.info("request file name: {}", multipartFile.getOriginalFilename());
            log.info("request file content type: {}", multipartFile.getContentType());

            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

            if (multipartFile != null || !fileName.trim().equals(" ")) {
                File file = new File(multipartFile.getOriginalFilename());
                file.createNewFile();
                FileOutputStream fos = new FileOutputStream(file);
                fos.write(multipartFile.getBytes());
                fos.close();
                //studentService.requestFileUploadDemo(file, multipartFile.getOriginalFilename());
                //File change to byte and save db

            } else {
                log.warn("file is empty");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void requestBulkFileUpload(Map<String, String> allHeaderMap, MultipartFile file) {
        // here, you can read that request file and convert bytes and save into db or upload into file server or sending as email attachment or do your logic depend on your application business logic.
        // here, I show as demo and don't do any other logic
    }

    // below code is demo retrieving data from database with pageable
    /**
     * Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
     * // you can use slice for better performance if you don't need to know total pageSize
     * Page<AccountHistory> pagedResult = repository.findByAccountNameAndServiceType(accountName, actionType, paging);
     * if(pagedResult.hasContent())
     *      return pagedResult.getContent();
     * else return new ArrayList<AccountHistory>();
     */


}
