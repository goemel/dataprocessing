
function showone() {
    var pokemonname = document.getElementById('pokemonname').value;
    var input = pokemonname.charAt(0).toUpperCase() + pokemonname.slice(1);
    let request = new XMLHttpRequest()
    request.open('GET', 'http://localhost:8080/pokemonOrigins/', true)
    request.onload = function () {
        // Begin accessing JSON data here
        data = JSON.parse(this.response)

        if (request.status >= 200 && request.status < 400) 
        {
            let row = document.getElementById('info');
            let results = [];
            data.forEach(data => {
                if (data.name == input)
                {
                    results.push(data);
                }
            });
            if (results.length == 0)
            {
                document.getElementById('showOne').innerHTML = "There is no pokemon with this name.";
                row.innerHTML = "";
            }
            else
            {
                document.getElementById('showOne').innerHTML = ""
                let table = document.getElementById('table');
                row.innerHTML = ""
                let data1 = document.createElement('td');
                let data2 = document.createElement('td');
                let data3 = document.createElement('td');
                let data4 = document.createElement('td');
                let data5 = document.createElement('td');
                let data6 = document.createElement('td');
                let data7 = document.createElement('td');
                let data8 = document.createElement('td');
                let data9 = document.createElement('td');
                let data10 = document.createElement('td');
                data1.innerHTML = results[0].index;
                data2.innerHTML = results[0].pokedex_number;
                data3.innerHTML = results[0].name;
                data4.innerHTML = results[0].german_name;
                data5.innerHTML = results[0].japanese_name;
                data6.innerHTML = results[0].species;
                data7.innerHTML = results[0].generation;
                if (results[0].is_sub_legendary == 0)
                {
                    data8.innerHTML = "No"
                }
                else
                {
                    data8.innerHTML = "Yes"
                }
                if (results[0].is_mythical == 0)
                {
                    data9.innerHTML = "No"
                }
                else
                {
                    data9.innerHTML = "Yes"
                }
                if (results[0].is_legendary == 0)
                {
                    data10.innerHTML = "No"
                }
                else
                {
                    data10.innerHTML = "Yes"
                }
                row.appendChild(data1);
                row.appendChild(data2);
                row.appendChild(data3);
                row.appendChild(data4);
                row.appendChild(data5);
                row.appendChild(data6);
                row.appendChild(data7);
                row.appendChild(data8);
                row.appendChild(data9);
                row.appendChild(data10);
                table.appendChild(row);
            }
        }
        else
        {
            console.log('error')
        }
    }
    request.send();
}