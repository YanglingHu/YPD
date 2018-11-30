$(document).ready(function () {
    $("#File").change(function () {
        var filePath = $(this).val();
        if (filePath !== "") {
            var arr = filePath.split('\\');
            var fileName = arr[arr.length - 1];
            $("#FileTips").html(fileName);
        } else {
            $("#FileTips").html("You haven't choose a file yet, or the file type is invalid!")
            return false
        }
    });
});