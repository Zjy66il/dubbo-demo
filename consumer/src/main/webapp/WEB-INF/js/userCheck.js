$(function(){
    //全选
    $("#selectAll").click(function () {
        if (this.checked) {
            $("input[name=deleteId]").prop("checked", true);
        } else {
            $("input[name=deleteId]").prop("checked", false);
        }
    });

    $("input[name=deleteId]").click(function () {
        var allChecked = true;
        $("input[name=deleteId]").each(function () {
            if (!$(this).prop("checked")) {
                allChecked = false;
            }
        });
        if (allChecked) {
            $("#selectAll").prop("checked", true);
        } else {
            $("#selectAll").prop("checked", false);
        }
    });

    //删除用户
    $("#delete").click(function () {
        var ids = [];
        $("input[name=deleteId]:checked").each(function (index) {
            ids[index] = $(this).val();
        });
        if (ids.length === 0) {
            alert("没有选中的选项");
            return false;
        }
        $.ajax({
            url: "deleteUser",
            data: {"ids": ids},
            cache: false,
            async: false,
            type: "GET",
            success: function (data) {
                if (data === true) {
                    window.location.reload();
                }
            }
        });
    });
});
