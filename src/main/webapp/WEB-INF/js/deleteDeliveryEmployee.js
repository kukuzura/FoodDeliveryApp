function deleteDeliveryEmployee(id) {
    $.ajax({
            type:"DELETE",
            url: "../employee/delete/"+ id,
            success: function () {
                $('#' + id).remove();
            },
            error: function (e) {
                console.log('error')
            }
        }
    )
}