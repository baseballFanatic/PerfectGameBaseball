var sessionUrl = "/getSessionUser";

function getSessionUser(url) {
    var memberNameHtml = '';
    $.getJSON( url, function(response) {
        if (response) {
            console.log("Got here - " + response);
        }
        memberNameHtml += '<p class="card-text">Welcome ' + response + '</p>';
    });
    $('#memberName').html(memberNameHtml);
}

$(document).ready(function() {
    $('#nav-front-office').addClass( "active" );
    /*getSessionUser(sessionUrl);*/
});