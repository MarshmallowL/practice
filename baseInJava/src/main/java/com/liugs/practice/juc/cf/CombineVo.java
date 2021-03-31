package com.liugs.practice.juc.cf;

import lombok.Data;

import java.util.List;

/**
 * @author liugs
 * @createTime 2021/3/31 23:05
 */
@Data
public class CombineVo {
    private List<PhoneVO> phoneVOS;
    private PersonVO personVO;

    public CombineVo(List<PhoneVO> phoneVOS, PersonVO personVO) {
        this.phoneVOS = phoneVOS;
        this.personVO = personVO;
    }


}
