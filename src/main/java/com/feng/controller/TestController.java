package com.feng.controller;

import com.feng.Service.SeckillService;
import com.feng.dao.FestivalMapper;
import com.feng.dao.PlanMapper;
import com.feng.dto.CommonResult;
import com.feng.entity.Festival;
import com.feng.entity.Plan;
import com.feng.entity.SecKill;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 萨达
 * Created by TTfly on 2017/6/12.
 */
@Controller
@RequestMapping("")
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private SeckillService seckillService;

    @Autowired
    private FestivalMapper festivalMapper;

    @Autowired
    private PlanMapper planMapper;

    @RequestMapping("products")
    @ResponseBody
    public CommonResult<List<SecKill>> getSeckill() {
        List<SecKill> secKillList = seckillService.getSeckillListByOffset(0, 5);
        return new CommonResult<List<SecKill>>(0, "success", secKillList);
    }

    @RequestMapping(value = "plans/{pageNum}/{pageSize}/")
    @ResponseBody
    public CommonResult<PageInfo> getPlans(@PathVariable("pageNum")Integer pageNum,
                                               @PathVariable("pageSize")Integer pageSize) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 5;
        }

        PageHelper.startPage(pageNum, pageSize);

        List<Plan> planList = planMapper.selectAll();
        logger.error("sadasd:" + planList);
        PageInfo pageResult = new PageInfo(planList);
        pageResult.setList(planList);
        return new CommonResult<PageInfo>(0, "success", pageResult);
    }

    @RequestMapping(value = "festivals/{pageNum}/{pageSize}/")
    @ResponseBody
    public CommonResult<PageInfo> getFestivals(@PathVariable("pageNum")Integer pageNum,
                                               @PathVariable("pageSize")Integer pageSize,
                                               @Param("param1")String param1
                                               ) {
        System.out.println(param1);
        if(pageNum==null){
            pageNum = 1;
        }
        if(pageSize==null){
            pageSize = 5;
        }

        PageHelper.startPage(pageNum,pageSize);

        List<Festival> festivalList = festivalMapper.selectAll();
        logger.error("sadasd:"+festivalList);
        PageInfo pageResult = new PageInfo(festivalList);
        pageResult.setList(festivalList);
        return new CommonResult<PageInfo>(0, "success", pageResult);


//        Gift gift1 = new Gift(1, "热门", "remen", "sadasdasdasd");
//        Gift gift2 = new Gift(2, "儿童节", "remen", "sadasdasdasd");
//        Gift gift3 = new Gift(3, "端午节", "remen", "sadasdasdasd");
//        Gift gift4 = new Gift(4, "国庆节", "remen", "sadasdasdasd");
//        Gift gift5 = new Gift(5, "清明节", "remen", "sadasdasdasd");
//        Gift gift6 = new Gift(6, "元旦节", "remen", "sadasdasdasd");
//        Gift gift7 = new Gift(7, "春节", "remen", "sadasdasdasd");
//        Gift gift8 = new Gift(8, "情人节", "remen", "sadasdasdasd");
//        Gift gift9 = new Gift(9, "白色情人节", "remen", "sadasdasdasd");
//        gifts.add(gift1);
//        gifts.add(gift2);
//        gifts.add(gift3);
//        gifts.add(gift4);
//        gifts.add(gift5);
//        gifts.add(gift6);
//        gifts.add(gift7);
//        gifts.add(gift8);
//        gifts.add(gift9);
//        return new CommonResult<List<Festival>>(0, "success", gifts);
//        return null;
    }
}
