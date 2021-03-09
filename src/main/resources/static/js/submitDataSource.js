$(document).ready(function () {
    $('#sumDataButton').on('click', function () {
        var dataSources = [];
        $(".data-sources > input").each(function () {
            if (this.checked)
                dataSources.push(this.value);
        });

        var xhr = new XMLHttpRequest();
        xhr.responseType = 'json';
        xhr.open('POST', '/sum');
        xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");

        xhr.addEventListener('load', function (event) {

            return computeSumSuccess(event, xhr.response)
        }, false);

        xhr.addEventListener('error', function (event) {
            return computeSumError(event)
        }, false);
        xhr.send(JSON.stringify({'dataSources':dataSources}));
    });

    function computeSumSuccess(event, xhrResponse) {
        $('#result').text(xhrResponse);
        return false;
    }

    function computeSumError(event, xhrResponse) {
        $('#result').text("Wystąpił błąd");
        return false;
    }

});