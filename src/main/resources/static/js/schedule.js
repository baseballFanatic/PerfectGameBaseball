var selectedYear = 1913;

function loadScheduleData(selectedYear) {
    const getSchedule = "/scheduleMonth?yearID=" + selectedYear;
    var scheduleHtml = '';
    var scheduleIndex = 0;
    $.getJSON(getSchedule, function(schedule) {
        $.each(schedule, function(key, scheduleDay) {
            if (scheduleDay.gameMonth === 4) {
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
                    scheduleHtml += '<td index="' + scheduleIndex + '" class="dg-winning-pitcher">' + scheduleDay.winningPitcherName + '</td>';
                    scheduleHtml += '<td index="' + scheduleIndex + '" class="dg-losing-pitcher">' + scheduleDay.losingPitcherName + '</td>';
                    scheduleHtml += '<td index="' + scheduleIndex + '">' + '<a class="btn btn-success btn-small" href="box?gameKey=' + scheduleDay.gameKey + '" role="button">BOX</a>' + '</td>';
                } else {
                    scheduleHtml += '<td index="' + scheduleIndex + '" class="dg-result">0 - 0</td>';
                    scheduleHtml += '<td index="' + scheduleIndex + '" class="dg-winning-pitcher">NA</td>';
                    scheduleHtml += '<td index="' + scheduleIndex + '" class="dg-losing-pitcher">NA</td>';
                    scheduleHtml += '<td index="' + scheduleIndex + '">' + '<button type="submit" class="btn btn-default btn-small playButton" data-toggle="modal" data-target="#modalPlayGame">PLAY</button>' + '</td>';
                }
                scheduleIndex++;
            }
        })
        $('#scheduleTableBody').html(scheduleHtml);

               $('.playButton').on('click', function() {
                   console.log("recognized the clicking of the play button")
/*                   todo this currently doesn't play the current game selected but instead the next game available*/
                   var playGame = "/playGame";
                   $.getJSON( playGame, function(response) {
                       if ( response ) {
                        console.log("Game completed");
                        $('#modalGameCompleted').append(`<span>Game Completed!</span>`);
                       } else {
                        console.log("something went wrong");
                        $('#modalGameCompleted').append(`<span>Some bad happened...</span>`);
                       }
                   });
               });
    });
}


$(document).ready(function() {
       $('#nav-schedule').addClass( "active" );
       loadSimulatedYears();
       loadScheduleData(selectedYear);


});

