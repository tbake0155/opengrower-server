let ctx = document.getElementById("measurements_plot").getContext("2d");
let labels = [];
let data = [];
let config = {
    type: 'line',
    data: {
        labels: labels,
        datasets: [{
            label: 'Graph Line',
            data: data,
            backgroundColor: 'rgba(0, 119, 204, 0.3)'
        }]
    }
};
window.measurements_plot = new Chart(ctx, config);

function onSelectedChange() {
    let selected = document.getElementById("selected").value;
    document.getElementById("measurements_div").src = "http://192.168.1.80:8080/measurements/" + selected;

    let jsonObject = JSON.parse(document.getElementById("measurements_div").innerHTML);

    let labels = jsonObject.map(function (e) {
        return e.timeStamp;
    });
    let data = jsonObject.map(function (e) {
        return e.moisture;
    });

    console.log(jsonList);
    console.log(labels);
    console.log(data);

    window.measurements_plot.labels = labels;
    window.measurements_plot.data = data;
}