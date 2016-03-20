<div>Hello World!</div>

<div>form1</div>

<div id="test"></div>
<script>
    $(document).ready(function () {
        var initial = 1;
        debugger;
        if (task !== undefined)
            clearInterval(task);
        task = setInterval(function () {
            initial++;
            $("#test").text(initial);
        }, 1000);
    });
</script>