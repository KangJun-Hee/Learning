console.log("=========KH 사이트========");

class MemberMenu {
    var input = prompt("숫자를 입력하세요.","");
    var num1 = Number(input);
    switch(num1) {
        case 1:
            mainMenu();
        break;
        case 2:
            MemberMenu();
        break;
    
        default:
        break;
}
mainMenu(){
    console.log("===*****메인 메뉴*****===");
    console.log("1.회원가입");
    console.log("2.로그인");
    console.log("3.같은 이름 회원 찾기");
    console.log("9.종료");

    while(true){
        switch(key){
            case 1:
                joinMembership();
                break;
            case 2:
                logIn();
                break;
            case 3:
                sameName();
                break;
            case 9:
                break;
            default:
                return mainMenu();
        }
    }
};
MemberMenu(){
    while(true){
        console.log("=====*****회원 메뉴*****=====");
        console.log("1.비밀번호 바꾸기");
        console.log("2.이름바꾸기");
        console.log("3.로그아웃")
        switch(key){
            case 1:
                changePassword();
                break;
            case 2:
                changeName();
                break;
            case 3:

        }
    }
};

joinMembership() {
    console.log("아이디:");
    console.log("비밀번호:");
    console.log("이름:");
    console.log("성공적으로 회원가입 완료하였습니다.");
}
logIn() {
    console.log("아이디:");
    console.log("비밀번호:");
    console.log("이름:");

    let correct;
    if(wrongid != correct){
        console.log("중복된 아이디입니다. 다시 입력해 줏요.")
        logIn();
    }else if(wrong {
        console.log(this.name+"님, 환영합니다!");
    }
}
changePassword() {
    console.log(toString());
    console.log("비밀번호 변경에 성공했습니다.");
}
changeName() { }
sameName() {
    console.log("이름 변경에 성공했습니다.")
}


}





class Member {
    password;
    name;

    Member() { }
    Member(password, name) {
        this.password = password;
        this.name = name;
    }
    toString() {
        return "Your Password:"+this.password+", Your Name:"+ this.name;
    }
}