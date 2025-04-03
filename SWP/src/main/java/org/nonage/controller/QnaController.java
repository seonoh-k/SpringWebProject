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
public class QnaController {

    private QnaService qnaService;

    public QnaController(QnaService qnaService) {
        this.qnaService = qnaService;
    }

    // =============================MEMBER QNA=================================
    @GetMapping("/qnalist")
    public String getList(HttpSession session, Model model) {
        MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
        if (loginUser == null) {
            return "redirect:/login";
        }

        List<QnaVO> qnaList = qnaService.getList(loginUser.getId());
        model.addAttribute("qnaList", qnaList);
        return "qna/qna_list";
    }


    @GetMapping("/qnadetail")
    public String getDetail(@RequestParam("qseq") int qseq, HttpSession session, Model model) {
        MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
        if (loginUser == null) {
            return "redirect:/login";
        }

        QnaVO qna = qnaService.getDetail(qseq);
        model.addAttribute("qna", qna);
        return "qna/qna_detail";
    }


    @GetMapping("/qnainsert")
    public String qnaInsertForm(HttpSession session) {
        MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
        if (loginUser == null) {
            return "redirect:/login";
        }
        return "qna/qna_insert";
    }


    @PostMapping("/qnainsert")
    public String qnaInsert(@ModelAttribute QnaVO qna, HttpSession session) {
        MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
        if (loginUser == null) {
            return "redirect:/login";
        }

        qnaService.qnaInsert(qna, loginUser.getId());
        return "redirect:/qnalist";
    }

    // ==================================ADMIN========================================
    @GetMapping("/adminqnalist")
    public String adminQnaList(HttpSession session, Model model) {
        Object adminLoginUser = session.getAttribute("adminLoginUser");
        if (adminLoginUser == null) {
            return "redirect:/admin/login";
        }

        List<QnaVO> qnaList = qnaService.adminGetList();
        model.addAttribute("adminQnaList", qnaList);
        return "admin/qna/admin_qna_list";
    }


    @GetMapping("/adminqnadetail")
    public String adminQnaDetail(@RequestParam("qseq") int qseq, HttpSession session, Model model) {
        Object adminLoginUser = session.getAttribute("adminLoginUser");
        if (adminLoginUser == null) {
            return "redirect:/admin/login";
        }

        QnaVO qna = qnaService.adminGetDetail(qseq);
        model.addAttribute("qna", qna);
        return "admin/qna/admin_qna_detail";
    }


    @PostMapping(value = "/reply",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> insertReply(@RequestBody QnaVO qna, HttpSession session) {

        log.info("받은 QnA 데이터: " + qna);

        if (session.getAttribute("adminLoginUser") == null) {
            log.warn("관리자 로그인 필요");
            return new ResponseEntity<>("UNAUTHORIZED", HttpStatus.UNAUTHORIZED);
        }

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