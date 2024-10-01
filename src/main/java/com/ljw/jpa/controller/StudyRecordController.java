package com.ljw.jpa.controller;

import com.ljw.jpa.entity.Study_record;
import com.ljw.jpa.service.StudyRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller()
@RequestMapping(value = "/study")
public class StudyRecordController {

    @Autowired
    StudyRecordService studyRecordService;

    @GetMapping("/list")
    public ModelAndView list(Model model) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("list", studyRecordService.doSelectAll());
        mav.setViewName("study/study_list");

        return mav;
    }

    @GetMapping("/insert")
    public ModelAndView insert(Model model) {
        ModelAndView mav = new ModelAndView();
        //mav.addObject("list", studyRecordService.doSelectAll());
        mav.setViewName("study/study_insert");

        return mav;
    }
    @PostMapping("/insertProc")
    public ModelAndView insertProc(@ModelAttribute Study_record record) {
        System.out.println("record:>"+record);
        ModelAndView mav = new ModelAndView();
        studyRecordService.doInsert(record);
        mav.setViewName("redirect:/study/list");

        return mav;
    }
    @GetMapping("/modify")
    public ModelAndView modify(Model model, @ModelAttribute Study_record record) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("study", studyRecordService.doSelectById(record.getKey_id()));
        mav.setViewName("study/study_modify");

        return mav;
    }
    @PostMapping("/modifyProc")
    public ModelAndView modifyProc(@ModelAttribute Study_record record) {
        ModelAndView mav = new ModelAndView();
        studyRecordService.doUpdate(record);
        mav.setViewName("redirect:/study/list");

        return mav;
    }
    @GetMapping("/delete")
    public ModelAndView delete(@ModelAttribute Study_record record) {
        ModelAndView mav = new ModelAndView();
        studyRecordService.doDelete(record.getKey_id());
        mav.setViewName("redirect:/study/list");

        return mav;
    }
}
