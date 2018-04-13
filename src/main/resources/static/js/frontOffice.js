$(document).ready(function() {
    appendOtherHeader();
    $('#nav-front-office').addClass( "active" );
    $('#frontOfficeWelcome').html("Welcome " + currentUser.displayName + "!");
});