let data;
let graphs = [];
document.onload = showone(), showtwo(), showthree();

function showone() {
    // pokemon origin dataset
    let request = new XMLHttpRequest()
    request.open('GET', 'http://localhost:8080/pokemonOrigins/', true)
    request.onload = function () {
        // Begin accessing JSON data here
        data = JSON.parse(this.response)

        if (request.status >= 200 && request.status < 400) 
        {
            let base = document.getElementById("baseText");
            base.innerHTML = "All of the pokemon divided in legendary's, sub-legendary's, mythical and normal pokemon"

            let labels = ["Normal", "SubLegendary", "Legendary", "Mythical"];
            let graphData = countPokemonPerClass(data);

            let ctx = document.getElementById('showOne');
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
                            'rgba(8,8,151,1)',
                            'rgba(151,151,151,1)'
                        ],
                        borderColor: [
                            'rgba(151, 8, 8, 1)',
                            'rgba(8,151,8,1)',
                            'rgba(8,8,151,1)',
                            'rgba(151,151,151,1)'
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

function countPokemonPerClass(data) {
    let normal = 0;
    let is_mythical = 0;
    let is_sub_legendary = 0;
    let is_legendary = 0;

    data.forEach(element => {
        if (element.is_legendary)
        {
            is_legendary++;
        }
        else if (element.is_mythical)
        {
            is_mythical++;
        }
        else if (element.is_sub_legendary)
        {
            is_sub_legendary++;
        }
        else
        {
            normal++;
        }
    });

    return new Array(normal, is_sub_legendary, is_legendary, is_mythical);
}