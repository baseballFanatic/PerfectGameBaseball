var selectedYear = 1913;

var monthsOfYear = {NON: 0, JAN: 1, FEB: 2, MAR: 3, APR: 4, MAY: 5, JUN: 6, JUL: 7, AUG: 8, SEP: 9, OCT: 10, NOV: 11, DEC: 12};

function loadScheduleData(selectedYear, league) {
    const getSchedule = "/scheduleMonth?yearID=" + selectedYear;
    var scheduleHtml = '';
    var scheduleIndex = 0;
    var enteredMonth = $( ".display-month" ).text();
    var displayMonth = monthsOfYear[enteredMonth];
    $.getJSON(getSchedule, function(schedule) {
        $.each(schedule, function(key, scheduleDay) {
            if ( league.includes('MLB') ) {
                if (scheduleDay.gameMonth === displayMonth) {
                        scheduleHtml += '<tr index="' + scheduleIndex + '" tabindex="0">';
                        scheduleHtml += '<td index="' + scheduleIndex + '" class="dg-date">' + scheduleDay.gameMonth + ' - ' + scheduleDay.gameDay + '</td>';
            /*            scheduleHtml += '<a href="#" class="' + simulatedTeam.teamId + '">' + simulatedTeam.teamName + '</a>';*/
                        scheduleHtml += '</td>';
                        scheduleHtml += '<td index="' + scheduleIndex + '" class="dg-away">' + scheduleDay.visitingTeamId + '</td>';
                        scheduleHtml += '<td index="' + scheduleIndex + '" class="dg-home">' + scheduleDay.homeTeamId+ '</td>';
                        scheduleHtml += '<td index="' + scheduleIndex + '" class="dg-away-probable">' + scheduleDay.visitingStartingPitcherName + '</td>';
                        scheduleHtml += '<td index="' + scheduleIndex + '" class="dg-home-probable">' + scheduleDay.homeStartingPitcherName + '</td>';

                        if (scheduleDay.gameCompleted === 'Y') {
                            scheduleHtml += '<td index="' + scheduleIndex + '" class="dg-result">' + scheduleDay.visitingScore + ' - ' + scheduleDay.homeScore + '</td>';
                            scheduleHtml += '<td index="' + scheduleIndex + '" class="dg-winning-pitcher">' + scheduleDay.winningPitcherName + ' (' + scheduleDay.winningPitcherWins + '-' + scheduleDay.winningPitcherLosses + ')' + '</td>';
                            scheduleHtml += '<td index="' + scheduleIndex + '" class="dg-losing-pitcher">' + scheduleDay.losingPitcherName + ' (' + scheduleDay.losingPitcherWins + '-' + scheduleDay.losingPitcherLosses + ')' + '</td>';
                            scheduleHtml += '<td index="' + scheduleIndex + '">' + '<a class="btn btn-success btn-small" href="box?gameKey=' + scheduleDay.gameKey + '" role="button">BOX</a>' + '</td>';
                        } else {
                            scheduleHtml += '<td index="' + scheduleIndex + '" class="dg-result">0 - 0</td>';
                            scheduleHtml += '<td index="' + scheduleIndex + '" class="dg-winning-pitcher">NA</td>';
                            scheduleHtml += '<td index="' + scheduleIndex + '" class="dg-losing-pitcher">NA</td>';
                            scheduleHtml += '<td index="' + scheduleIndex + '">' + '<button type="submit" class="btn btn-default btn-small playButton" data-toggle="modal" data-gameKey="' + scheduleDay.gameKey + '" data-target="#modalPlayGame">PLAY</button>' + '</td>';
                        }
                        scheduleIndex++;
                    }
            } else {
                if ( scheduleDay.gameMonth === displayMonth && league.includes( scheduleDay.homeLgId ) ) {
                    scheduleHtml += '<tr index="' + scheduleIndex + '" tabindex="0">';
                    scheduleHtml += '<td index="' + scheduleIndex + '" class="dg-date">' + scheduleDay.gameMonth + ' - ' + scheduleDay.gameDay + '</td>';
        /*            scheduleHtml += '<a href="#" class="' + simulatedTeam.teamId + '">' + simulatedTeam.teamName + '</a>';*/
                    scheduleHtml += '</td>';
                    scheduleHtml += '<td index="' + scheduleIndex + '" class="dg-away">' + scheduleDay.visitingTeamId + '</td>';
                    scheduleHtml += '<td index="' + scheduleIndex + '" class="dg-home">' + scheduleDay.homeTeamId+ '</td>';
                    scheduleHtml += '<td index="' + scheduleIndex + '" class="dg-away-probable">' + scheduleDay.visitingStartingPitcherName + '</td>';
                    scheduleHtml += '<td index="' + scheduleIndex + '" class="dg-home-probable">' + scheduleDay.homeStartingPitcherName + '</td>';

                    if (scheduleDay.gameCompleted === 'Y') {
                        scheduleHtml += '<td index="' + scheduleIndex + '" class="dg-result">' + scheduleDay.visitingScore + ' - ' + scheduleDay.homeScore + '</td>';
/*                        scheduleHtml += '<td index="' + scheduleIndex + '" class="dg-winning-pitcher">' + scheduleDay.winningPitcherName + '</td>';*/
                        scheduleHtml += '<td index="' + scheduleIndex + '" class="dg-winning-pitcher">' + scheduleDay.winningPitcherName + ' (' + scheduleDay.winningPitcherWins + '-' + scheduleDay.winningPitcherLosses + ')' + '</td>';
                        scheduleHtml += '<td index="' + scheduleIndex + '" class="dg-losing-pitcher">' + scheduleDay.losingPitcherName + ' (' + scheduleDay.losingPitcherWins + '-' + scheduleDay.losingPitcherLosses + ')' + '</td>';
                        scheduleHtml += '<td index="' + scheduleIndex + '">' + '<a class="btn btn-success btn-small" href="box?gameKey=' + scheduleDay.gameKey + '" role="button">BOX</a>' + '</td>';
                    } else {
                        scheduleHtml += '<td index="' + scheduleIndex + '" class="dg-result">0 - 0</td>';
                        scheduleHtml += '<td index="' + scheduleIndex + '" class="dg-winning-pitcher">NA</td>';
                        scheduleHtml += '<td index="' + scheduleIndex + '" class="dg-losing-pitcher">NA</td>';
                        scheduleHtml += '<td index="' + scheduleIndex + '">' + '<button type="submit" class="btn btn-default btn-small playButton" data-toggle="modal" data-gameKey="' + scheduleDay.gameKey + '" data-target="#modalPlayGame">PLAY</button>' + '</td>';
                    }
                    scheduleIndex++;
                }
            }
        })
        $('#scheduleTableBody').html(scheduleHtml);

    $('.playButton').on('click', function() {
           var lgID = $('.league-selector.ui-state-active').children().text();
           var gameKey = $(this).attr('data-gameKey');
           var success = '<span>Game Completed!</span>';
           var playGame = "/playGame?yearID=" + selectedYear + "&lgID=" + lgID + "&round=RS&simName=clint&gameKey=" + gameKey;
           $.getJSON( playGame, function(response) {
               if ( response ) {
                $('.modalMessage').html(success);
               }
           });
        });
    });
}

function changeLeague() {
    $( ".league-selector" ).siblings().removeClass( "ui-state-active" );
    $(this).addClass( "ui-state-active ");
    loadScheduleData( selectedYear, $(this).text() );
}


$(document).ready(function() {
   $('#nav-schedule').addClass( "active" );
   var league = $(".league-selector.ui-state-active").text();

   loadScheduleData(selectedYear, league);

    $('.league-selector').on( 'click', changeLeague );

    $('#modalPlayGame').on('hidden.bs.modal', function() {
        league = $(".league-selector.ui-state-active").text();
        $('.modalMessage').html("");
        loadScheduleData( selectedYear, league )
    });
});


