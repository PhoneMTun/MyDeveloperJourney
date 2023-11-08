const apiKey = "9fe79409d199407e15a985fea65d73b5";
const limit = "1";
const countryCode = "US";

function hide() {
    var cookie = document.querySelector('.cookie-container')
    cookie.remove();
}

function CTF(temp) {
    return Math.round((temp * 9/5) + 32)
}

function loading(cityName, stateCode) {
    alert("Loading weather report for " + cityName);
    // Change the city name in the description
    const descriptionElem = document.querySelector(".discription h2");
    descriptionElem.textContent = cityName;
    
    // Update the weather blocks
    updateWeatherBlocks(cityName, stateCode);
}
function CTC(temp){
    return Math.round(5 / 9 * (temp - 32));
}
function kelvinToCelsius(kelvin) {
    return kelvin - 273.15;
}

function convert(element) {
    console.log(element.value);
    for(var i=1; i<9; i++) {
        var tempSpan = document.querySelector("#temp" + i);
        var tempVal = parseInt(tempSpan.innerText);
        if(element.value == "°C") {
            tempSpan.innerText = CTC(tempVal);
        } else {
            tempSpan.innerText = CTF(tempVal);
        }
    }
}




// get werather data
async function getWeatherData(lat, lon, apiKey) {
    const response = await fetch(`https://api.openweathermap.org/data/2.5/forecast?lat=${lat}&lon=${lon}&appid=${apiKey}`);
    const weatherData = await response.json();
    return weatherData;
}

// for Chicago

async function genereated(cityName, stateCode) {
    

    const url = `http://api.openweathermap.org/geo/1.0/direct?q=${cityName},${stateCode},${countryCode}&limit=${limit}&appid=${apiKey}`;
    const response = await fetch(url);
    const locationData = await response.json();

    // Use the latitude and longitude from the locationData to get weather data
    const weatherData = await getWeatherData(locationData[0].lat, locationData[0].lon, apiKey);

    let currentDate = new Date();
    currentDate.setHours(0, 0, 0, 0);  // reset time to start of the day

    let extractedData = weatherData.list
        .map(entry => {
            return {
                date: entry.dt_txt,
                weather: entry.weather[0].main,
                maxTemp: entry.main.temp_max,
                minTemp: entry.main.temp_min
            };
        })
        .filter(entry => {
            let entryDate = new Date(entry.date);
            return entryDate >= currentDate && entryDate <= new Date(currentDate.getTime() + 3 * 24 * 60 * 60 * 1000);  // adding 3 days worth of milliseconds
        });
        console.log(extractedData);
    return extractedData;
}

function extractDay(dateString) {
    return dateString.split(' ')[0];  // Extracts the YYYY-MM-DD part from the date-time string
}



async function getMostFrequentWeatherForDays(cityName, stateCode) {
    const data = await genereated(cityName, stateCode);

    // Group by day and count weather types and track min/max temperatures
    const countsByDay = {};
    data.forEach(entry => {
        const day = extractDay(entry.date);
        if (!countsByDay[day]) {
            countsByDay[day] = {
                weatherCounts: {},
                minTemp: Infinity,
                maxTemp: -Infinity
            };
        }
        if (!countsByDay[day].weatherCounts[entry.weather]) countsByDay[day].weatherCounts[entry.weather] = 0;
        countsByDay[day].weatherCounts[entry.weather]++;

        // Track min/max temperatures
        if (entry.minTemp < countsByDay[day].minTemp) countsByDay[day].minTemp = entry.minTemp;
        if (entry.maxTemp > countsByDay[day].maxTemp) countsByDay[day].maxTemp = entry.maxTemp;
    });

    // Determine most frequent weather per day and gather temps
    const mostFrequentWithTemps = [];
    for (let day in countsByDay) {
        const mostFrequentWeather = Object.keys(countsByDay[day].weatherCounts).reduce((a, b) => countsByDay[day].weatherCounts[a] > countsByDay[day].weatherCounts[b] ? a : b);
        mostFrequentWithTemps.push({
            weather: mostFrequentWeather,
            minTemp: countsByDay[day].minTemp,
            maxTemp: countsByDay[day].maxTemp
        });
    }

    console.log(mostFrequentWithTemps);
    return mostFrequentWithTemps;
}

// getMostFrequentWeatherForDays()

// update Weather data
async function updateWeatherBlocks(cityName = "San Jose", stateCode = "CA") {
    let thisdata = await getMostFrequentWeatherForDays(cityName, stateCode);;
    let blocks = document.querySelectorAll('.block1 p');
    let pics = document.querySelectorAll('.block1 .Weather-pic');
    let coldest = document.querySelectorAll('.block1 .coldest');
    let hotest = document.querySelectorAll('.block1 .hotest');

    for (let i = 0; i < thisdata.length; i++) {
        let currentWeather = thisdata[i];

        if (currentWeather.weather === "Clear") {
            blocks[i].textContent = "some sun";
            pics[i].src = "assets/some_sun.png";
        } else if (currentWeather.weather === "Rain") {
            blocks[i].textContent = "some rain";
            pics[i].src = "assets/some_rain.png";
        } else if (currentWeather.weather === "Clouds") {
            blocks[i].textContent = "some clouds";
            pics[i].src = "assets/some_clouds.png";
        }

        // Update the temperature
        coldest[i].textContent = `${kelvinToCelsius(currentWeather.minTemp).toFixed(2)}°`;
        hotest[i].textContent = `${kelvinToCelsius(currentWeather.maxTemp).toFixed(2)}°`;
    }
}






// chekc next 4 days
function daycheck(){
    let currentDate = new Date();
    let dayNumber = currentDate.getDay();

    console.log(dayNumber); 
    let next4days=[];

    let days = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
    

    for(let i = 0; i <= 3; i++) {
        next4days.push(days[(dayNumber + i) % 7]);
    }  
    return next4days;
}


// set the days
function setDaysOnBlocks() {
    let days = daycheck();
    let blocks = document.querySelectorAll('.block1 h3');
    
    for(let i = 0; i < blocks.length; i++) {
        blocks[i].textContent = days[i];
    }
}

document.addEventListener('DOMContentLoaded', function() {
    updateWeatherBlocks();
    setDaysOnBlocks();
});



