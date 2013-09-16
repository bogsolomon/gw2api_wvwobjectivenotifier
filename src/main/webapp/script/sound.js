 var pingSound;

function playSound() {
	var elements = document.getElementsByClassName("soundClass");
	
	var elementCB = document.getElementById("checkboxes:playSoundCB:0");
	
	var playSound = false;
	
	if (elementCB.checked) {
		for(var i=0; i<elements.length; i++) {
			 var content = elements[i].getElementsByTagName("span")[0].innerHTML;
			
			if (content == "true") {
				playSound = true;
				elements[i].getElementsByTagName("span")[0].innerHTML = "false";
			}
		}
		
		if (pingSound != null && playSound)
			pingSound.play();
	}
}