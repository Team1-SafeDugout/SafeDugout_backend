document.addEventListener("DOMContentLoaded", function() {
    const ctx = document.getElementById('visitorChart').getContext('2d');
	const today = new Date();
	let days = [];
	
	makeDays();
    const visitorChart = new Chart(ctx, {
        type: 'line',
        data: {
            labels:days,
            datasets: [{
                label: '방문자 수',
                data: [12, 19, 3, 5, 2, 3, 7],
                borderColor: 'rgba(77, 80, 97, 1)',
                backgroundColor: 'rgba(77, 80, 97, 0.2)',
                tension: 0.3,
                fill: true
            }]
        },
        options: {
            responsive: true,
            plugins: {
                legend: { display: true, position: 'top' }
            },
            scales: {
                y: { beginAtZero: true }
            }
        }
    });
	
	function makeDays(){
		
		for(i = 0; i < 7; i ++){
			let numTemp = i - 3;
			
			let dayTemp = new Date(today);
			dayTemp.setDate(today.getDate() + numTemp);
			console.log(dayTemp);
			
			const makeDaywithMonth = (dayTemp.getMonth()+1) + "/" + dayTemp.getDate();
			
			days.push(makeDaywithMonth);
		}
	}
});