function checkWinner() {
    var homeScore = $('#homeScore').text();
    var visitingScore = $('#visitingScore').text();
    var visitorPitcher = '';
    var homePitcher = '';

    if ( parseInt(visitingScore) > parseInt(homeScore) ) {
        $('.game-score.top').addClass("winner");
    } else {
        $('.game-score.bottom').addClass("winner");
    }
}

$(document).ready(function() {
    appendOtherHeader();
    $('#nav-schedule').addClass( "active" );
    $('.game-score.top').removeClass( "winner" );
    $('.game-score.bottom').removeClass( "winner" );
    checkWinner();
});