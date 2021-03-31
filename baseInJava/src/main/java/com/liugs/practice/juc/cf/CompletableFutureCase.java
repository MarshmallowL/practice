package com.liugs.practice.juc.cf;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @author liugs
 * @createTime 2021/3/31 22:56
 * CompletableFutureCase api实例类
 */
public class CompletableFutureCase {
    public CombineVo queryCombineVO(String idCard) {
        long beginTime = System.currentTimeMillis();
        PersonVO personVO = QueryServer.queryPerson(idCard);
        List<PhoneVO> phoneVOS = new ArrayList<>();
        personVO.getPhoneNum().forEach(phoneNum -> phoneVOS.add(QueryServer.queryPhone(phoneNum)));
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - beginTime) + "ms");
        return new CombineVo(phoneVOS, personVO);
    }

    //
    public CombineVo queryWithCf(String idCard) {
        long begin = System.currentTimeMillis();
        CompletableFuture<PersonVO> personVOCf = CompletableFuture.supplyAsync(() -> QueryServer.queryPerson(idCard));
        PersonVO personVO = personVOCf.join();
        //应该使用两个流水线完成操作，因为流是顺序执行的，只有前一个CompletableFuture执行完才能创建下一个
        //因此应该将CompletableFuture的创建和获取结果分开
        List<CompletableFuture<PhoneVO>> list = personVO.getPhoneNum().stream()
                .map(phone -> CompletableFuture.supplyAsync(() -> QueryServer.queryPhone(phone)))
                .collect(Collectors.toList());
        List<PhoneVO> phoneVOList = list.stream().map(CompletableFuture::join).collect(Collectors.toList());

//        List<PhoneVO> phoneVOList = personVO.getPhoneNum().stream()
//                .map(phone -> CompletableFuture.supplyAsync(() -> QueryServer.queryPhone(phone)))
//                .map(CompletableFuture::join)
//                .collect(Collectors.toList());
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - begin) + "ms");
        return new CombineVo(phoneVOList, personVO);
    }

    public static void main(String[] args) {
        CompletableFutureCase futureCase = new CompletableFutureCase();
        CombineVo vo = futureCase.queryWithCf("430981199802141234");
        System.out.println(vo.getPersonVO());
        System.out.println(vo.getPhoneVOS().get(0));
    }
}
