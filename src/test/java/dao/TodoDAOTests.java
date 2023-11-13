package dao;

import com.example.jdbc_example.dao.TodoDAO;
import com.example.jdbc_example.domain.TodoVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class TodoDAOTests {
    private TodoDAO todoDAO;

    @BeforeEach // 모든 테스트 실행 전에 실행시키는 Annotation
    public void ready() { // 매 테스트 시작 전 TodoDAO 객체 todoDAO 생성
        todoDAO = new TodoDAO();
    }

    @Test
    public void testTime() throws Exception {
        System.out.println(todoDAO.getTime());
    }

    @Test
    public void testInsert() throws Exception {
        TodoVO todoVO = TodoVO.builder()
                .title("This is test")
                .dueDate(LocalDate.now())
                .build();

        todoDAO.insert(todoVO);
    }

    @Test // select * 기능
    public void testSelectAll() throws Exception {
        List<TodoVO> list = todoDAO.selectAll();
        list.forEach(System.out::println);
    }

    @Test // 1개의 튜플 select
    public void testSelectOne() throws Exception {
        Long tno = 2L;
        TodoVO vo = todoDAO.selectOne(tno);

        System.out.println(vo);

    }

    @Test
    public void testUpdateOne() throws Exception{
        TodoVO vo = TodoVO.builder().tno(1L).title("This is updated title.").dueDate(LocalDate.of(2023,10,30)).finished(true).build();

        todoDAO.updateOne(vo);
    }

}

