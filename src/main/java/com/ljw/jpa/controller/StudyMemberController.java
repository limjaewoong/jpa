package com.ljw.jpa.controller;

import com.ljw.jpa.entity.Study_member;
import com.ljw.jpa.service.StudyMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/member")
public class StudyMemberController {

    @Autowired
    StudyMemberService studyMemberService;

    @GetMapping("/list")
    public ModelAndView list(Model model) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("list", studyMemberService.doSelectAll());
        mav.setViewName("member/member_list");

        return mav;
    }

    @PostMapping("/search")
    public ModelAndView search(Model model, @ModelAttribute Study_member member) {
        ModelAndView mav = new ModelAndView();
        System.out.println("searchLoginId:>"+member.getSearchLoginId());
        mav.addObject("list", studyMemberService.doSearch(member.getSearchLoginId()));
        mav.setViewName("member/member_list");

        return mav;
    }

    @GetMapping("/insert")
    public ModelAndView insert(Model model) {
        ModelAndView mav = new ModelAndView();
        //mav.addObject("list", studyRecordService.doSelectAll());
        mav.setViewName("member/join");

        return mav;
    }
    @PostMapping("/insertProc")
    public ModelAndView insertProc(@ModelAttribute Study_member member) {
        ModelAndView mav = new ModelAndView();
        studyMemberService.doInsert(member);
        mav.setViewName("redirect:/member/list");

        return mav;
    }

    @GetMapping("/delete")
    public ModelAndView delete(@ModelAttribute Study_member member) {
        ModelAndView mav = new ModelAndView();
        studyMemberService.doDelete(member.getMemberId());
        mav.setViewName("redirect:/member/list");

        return mav;
    }
}
