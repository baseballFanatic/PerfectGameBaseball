$(document).ready(function() {
    var url = "/users";
    var register = "/register";

    $('#signInUserName').keypress( function(event) {
        if (event.which == 13) {
            event.preventDefault();
            var submittedUser = "user=" + $('#signInUserName').val();
            $.getJSON( url, submittedUser, function(response) {
                if ( response ) {
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
        }
    });

    $('#signIn-button').on('click', function() {
        var submittedUser = "user=" + $('#signInUserName').val();
        $.getJSON( url, submittedUser, function(response) {
            if ( response ) {
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

    $('#register-button').on('click', function() {
        var submittedUser = "user=" + $('#registerUserName').val();
        var userRegistered = false;
        $.getJSON( url, submittedUser, function(response) {
            if ( response ) {
                $('#registerModal').append(`<div class='alert alert-warning alert-dismissible fade show' role='alert'>Username already exists</div>`);
                $('.alert-warning').append(`<button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                    </button>`);
                $('#registerUserName').val('');
                $('#registerFirstName').val('');
                $('#registerLastName').val('');
                document.getElementById( '#registerUserName' ).value = '';
                document.getElementById( '#registerFirstName' ).value = '';
                document.getElementById( '#registerLastName' ).value = '';
            } else {
                $('#registerModal').append(`<div class='alert alert-success alert-dismissible fade show' role='alert'>User created successfully.</div>`);
                $('.alert-success').append(`<button type="button" id="success-close" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                    </button>`);
                $('#registerUserName').val('');
                $('#registerFirstName').val('');
                $('#registerLastName').val('');
                document.getElementById( '#registerUserName' ).value = '';
                document.getElementById( '#registerFirstName' ).value = '';
                document.getElementById( '#registerLastName' ).value = '';
                userRegistered = true;
                return true;
            }
        })
    });
    /*TODO this is not working*/
    $('#success-close').on('click', function() {
        window.location.replace("/office");
    });
});