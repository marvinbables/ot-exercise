package com.ideyatech.ot.tutorial.web.controller;

import org.opentides.web.controller.BaseCrudController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ideyatech.ot.tutorial.entity.DailyTimeRecord;

@Controller
@RequestMapping("/dailyTimeRecord")
public class DailyTimeRecordController extends BaseCrudController<DailyTimeRecord>{

}
