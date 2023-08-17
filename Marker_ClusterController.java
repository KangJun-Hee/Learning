package com.ap4j.bma.controller.marker_cluster;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Marker_ClusterController {

    @GetMapping("mk")
    public String testA() {


        return "/marker_cluster/marker_cluster";
    }
}
