
function showone() {
    var pokemonname = document.getElementById('pokemonname').value;
    var input = '"' + pokemonname.charAt(0).toUpperCase() + pokemonname.slice(1) + '"';
    let request = new XMLHttpRequest()
    request.open('GET', 'http://localhost:8080/pokemonInfos/', true)
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
                document.getElementById('showOne').innerHTML = "There is no pokemon with this name."
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
                data1.innerHTML = results[0].id;
                data2.innerHTML = results[0].pokedexNumber;
                data3.innerHTML = results[0].name.substr(1, results[0].name.length - 2);
                data4.innerHTML = results[0].alternateForm.substr(1, results[0].alternateForm.length - 2);
                data5.innerHTML = results[0].height;
                data6.innerHTML = results[0].weight;
                data7.innerHTML = results[0].primaryType.substr(1, results[0].primaryType.length - 2);
                data8.innerHTML = results[0].classification.substr(1, results[0].classification.length - 2);
                data9.innerHTML = results[0].legendary.substr(1, results[0].legendary.length - 2);
                data10.innerHTML = results[0].orignal;
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

// function showall() {
//     let request = new XMLHttpRequest()
//     request.open('GET', 'http://localhost:8080/pokemonInfos', true)
//     request.onload = function () {
//         // Begin accessing JSON data here
//         data = JSON.parse(this.response)

//         if (request.status >= 200 && request.status < 400)
//         {
//             let results = [];
//             data.forEach(data => {
//                 results.push(data)
//             });
//             let table = document.getElementById('table');
//             for (i = 0; i < results.length; i++)
//             {
//                 let row = document.createElement('tr');
//                 let data1 = document.createElement('td');
//                 let data2 = document.createElement('td');
//                 let data3 = document.createElement('td');
//                 let data4 = document.createElement('td');
//                 let data5 = document.createElement('td');
//                 let data6 = document.createElement('td');
//                 let data7 = document.createElement('td');
//                 let data8 = document.createElement('td');
//                 let data9 = document.createElement('td');
//                 let data10 = document.createElement('td');
//                 data1.innerHTML = results[i].id;
//                 data2.innerHTML = results[i].pokedexNumber;
//                 data3.innerHTML = results[i].name.substr(1, results[i].name.length - 2);
//                 data4.innerHTML = results[i].alternateForm.substr(1, results[i].alternateForm.length - 2);
//                 data5.innerHTML = results[i].height;
//                 data6.innerHTML = results[i].weight;
//                 data7.innerHTML = results[i].primaryType.substr(1, results[i].primaryType.length - 2);
//                 data8.innerHTML = results[i].classification.substr(1, results[i].classification.length - 2);
//                 data9.innerHTML = results[i].legendary.substr(1, results[i].legendary.length - 2);
//                 data10.innerHTML = results[i].orignal;
//                 row.appendChild(data1);
//                 row.appendChild(data2);
//                 row.appendChild(data3);
//                 row.appendChild(data4);
//                 row.appendChild(data5);
//                 row.appendChild(data6);
//                 row.appendChild(data7);
//                 row.appendChild(data8);
//                 row.appendChild(data9);
//                 row.appendChild(data10);
//                 table.appendChild(row);

//             }
//         }
//         else
//         {
//             console.log('error')
//         }
//     }
//     request.send();
// }


// showall();