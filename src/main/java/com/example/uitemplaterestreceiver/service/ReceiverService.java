package com.example.uitemplaterestreceiver.service;

import com.example.uitemplaterestreceiver.model.response.Employee;
import com.example.uitemplaterestreceiver.model.response.EmployeeList;
import com.example.uitemplaterestreceiver.model.response.StringList;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author: Linn Lat Htun
 * @created: 11/09/2022
 * @project: uitemplate-restreceiver
 * @package: com.example.uitemplaterestreceiver.service
 */

public interface ReceiverService {
    Employee requestBodyObj(Employee employee);

    List<Employee> requestBodyObjList(EmployeeList employeeList);

    List<String> requestBodyStringList(StringList stringList);

    void requestPathVariable(Integer id);

    void requestMultiplePathVariables(Integer id, String name);

    void requestParamInteger(Integer id);

    void requestMultiParams(Integer id, String name);

    void requestPathVariableAndParam(Integer id, String name);

    void requestFromHeader(Map<String, String> allHeaderMap);

    void requestFromHeaderAndRequestParam(Map<String, String> allHeaderMap, String name);

    void requestFormHeaderAndRequestBody(Map<String, String> allHeaderMap, Employee employee);

    void requestFileUpload(MultipartFile file);

    void requestBulkFileUpload(Map<String, String> allHeaderMap, MultipartFile file);


}
