package com.rubypaper.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.PostMapping;

import com.rubypaper.domain.BoardVO;
import com.rubypaper.domain.Board;
import com.rubypaper.service.BoardService_old;
import com.rubypaper.service.BoardService;

//@RestController
@Controller
public class BoardController {
	@Autowired 
	private BoardService_old boardService_old;
	
	@Autowired 
	private BoardService boardService;
	
	@RequestMapping("/hello")
	public void hello(Model model) {
		System.out.println("KKKKK"+model.getAttribute("name"));
	}
	
//	@GetMapping("/hello")
//	public String hello(Model model) {		
//		model.addAttribute("greeting","Hello 타임리프. ^^");
//		return "hello";
//	}
	
//	@GetMapping("/getBoard")
//	public BoardVO getBoard() {
//		return boardService_old.getBoard();
//	}
	
//	@GetMapping("/getBoardList")
//	public List<Board> getBoardList() {
//		Board board=new Board();
//		board.setTitle("제목을 수정했습니다.");
//		return boardService.getBoardList(board);		
//	}
	
	
	@RequestMapping("/board/getBoardList")
	public String getBoardList(Model model, Board board) {
		List<Board> boardList = boardService.getBoardList(board);
		model.addAttribute("boardList", boardList);
		return "/board/getBoardList";
	}
	
	@GetMapping("/board/getBoard")
	public String getBoard(Board board, Model model) {
		model.addAttribute("board", boardService.getBoard(board));
		return "getBoard";
	}
	@GetMapping("/board/insertBoard")
	public String insertBoardView() {
//		if (member.getId() == null) {
//			return "redirect:login";
//		}

		return "insertBoard";
	}

	@PostMapping("/board/insertBoard")
	public String insertBoard(Board board) {
		
		boardService.insertBoard(board);
		return "redirect:getBoardList";
	}

	@PostMapping("/board/updateBoard")
	public String updateBoard(Board board) {
		boardService.updateBoard(board);
		return "forward:getBoardList";
	}
	
	@GetMapping("/board/deleteBoard")
	public String deleteBoard(Board board) {
		boardService.deleteBoard(board);
		return "forward:/board/getBoardList";
	}
	
	
	public BoardController() {
		System.out.println("===> BoardController 생성");
	}
	
//	@GetMapping("/hello")
//	public String hello(String name) {
//		return "Hello : " + name;
//	}
//	
//	@GetMapping("/getBoard")
//	public BoardVO getBoard() {
//		BoardVO board = new BoardVO();
//		board.setSeq(1);
//		board.setTitle("테스트 제목...");
//		board.setWriter("테스터");
//		board.setContent("테스트 내용입니다...............");
//		board.setCreateDate(new Date());
//		board.setCnt(0);
//		return board;
//	}
//	
//	@GetMapping("/getBoardList")
//	public List<BoardVO> getBoardList() {
//		List<BoardVO> boardList = new ArrayList<BoardVO>();
//		for (int i = 1; i <= 5; i++) {
//			BoardVO board = new BoardVO();
//			board.setSeq(i);
//			board.setTitle("제목" + i);
//			board.setWriter("테스터");
//			board.setContent(i + "번 내용입니다.");
//			board.setCreateDate(new Date());
//			board.setCnt(0);
//			boardList.add(board);
//		}
//		return boardList;
//	}


}
