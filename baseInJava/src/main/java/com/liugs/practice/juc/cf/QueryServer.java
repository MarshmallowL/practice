package com.liugs.practice.juc.cf;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author liugs
 * @createTime 2021/3/31 22:44
 * @description 模拟查询类
 */
public class QueryServer {
    private static Map<String,PhoneVO> phoneNumMap = Stream.of("13612341234", "13612341235", "13612341236", "13612341237")
            .map(phone -> new PhoneVO(phone,Long.parseLong(phone) / 2 == 0 ? "移动" : "联通","广州"))
            .collect(Collectors.toMap(PhoneVO::getPhoneNum, vo -> vo));

    public static PersonVO queryPerson(String idCard) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<String> phoneNumList = Stream.of("13612341234", "13612341235", "13612341236", "13612341237")
                .collect(Collectors.toList());
        return new PersonVO(idCard, "李四", phoneNumList);
    }

    public static PhoneVO queryPhone(String phoneNum){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return phoneNumMap.get(phoneNum);
    }
}
