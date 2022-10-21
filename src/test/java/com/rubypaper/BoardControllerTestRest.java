package com.rubypaper;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.GetMapping;

import com.rubypaper.service.BoardService_미사용;
import com.rubypaper.controller.BoardController;
import com.rubypaper.domain.BoardVO;


@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class BoardControllerTestRest {
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void testHello() throws Exception {
		String result = restTemplate.getForObject("/hello?name=둘리", String.class);
		assertEquals("Hello2 : 둘리", result);
	}
	
	
	@Test
	public void testGetBoard() throws Exception {
		System.out.println("------->");		
		
		BoardVO b= restTemplate.getForObject("/getBoard",BoardVO.class);		
		
		System.out.println(b.getSeq());
		System.out.println(b.getTitle());
		System.out.println(b.getContent());
		System.out.println(b.getWriter());
		System.out.println(b.getCreateDate());
	}	
	
	
	
	@Test
	public void testGetBoardList() throws Exception {
		System.out.println("------->");
		
		// ForObject 메서드
		BoardVO[] boardList = restTemplate.getForObject("/getBoardList",BoardVO[].class);

		
//		exchange에서 ParameterizedTypeReference 사용		
//		ResponseEntity<List<BoardVO>> response = restTemplate.exchange("/getBoardList",HttpMethod.GET, null, new ParameterizedTypeReference<List<BoardVO>>() {});
//		List<BoardVO> boardList = response.getBody();		
		
//		ForEntity를 사용
//		ResponseEntity<BoardVO[]> responseEntity = restTemplate.getForEntity("/getBoardList", BoardVO[].class);
//		List<BoardVO> boardList = Arrays.asList(responseEntity.getBody());

				
		
		for(BoardVO b : boardList) {	
			System.out.println(b);			
		}
			
		
	}	
	
	
}


