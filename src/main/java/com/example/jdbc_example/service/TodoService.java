package com.example.jdbc_example.service;

import com.example.jdbc_example.dao.TodoDAO;
import com.example.jdbc_example.dto.TodoDTO;
import com.example.jdbc_example.domain.TodoVO;
import com.example.jdbc_example.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public enum TodoService {
    INSTANCE;

    private final TodoDAO dao;
    private final ModelMapper modelMapper;

    TodoService(){
        dao = new TodoDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    public void register(TodoDTO todoDTO) throws Exception{
        TodoVO vo = modelMapper.map(todoDTO, TodoVO.class);
      //System.out.println("todo VO: " + vo);
        log.info(vo);

        dao.insert(vo);
    }

    public List<TodoDTO> listAll() throws Exception{
        List<TodoVO> voList = dao.selectAll();
        log.info("Value Object List.................");
        log.info(voList);

        List<TodoDTO> dtoList = voList.stream().map(vo -> modelMapper.map(vo,TodoDTO.class)).collect(Collectors.toList());

        return dtoList;
    }



}
