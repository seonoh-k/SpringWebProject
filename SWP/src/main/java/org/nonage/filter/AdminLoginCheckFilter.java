package org.nonage.filter;


import lombok.extern.log4j.Log4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Log4j
public class AdminLoginCheckFilter implements Filter {

    /**
     * 세션 체크가 필요한 URL 목록
     * web.xml 파일
     * QnA 관리자 요청이름으로된 XML 주석이 시작점이며 참고 할 것
     */
    private final List<String> protectedUrls = Arrays.asList(
            "/qna/adminqnalist",
            "/qna/adminqnadetail",
            "/qna/adminqnainsert",
            "/product/adminproductdetail",
            "/product/adminproductlist",
            "/product/productinsert",
            "/product/productmodify",
            "/product/adminproductsearch"
    );

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     *
     * @param request   클라이언트의 요청 정보를 담고 있는 객체 (HTTP 요청 포함)
     * @param response  클라이언트에게 응답을 보내기 위한 객체
     * @param chain     현재 필터 이후에 존재하는 필터나 최종 서블릿(컨트롤러)으로 요청을 전달하는 객체
     * @throws IOException
     * @throws ServletException
     *
     * 관리자 전용 URL에 요청이 들어왔을 때,
     * 세션에 admin이 없으면 로그인 페이지로 보내고,
     * 그렇지 않으면 그대로 진행시키는 필터
     *
     * boolean isLoginRequired  요청 -> 관리자 로그인이 필요한 URL 이냐?
     * boolean isLoggedIn       요청 -> 현재 로그인 되어 있는 관리자냐?
     *
     * if (isLoginRequired && !isLoggedIn) : 로그인 필요하고, 로그인 안 되어 있음 → 로그인 페이지로 강제 이동
     *
     * chain.doFilter(request, response) : 지금 필터에서 모든 조건 검사 완료 → 다음 필터 또는 최종 목적지(서블릿, 컨트롤러)로 요청을 전달
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        String uri = req.getRequestURI();
        HttpSession session = req.getSession(false);

        boolean isLoginRequired = protectedUrls.stream().anyMatch(uri::startsWith);
        boolean isLoggedIn = session != null && session.getAttribute("admin") != null;

        if (isLoginRequired && !isLoggedIn) {
            log.info("[AdminLoginCheckFilter] 로그인 필요 [" + uri + "]");
            ( (HttpServletResponse) response).sendRedirect("/admin/adminlogin");
            return;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.info("[AdminLoginCheckFilter] execute destroy");
    }
}

