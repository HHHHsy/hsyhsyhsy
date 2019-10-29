package com.example.student.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class User {




    @Id
    private Long sid;

    private String sname;
    private String sage;
    private String ssex;
    private String sremakers;


}
