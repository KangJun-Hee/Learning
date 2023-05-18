function msg(){
    let amsg = document.getElementById('msg');
    let input = '영문자 대/소문자 특수문자, 숫자 포함 8~32자';

    document.querySelector(('msg'),click =>{
        amsg = input;
    })
}

function inputcheck(){
    const id = document.getElementById('id').value;
    const pw = document.getElementById('pw').value;
    const pwc = document.getElementById('pwc').value;

    if(id && pw && pwc){
        
    }else{
        alert('필수항목을 입력하세요');
    }
}