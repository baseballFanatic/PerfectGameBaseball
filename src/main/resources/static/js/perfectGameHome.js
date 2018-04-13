$(document).ready(function() {
    var url = "/users";
    var currentUser = new User(null, null, null);

    $('#signIn-button').on('click', function() {
        var submittedUser = "user=" + $('#signInUserName').val();
        $.getJSON( url, submittedUser, function(response) {
            if ( response ) {
                currentUser.username = $('#signInUserName').val();
                currentUser.recentYear = 1913;
                currentUser.displayName = 'Clint';
                window.location.replace("/office");
                return false;
            } else {
                $('#signInModal').append(`<div class='alert alert-warning alert-dismissible fade show' role='alert'>Username not found</div>`);
                $('.alert-warning').append(`<button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>`);
                $('#signInUserName').val('');
                document.getElementById( '#signInUserName' ).value = '';
            }
        });
    });

});