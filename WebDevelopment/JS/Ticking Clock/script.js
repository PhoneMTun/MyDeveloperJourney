function getSecondsSinceStartOfDay() {
    return new Date().getSeconds() + 
      new Date().getMinutes() * 60 + 
      new Date().getHours() * 3600;
}





setInterval(function() {
    var time = getSecondsSinceStartOfDay();
  
    // Calculate angles for hour, minute, and second hands
    var hourHandAngle = ((360 * (time % 43200) / 43200) + 180) % 360;
    var minuteHandAngle = ((6 * (time % 3600) / 60) + 180) % 360;
    var secondHandAngle = ((6 * (time % 60)) + 180) % 360;
  
    // Update the clock hands' rotation using CSS transform property
    document.getElementById("hour").style.transform = `rotate(${hourHandAngle}deg)`;
    document.getElementById("minutes").style.transform = `rotate(${minuteHandAngle}deg)`;
    document.getElementById("seconds").style.transform = `rotate(${secondHandAngle}deg)`;
  }, 1000);