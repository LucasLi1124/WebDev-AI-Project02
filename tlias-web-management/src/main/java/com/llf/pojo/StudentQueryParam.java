package com.llf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentQueryParam {
    private int page = 1;
    private int pageSize = 10;
    private String name;
    private Integer degree;
    private Integer clazzId;



}
