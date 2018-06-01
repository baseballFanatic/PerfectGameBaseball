function addHitterData ( hitters, league ) {
    var playerHtml = '';
    $.each(hitters, function(index, player) {
        if (player.batterStats.sGamesPlayed > 0 ) {
            if ( player.lgID == league || league == 'MLB' ) {
                var battingAverage = player.batterStats.sHits / player.batterStats.sAtBats;
                var onBase = (player.batterStats.sHits + player.batterStats.sWalks) / player.batterStats.sAtBats;
                var sluggingAverage = ((player.batterStats.sHits - player.batterStats.sDoubles - player.batterStats.sTriples - player.batterStats.sHomeRuns) + (player.batterStats.sDoubles * 2) + (player.batterStats.sTriples * 3) + (player.batterStats.sHomeRuns * 4)) / player.batterStats.sAtBats;
                var onBasePlusSlugging = onBase + sluggingAverage;
                playerHtml += '<tr>';
                playerHtml += '<td>' + player.nameLast + ', ' + player.nameFirst[0] + '</td>';
                playerHtml += '<td>' + player.teamID + '</td>';
                playerHtml += '<td>NA</td>';
                playerHtml += '<td>' + player.batterStats.sGamesPlayed + '</td>';
                playerHtml += '<td>' + player.batterStats.sAtBats + '</td>';
                playerHtml += '<td>' + player.batterStats.sRuns + '</td>';
                playerHtml += '<td>' + player.batterStats.sHits + '</td>';
                playerHtml += '<td>' + player.batterStats.sDoubles + '</td>';
                playerHtml += '<td>' + player.batterStats.sTriples + '</td>';
                playerHtml += '<td>' + player.batterStats.sHomeRuns + '</td>';
                playerHtml += '<td>' + player.batterStats.sRbi + '</td>';
                playerHtml += '<td>' + player.batterStats.sWalks + '</td>';
                playerHtml += '<td>' + player.batterStats.sStrikeOuts + '</td>';
                playerHtml += '<td>' + player.batterStats.sStolenBases + '</td>';
                playerHtml += '<td>' + player.batterStats.sCaughtStealing + '</td>';
                playerHtml += '<td>' + battingAverage.toFixed(3) + '</td>';
                playerHtml += '<td>' + onBase.toFixed(3) + '</td>';
                playerHtml += '<td>' + sluggingAverage.toFixed(3) + '</td>';
                playerHtml += '<td>' + onBasePlusSlugging.toFixed(3) + '</td>';
                playerHtml += '</tr>';
            }
        }
    })
    return playerHtml;
}

function addPitcherData ( pitchers, league ) {
    var pitcherHtml = '';
    $.each(pitchers, function(index, player) {
        if (player.pitcherStats.sGamesPlayed > 0 ) {
            if ( player.lgID == league || league == 'MLB' ) {
                pitcherHtml += '<tr>';
                pitcherHtml += '<td>' + player.nameLast + ', ' + player.nameFirst[0] + '</td>';
                pitcherHtml += '<td>' + player.teamID + '</td>';
                pitcherHtml += '<td>' + player.pitcherStats.sWins + '</td>';
                pitcherHtml += '<td>' + player.pitcherStats.sLosses + '</td>';
                pitcherHtml += '<td>NA</td>';
                pitcherHtml += '<td>' + player.pitcherStats.sGamesPlayed + '</td>';
                pitcherHtml += '<td>' + player.pitcherStats.sGamesStarted + '</td>';
                pitcherHtml += '<td>' + player.pitcherStats.sSaves + '</td>';
                pitcherHtml += '<td>' + player.pitcherStats.sInningsPitchedOuts + '</td>';
                pitcherHtml += '<td>' + player.pitcherStats.sHitsAllowed + '</td>';
                pitcherHtml += '<td>' + player.pitcherStats.sRunsAllowed + '</td>';
                pitcherHtml += '<td>' + player.pitcherStats.sEarnedRuns + '</td>';
                pitcherHtml += '<td>' + player.pitcherStats.sHomeRunsAllowed + '</td>';
                pitcherHtml += '<td>' + player.pitcherStats.sWalksAllowed + '</td>';
                pitcherHtml += '<td>' + player.pitcherStats.sStrikeOutAllowed + '</td>';
                pitcherHtml += '<td>NA</td>';
                pitcherHtml += '<td>NA</td>';
                pitcherHtml += '<td>NA</td>';
                pitcherHtml += '</tr>';
            }
        }
    })
    return pitcherHtml;
}

function loadHittersByYearByLeague( year, league ) {
    var defaultUrl = "/hitters";
    var loadYear = 'yearID=' + year;
    var playerHtml = '';
    $.getJSON( defaultUrl, loadYear, function( hitters ) {
        playerHtml = addHitterData( hitters, league );
        $('#stats-table-hitters').html(playerHtml);
    });
}

function loadPitchersByYearByLeague ( year, league ) {
    var defaultUrl = "/pitchers";
    var loadYear = 'yearID=' + year;
    var playerHtml = '';
    $.getJSON( defaultUrl, loadYear, function( pitchers ) {
        playerHtml = addPitcherData( pitchers, league );
        $('#stats-table-pitchers').html( playerHtml );
    });
}

function changeLeague() {
    $( ".league-selector" ).siblings().removeClass( "ui-state-active" );
    $(this).addClass( "ui-state-active ");
    var league = $(this).find('span').text();
    loadHittersByYearByLeague(1913, league);
    loadPitchersByYearByLeague(1913, league);
}

function changeQualifiers() {
    $( ".qualifying-selector").siblings().removeClass( "ui-state-active" );
    $(this).addClass( "ui-state-active" );
}

function changeDisplay() {
    $( ".categoryDisplay li a" ).removeClass( "active" );
    $(this).addClass( "active" );
    if ( $(this).attr('id') == 'sp_pitching_child' ) {
        document.getElementById("stats-hitting-data-table").style.display="none";
        document.getElementById("stats-pitching-data-table").style.display="block";
    } else if ( $(this).attr('id') == 'sp_hitting_child' ) {
        document.getElementById("stats-pitching-data-table").style.display="none";
        document.getElementById("stats-hitting-data-table").style.display="block";
    } else if (  $(this).attr('id') == 'sp_fielding_child' ) {
        document.getElementById("stats-pitching-data-table").style.display="none";
        document.getElementById("stats-hitting-data-table").style.display="none";
    }

}

$(document).ready(function() {
    document.getElementById("stats-pitching-data-table").style.display="none";
    appendOtherHeader();
    var league = 'MLB';
    $('#nav-leaders').addClass( "active" );
    loadHittersByYearByLeague(1913, league);
    loadPitchersByYearByLeague(1913, league);

    $('.league-selector').on( 'click', changeLeague );
    $('.qualifying-selector').on( 'click', changeQualifiers );
    $('.tab_child').on( 'click', changeDisplay );

});