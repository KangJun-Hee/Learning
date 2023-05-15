const nuum1 = document.querySelector('#num1');
const nuum2 = document.querySelector('#num2');
const oper = document.querySelector('#res');

function cal(num1,oper,num2){
    let result = 0;
    if(oper === "+"){
        result = Number(num1) + Number(num2);
    }else if(oper === "-"){
        result = Number(num1) - Number(num2);
    }else if(oper === "*"){
        result = Number(num1) * Number(num2);
    }else if(oper === "/"){
        result = Number(num1) / Number(num2);
    }else if(oper ==="%"){
        result = Number(num1) % Number(num2);
    }return String(result);

}

const result = [];