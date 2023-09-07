/** DB에 저장된 좌표를 가지고 사용자가 보고 있는 화면의 좌표값과 비교하여 그 범위에만 마커를 찍어주는 javascript 파일입니다. */
/** 불필요한 데이터를 가져오지 않아서 성능향상에 도움이 됩니다. */

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

// 클러스터
var clusterer = new kakao.maps.MarkerClusterer({
    map: map,
    gridSize: 300,
    averageCenter: false,
    minLevel: 14
});

// 생성된 마커 저장 객체
var existingMarkers = {};

// 마커 생성 함수
function createMarker(position, markerContent, responseData) {
    var markerKey = position.toString();

    var imageSrc = '/img/mapDetailAndAPTList/houseMarker.png',
        imageSize = new kakao.maps.Size(32, 32),
        imageOption = { offset: new kakao.maps.Point(20, 20) };
    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption);

    // 마커가 생성되어 있지 않다면 마커 생성
    if (!existingMarkers[markerKey]) {
        var marker = new kakao.maps.Marker({
            position: position,
            image: markerImage,
            clickable: true
        });

        marker.responseData = responseData; // 첫 화면에서 사이드바 띄워줄 때 사용함

        var overlayContent = markerContent;

        // 오버레이 생성
        var overlay = new kakao.maps.CustomOverlay({
            content: overlayContent,
            map: map,
            position: marker.getPosition(),
            zIndex: 9999
        });

        marker.overlay = overlay;
        marker.overlay.setMap(null); // 오버레이는 초기에 닫혀있는 상태

        // 마커 클릭시 오버레이 열리는 이벤트
        kakao.maps.event.addListener(marker, 'click', function () {
            closeOtherOverlays(); // 다른 오버레이 닫기
            openOverlay(marker.overlay); // 오버레이 열기
            updateSidebar(responseData); // 사이드바에 데이터 전송
            updateTransactionTable(responseData.roadName); // 사이드바의 거래내역 테이블에 데이터 전송
             // 마커의 아이디값 가져오기
             var id = responseData.id;
             console.log(id);

             // RESTful API 엔드포인트 URL
             var apiUrl = '/board/writepro/' + id;

             // AJAX 요청을 보내 아파트 아이디를 서버에 전송
             $.ajax({
                 type: 'POST',
                 url: apiUrl,
                 data: { id: id, content:null , session:null},
                 success: function(response) {
                     // 서버에서의 응답 처리
                     console.log(response+"아파트 아이디값을 챙길거임");

//                     // 이제 response에는 서버에서 리턴한 아파트 아이디가 있음
//                     // 이 값을 활용하여 리뷰 엔티티에 저장 가능
//                     // 다음과 같이 변수에 저장해서 활용
                     var apartmentId = response;

                     // 이제 이 apartmentId 값을 boardwritePro 메서드로 전달
                     // AJAX 요청을 보내 아파트 아이디를 서버에 전송
                     $.ajax({
                         type: 'PUT',
                         url: 'board/writepro{id}',
                         data: { id: apartmentId,content:null , session:null }, // 서버로 아파트 아이디 전달
                         success: function(response) {
                             // 서버에서의 응답 처리
                             console.log(response + " 리뷰 작성이 완료되었습니다.");
                         },
                         error: function(xhr, status, error, cors) {
                             console.error(error);
                         }
                     });
                 },
                 error: function(xhr, status, error,cors) {
                     console.error(error);
                 }
             });
//             아작스로 put전송방식 써서 url을 board/writepro{id}로 넣고 Long타입으로 뽑아오야 함
//             서비스로 객체 넘겨주으
//json으로 리턴해 보기.......



        });

        clusterer.addMarker(marker); // 클러스터러에 마커 추가
        existingMarkers[markerKey] = marker; // 생성된 마커를 마커리스트에 저장
    }
}

