package com.feng.controller;

import com.feng.Service.SeckillService;
import com.feng.dto.ExposerDTO;
import com.feng.dto.SeckillExecutionDTO;
import com.feng.dto.SeckillResult;
import com.feng.entity.SecKill;
import com.feng.enums.SeckillStateEnum;
import com.feng.exception.RepeatKillException;
import com.feng.exception.SeckillCloseException;
import com.feng.vo.QueryByPageVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/secKill")//url:/模块/资源/{id}/细分
public class SeckillController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<SecKill> list(QueryByPageVO queryByPageVO){
        int limit = queryByPageVO.getPageSize();
        int offset = queryByPageVO.getPageNum()*limit+1;

        List<SecKill> secKillList = seckillService.getSeckillListByOffset(offset,limit);
        //获取列表页
        return secKillList;
    }

    @RequestMapping(value = "/{seckillId}/detail",method = RequestMethod.GET)
    public SeckillResult<SecKill> getSecKillById(@PathVariable("seckillId") Long secKillId, Model model){
        if(secKillId == null){
            return new SeckillResult<SecKill>(false,"请输入商品ID");
        }
        SecKill secKill =  seckillService.getSeckillById(secKillId);
        if (secKill == null){
            return new SeckillResult<SecKill>(false,"没有找到");
        }
        return new SeckillResult<SecKill>(true,secKill);
    }

    @RequestMapping(value = "/{seckillId}/exposer",
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SeckillResult<ExposerDTO> exposer(Long seckillId){
        SeckillResult<ExposerDTO> result ;
        try {
            ExposerDTO exposerDTO = seckillService.exportSeckillUrl(seckillId);
            result = new SeckillResult<ExposerDTO>(true, exposerDTO);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            result = new SeckillResult<ExposerDTO>(false,e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/{seckillId}/{md5}/execution", method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SeckillResult<SeckillExecutionDTO> execute(@PathVariable("seckillId")Long seckillId,
                                                      @PathVariable("md5") String md5,
                                                      @CookieValue(value = "killphone",required = false) Long phone){
        //springmvc valid
        if(phone==null){
            return new SeckillResult<SeckillExecutionDTO>(false,"未注册");
        }
        SeckillResult<ExposerDTO> result ;
        try {
            SeckillExecutionDTO execution = seckillService.executeSeckill(seckillId, phone, md5);
            return new SeckillResult<SeckillExecutionDTO>(true, execution);
        }catch (RepeatKillException e){
            SeckillExecutionDTO seckillExecutionDTO = new SeckillExecutionDTO(seckillId, SeckillStateEnum.REPEAT_KILL);
            return new SeckillResult<SeckillExecutionDTO>(false,seckillExecutionDTO);
        }catch (SeckillCloseException e){
            SeckillExecutionDTO seckillExecutionDTO = new SeckillExecutionDTO(seckillId, SeckillStateEnum.END);
            return new SeckillResult<SeckillExecutionDTO>(false,seckillExecutionDTO);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            SeckillExecutionDTO seckillExecutionDTO = new SeckillExecutionDTO(seckillId, SeckillStateEnum.INNER_ERROR);
            return new SeckillResult<SeckillExecutionDTO>(false,seckillExecutionDTO);
        }
    }

    @RequestMapping(value = "time/now", method = RequestMethod.GET)
    @ResponseBody
    public SeckillResult<Long> time(){
        Date now = new Date();
        return new SeckillResult(true,now.getTime());
    }


}
