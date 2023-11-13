package com.example.jdbc_example.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@ToString
@NoArgsConstructor // 파라미터가 없는 생성자
@AllArgsConstructor // 모든 필드값이 필요한 생성자


public class TodoVO {

    private long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;

}
