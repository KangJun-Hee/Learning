package com.ap4j.bma.controller.marker_cluster;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Marker_ClusterDTO {
    private String MAIN_TITLE;                  // 식당 이름
    private double LNG;                         // 위도
    private double LAT;                         // 경도
    private String GUGUN_NM;                    // 군
    private String ADDR1;                       // 주소1
    private String ADDR2;                       // 주소2
}
