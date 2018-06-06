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
                scheduleHtml += '<td index="' + scheduleIndex + '" class="dg-result">' + scheduleDay.visitingScore + ' - ' + scheduleDay.homeScore + '</td>';
                scheduleHtml += '<td index="' + scheduleIndex + '" class="dg-winning-pitcher">' + scheduleDay.winningPitcherName + '</td>';
                scheduleHtml += '<td index="' + scheduleIndex + '" class="dg-losing-pitcher">' + scheduleDay.losingPitcherName + '</td>';
                if (scheduleDay.gameCompleted === 'Y') {
                    scheduleHtml += '<td index="' + scheduleIndex + '">' + '<a class="btn btn-success btn-small" href="box" role="button">BOX</a>' + '</td>';
                } else {
                    scheduleHtml += '<td index="' + scheduleIndex + '">' + '<a class="btn btn-default btn-small" href="play" role="button">PLAY</a>' + '</td>';
                }
                scheduleIndex++;
            }
        })
        $('#scheduleTableBody').html(scheduleHtml);
    });
}


$(document).ready(function() {
       appendOtherHeader();
       $('#nav-schedule').addClass( "active" );
       loadSimulatedYears();
       loadScheduleData(selectedYear);
});

