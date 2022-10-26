(function (){
    $("#tabvendas").on("click",".js-delete", function(){
        let botaoClicado = $(this);
        $("#btnVendaSim").attr("data-id", botaoClicado.attr("data-id"));

        $("#modalvenda").modal("show");
    });

    $("#btnVendaSim").on("click", function(){
        let botaoSim = $(this);

        let id = botaoSim.attr("data-id");

        $.ajax({
            url: "/vendas/delete/" + id,
            method: "GET",
            success: function(){
                window.location.href="/vendas"
            }
        });
    });
})();