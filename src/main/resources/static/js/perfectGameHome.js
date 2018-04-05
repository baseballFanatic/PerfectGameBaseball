$(document).ready(function() {
    var url = "/users";
    var validUser = false;

    $.getJSON(url, function(response) {
        $('#signIn-button').on('click', function() {
            var submittedUsername = $('#materialFormNameModalEx1').val();
            $.each(response, function(key, user) {
                if (user.username === submittedUsername) {
                    validUser = true;
                    $('#modalSignInForm').modal('hide');
                    window.location.replace("/office");
                    return false;
                }
            });
            if (!validUser) {
                $('#signInModal').append(`<div class='alert alert-warning alert-dismissible fade show' role='alert'>Username not found</div>`);
                $('.alert-warning').append(`<button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>`);
                $('#materialFormNameModalExl').val('');
            }
            console.log(validUser);
        });
    });
});