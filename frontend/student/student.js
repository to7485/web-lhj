const API_URL = "http://localhost:10000/api/students";

//전체 수강생 목록 조회
//목록 조회버튼 누르면 수강생 내역을 테이블에 표시하기

const nameInput = document.getElementById("name");
const courseSelect = document.getElementById("course");
const emailInput = document.getElementById("email");
const studentCount = document.getElementById("count");


const message = document.getElementById("message");
const studentList = document.getElementById("studentList");
const loadBtn = document.getElementById("loadBtn");
const addBtn = document.getElementById("addBtn");


//메시지를 출력하는 함수
const showMessage = (text,type) => {
    message.innerText = text;
    message.className = type;
}

//학생데이터를 테이블에 표현하는 함수
const renderStudents = (students) => {
    if(students === null || students.length === 0){
        studentList.innerHTML = `
            <tr>
                <td colspan"4" class="empty">
                    등록된 수강생이 없습니다.
                </td>
            </tr>
        `;
        return;
    }

    const html = students.map(student => {
        return `
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.course}</td>
                <td>${student.email}</td>
            </tr>  
        `
    }).join("");

    studentList.innerHTML = html;
    studentCount.innerText = `총 ${students.length}명`
}

//서버에 요청하여 학생 데이터를 가져오는 함수
const loadStudents = () => {

    fetch(API_URL)
        .then(response => {
            if(!response.ok){
                throw new Error("수강생 목록 조회 실패");
            }
            return response.json();
        })
        .then(result => {
            //서버에서 error가 반환된 경우
            if(result.error !== null){
                showMessage(result.error, "error");
            }

            //ResponseDTO의 data에 실제 수강생 목록이 들어있다.
            renderStudents(result.data);

            showMessage("수강생 목록을 조회했습니다.","success");
        })
        .catch(error => {
            console.log(error);

            showMessage("서버와 통신할 수 없습니다.","error");
        });
}

loadBtn.addEventListener("click",loadStudents);

//유효성 검사
const validateInput = () => {
    const name = nameInput.value.trim();
    const course = courseSelect.value.trim();
    const email = emailInput.value.trim();

    if(name === ""){
        showMessage("이름을 입력하세요", "error");
        nameInput.focus();
        return false;
    }

    if(course === ""){
        showMessage("과정을 선택하세요", "error");
        courseSelect.focus();
        return false;
    }

    if(email === ""){
        showMessage("이메일을 입력하세요", "error");
        emailInput.focus();
        return false;
    }

    if(!email.includes("@")){
        showMessage("올바른 이메일 형식을 입력하세요.", "error");
        emailInput.focus();
        return false;
    }

    return true;
}

//입력창 초기화 시키는 함수
const resetInput = () => {
    nameInput.value = "";
    courseSelect.value = "";
    emailInput.value = "";

    nameInput.focus();
}

//수강생 등록
addBtn.addEventListener("click",() => {
    //내용이 비어있는지 검사
    if(!validateInput()){
        return;
    }
    //서버로 전송할 객체 만들기
    const student = {
        name: nameInput.value.trim(),
        course : courseSelect.value.trim(),
        email : emailInput.value.trim()
    }
    //fetch를 이용한 전송
    fetch(API_URL,{
        method : "POST",
        headers : {"Content-Type" : "application/json"},
        body : JSON.stringify(student)
    })
    .then(response => {
        if(!response.ok){
            throw new Error("수강생 등록 실패");
        }
        return response.json();
    })
    .then(result => {
        if(result.error !== null){
            showMessage(result.error, "error");
            return;
        }

        const savedStudent = result.data[0];

        showMessage(savedStudent.name + " 수강생이 등록되었습니다.", "success");
        //입력창 비우기
        resetInput();

        loadStudents();
    })
    .catch(error => {
        console.log(error);
        showMessage("서버와 통신할 수 없습니다.","error");
    })
    
})