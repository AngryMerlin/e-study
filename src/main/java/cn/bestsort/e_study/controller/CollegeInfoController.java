package cn.bestsort.e_study.controller;

import cn.bestsort.e_study.pojo.query.CollegeInfoQuery;
import cn.bestsort.e_study.pojo.vo.CollegeInfoVo;
import cn.bestsort.e_study.service.CollegeInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * TODO
 *
 * @author bestsort
 * @version 1.0
 * @date 12/31/19 10:31 AM
 */
@Api(tags = "高考资讯相关接口")
@RestController
@RequestMapping("/College")
public class CollegeInfoController {
    @Autowired
    private CollegeInfoService service;

    @GetMapping("/listByQuery")
    public List<CollegeInfoVo> listCollege(CollegeInfoQuery collegeInfoVo){
        return service.listCollege(collegeInfoVo);
    }

    @ApiOperation("获取所有的学区")
    @GetMapping("/listAllArea")
    public List<String> listArea(){
        return service.listArea();
    }
}

