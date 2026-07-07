function hello(){
    alert('안녕하세요');
}

//아직 버튼이 렌더링이 안됐음
let btn = document.getElementById("btn");

btn.addEventListener("click",() => {alert("하이")});