// 한 번만 실행하기 위한 변수
var onlyOneStart = false;
// 맵 로드가 완료되면 실행
kakao.maps.event.addListener(map, 'tilesloaded', function () {
    // 이미 실행된 경우 함수 종료
    if (onlyOneStart) {
        return;
    }
    onlyOneStart = true; // 변수 업데이트

    var bounds = map.getBounds();
    var southWest = bounds.getSouthWest();
    var northEast = bounds.getNorthEast();
    var currentZoomLevel = map.getLevel(); // 현재 줌 레벨 가져오기
    console.log("실행시 줌레벨 : " + currentZoomLevel);
    var dataToSend = {
        southWestLat: southWest.getLat(),
        southWestLng: southWest.getLng(),
        northEastLat: northEast.getLat(),
        northEastLng: northEast.getLng(),
        zoomLevel: currentZoomLevel
    };

    $.ajax({
        type: 'POST',
        url: '/map/main',
        data: dataToSend,
        success: function (response) {
            if (response.aptList) {
                response.aptList.forEach(function (apt) {
                    var markerPosition = new kakao.maps.LatLng(apt.latitude, apt.longitude);
                    var markerKey = markerPosition.toString();
                    var markerContent = "<div class='e-marker'>" +
                        "<div class='e-markerTitle'>" +
                        "<h3>" + apt.apartmentName + "</h3>" +
                        "</div>" +
                        "<div class='e-markerContent'>" +
                        "<p>" + apt.roadName + "</p>" +
                        "</div>" +
                        "</div>";

                    if (!existingMarkers[markerKey]) {
                        createMarker(markerPosition, markerContent, apt);
                    }

                });
            } else {
                console.log("표시할 마커가 없습니다. (좌표값 누락)");
            }
            // 아파트 이름이 "한남더힐"인 마커 찾기
            for (var key in existingMarkers) {
                if (existingMarkers.hasOwnProperty(key)) {
                    var marker = existingMarkers[key];
                    if (marker.overlay && marker.overlay.getContent().includes("한남더힐")) {
                        openOverlay(marker.overlay);
                        updateSidebar(marker.responseData);
                        updateTransactionTable(marker.responseData.roadName);
                        break;
                    }
                }
            }
        }
    });
});

