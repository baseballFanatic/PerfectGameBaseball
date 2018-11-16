let otherHeader = `
    <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="regular-nav">
        <div class="container">
            <!-- Navbar brand -->
            <a class="navbar-brand" href="home">Perfect Game</a>
            <img src="/img/PGBS_logo_circle_blue.png" height="40" class="d-inline-block align-top mr-3" alt="">
            <!-- Collapse button -->
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#basicExampleNav" aria-controls="basicExampleNav"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <!-- Collapsible content -->
            <div class="collapse navbar-collapse" id="basicExampleNav">
                <!-- Links -->
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item" id="nav-front-office">
                        <a class="nav-link" href="office">Front Office
                            <span class="sr-only">(current)</span>
                        </a>
                    </li>
                    <li class="nav-item" id="nav-standings">
                        <a class="nav-link" href="standings">Standings</a>
                    </li>
                    <li class="nav-item" id="nav-schedule">
                        <a class="nav-link" href="schedule">Schedule</a>
                    </li>
                    <!-- Collapsible content -->
                        <div class="collapse navbar-collapse" id="basicExampleNav">
                            <!-- Links -->
                            <ul class="navbar-nav mr-auto">
                              <!-- Dropdown -->
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Stats</a>
                                    <div class="dropdown-menu dropdown-primary" aria-labelledby="navbarDropdownMenuLink">
                                        <a class="dropdown-item" href="stats">Player Stats</a>
                                        <a class="dropdown-item" href="#">League Leaders</a>
                                        <a class="dropdown-item" href="#">Team Stats</a>
                                    </div>
                                </li>
                            </ul>
                            <!-- Links -->
                        </div>
                        <!-- Collapsible content -->
                    <li class="nav-item" id="nav-players">
                        <a class="nav-link" href="players">Players
                        </a>
                    </li>
                    <li class="nav-item" id="nav-teams">
                        <a class="nav-link" href="teams">Teams</a>
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
}

function User(username, displayName, recentYear) {
    this.username = username;
    this.displayName = displayName;
    this.recentYear = recentYear;
}

function loadTeamsByLeague( league, year ) {
    let defaultUrl = "/season";
    let loadYear = 'yearID=' + year;
    $( '#standings-table-al' ).html('');
    $( '#standings-table-nl' ).html('');
    $.getJSON(defaultUrl, loadYear, function(response) {
        $.each(response, function(index, team) {
            let winPercentage = team.teamStats.seasonWins / team.teamStats.seasonGames;
            let teamHtml = '<tr>';
            teamHtml += '<td>' + team.teamId + '</td>';
            teamHtml += '<td>' + team.teamStats.seasonWins + '</td>';
            teamHtml += '<td>' + team.teamStats.seasonLosses + '</td>';
            teamHtml += '<td>' + winPercentage.toFixed(3) + '</td>';
            teamHtml += '<tr>';
            if (league === "American" && team.lgId === 'AL')
            {
              $('#standings-table-al').append(teamHtml);
            }
            if (league === 'National' && team.lgId === 'NL')
            {
              $('#standings-table-al').append(teamHtml);
            }
        });
    });
}
function loadSimulatedYears() {
    const url = "/years";
    let addedClass = false;
    $.getJSON(url, function(simulatedYears) {
        let yearHtml = '<option value="';
        $.each(simulatedYears, function(key, simulatedYear) {
            if (!addedClass) {
                yearHtml += simulatedYear.yearID + '" selected>'
                addedClass = true;
            } else {
                yearHtml += '<option value="' + simulatedYear.yearID + '">'
            }
            yearHtml +=  + simulatedYear.yearID + '</option>'
        })
        $('#simulated-years').html(yearHtml);
        loadTeamStandingsData($('#simulated-years').val());
    });
}


