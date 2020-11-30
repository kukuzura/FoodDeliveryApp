$(document).ready(function() {
    $("#order_form").submit(function (event) {
        event.preventDefault(); //prevent default action
        const post_url = $(this).attr("action"); //get form action url
        const request_method = $(this).attr("method"); //get form GET/POST method
        const form_data = $(this).serialize(); //Encode form elements for submission

        $.ajax({
            url: post_url,
            type: request_method,
            data: form_data
        }).done(function (response) { //
            $("#server-results").html(response);
        });
    });
});