// keyword 입력 후 Enter 누르면 검색되는 함수
function checkEnter(event) {
    if (event.key === 'Enter') {
        clearHJDOverlays(); // 행정동 오버레이 닫기
        closeOtherOverlays(); // 열려있는 아파트리스트 오버레이 닫기
        // 입력한 키워드 공백 제거
        var keyword = document.querySelector('.aSearchInput').value.replaceAll(' ', '');
        var setZoomLevel = 5;

        $.ajax({
            type: 'POST',
            url: '/map/main',
            data: {
                keyword: keyword,
                zoomLevel: setZoomLevel
            },
            success: function (response) {
                // 검색 결과에 따라 마커를 생성하고 지도에 표시하기
                if (response.aptSearch) {
                    var result = response.aptSearch; // 키워드 검색후 전송받은 해당 아파트 데이터
                    var newCenter = new kakao.maps.LatLng(result.latitude, result.longitude);

                    map.setLevel(setZoomLevel); // 줌레벨 변경
                    map.setCenter(newCenter); // 해당 아파트 위치로 센터 변경
                    var currentZoomLevel = map.getLevel(); // 이동시 줌레벨 5로 설정 (줌레벨 안바뀐채로 이동되는 경우 있어서 방지차원)

                    var markerPosition = new kakao.maps.LatLng(result.latitude, result.longitude);
                    var markerKey = markerPosition.toString();
                    var markerContent = "<div class='e-marker'>" +
                        "<div class='e-markerTitle'>" +
                        "<h3>" + result.apartmentName + "</h3>" +
                        "</div>" +
                        "<div class='e-markerContent'>" +
                        "<p>" + result.roadName + "</p>" +
                        "</div>" +
                        "</div>";
                    createMarker(markerPosition, markerContent, result);
                    var marker = existingMarkers[markerKey];
                    openOverlay(marker.overlay);
                    updateSidebar(result);
                    updateTransactionTable(result.roadName);
                    console.log("클릭시 마커생성");
                }
            }
        });
    }
}

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
        url: '/map/main',
        data: dataToSend,
        success: function (response) {
            if (response.aptList && currentZoomLevel <= 5) {
                response.aptList.forEach(function (apt) {
                    var markerPosition = new kakao.maps.LatLng(apt.latitude, apt.longitude);
                    var markerKey = markerPosition.toString();
                    var markerContent = "<div class='e-marker'>" +
                        "<div class='e-markerTitle'>" +
                        "<h3>" + apt.apartmentName + "</h3>" +
                        "</div>" +
                        "<div class='e-markerContent'>" +
                        "<p>" + apt.roadName + "</p>" +
                        "</div>" +
                        "</div>";

                    if (!existingMarkers[markerKey]) {
                        createMarker(markerPosition, markerContent, apt);
                    }
                });
            }
            if (currentZoomLevel >= 6) {  // 위 if문뒤에 else로 조건 주면 오류남 따로 조건 줘야함
                // 줌레벨 6이상시 마커 삭제
                clusterer.clear();
                for (var key in existingMarkers) {
                    if (existingMarkers.hasOwnProperty(key)) {
                        var marker = existingMarkers[key];
                        if (marker.overlay) {
                            marker.overlay.setMap(null);
                        }
                    }
                }
                existingMarkers = {};

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

// 행정동 오버레이 클릭 이벤트 리스너 추가
kakao.maps.event.addListener(hjdOverlay, 'click', function() {
    var overlayPosition = hjdOverlay.getPosition();
    map.setLevel(map.getLevel() + 1, { anchor: overlayPosition }); // 클릭된 오버레이의 위치를 중심으로 맵을 줌인합니다.
});

// 사이드바 정보 업데이트
function updateSidebar(responseData) {
    // 사이드바 미니 지도 (staticMap)
    var staticMapContainer = document.getElementById('staticMap');
    staticMapContainer.innerHTML = ''; // 초기화 코드
    var markerPosition = new kakao.maps.LatLng(responseData.latitude, responseData.longitude);
    var staticMapOption = {
        center: markerPosition,
        level: 4,
        marker: new kakao.maps.Marker
    };
    var staticMap = new kakao.maps.StaticMap(staticMapContainer, staticMapOption);

    // 사이드바 타이틀과 상세정보
    var asideBar = document.querySelector('.asideBarAll');
    var titleElement = asideBar.querySelector('.title');

    var mapInfo = document.querySelector('.map-info');
    var mapInfoTitleElement = mapInfo.querySelector('.title');
    var mapInfoAddressElement = mapInfo.querySelector('.address');
    var mapInfoRoadNameElement = mapInfo.querySelector('.roadName');

    var title = responseData.apartmentName; // 타이틀 : 아파트이름
    var roadName = responseData.roadName;
    var address1 = responseData.district;
    var address2 = responseData.address;

    titleElement.textContent = title;

    mapInfoTitleElement.textContent = title;
    mapInfoAddressElement.textContent = address1 + " " + address2;
    mapInfoRoadNameElement.textContent = roadName;
}

function updateTransactionTable(roadName) {
    $.ajax({
        type: 'POST',
        url: '/map/main',
        data: {
            roadName: roadName
        },
        success: function (response) {
            var tableBody = $(".tbl tbody");
            tableBody.empty();

            if (response.aptRealTradeDTOList) {
                /* 차트 */
                var arrrange = [];
                var arrrange2 = [];
                var yearToAmountMap = {}; // 년도별 거래 금액을 저장하기 위한 맵
                var allAmounts = []; // 모든 거래 금액을 저장할 배열

                var chartCanvas = document.getElementById("myChart").getContext("2d");

                if (window.myChart && typeof window.myChart.destroy === 'function') {
                    window.myChart.destroy();
                }

                for (let i = 0; i < response.aptRealTradeDTOList.length; i++) {
                    var contractYearMonth = response.aptRealTradeDTOList[i].contractYearMonth;
                    var firstYear = contractYearMonth.slice(2, contractYearMonth.length - 2);
                    var lastYear = contractYearMonth.slice(contractYearMonth.length - 2, contractYearMonth.length);
                    var totalYear = firstYear + "." + lastYear;
                    var chartAmount = response.aptRealTradeDTOList[i].transactionAmount.toString();

                    var amountSliceFirst = chartAmount.slice(0, chartAmount.length - 1);
                    var amountSliceLast = chartAmount.slice(-1);
                    var reformatAmount = parseFloat(amountSliceFirst + "." + amountSliceLast);

                    allAmounts.push(reformatAmount); // 모든금액 넣기

                    if (!yearToAmountMap[totalYear]) {
                        yearToAmountMap[totalYear] = [reformatAmount]; // 해당 년도에 대한 배열 생성
                    } else {
                        yearToAmountMap[totalYear].push(reformatAmount); // 배열에 값을 추가
                    }
                }

                const highestAmount = Math.max(...allAmounts);  // 최고가
                const lowestAmount = Math.min(...allAmounts);   // 최저가

                // 중복 제거 및 평균 계산
                for (const year in yearToAmountMap) {
                    const averageAmount = yearToAmountMap[year].reduce((acc, curr) => acc + curr, 0) / yearToAmountMap[year].length;
                    arrrange.push(year);
                    arrrange2.push(averageAmount);
                }

                var chartData = {
                    labels: arrrange, // 날짜
                    datasets: [{
                        label: '',
                        data: arrrange2, // 거래 금액
                        backgroundColor: 'rgb(38, 171, 237)',
                        borderColor: 'rgb(75, 192, 192)',
                        borderWidth: 1,
                        // fill: true // 선 아래를 색으로 채우기
                    }]
                };

                myChart = new Chart(chartCanvas, {
                    type: 'line',
                    data: chartData,
                    options: {
                        plugins: {
                            title: {
                                display: true,
                                text: "최고:" + highestAmount + "억" + "          최저:" + lowestAmount + "억",
                                position: 'top'
                            },
                            legend: {
                                display: false
                            }
                        },
                        scales: {
                            x: {
                                beginAtZero: true,
                                ticks: {
                                    autoSkip: true,
                                    maxRotation: 0,
                                    minRotation: 0,
                                    maxTicksLimit: 10
                                },
                                title: {
                                    display: true,
                                    text: '거래연월'
                                }
                            },
                            y: {
                                beginAtZero: true,
                                title: {
                                    display: true,
                                    text: '거래금액(억)'
                                }
                            }
                        }
                    }
                });

                window.myChart = myChart;

                // 실거래정보 표시
                response.aptRealTradeDTOList.forEach(function (detailItem) {
                    var tableBody = $(".tbl tbody"); // 테이블의 tbody 요소 선택

                    var amount = detailItem.transactionAmount.toString();
                    var amountSliceFirst = amount.slice(0, amount.length - 1);
                    var amountSliceLast = amount.slice(-1)
                    var reformatAmount = null;

                    // 테이블 행 생성 및 데이터 추가
                    var row = $("<tr>");
                    $("<td>").text(detailItem.area).appendTo(row);
                    $("<td>").text(detailItem.floor).appendTo(row);
                    $("<td>").text(detailItem.contractYearMonth).appendTo(row);

                    if (amount.length === 1) {
                        reformatAmount = amount + "000만원";
                    } else if (amountSliceLast != 0) {
                        reformatAmount = amountSliceFirst + "억 " + amountSliceLast + "000만원";
                    } else {
                        reformatAmount = amountSliceFirst + "억";
                    }

                    $("<td>").text(reformatAmount).appendTo(row);

                    // 테이블에 행 추가
                    tableBody.append(row);

                });

            } else {
                console.log("표시할 aptDetailList 데이터가 없습니다.");
            }
        }
    });
}

// 날짜 포맷팅 함수
function formatDate(rawDate) {
    var year = rawDate.substring(0, 4);
    var month = rawDate.substring(4, 6);
    return year + '-' + month;
}
// 다른 오버레이 닫아주는 함수
function closeOtherOverlays() {
    for (var key in existingMarkers) {
        if (existingMarkers.hasOwnProperty(key)) {
            var marker = existingMarkers[key];
            if (marker.overlay) {
                marker.overlay.setMap(null);
            }
        }
    }
}


