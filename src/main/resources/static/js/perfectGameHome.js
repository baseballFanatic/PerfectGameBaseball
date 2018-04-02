var otherHeader = `
        <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="regular-nav">
                    <div class="container">
                        <!-- Navbar brand -->
                        <a class="navbar-brand" href="office">Perfect Game</a>
                        <img src="/img/baseball_lighter.png" height="20" class="d-inline-block align-top mr-3" alt="">
                        <!-- Collapse button -->
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#basicExampleNav" aria-controls="basicExampleNav"
                                aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <!-- Collapsible content -->
                        <div class="collapse navbar-collapse" id="basicExampleNav">
                            <!-- Links -->
                            <ul class="navbar-nav mr-auto">
                                <li class="nav-item active">
                                    <a class="nav-link" href="office">Front Office
                                        <span class="sr-only">(current)</span>
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="players">Players
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#">Teams</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#">Seasons</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#">Schedule</a>
                                </li>
                            </ul>
                        </div>
                        <!-- Collapsible content -->
                        <button type="submit" class="btn btn-primary mb-0 btn-small" id="sign-out">Sign-Out</button>
                    </div>
                </nav>
    `;

function appendOtherHeader() {
    $('#other-header').append(otherHeader);
};

$(document).ready(function() {
    var url = "/users";
    var validUser = false;

    $.getJSON(url, function(response) {
        $('#signIn-button').on('click', function() {
            var submittedUsername = $('#materialFormNameModalEx1').val();
            $.each(response, function(key, user) {
                if (user.username === submittedUsername) {
                    validUser = true;
                    console.log(validUser);
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