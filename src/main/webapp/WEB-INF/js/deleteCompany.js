function deleteCompany(id,type) {
    $.ajax({
            type:"DELETE",
            url: "../deleteCompany/" + type + "/" + id,
            success: function () {
                $('#' + id).remove();
            },
            error: function (e) {
                console.log('error')
            }
        }
    )
}