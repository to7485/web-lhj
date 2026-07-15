const btn = document.getElementById("btn");
const name = document.querySelector("input[type=text]");
const result = document.getElementById("result");
btn.addEventListener("click",() => {
    fetch(`http://localhost:10000/api/hello?name=${name.value}`)
    .then(res => res.text())//text() : 응답 본문을 문자열로 읽는 메서드
    .then(data => {
        result.textContent = data;
    });
})