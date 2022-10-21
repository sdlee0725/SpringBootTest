package com.rubypaper;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.rubypaper.service.BoardService_미사용;
import com.rubypaper.controller.BoardController;
import com.rubypaper.domain.BoardVO;


@SpringBootTest(webEnvironment=WebEnvironment.MOCK) //컨테이너 구동하지 않음
@AutoConfigureMockMvc
public class BoardControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private BoardService_미사용 boardService;
	
	//@Test
	public void testHello() throws Exception {
		when(boardService.hello("둘리")).thenReturn("Hello2 : 둘리");
		
		mockMvc.perform(get("/hello").param("name", "둘리"))
				.andExpect(status().isOk())				
				.andExpect(content().string("Hello2 : 둘리"))
				.andDo(print());
		
	}
	
	
	
	
	
//	//////////////////////////////////////////////////////////
//	@Autowired
//	BoardController boardController;
//	
//	@Test
//	public void testHello2() throws Exception {		
//		System.out.println("------->");
//		String returnValue=boardController.hello("이건 실제로 호출함");
//		System.out.println(returnValue);
//		
//		System.out.println("------->");
//		List<BoardVO> boardList = new ArrayList<BoardVO>();
//		boardList = boardController.getBoardList();		
//		for(BoardVO b : boardList) {	
//			System.out.println(b);
//		}
//		
//	}
	
}


