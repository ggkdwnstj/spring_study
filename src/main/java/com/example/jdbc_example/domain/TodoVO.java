package com.example.jdbc_example.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Builder
@ToString

public class TodoVO {

    private long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;

}
