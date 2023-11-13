package com.example.jdbc_example.controller;


import com.example.jdbc_example.service.TodoService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import java.io.IOException;

@Log4j2
@WebServlet(name = "todoListController", value="/todo/list")
public class TodoListController extends HttpServlet {

    private final TodoService todoService = TodoService.INSTANCE;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("---------------------------------------------");
    }
}

// 2023-10-31 20:32:52 황준서
// servlet 관련 라이브러리 import할 떄 jakarta 제공 라이브러리를 적용할 경우 오류 발생, javax로 진행 시 오류 발생하지 않음
// 이유 확인 필요