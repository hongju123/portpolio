

// function onLocation(e) {
//     const lat = e.coords.latitude;
//     const lon = e.coords.longitude;

//     console.log(lat + "+" + lon);

//     const key = "6682c5c50c3364b6073670a47567585b";
//     const url = `https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lon}&appid=${key}`;

//     fetch(url).
//         then(data => { data.json(); }).
//         then(data => { console.log(data); });
// }
// function offLocation() {

// }
// navigator.geolocation.getCurrentPosition(onLocation, offLocation)


function onLocation(e) {
    const lat = e.coords.latitude;
    const lon = e.coords.longitude;
    
    console.log(lat + "+" + lon);
    
    const key = "6682c5c50c3364b6073670a47567585b";
    const url = `https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lon}&appid=${key}`;
    
    fetch(url)
        .then(response => response.json())
        .then(data => {
            console.log(data);
        });
}

function offLocation() {
    console.log("");
}

navigator.geolocation.getCurrentPosition(onLocation, offLocation);
