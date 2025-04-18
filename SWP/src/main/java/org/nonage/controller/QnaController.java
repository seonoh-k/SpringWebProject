package org.nonage.controller;

import lombok.extern.log4j.Log4j;
import org.nonage.domain.MemberVO;
import org.nonage.domain.QnaVO;
import org.nonage.service.QnaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Log4j
@Controller
@RequestMapping("/qna/*")
public class QnaController {

    private QnaService qnaService;

    public QnaController(QnaService qnaService) {
        this.qnaService = qnaService;
    }

    // =============================MEMBER QNA=================================
    @GetMapping("/qnalist")
    public String getList(HttpSession session, Model model) {
        MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");

        List<QnaVO> qnaList = qnaService.getList(loginUser.getId());
        model.addAttribute("qnaList", qnaList);
        return "qna/qnalist";
    }


    @GetMapping("/qnadetail")
    public String getDetail(@RequestParam("qseq") int qseq, Model model) {

        QnaVO qna = qnaService.getDetail(qseq);
        model.addAttribute("qna", qna);
        return "qna/qnadetail";
    }


    @GetMapping("/qnainsert")
    public String qnaInsertForm() {

        return "qna/qnainsert";
    }


    @PostMapping("/qnainsert")
    public String qnaInsert(@ModelAttribute QnaVO qna, HttpSession session) {
        MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");

        qnaService.qnaInsert(qna, loginUser.getId());
        return "redirect:/qna/qnalist";
    }

    // ==================================ADMIN========================================
    @GetMapping("/adminqnalist")
    public String adminQnaList(Model model) {
        List<QnaVO> qnaList = qnaService.adminGetList();
        model.addAttribute("adminQnaList", qnaList);
        return "qna/adminqnalist";
    }


    @GetMapping("/adminqnadetail")
    public String adminQnaDetail(@RequestParam("qseq") int qseq, Model model) {
        QnaVO qna = qnaService.adminGetDetail(qseq);
        model.addAttribute("qna", qna);
        return "qna/adminqnadetail";
    }


    @PostMapping(value = "/reply",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> insertReply(@RequestBody QnaVO qna, HttpSession session) {

        log.info("받은 QnA 데이터: " + qna);

        try {
            qnaService.qnaInsertReply(qna);
            log.info("답글 등록 성공");
            return new ResponseEntity<>("success", HttpStatus.OK);
        } catch (Exception e) {
            log.error("답글 등록 실패", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}