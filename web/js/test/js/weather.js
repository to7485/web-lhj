const cities = [
  { name: "서울", lat: 37.5665, lon: 126.9780 },
  { name: "부산", lat: 35.1796, lon: 129.0756 },
  { name: "제주", lat: 33.4996, lon: 126.5312 },
  { name: "도쿄", lat: 35.6762, lon: 139.6503 },
  { name: "뉴욕", lat: 40.7128, lon: -74.0060 }
];

const citySelect = document.getElementById("citySelect");
const weatherBtn = document.getElementById("weatherBtn");
const message = document.getElementById("message");
const weatherBox = document.getElementById("weatherBox");

const validateCity = () => {
    //select에서 선택한 값을 가져온다.
    const selectedValue = citySelect.value;

    //선택을 안했다면
    if(selectedValue === ""){
        message.textContent = "도시를 선택하세요";
        //비활성화 유지
        weatherBtn.disabled = true;
        return false;
    }

    //내가 선택한 도시를 배열에서 정보를 꺼내온다.
    const city = cities.find(item => {
        return item.name === selectedValue;
    })

    if (!city){
        message.textContent = "존재하지 않는 도시입니다.";
        weatherBtn.disabled = true;
        return false;
    }

    message.textContent = "";
    weatherBtn.disabled = false;
    return true;
}

//날씨 정보 가져오기
const getWeather = () => {
    //도시가 선택이 안되면 멈춤
    if(!validateCity()){
        return;
    }

    //조건에 맞는 객체 1개를 담는다.
    const city = cities.find(item => {
        return item.name === citySelect.value;
    })

    const url = `https://api.open-meteo.com/v1/forecast?latitude=${city.lat}&longitude=${city.lon}&current_weather=true`

    message.textContent = "날씨 정보를 불러오는 중입니다...";
    weatherBox.innerHTML = "";

    fetch(url)
    .then(response => response.json())
    .then(data => {
        if(!data.current_weather){
            message.textContent = "날씨 데이터가 없습니다.";
            return;
        }

        const weather = data.current_weather;
        message.textContent = "";

        weatherBox.innerHTML = `
            <div class="weather-title">${city.name}</div>
            <p><strong>현재 기온:</strong>${weather.temperature}</p>
            <p><strong>풍속:</strong>${weather.windspeed} km/h</p>
            <p><strong>날씨 코드:</strong>${weather.weathercode}</p>
            <p><strong>조회 시간:</strong>${weather.time}</p>
        `
    });
}

citySelect.addEventListener("change",validateCity);
weatherBtn.addEventListener("click",getWeather);