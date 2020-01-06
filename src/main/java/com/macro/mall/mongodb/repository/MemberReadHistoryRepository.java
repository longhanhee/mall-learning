package com.macro.mall.mongodb.repository;


import com.macro.mall.mongodb.document.MemberReadHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface MemberReadHistoryRepository extends MongoRepository<MemberReadHistory,String> {
    /**
     * 根据会员id按时间倒序获取浏览记录
     * @param memberId 会员id
     */
    List<MemberReadHistory> findByMemberIdOrderByCreateTimeDesc(Long memberId);
    @Query("{ 'memberId' : ?0 }")
    List<MemberReadHistory> findByMemberId(Long memberId);
}