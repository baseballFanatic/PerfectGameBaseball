var selectedYear = 1900;

function loadSimulatedYears() {
    const url = "/years";
    var addedClass = false;
    $.getJSON(url, function(simulatedYears) {
        var yearHtml = '<option value="';
        $.each(simulatedYears, function(key, simulatedYear) {
            if (!addedClass) {
                yearHtml += simulatedYear.yearID + '" selected>'
                addedClass = true;
            } else {
            //todo fix this, not accurately building the option value
                yearHtml += simulatedYear.yearID + '">'
            }
            yearHtml +=  + simulatedYear.yearID + '</option>'
        })
        $('#simulated-years').html(yearHtml);
        selectedYear = $('#simulated-years').val();
        console.log(selectedYear);
        loadTeamStandingsData(selectedYear);
    });
}

function loadTeamStandingsData(selectedYear) {
    const getTeams = "/season?yearID=" + selectedYear;
    var alTableHtml = '';
    var nlTableHtml = '';
    var alIndex = 0;
    var nlIndex = 0;
    $.getJSON(getTeams, function(teams) {
        const alLeaderWins = teams[0].teamStats.seasonWins;
        const nlLeaderWins = teams[8].teamStats.seasonWins;
        $.each(teams, function(key, simulatedTeam) {
            const teamWinPct = (simulatedTeam.teamStats.seasonWins / simulatedTeam.teamStats.seasonGames).toFixed(3);
            if (simulatedTeam.lgId === 'AL') {
                const gamesBehind = alLeaderWins - simulatedTeam.teamStats.seasonWins;
                alTableHtml += '<tr index="' + alIndex + '" tabindex="0">';
                alTableHtml += '<td index="' + alIndex + '" class="dg-team-short">';
                alTableHtml += '<a href="#" class="nya">' + simulatedTeam.teamId + '</a>';
                alTableHtml += '</td>';
                alTableHtml += '<td index="' + alIndex + ' class="dg-w">' + simulatedTeam.teamStats.seasonWins + '</td>';
                alTableHtml += '<td index="' + alIndex + ' class="dg-l">' + simulatedTeam.teamStats.seasonLosses + '</td>';
                alTableHtml += '<td index="' + alIndex + ' class="dg-pct">' + teamWinPct + '</td>';
                alTableHtml += '<td index="' + alIndex + ' class="dg-gb">' + gamesBehind + '</td>';
                alTableHtml += '<td index="' + alIndex + ' class="dg-last-ten">NA</td>';
                alTableHtml += '<td index="' + alIndex + ' class="dg-streak">NA</td>';
                alTableHtml += '<td index="' + alIndex + ' class="dg-home">' + simulatedTeam.teamStats.homeWins + ' - ' + simulatedTeam.teamStats.homeLosses + '</td>';
                alTableHtml += '<td index="' + alIndex + ' class="dg-away">' + simulatedTeam.teamStats.awayWins + ' - ' + simulatedTeam.teamStats.awayLosses + '</td>';
                alTableHtml += '<td index="' + alIndex + ' class="dg-last-game">NA</td>';
                alTableHtml += '<td index="' + alIndex + ' class="dg-next-game">Season Completed</td>';
                alIndex++;
            } else {
                const gamesBehind = nlLeaderWins - simulatedTeam.teamStats.seasonWins;
                nlTableHtml += '<tr index="' + nlIndex + '" tabindex="0">';
                nlTableHtml += '<td index="' + nlIndex + '" class="dg-team-short">';
                nlTableHtml += '<a href="#" class="nya">' + simulatedTeam.teamId + '</a>';
                nlTableHtml += '</td>';
                nlTableHtml += '<td index="' + nlIndex + ' class="dg-w">' + simulatedTeam.teamStats.seasonWins + '</td>';
                nlTableHtml += '<td index="' + nlIndex + ' class="dg-l">' + simulatedTeam.teamStats.seasonLosses + '</td>';
                nlTableHtml += '<td index="' + nlIndex + ' class="dg-pct">' + teamWinPct + '</td>';
                nlTableHtml += '<td index="' + nlIndex + ' class="dg-gb">' + gamesBehind + '</td>';
                nlTableHtml += '<td index="' + nlIndex + ' class="dg-last-ten">NA</td>';
                nlTableHtml += '<td index="' + nlIndex + ' class="dg-streak">NA</td>';
                nlTableHtml += '<td index="' + nlIndex + ' class="dg-home">' + simulatedTeam.teamStats.homeWins + ' - ' + simulatedTeam.teamStats.homeLosses + '</td>';
                nlTableHtml += '<td index="' + nlIndex + ' class="dg-away">' + simulatedTeam.teamStats.awayWins + ' - ' + simulatedTeam.teamStats.awayLosses + '</td>';
                nlTableHtml += '<td index="' + nlIndex + ' class="dg-last-game">NA</td>';
                nlTableHtml += '<td index="' + nlIndex + ' class="dg-next-game">Season Completed</td>';
                nlIndex++;
            }
        })
        $('#standingsTableBodyAL').html(alTableHtml);
        $('#standingsTableBodyNL').html(nlTableHtml);
    });
}


$(document).ready(function() {
    appendOtherHeader();
    $('#nav-standings').addClass( "active" );
    loadSimulatedYears();
});