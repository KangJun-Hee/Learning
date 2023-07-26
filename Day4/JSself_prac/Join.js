function Join() {
    let name = document.querySelector("#name");
    let id = document.querySelector("#id");
    let pw = document.querySelector("#pw");
    let phnum = document.querySelector("#phnum");


    addEventListener('click', e => {
        if (id.value == "" || pw.value == "" || name.value == "" || phnum.value == "") {
            alert("모든 정보를 입력해 주세요.")
        } else {
            window.location = 'Homepage.html';
            // location.href = 'Homapage.html'
        }
    });
}