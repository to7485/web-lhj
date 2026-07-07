//요소들을 등록

//문의 유형 선택상자
let type = document.getElementById("type");
//제목
let title = document.getElementById("title");
//이메일
let email = document.getElementById("email");
//내용
let content = document.getElementById("content");
//체크박스
let agree = document.getElementById("agree");
//등록 버튼
let submitBtn = document.getElementById("submitBtn");
//문의 목록
let list = document.getElementById("list");

let typeMsg = document.getElementById("typeMsg");
let titleMsg = document.getElementById("titleMsg");
let emailMsg = document.getElementById("emailMsg");
let contentMsg = document.getElementById("contentMsg");
let agreeMsg = document.getElementById("agreeMsg");

const inquiries = [];

//문의 유형 선택 검사
const validateType = () => {
    //유형을 선택하지 않았다면
    if(type.value === ""){
        //메시지
        typeMsg.innerContent = "문의 유형을 선택하세요.";
        return false;
    }

        typeMsg.innerContent = "선택 완료";
        typeMsg.className = "success";
        return true;
}

const validateTitle = () =>{
    const value = title.value.trim();

    if(value.length < 5 || value.length > 30){
        titleMsg.textContent = "제목은 5자 이상 30자 이하로 입력하세요";
        titleMsg.className = "error";
        return false;
    }
        titleMsg.textContent = "사용가능한 제목입니다.";
        titleMsg.className = "success";
        return true;

}

const validateEmail = () =>{
    const value = email.value.trim();

    let regex = /^[A-Za-z0-9!@#$%^&*]+@[A-Za-z0-9]+\.[A-Za-z0-9]{2,}$/

    if(!regex.test(value)){
        emailMsg.textContent = "이메일 형식에 맞지 않는다.";
        emailMsg.className = "error";
        return false;
    }
        emailMsg.textContent = "사용가능한 이메일입니다.";
        emailMsg.className = "success";
        return true;

}

const validateContent = () =>{
    const value = content.value.trim();

    if(value.length < 20 || value.length > 300){
        contentMsg.textContent = "제목은 20자 이상 300자 이하로 입력하세요";
        contentMsg.className = "error";
        return false;
    }
        contentMsg.textContent = "문의 내용이 정상적으로 입력되었습니다.";
        contentMsg.className = "success";
        return true;

}

const validateAgree = () =>{
    if(!agree.checked){
        contentMsg.textContent = "개인정보 수집에 동의해야 합니다.";
        contentMsg.className = "error";
        return false;
    }
        contentMsg.textContent = "동의 완료";
        contentMsg.className = "success";
        return true;

}

const checkForm = () => {
    const result = 
        validateType() &&
        validateTitle() &&
        validateEmail() &&
        validateContent() &&
        validateAgree();

    //조건을 모두 만족한다면 disabled를 false로 만들어야 활성화됨
    submitBtn.disabled = !result;
    return result;
}

const renderList = () => {
    list.innerHTML = "";

    inquiries.forEach(item => {
        list.innerHTML += `
            <div class="card">
                <p><strong>${item.type}</strong></p>
                <h3>${item.title}</h3>
                <p>${item.content}</p>
                <p>답변받을 메일 : ${item.email}</p>
            </div>
        `
    })
}

type.addEventListener("change",checkForm);
title.addEventListener("input",checkForm);
email.addEventListener("input",checkForm);
content.addEventListener("input",checkForm);
agree.addEventListener("change",checkForm);

submitBtn.addEventListener("click",() => {
    if(!checkForm()){
        return;
    }

    const inquiry = {
        type : type.value,
        title : title.value.trim(),
        email : email.value.trim(),
        content : content.value.trim()
    }

    inquiries.push(inquiry);
    renderList();

    type.value = "";
    title.value= "";
    email.value = "";
    content.value = "";
    agree.checked = false;

    checkForm();
})