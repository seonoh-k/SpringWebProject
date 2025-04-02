package org.nonage.domain;

import lombok.Data;

@Data
public class PageVO {

    private int page; // 현재 사용자가 보고 있는 페이지
    private int limit; // 한 페이지당 보여줄 항목 수
    private int totalCount; // 전체 제품 수
    private int startPage; // 현재 보여줄 페이지 번호의 시작번호 보통 1
    private int endPage; // 화면에 보여줄 페이지 번호의 마지막 번호 endPage = 10이면 1 ~ 10까지 페이지 링크가 나옴
    private int maxPage; // 전체 페이지 수 totalCount와 limit을 기준으로 계산 총 95개 데이터, 한 페이지에 10개씩이면 → maxPage = 10



    private boolean prev;    // 이전 페이지 블럭 존재 여부
    private boolean next;    // 다음 페이지 블럭 존재 여부

    private int startRow; // 현재 페이지의 시작 행 번호
    private int endRow; // 현재 페이지의 끝 행 번호 쿼리에서 rnum <= endRow 조건에 사용됨

    /**
     *
     * @param page // 현재 사용자가 보고 있는 페이지
     * @param totalCount // 전체 제품 수
     * @param startPage // 현재 보여줄 페이지 번호의 시작번호 보통 1
     * @param endPage // 화면에 보여줄 페이지 번호의 마지막 번호 endPage = 10이면 1 ~ 10까지 페이지 링크가 나옴
     *
     */
    public PageVO(int page ,int totalCount) {
        this.page = page;
        this.limit = 10; // 고정값, 필요 시 setter 만들어도 됨
        this.totalCount = totalCount;

        this.maxPage = (int) Math.ceil((double) totalCount / limit);
        this.startPage = ((page - 1) / 10) * 10 + 1;
        this.endPage = Math.min(startPage + 9, maxPage); // 1 vs max page가 1 + 9 보다 작은 경우 대비

        this.prev = startPage > 1;
        this.next = endPage < maxPage;

        this.startRow = (page - 1) * limit;
        this.endRow = startRow + limit;
    }

}
