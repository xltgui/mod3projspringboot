(function (){
    $("#tabprodutos").on("click",".js-delete", function(){
        let botaoClicado = $(this);
        $("#btnProdutoSim").attr("data-id", botaoClicado.attr("data-id"));

        $("#modalproduto").modal("show");
    });

    $("#btnProdutoSim").on("click", function(){
        let botaoSim = $(this);

        let id = botaoSim.attr("data-id");

        $.ajax({
            url: "/produtos/delete/" + id,
            method: "GET",
            success: function(){
                window.location.href="/produtos"
            }
        });
    });
})();