/*초를 입력하면 몇시,몇분,몇초인지를 출력하는 함수를 작성해보자.
    //1.사용자가 입력받은 시간은 하루 내의 시간이어야 한다.
    //2.1분은 60초, 1시간은 3,600초이다

    //time을 입력받는다.
    //함수의 이름은 cal time, time을 인자로 받는
    //def cal time(time)
    //함수를 정의한다.
    //입력받은 time이 하루 내의 시간인지 아닌지를 확인하는 조건을 정의한다.
    //if time이 24*60*60보다 작다
}

//time이 하루 내의 시간인 경우 수행을 계속한다.
//time이 하루 내의 시간을 초과하는 경우 
//"입력시간이 하루를 초과합니다."를 출력
var input = prompt("시간을 입력하세요");
cal_time(time)
if (time < 24 * 60 * 60) {
    hour = time / (60 * 60);
        time = time - hour * 60 * 60;
        minute = time / 60;
        time = time - minute * 60;
        second = time;
    } else {
        console.log("입력시간이 하루를 초과합니다.");
    }
    
    //우리가 구매하는 제품의 소비자가에는 제품 가격과 제품 가격의
    //10%에 해당하는 부가가치세가 포함되어 있다. 제품의 소비자가를
    //입력받아 제품 가격과 부가가치세를 출력하는 프로그램을 작성해보자.
    
    //1. 사용자가 제품의 소비자가 totalPrice를 입력한다.
    //이때, totalPrice는 Integer타입이다.
    //2. 구해진 제품 가격 productPrice와 부가가치세 tax에 대해 다음과 같이 출력한다.
    //"제품가격은 productPrice원, 부가가치세는 tax원입니다."
    
    //사용자에게 totalPrice를 입력받는다.
    //totalPrice를 인자로 받고, 제품가격 productPrice를 return하는 cal_
    
    */

    score = [90,80,70,50,60];
    sum =0;
    average = 0;
    maximum = 0;
    for(number in score){
        sum+=number;
        if(maximum<number){
            maximum=number;
        }
    }
    average = num/length(score)
    if (average >= 60){
        message = "pass";
    }else{
        message = "fail"
    }
    console.log("average ="+average+", maximun="+maximun)
