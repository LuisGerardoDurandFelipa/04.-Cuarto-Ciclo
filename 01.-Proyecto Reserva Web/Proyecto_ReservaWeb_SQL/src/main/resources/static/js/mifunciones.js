
document.getElementById('checkbox').addEventListener('change', function() {
	// Si no esta checked
	if (!this.checked) {
		this.checked = !confirm('¿Esta seguro que no quiere guardar?');
	}
});

function undisable() {
	
	document.getElementById("flexCheckDisabled").disabled = false;
	document.getElementById("flexCheckDisabled").checked = true;
	document.getElementById("button_reserva").disabled = false;
}      
