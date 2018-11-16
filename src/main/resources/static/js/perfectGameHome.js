$(document).ready(function() {
    let url = "/users";
    let register = "/register";

    $('#signInModal').on('shown.bs.modal', function() {
      $('#signInUserName').focus();
    });

    $('#signInUserName').keypress( function(event) {
        if (event.which === 13) {
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
        let submittedUser = "user=" + $('#signInUserName').val();
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
        let submittedUser = "user=" + $('#registerUserName').val();
        let firstName = "firstName=" + $('#registerFirstName').val();
        let lastName = "lastName=" + $('#registerLastName').val();
        let active = "active=Y";
        let mostRecentYear = "mostRecentYear=1913";
        let params = submittedUser + "&" + firstName + "&" + lastName + "&" + active + "&" + mostRecentYear;
        let userRegistered = false;
        $( ".alert" ).remove();
        $.getJSON( url, submittedUser, function(response) {
            if ( response ) {
                $('#registerModal').append(`<div class='alert alert-warning alert-dismissible fade show' role='alert'>Username already exists</div>`);
                $('.alert-warning').append(`<button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                    </button>`);
                $('#registerUserName').val('');
                $('#registerFirstName').val('');
                $('#registerLastName').val('');
            } else {
/*                $.getJSON( register, params)
                    .done(function (data) {
                        $('#registerModal').append(`<div class='alert alert-success alert-dismissible fade show' role='alert'>User created successfully</div>`);
                        $('.alert-success').append(`<button type="button" id="success-close" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                    </button>`);
                        $('#registerUserName').val('');
                        $('#registerFirstName').val('');
                        $('#registerLastName').val('');
                        userRegistered = true;
                        console.log("user created successfully");
                    })

                    .fail( function () {
                        $('#registerModal').append(`<div class='alert alert-success alert-dismissible fade show' role='alert'>User not registered</div>`);
                        $('.alert-warning').append(`<button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                    </button>`);
                        userRegistered = false;
                        console.log("user not registered");
                    });*/
                // this below code works so if the promise doesn't, you can uncomment out this:
                $.getJSON( register, params, function(response) {
                    if ( response ) {
                        console.log("Woohoo, it worked!");
                    } else {
                        console.log("Uh oh, you still don't know how to do it!");
                    }
                })
                $('#registerModal').append(`<div class='alert alert-success alert-dismissible fade show' role='alert'>User created successfully</div>`);
                $('.alert-success').append(`<button type="button" id="success-close" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                    </button>`);
                $('#registerUserName').val('');
                $('#registerFirstName').val('');
                $('#registerLastName').val('');
                userRegistered = true;
                return true;
            }
        })
    });
    $('#success-close').on('click', function() {
        window.location.replace("/office");
    });
});