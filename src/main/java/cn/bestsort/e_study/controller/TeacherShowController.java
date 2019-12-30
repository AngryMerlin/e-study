package cn.bestsort.e_study.controller;

import cn.bestsort.e_study.service.TeacherShowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * TODO
 *
 * @author bestsort
 * @version 1.0
 * @date 12/30/19 10:29 AM
 */
@Api(tags = "教师风采相关")
@RestController
public class TeacherShowController {
    @Autowired
    private TeacherShowService teacherShowService;

    @ApiOperation("通过pageNo(页码)和pageSize(页大小)获取对应列表")
    @GetMapping("/listTeacherShows")
    public List<TeacherShow> listTeacherShow(@RequestParam(name = "pageSize",defaultValue = "5") int pageSize,
                                             @RequestParam(name = "pageNo",defaultValue = "1") int pageNo){
        return teacherShowService.listTeacherShows(pageNo,pageSize);

    }
}