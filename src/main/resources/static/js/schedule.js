let selectedYear = 1913;

function changeLeague() {
    $( ".league-selector" ).siblings().removeClass( "ui-state-active" );
    $(this).addClass( "ui-state-active ");
    let league = $(this)[0].innerText;
    let setSessionLeague = "/setSessionLeague?league=" + league;
    console.log(setSessionLeague);
/*    let table = $('.datatable').DataTable();

    if ( league === 'AL' ) {
        $( ".american" ).show();
        $( ".national" ).hide();
    } else if (league === 'NL') {
        $( ".national" ).show();
        $( ".american" ).hide();
    } else {
        $( ".national" ).show();
        $( ".american" ).show();
    }*/

    $.getJSON(setSessionLeague, function() {});
    location.reload();
}

function changeMonth() {
    console.log("hey, you changed the month!  Well, not really.")
    $( ".paginate_button" ).siblings().removeClass( "active" );
    $(this).addClass( "active" );
    let month = $(this)[0].innerText;
    let searchMonth = 4;
    console.log(month);
    if ( month === "MAY" ) {
        searchMonth = 5;
    } else if ( month === "JUN") {
        searchMonth = 6;
    } else if ( month === "JUL" ) {
        searchMonth = 7;
    } else if ( month === "AUG" ) {
        searchMonth = 8;
    } else if ( month === "SEP" ) {
        searchMonth = 9;
    } else if ( month === "OCT" ) {
        searchMonth = 10;
    }

    let setSessionMonth = "/setSessionMonth?month=" + searchMonth;
    console.log(setSessionMonth);
    $.getJSON(setSessionMonth, function () {});
    location.reload();
}

function changeGamesDisplay() {
    document.scheduleGamesGroup.scheduleSimulatedRadio.checked=false;
    document.scheduleGamesGroup.scheduleAvailableRadio.checked=false;
    document.scheduleGamesGroup.scheduleAllRadio.checked=false;
    $(this).prop( "checked", true );
    console.log($(this));
    let selection = this.id;
    console.log(selection);
    let setSessionGames = "/setSessionGames?gamesDisplay=" + selection;
    $.getJSON(setSessionGames, function() {});
    location.reload();
}


$(document).ready(function() {
    appendOtherHeader();

   $('#nav-schedule').addClass( "active" );

    $('.datatable').DataTable( {
        "lengthMenu": [[10,25,50,-1], [10,25,50, "All"]]
    });

    $('.league-selector').on( 'click', changeLeague );

    $('.paginate_button_schedule').on( 'click', changeMonth );

    $('.playButton').on('click', function() {
       let lgID = $('.league-selector.ui-state-active').children().text();
       let gameKey = $(this).attr('data-gameKey');
       let success = '<span>Game Completed!</span>';
       let playGame = "/playGame?yearID=" + selectedYear + "&lgID=" + lgID + "&round=RS&simName=clint&gameKey=" + gameKey;
       $.getJSON( playGame, function(response) {
           if ( response ) {
               $('.modalMessage').html(success)
               $('#modalPlayGame').on('hidden.bs.modal', function() {
                   /*        league = $(".league-selector.ui-state-active").text();*/
                   $('.modalMessage').html("");
                   location.reload();
               });
           }
       });
    });

    $('.schedule-radio').on( 'click', changeGamesDisplay );


});


