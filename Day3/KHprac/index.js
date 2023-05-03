const bookCart = [];
const resultDiv = document.querySelector("#category");

const bookCheck = document.querySelectorAll("#genre checkbox");

for (let i = 0; i < bookCheck.length; i++) {
    bookCheck[i].addEventListener("checked", function (e) {
        const chk = e.target;
        const bookGnr = chk.innerText;

        bookCart.push(bookGnr);

        resultDiv.innerText = `${bookCart}를 선택하셨습니다.`

    })
}