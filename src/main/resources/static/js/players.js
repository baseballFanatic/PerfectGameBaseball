$(document).ready(function() {
    appendOtherHeader();

    $('#nav-players').addClass("active");

    $('.datatable').DataTable();

    $('.datatable').each(function(){
        let datatable = $(this);
        // SEARCH - Add the placeholder for Search and Turn this into in-line form control
        let search_input = datatable.closest('.dataTables_wrapper').find('div[id$=_filter] input');
        search_input.attr('placeholder', 'Search');
        search_input.addClass('form-control input-sm');
        // LENGTH - Inline-Form control
        let length_sel = datatable.closest('.dataTables_wrapper').find('div[id$=_length] select');
        length_sel.addClass('form-control input-sm');
    });

    $('.dataTables_length').addClass('bs-select');
});