$( function() {
$( "#tabs" ).tabs({
  collapsible: true
});
} );

// Call to get the available simulated years
var getYear = new XMLHttpRequest();
getYear.onreadystatechange = function() {
    if (getYear.readyState === 4) {
        document.getElementById('load').innerHTML = getYear.responseText;
    }
};
getYear.open('GET', '');
function sendYear() {
    getYear.send();
    document.getElementById('load').style.display = "none";
}
