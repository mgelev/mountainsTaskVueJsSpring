'use strict';

$(document).ready(function () {
    let countrySelect = $("#countrySelect");

    function fillCountry() {
        $('#countrySelect').find('option').remove().end();
        let services = $.parseJSON($.ajax({
            url: '/country',
            dataType: 'json',
            async: false
        }).responseText);

        $.each(services, function (name) {
            $('#countrySelect').append($('<option>').text(value).attr("value", name));
        });
    }
});