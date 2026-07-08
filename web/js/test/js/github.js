//요소들 등록
const githubId = document.getElementById("githubId");
const searchBtn = document.getElementById("searchBtn");
const message = document.getElementById("message");
const profileBox = document.getElementById("profileBox");

//아이디 검증 함수
const validateGithubId = () => {
    //아이디 값을 가져온다.
    const value = githubId.value.trim();

    let regex = /^[A-Za-z0-9-]+$/;

    //비어있는지 검사
    if(value === ""){
        message.textContent = "GitHub 아이디를 입력하세요";
        searchBtn.disabled = true;
        return false;
    }

    //길이가 맞는지 검사
    if(value.length < 3 || value.length > 20){
        message.textContent = "아이디는 3자 이상 20자 이하로 입력하세요";
        searchBtn.disabled = true;
        return false;
    }

    //정규식에 맞는지 검사
    if(!regex.test(value)){
        message.textContent = "아이디는 영어, 숫자, 하이픈만 입력할 수 있다.";
        searchBtn.disabled = true;
        return false;
    }

    //하이픈이 맨앞이나 맨뒤에 오는지 검사
    if(value.startsWith("-") || value.endsWith("-")){
        message.textContent = "하이픈은 처음이나 끝에 사용할 수 없다.";
        searchBtn.disabled = true;
        return false;
    }

    //모든 조건을 충족할 때
    message.textContent = "";
    searchBtn.disabled = false;
    return true;
}

const searchGithubUser = async () => {
    if(!validateGithubId()){
        return;
    }

    const id = githubId.value.trim();
    const url = `https://api.github.com/users/${id}`;

    try{
        message.textContent = "사용자 정보를 불러오는 중입니다...";
        profileBox.innerHTML = "";

        const response = await fetch(url);

        if(response.status === 404){
            message.textContent = "존재하지 않는 사용자입니다.";
            return;
        }

        if(response.status === 403){
            message.textContent = "접근 권한이 없습니다.";
            return;
        }

        if(!response.ok){
            throw new Error("API 오류");
        } 

        const user = await response.json();

        message.textContent = "";

        profileBox.innerHTML = `
            <div class="profile-card">
                <img src="${user.avatar_url}" alt="${user.login}">
                <div class="profile-info">
                    <h2>${user.login}</h2>
                    <p><strong>이름:</strong> ${user.name || "이름 정보 없음"}</p>
                    <p><strong>소개:</strong> ${user.bio || "소개 정보 없음"}</p>

                    <div class="status">
                        <div class="stat">팔로워 ${user.followers}</div>
                        <div class="stat">팔로잉 ${user.following}</div>
                        <div class="stat">저장소 ${user.public_repos}</div>
                    </div>

                    <a href="${user.html_url}">GitHub 페이지 이동</a>
                </div>
            </div>
        `
    }catch(error){
        message.textContent = "사용자 정보를 불러오지 못했습니다.";
    }
}


githubId.addEventListener("input",validateGithubId);

//버튼을 눌렀을 때 해야 하는일
//1. 내용이 제대로 입력이 됐는지 확인
//2. github api 서버에 정보를 요청을하고 응답을 받아와서 화면에 보여줘야한다.
searchBtn.addEventListener("click",searchGithubUser);