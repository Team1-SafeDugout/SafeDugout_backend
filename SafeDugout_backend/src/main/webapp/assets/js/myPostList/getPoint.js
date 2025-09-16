const myPoint = document.getElementById("my-point");

document.addEventListener('DOMContentLoaded', function(){
	
	fetch(`/myPage/getPoint.mp`, {
		headers: {
			"X-Requested-With": "XMLHttpRequest" 
			,"Accept": "text/plain" 
		}
	})
		.then(r => { if (!r.ok) throw new Error(r.status); return r.text(); })
		.then(data => {
			if(data){
				myPoint.innerHTML = `
				<span>${data}</span><span>P</span>
				`;		
			} 
		})
		.catch(() => {

		});
});