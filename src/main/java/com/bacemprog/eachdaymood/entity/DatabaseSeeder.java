package com.bacemprog.eachdaymood.entity;

import com.bacemprog.eachdaymood.service.EntryPageService;
import com.bacemprog.eachdaymood.util.DateUtil;
import com.bacemprog.eachdaymood.util.DebugUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private EntryPageService entryPageService;

    @Autowired
    public DatabaseSeeder(EntryPageService entryPageService) {
        this.entryPageService = entryPageService;
    }

    @Override
    public void run(String... args) throws Exception {

        LocalDateTime page1Start = DateUtil.parseDate("17-09-2014 00:00");
        LocalDateTime page1End = DateUtil.parseDate("17-08-2015 00:00");

        LocalDateTime page2Start = DateUtil.parseDate("18-08-2015 00:00");
        LocalDateTime page2End = DateUtil.parseDate("15-08-2016 00:00");

        LocalDateTime page3Start = DateUtil.parseDate("16-08-2016 00:00");
        LocalDateTime page3End = DateUtil.parseDate("16-08-2017 00:00");

        LocalDateTime page4Start = DateUtil.parseDate("17-08-2017 00:00");
        LocalDateTime page4End = DateUtil.parseDate("15-08-2018 00:00");

        LocalDateTime page5Start = DateUtil.parseDate("16-08-2018 00:00");
        LocalDateTime page5End = DateUtil.parseDate("31-12-2018 00:00");

        if (entryPageService.findByStartAndEndDate(page1Start,page1End) == null)
            entryPageService.saveNewWithEntries(new EntryPage(page1Start,page1End));
        if (entryPageService.findByStartAndEndDate(page2Start,page2End) == null)
            entryPageService.saveNewWithEntries(new EntryPage(page2Start,page2End));
        if (entryPageService.findByStartAndEndDate(page3Start,page3End) == null)
            entryPageService.saveNewWithEntries(new EntryPage(page3Start,page3End));
        if (entryPageService.findByStartAndEndDate(page4Start,page4End) == null)
            entryPageService.saveNewWithEntries(new EntryPage(page4Start,page4End));
        if (entryPageService.findByStartAndEndDate(page5Start,page5End) == null)
            entryPageService.saveNewWithEntries(new EntryPage(page5Start,page5End));
    }
}
