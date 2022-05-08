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

function showthree() {
    //pokemon info dataset
    let request = new XMLHttpRequest()
    request.open('GET', 'http://localhost:8080/pokemonStrategys/', true)
    request.onload = function () {
        // Begin accessing JSON data here
        data = JSON.parse(this.response)

        if (request.status >= 200 && request.status < 400) 
        {
            let base = document.getElementById("baseText3");
            base.innerHTML = "Oversight of the primary typing from all pokemon";

            let labels = ["normal", "fight", "flying", "poison", "ground", "rock", "bug", "ghost", "steel", "fire", "water", "grass", "electric", "psychic", "ice", "dragon", "dark", "fairy", "unknownType"];
            let graphData = primaryTypePokemon(data);

            let ctx = document.getElementById('showThree');
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
                            'rgba(254,0,0,1)',
                            'rgba(8,8,151,1)',
                            'rgba(221,77,67,1)',
                            'rgba(157,55,68,1)',
                            'rgba(254,132,42,1)',
                            'rgba(252,118,106,1)',
                            'rgba(200,62,115,1)',
                            'rgba(145,150,73,1)',
                            'rgba(251,199,72,1)',
                            'rgba(45,92,158,1)',
                            'rgba(117,87,65,1)',
                            'rgba(217,159,60,1)',
                            'rgba(104,105,67,1)',
                            'rgba(231,182,207,1)',
                            'rgba(215,196,157,1)',
                            'rgba(59,58,80,1)',
                            'rgba(86,64,62,1)'
                        ],
                        borderColor: [
                            'rgba(151,8,8,1)',
                            'rgba(8,151,8,1)',
                            'rgba(254,0,0,1)',
                            'rgba(8,8,151,1)',
                            'rgba(221,77,67,1)',
                            'rgba(157,55,68,1)',
                            'rgba(254,132,42,1)',
                            'rgba(252,118,106,1)',
                            'rgba(200,62,115,1)',
                            'rgba(145,150,73,1)',
                            'rgba(251,199,72,1)',
                            'rgba(45,92,158,1)',
                            'rgba(117,87,65,1)',
                            'rgba(217,159,60,1)',
                            'rgba(104,105,67,1)',
                            'rgba(231,182,207,1)',
                            'rgba(215,196,157,1)',
                            'rgba(59,58,80,1)',
                            'rgba(86,64,62,1)'
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
function primaryTypePokemon(data) {
    let normal = 0;
    let fight = 0;
    let flying = 0;
    let poison = 0;
    let ground = 0;
    let rock = 0;
    let bug = 0;
    let ghost = 0;
    let steel = 0;
    let fire = 0;
    let water = 0;
    let grass = 0;
    let electric = 0;
    let psychic = 0;
    let ice = 0;
    let dragon = 0;
    let dark = 0;
    let fairy = 0;
    let unknownType = 0;

    data.forEach(element => {
        if (element.type1 == "Normal")
        {
            normal++;
        }
        else if (element.type1 == "Fight")
        {
            fight++;
        }
        else if (element.type1 == "Flying")
        {
            flying++;
        }
        else if (element.type1 == "Poison")
        {
            poison++;
        }
        else if (element.type1 == "Ground")
        {
            ground++;
        }
        else if (element.type1 == "Rock")
        {
            rock++;
        }
        else if (element.type1 == "Bug")
        {
            bug++;
        }
        else if (element.type1 == "Ghost")
        {
            ghost++;
        }
        else if (element.type1 == "Steel")
        {
            steel++;
        }
        else if (element.type1 == "Fire")
        {
            fire++;
        }
        else if (element.type1 == "Water")
        {
            water++;
        }
        else if (element.type1 == "Grass")
        {
            grass++;
        }
        else if (element.type1 == "Electric")
        {
            electric++;
        }
        else if (element.type1 == "Psychic")
        {
            psychic++;
        }
        else if (element.type1 == "Ice")
        {
            ice++;
        }
        else if (element.type1 == "Dragon")
        {
            dragon++;
        }
        else if (element.type1 == "Dark")
        {
            dark++;
        }
        else if (element.type1 == "Fairy")
        {
            fairy++;
        }
        else 
        {
            unknownType++;
        }
    });

    return new Array(normal, fight, flying, poison, ground, rock, bug, ghost, steel, fire, water, grass, electric, psychic, ice, dragon, dark, fairy, unknownType);
}