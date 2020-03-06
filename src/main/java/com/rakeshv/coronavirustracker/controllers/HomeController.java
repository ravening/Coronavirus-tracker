package com.rakeshv.coronavirustracker.controllers;

import com.rakeshv.coronavirustracker.models.LocationStats;
import com.rakeshv.coronavirustracker.services.CoronaVirusDataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private CoronaVirusDataService coronaVirusDataService;

    HomeController(CoronaVirusDataService coronaVirusDataService) {
        this.coronaVirusDataService = coronaVirusDataService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<LocationStats> allStats = coronaVirusDataService.getAllStats();
        Long totalNewCases = allStats.parallelStream().mapToLong(LocationStats::getDiffFromPrevDay).sum();
        Long totalReportedCases = allStats.parallelStream().mapToLong(LocationStats::getLatestTotalCases).sum();
        model.addAttribute("locationStats", coronaVirusDataService.getAllStats());
        model.addAttribute("totalReportedCases", totalReportedCases);
        model.addAttribute("totalNewCases", totalNewCases);
        return "home";
    }
}
