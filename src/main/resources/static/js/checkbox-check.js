$(document).ready(function () {
    $('.data-checkbox').on('click', function () {
        if ($('input:checked').length === 2) {
            $(".data-sources > input").each(function () {
                if (!this.checked) {
                    $(this).attr("disabled", true)
                }
            });
            $('#sumDataButton').attr('disabled', false);
        } else {
            $(".data-sources > input").each(function () {
                $(this).attr("disabled", false)
            });
            $('#sumDataButton').attr('disabled', true);
        }
    })
});