let data;
let graphs = [];
document.onload = showtwo();


function showtwo() {
    //pokemon info dataset
    let request = new XMLHttpRequest()
    request.open('GET', 'http://localhost:8080/pokemonInfos/', true)
    request.onload = function () {
        // Begin accessing JSON data here
        data = JSON.parse(this.response)

        if (request.status >= 200 && request.status < 400) 
        {
            let base = document.getElementById("baseText2");
            base.innerHTML = "Oversight of small, average and big pokemon";

            let labels = ["Small pokemon", "Average pokemon", "Big pokemon"];
            let graphData = heightPokemon(data);

            let ctx = document.getElementById('showTwo');
            let myChart = new Chart(ctx, {
                type: 'doughnut',
                data: {
                    labels: labels,
                    datasets: [{
                        label: 'normal',
                        data: graphData,
                        backgroundColor: [
                            'rgba(151,8,8,1)',
                            'rgba(8,151,8,1)',
                            'rgba(8,8,151,1)'
                        ],
                        borderColor: [
                            'rgba(151, 8, 8, 1)',
                            'rgba(8,151,8,1)',
                            'rgba(8,8,151,1)'
                        ],
                        borderWidth: 1
                    }]

                }
            });
            graphs.push(myChart)
        }
        else
        {
            console.log(error)
        }
    }
    request.send();
}


function heightPokemon(data) {
    let height1 = 0;
    let height2 = 0;
    let height3 = 0;

    data.forEach(element => {
        if (element.height < 1)
        {
            height1++;
        }
        else if (element.height >= 1 && element.height <= 1.5)
        {
            height2++;
        }
        else 
        {
            height3++;
        }
    });

    return new Array(height1, height2, height3);
}