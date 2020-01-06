package com.macro.mall.service;

import com.macro.mall.mongodb.document.MemberReadHistory;

import java.util.List;

public interface MemberReadHistoryService {
    /**
     * Tạo lịch sử duyệt web
     */
    int create(MemberReadHistory memberReadHistory);

    /**
     * Xóa hàng loạt lịch sử duyệt web
     */
    int delete(List<String> ids);

    /**
     * Nhận lịch sử duyệt web của người dùng
     */
    List<MemberReadHistory> list(Long memberId);
}
