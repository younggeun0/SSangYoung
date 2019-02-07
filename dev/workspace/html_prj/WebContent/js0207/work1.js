
function setDirection(direction) {
	var msg = prompt("메시지를 입력해주세요.", "");
	var htmlContent = "";
	
	if (direction == "up") {
		htmlContent = "<div><marquee scrollamount='10' direction="+direction+">"+"∧<br>"+msg+"</marquee></div>";
	} else if (direction == "down") {
		htmlContent = "<div><marquee scrollamount='10' direction="+direction+">"+msg+"<br>∨"+"</marquee></div>";
	} else if (direction == "left") {
		htmlContent = "<div><marquee scrollamount='10' direction="+direction+">&lt;"+msg+"</marquee></div>";
	} else if (direction == "right") {
		htmlContent = "<div><marquee scrollamount='10' direction="+direction+">"+msg+"&gt;</marquee></div>";
	}
	
	window.document.write(htmlContent);
}

var direction = prompt("방향을 입력해주세요.","UP, DOWN, LEFT, RIGHT만 입력가능합니다.");

if (direction == "UP" || direction=="up") {
	direction = "up";
	setDirection(direction);
} else if (direction == "DOWN" || direction == "down") {
	direction = "down";
	setDirection(direction);
} else if (direction == "LEFT" || direction == "left") {
	direction = "left";
	setDirection(direction);
} else if (direction == "RIGHT" || direction == "right") {
	direction = "right";
	setDirection(direction);
} else {
	alert("UP, DOWN, LEFT, RIGHT 중 한가지 방향을 입력해주세요.");
}




