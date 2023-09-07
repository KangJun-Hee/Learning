/** 매물 마커 생성 js */

// 카카오 지도 불러오기
var container = document.getElementById('map');
var options = {
    center: new kakao.maps.LatLng(37.535814, 127.008644), // 초기 맵 중심 좌표
    level: 5 // 초기 줌 레벨
};
var map = new kakao.maps.Map(container, options);

// 줌 컨트롤러 지도에 추가
var zoomControl = new kakao.maps.ZoomControl();
map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

// 카테고리 장소 검색
var ps = new kakao.maps.services.Places(map);

// 맵 이동시 현재 맵의 경계를 기준으로 데이터 요청하고 그 범위에 속하는 행정동 또는 아파트 데이터의 마커 생성
kakao.maps.event.addListener(map, 'idle', function () {
    // 행정동 오버레이 초기화
    clearHJDOverlays();

    var bounds = map.getBounds();
    var southWest = bounds.getSouthWest();
    var northEast = bounds.getNorthEast();
    var currentZoomLevel = map.getLevel(); // 현재 줌 레벨 가져오기

    var dataToSend = {
        southWestLat: southWest.getLat(),
        southWestLng: southWest.getLng(),
        northEastLat: northEast.getLat(),
        northEastLng: northEast.getLng(),
        zoomLevel: currentZoomLevel
    };

    console.log(dataToSend);

    $.ajax({
        type: 'POST',
        url: '/map/map',
        data: dataToSend,
        success: function (response) {
            if (response.maemulList && currentZoomLevel <= 5) {
                response.maemulList.forEach(function (maemul) {
                    var markerPosition = new kakao.maps.LatLng(maemul.latitude, maemul.longitude);
                    var markerKey = markerPosition.toString();
                    var markerContent = "<div class='e-marker'>" +
                        "<div class='e-markerTitle'>" +
                        "<h3>" + maemul.APT_name + "</h3>" +
                        "</div>" +
                        "<div class='e-markerContent'>" +
                        "<p>" + maemul.address + "</p>" +
                        "</div>" +
                        "</div>";

                    if (!existingMarkers[markerKey]) {
                        createMarker(markerPosition, markerContent, maemul);
                    }
                });
            }
            if (currentZoomLevel >= 6) {  // 위 if문뒤에 else로 조건 주면 오류남 따로 조건 줘야함
                // 줌레벨 6이상시 마커 삭제


                // 행정동으로 클러스터 생성
                response.hjdList.forEach(function (hjd) {
                    var overlayPosition = new kakao.maps.LatLng(hjd.latitude, hjd.longitude);
                    var overlayContent = "<div class='e-hjdOverlay'>";
                    if (hjd.siDo && hjd.siGunGu && hjd.eupMyeonDong && hjd.eupMyeonRiDong) {
                        overlayContent += "<p>" + hjd.eupMyeonRiDong + "</p>";
                    } else if (hjd.siDo && hjd.siGunGu && hjd.eupMyeonDong) {
                        overlayContent += "<p>" + hjd.eupMyeonDong + "</p>";
                    } else if (hjd.siDo && hjd.siGunGu) {
                        overlayContent = "<div class='e-hdjOverlaySiGunGu'>" +
                                            "<p>" + hjd.siGunGu + "</p>";
                    } else if (hjd.siDo) {
                        overlayContent = "<div class='e-hdjOverlaySiDo'>" +
                                         "<p>" + hjd.siDo + "</p>";
                    }
                    overlayContent += "</div>";

                    var hjdOverlay = new kakao.maps.CustomOverlay({
                        position: overlayPosition,
                        content: overlayContent,
                        map: map
                    });
                    // 생성된 오버레이를 배열에 추가
                    hjdOverlays.push(hjdOverlay);
                });

            }
        }
    });
});

// 오버레이 열기
function openOverlay(overlay) {
    if (overlay) {
        overlay.setMap(map);
    }
}

// 행정동 오버레이 초기화 함수 정의
function clearHJDOverlays() {
    // 모든 오버레이 삭제
    hjdOverlays.forEach(function (hjdOverlay) {
        hjdOverlay.setMap(null);
    });
    hjdOverlays = []; // 오버레이 배열 초기화
}
// 행정동 오버레이 배열 초기화
var hjdOverlays = [];

// 오버레이 클릭 이벤트 리스너 추가
kakao.maps.event.addListener(hjdOverlay, 'click', function() {
    var overlayPosition = hjdOverlay.getPosition();
    map.setLevel(map.getLevel() + 1, { anchor: overlayPosition }); // 클릭된 오버레이의 위치를 중심으로 맵을 줌인합니다.
});

// 카테고리 버튼 클릭시 장소 검색하기
