$(document).ready(function(){
    createStandingsByYear();

    $("#simulated-years").change(function() {
      var rowHtml = '<tr class="table-standings-header">';
      rowHtml += '<th>Team</th>';
      rowHtml += '<th>W</th>';
      rowHtml += '<th>L</th>';
      rowHtml += '<th>%</th>';
      rowHtml += '</tr>';
      $('#standings-table-al').html(rowHtml);
      $('#standings-table-nl').html(rowHtml);
      var year = $("#simulated-years").attr( "option" );
      var urlYear = "/season";
      var actualYear = 'yearID=' + $( "#simulated-years" ).val();
      var league = 'American';
      loadTeamsByLeague( league, $( "#simulated-years" ).val() );
    });

    $('.p-navbar-mini-title').click(function(event) {
        var currentElement = $(this);
        if ($(currentElement).text() == 'American' || $(currentElement).text() == 'National') {
            $('#navbar-standings').find('li').toggleClass('p-navbar-mini p-navbar-mini-active');
            loadTeamsByLeague( $(currentElement).text(), $( "#simulated-years" ).val() )
            event.preventDefault();
        }
        else {
            $("#navbar-leaders").find('li').toggleClass('p-navbar-mini p-navbar-mini-active');
            event.preventDefault();
            if ($( currentElement ).text() === 'Batting' )
            {
                $( "#grid-player-stats-container" ).find('div').toggleClass( 'grid-player-data grid-player-data-active');
            }
        }
    });
});

function createStandingsByYear() {
    var url = "/years";
    $.getJSON(url, function(response) {
      var defaultYear = response[0].yearID;
      var yearHtml = '<option value="' + defaultYear + '">' + defaultYear + '</option>';
      var defaultHtml = '<tr class="table-standings-header">';
      defaultHtml += '<th>Team</th>';
      defaultHtml += '<th>W</th>';
      defaultHtml += '<th>L</th>';
      defaultHtml += '<th>%</th>';
      defaultHtml += '</tr>';
      $('#standings-table-al').html(defaultHtml);
      $('#standings-table-nl').html(defaultHtml);
      var league = 'American';
      loadTeamsByLeague(league, defaultYear);
      $.each(response, function(index, year) {
        var actualYear = year.yearID;
        yearHtml += '<option value="' + actualYear + '">' + actualYear + '</option>';
      });
      $('#simulated-years').html(yearHtml);
    });
}

function loadTeamsByLeague( league, year ) {
    var defaultUrl = "/season";
    var loadYear = 'yearID=' + year;
    $( '#standings-table-al' ).html('');
    $( '#standings-table-nl' ).html('');
    $.getJSON(defaultUrl, loadYear, function(response) {
        $.each(response, function(index, team) {
            var winPercentage = team.teamStats.seasonWins / team.teamStats.seasonGames;
            var teamHtml = '<tr>';
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
