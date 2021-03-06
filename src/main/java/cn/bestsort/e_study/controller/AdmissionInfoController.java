package cn.bestsort.e_study.controller;

import cn.bestsort.e_study.pojo.dto.AdmissionInfo;
import cn.bestsort.e_study.service.AdmissionInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TODO
 *
 * @author bestsort
 * @version 1.0
 * @date 12/31/19 8:28 AM
 */

@RestController
@RequestMapping("/admission")
@Api(tags = "招生政策相关接口")
public class AdmissionInfoController {
    @Autowired
    private AdmissionInfoService service;

    @ApiOperation(value = "根据学校id获取该学校从begin - end年份的招生信息.",
            notes = "type:学校类型(0表示中考资讯,1表示高考资讯)")
    @GetMapping("/high_school")
    public List<AdmissionInfo> listAdmission(Boolean isCollege,
                                             Long schoolId,
                                             @RequestParam(defaultValue = "2017") Integer begin,
                                             @RequestParam(defaultValue = "2020") Integer end){
        return service.listAdmissionBySchool(isCollege,schoolId,begin,end);
    }
}
