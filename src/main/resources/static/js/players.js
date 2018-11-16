$(document).ready(function() {
    appendOtherHeader();
    $('th[data-toggle="tooltip"]').tooltip();

    $('#nav-players').addClass("active");

    $('.datatable').DataTable();

/*    $('.datatable').each(function(){
        let datatable = $(this);
        // SEARCH - Add the placeholder for Search and Turn this into in-line form control
        let search_input = datatable.closest('.dataTables_wrapper').find('div[id$=_filter] input');
        search_input.attr('placeholder', 'Search');
        search_input.addClass('form-control input-sm');
        // LENGTH - Inline-Form control
        let length_sel = datatable.closest('.dataTables_wrapper').find('div[id$=_length] select');
        length_sel.addClass('form-control input-sm');
    });

    $('.dataTables_length').addClass('bs-select');*/

    $(function() {
        $('#playerSearchText').focus();
    });

    $('#playerSearchButton').on('click', function() {
        let lastName = document.getElementById("playerSearchText").value;
        let setSearchPlayer = "/setSessionSearchPlayer?lastName=" + lastName;
        $.getJSON( setSearchPlayer, function (response) {
            if (response) {
                location.reload();
            }
        });
    });

    $('#playerSearchText').keypress( function( event ) {
        if ( event.which === 13) {
            event.preventDefault();
            let lastName = document.getElementById("playerSearchText").value;
            let setSearchPlayer = "/setSessionSearchPlayer?lastName=" + lastName;
            $.getJSON( setSearchPlayer, function (response) {
                if (response) {
                    location.reload();
                }
            });
        }
    });

    $('#batting-tab').on('click', function (e) {
        e.preventDefault();
        $('#player-tab-fielding').removeClass("show");
        $('#player-tab-fielding').removeClass("active");
        $('#player-tab-pitching').removeClass("show");
        $('#player-tab-pitching').removeClass("active");
        $('#player-tab-batting').addClass("show");
        $('#player-tab-batting').addClass("active");
        $(this).tab('show');
    });

    $('#fielding-tab').on('click', function (e) {
        e.preventDefault();
        console.log("you clicked on the fielding tab");
        $('#player-tab-batting').removeClass("show");
        $('#player-tab-batting').removeClass("active");
        $('#player-tab-pitching').removeClass("show");
        $('#player-tab-pitching').removeClass("active");
        $('#player-tab-fielding').addClass("show");
        $('#player-tab-fielding').addClass("active");
        $(this).tab('show');
    });

    $('#pitching-tab').on('click', function (e) {
        e.preventDefault();
        $('#player-tab-batting').removeClass("show");
        $('#player-tab-batting').removeClass("active");
        $('#player-tab-fielding').removeClass("show");
        $('#player-tab-fielding').removeClass("active");
        $('#player-tab-pitching').addClass("show");
        $('#player-tab-pitching').addClass("active");
        $(this).tab('show');
    });

});