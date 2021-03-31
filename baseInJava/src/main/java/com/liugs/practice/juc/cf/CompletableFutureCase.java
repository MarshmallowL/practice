package com.liugs.practice.juc.cf;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author liugs
 * @createTime 2021/3/31 22:56
 * CompletableFutureCase api实例类
 */
public class CompletableFutureCase {
    public CombineVo queryCombineVO(String idCard){
        long beginTime = System.currentTimeMillis();
        PersonVO personVO = QueryServer.queryPerson(idCard);
        List<PhoneVO> phoneVOS = new ArrayList<>();
        personVO.getPhoneNum().forEach(phoneNum -> phoneVOS.add(QueryServer.queryPhone(phoneNum)));
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - beginTime) + "ms");
        return new CombineVo(phoneVOS,personVO);
    }

    public static void main(String[] args) {
        CompletableFutureCase futureCase = new CompletableFutureCase();
        CombineVo vo = futureCase.queryCombineVO("430981199802141234");
        System.out.println(vo.getPersonVO());
        System.out.println(vo.getPhoneVOS().get(0));
    }
}
