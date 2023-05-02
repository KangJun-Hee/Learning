score = [90, 80, 70, 50, 60];
sum = 0;
average = 0;
maximum = 0;
for(number in score){
    sum+=number;
    if(maximum<number){
        maximum=number;
    }
}
average = num/length(score)
if(average >= 60){
    message = "pass";
}else{
    message = "fail"
}
console.log("average ="+average+", maximum ="+maxtimum)
console.log