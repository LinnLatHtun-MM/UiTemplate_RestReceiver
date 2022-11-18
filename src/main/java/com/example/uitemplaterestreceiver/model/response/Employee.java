package com.example.uitemplaterestreceiver.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Linn Lat Htun
 * @created: 11/09/2022
 * @project: uitemplate-restreceiver
 * @package: com.example.uitemplaterestreceiver.response
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String name;
    private String address;
    private String phNo;
}
